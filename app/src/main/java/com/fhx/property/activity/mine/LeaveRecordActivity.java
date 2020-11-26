package com.fhx.property.activity.mine;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.LeaveRecordAdapter;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.LeaveRecordBean;
import com.fhx.property.utils.CutToUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * 请假记录
 */
public class LeaveRecordActivity extends BaseActivity implements View.OnClickListener {
    private ImageView image_top;
    private TextView tv_msg;
    private ImageView imageLeft;
    private TextView tvTitle;
    private LinearLayout ll_empty;
    private RecyclerView recycle_record;
    private SmartRefreshLayout refresh;
    private LeaveRecordAdapter recordAdapter;
    private List<LeaveRecordBean.DataBean.RecordsBean> recordBeanList =new ArrayList<>();
    private int page;
    @Override
    protected int initLayout() {
        return R.layout.activity_leave_record;
    }

    @Override
    protected void initView() {
        image_top = (ImageView) findViewById(R.id.image_top);
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tv_msg = (TextView) findViewById(R.id.tv_msg);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle_record = (RecyclerView) findViewById(R.id.recycle_record);
        ll_empty = (LinearLayout) findViewById(R.id.ll_empty);
        refresh = (SmartRefreshLayout) findViewById(R.id.refresh);
    }

    @Override
    protected void initData() {
        tvTitle.setText("请假记录");
        tv_msg.setText("你还没有提交过请假");
        image_top.setImageResource(R.mipmap.icon_empty_notice);

        recordAdapter =new LeaveRecordAdapter(recordBeanList);
        recycle_record.setLayoutManager(new LinearLayoutManager(this));
        recycle_record.setAdapter(recordAdapter);
        page=1;
        getList();
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        recordAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                CutToUtils.getInstance().JumpToTwo(LeaveRecordActivity.this,LeaveMsgActivity.class,1,recordBeanList.get(position).getSheetStatus());
//                CutToUtils.getInstance().JumpToBean(LeaveRecordActivity.this,LeaveMsgActivity.class,recordBeanList.get(position));
            }
        });
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                recordBeanList.clear();
                page=1;
                getList();
            }
        });

        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                getList();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
        }
    }

    /**
     * 获取列表
     */
    private void getList(){
        EasyHttp.post(AppUrl.LeaveList)
                .syncRequest(false)
                .headers("Admin-Token",mmkv.decodeString("token"))
                .params("page", String.valueOf(page))
                .params("limit","10")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error",e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        refresh.finishRefresh();
                        refresh.finishLoadMore();
                        LeaveRecordBean leaveRecordBean = JSON.parseObject(s, LeaveRecordBean.class);
                        if (leaveRecordBean.isSuccess()){

                            recordBeanList.addAll(leaveRecordBean.getData().getRecords());
                            if (recordBeanList.size()>0){
                                ll_empty.setVisibility(View.GONE);

                            }else {
                                ll_empty.setVisibility(View.VISIBLE);
                            }
                            recordAdapter.notifyDataSetChanged();
                        }
                    }
                });

    }
}
