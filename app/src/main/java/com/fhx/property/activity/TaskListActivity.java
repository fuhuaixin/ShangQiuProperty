package com.fhx.property.activity;

import android.content.Intent;
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
import com.fhx.property.adapter.HomeTaskAdapter;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.HomeTaskBean;
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
 * 我的任务
 */
public class TaskListActivity extends BaseActivity {
    private TextView tvTitle;
    private ImageView imageLeft;
    private SmartRefreshLayout refresh;
    private RecyclerView recycle;
    private LinearLayout ll_empty;

    private List<HomeTaskBean.DataBean> homeTaskBeanList = new ArrayList<>();
    private HomeTaskAdapter homeTaskAdapter;
    int page;

    @Override
    protected int initLayout() {
        return R.layout.activity_task_list;
    }

    @Override
    protected void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        imageLeft = (ImageView) findViewById(R.id.image_left);
        refresh = (SmartRefreshLayout) findViewById(R.id.refresh);
        recycle = (RecyclerView) findViewById(R.id.recycle);
        ll_empty = (LinearLayout) findViewById(R.id.ll_empty);
    }

    @Override
    protected void onResume() {
        super.onResume();
        page = 1;
        getMyProcess();
    }

    @Override
    protected void initData() {
        tvTitle.setText("我的任务");
        homeTaskAdapter = new HomeTaskAdapter(homeTaskBeanList);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle.setAdapter(homeTaskAdapter);

    }


    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
            }
        });

        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                getMyProcess();
            }
        });

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                homeTaskBeanList.clear();
                page = 1;
                getMyProcess();
            }
        });

        homeTaskAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                Intent intent = new Intent(TaskListActivity.this, TaskFaultMsgActivity.class);
                intent.putExtra("jumpOne", homeTaskBeanList.get(position).getOrderType());
                intent.putExtra("jumpTwo",homeTaskBeanList.get(position).getProcessId());
                intent.putExtra("jumpThree",homeTaskBeanList.get(position).getStatus());
                startActivity(intent);
                overridePendingTransition(R.anim.activity_in_from_anim, R.anim.activity_in_to_anim);
            }
        });

    }


    /**
     * 获取与我相关任务
     */
    private void getMyProcess() {
        EasyHttp.get(AppUrl.MyProcess)
                .headers("Admin-Token", mmkv.decodeString("token"))
                .params("type", "0")
                .params("page", String.valueOf(page))
                .params("size", "10")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                        refresh.finishRefresh();
                        refresh.finishLoadMore();
                    }

                    @Override
                    public void onSuccess(String s) {
                        refresh.finishRefresh();
                        refresh.finishLoadMore();
                        //orderType  0报修 1 投诉 2 设备维护
                        HomeTaskBean homeTaskBean = JSON.parseObject(s, HomeTaskBean.class);
                        if (homeTaskBean.isSuccess()) {
                            if (homeTaskBean.getData().size()>0){
                                ll_empty.setVisibility(View.GONE);
                            }else {
                                ll_empty.setVisibility(View.VISIBLE);
                            }
                            homeTaskBeanList.addAll(homeTaskBean.getData());
                            homeTaskAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }


}
