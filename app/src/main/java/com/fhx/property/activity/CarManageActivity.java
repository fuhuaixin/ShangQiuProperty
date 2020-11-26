package com.fhx.property.activity;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.CarManageAdapter;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.CarManageBean;
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
 * 车辆管理列表
 */
public class CarManageActivity extends BaseActivity implements View.OnClickListener {

    private EditText et_search;
    private TextView tvTitle;
    private ImageView imageLeft;
    private RecyclerView recyclerCar;
    private SmartRefreshLayout refreshLayout;

    /*空界面*/
    private LinearLayout ll_empty;
    private ImageView image_top;
    private TextView tv_msg;
    private TextView tv_btn;

    private CarManageAdapter adapter;
    private List<CarManageBean.DataBean.RecordsBean> mList = new ArrayList<>();
    private int page;
    @Override
    protected int initLayout() {
        return R.layout.activity_reminder;
    }

    @Override
    protected void initView() {
        et_search = (EditText) findViewById(R.id.et_search);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        imageLeft = (ImageView) findViewById(R.id.image_left);
        recyclerCar = (RecyclerView) findViewById(R.id.recycle_reminder);
        refreshLayout = (SmartRefreshLayout) findViewById(R.id.refreshLayout);

        ll_empty = (LinearLayout) findViewById(R.id.ll_empty);
        image_top = (ImageView) findViewById(R.id.image_top);
        tv_msg = (TextView) findViewById(R.id.tv_msg);
        tv_btn = (TextView) findViewById(R.id.tv_btn);
    }

    @Override
    protected void initData() {
        et_search.setHint("搜索车牌号、车主");
        tvTitle.setText("车辆管理");

        adapter = new CarManageAdapter(mList);
        recyclerCar.setLayoutManager(new LinearLayoutManager(this));
        recyclerCar.setAdapter(adapter);
        page=1;
        getList("");
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToOne(CarManageActivity.this, CarMsgActivity.class, mList.get(position).getCarId());
            }
        });
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mList.clear();
                page=1;
                if (TextUtils.isEmpty(et_search.getText().toString())){
                    getList("");
                }else {
                    getList(et_search.getText().toString());

                }
            }
        });

        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                if (TextUtils.isEmpty(et_search.getText().toString())){
                    getList("");
                }else {
                    getList(et_search.getText().toString());
                }
            }
        });
        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId == 0 || actionId == 3) && event != null) {
                    //点击搜索要做的操作
                    mList.clear();
                    page=1;
                    getList(et_search.getText().toString());
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;

        }
    }

    /**
     * 获取车俩列表
     */
    private void getList(String search){
        EasyHttp.get(AppUrl.CarList)
                .syncRequest(false)
                .params("pageNum", String.valueOf(page))
                .params("pageSize","10")
                .params("param",search)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error",e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        refreshLayout.finishLoadMore();
                        refreshLayout.finishRefresh();
                        CarManageBean carManageBean = JSON.parseObject(s, CarManageBean.class);
                        if (carManageBean.isSuccess()){
                            mList.addAll(carManageBean.getData().getRecords());
                            if (mList.size()>0){
                                ll_empty.setVisibility(View.GONE);
                            }else {
                                ll_empty.setVisibility(View.VISIBLE);
                                image_top.setImageResource(R.mipmap.icon_empty_car);
                                tv_msg.setText("暂无登记车辆");
                            }

                            adapter.notifyDataSetChanged();
                        }else {
                            ToastShort(carManageBean.getMsg());
                        }
                    }
                });
    }
}
