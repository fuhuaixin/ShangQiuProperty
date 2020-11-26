package com.fhx.property.activity;

import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
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
import com.fhx.property.adapter.RepairsCommitAdapter;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.RepairsCommitBean;
import com.fhx.property.utils.CutToUtils;
import com.lljjcoder.style.citylist.Toast.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.request.GetRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * 报修
 */
public class RepairsActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvTitle;
    private TextView tv_right;
    private ImageView imageBack;
    private TextView tv_to_repairs;
    private SmartRefreshLayout refresh_repairs;
    private EditText et_search;
    private RecyclerView recycle_repairs;
    private List<RepairsCommitBean.DataBean.RecordsBean> repairsBeanList = new ArrayList<>();
    private RepairsCommitAdapter repairsCommitAdapter;

    /*空界面*/
    private LinearLayout ll_empty;
    private ImageView image_top;
    private TextView tv_msg;
    private TextView tv_btn;
    private int page = 1; //第几页


    @Override
    protected int initLayout() {
        return R.layout.activity_repairs;
    }

    @Override
    protected void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_right = (TextView) findViewById(R.id.tv_right);
        tv_to_repairs = (TextView) findViewById(R.id.tv_to_repairs);
        imageBack = (ImageView) findViewById(R.id.image_left);
        recycle_repairs = (RecyclerView) findViewById(R.id.recycle_repairs);
        refresh_repairs = (SmartRefreshLayout) findViewById(R.id.refresh_repairs);

        ll_empty = (LinearLayout) findViewById(R.id.ll_empty);
        image_top = (ImageView) findViewById(R.id.image_top);
        tv_msg = (TextView) findViewById(R.id.tv_msg);
        tv_btn = (TextView) findViewById(R.id.tv_btn);
        et_search = (EditText) findViewById(R.id.et_search);


    }

    @Override
    protected void onResume() {
        super.onResume();
        repairsBeanList.clear();
        page = 1;
        getList(page);
    }

    @Override
    protected void initData() {
        tvTitle.setText("报修");
        tv_right.setVisibility(View.VISIBLE);
        tv_right.setText("我的报修");
        repairsCommitAdapter = new RepairsCommitAdapter(repairsBeanList);
        recycle_repairs.setLayoutManager(new LinearLayoutManager(this));
        recycle_repairs.setAdapter(repairsCommitAdapter);

    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        tv_to_repairs.setOnClickListener(this);
        tv_btn.setOnClickListener(this);
        tv_right.setOnClickListener(this);

        repairsCommitAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToBean(RepairsActivity.this,RepairsMsgActivity.class,repairsBeanList.get(position));
            }
        });

        refresh_repairs.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                repairsBeanList.clear();
                page = 1;
                getList(page);
            }
        });

        refresh_repairs.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                getList(page);
            }
        });

        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == KeyEvent.KEYCODE_ENTER) {
                    //先隐藏键盘
                    ((InputMethodManager) et_search.getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(
                                    RepairsActivity.this
                                            .getCurrentFocus()
                                            .getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
                    //实现搜索逻辑
//                    gotoSearch();
                    repairsBeanList.clear();
                    page=1;
                    getList(page);
                    return true;
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
            case R.id.tv_to_repairs:
            case R.id.tv_btn:
                CutToUtils.getInstance().JumpTo(RepairsActivity.this, RepairsCommitActivity.class);
                break;
            case R.id.tv_right:
                CutToUtils.getInstance().JumpTo(RepairsActivity.this, MyRepairsActivity.class);
                break;
        }
    }

    private void getList(int page) {
        GetRequest getRequest = EasyHttp.get(AppUrl.RepairList);
        getRequest.syncRequest(false);
        getRequest .params("pageNum", String.valueOf(page));
        getRequest.params("pageSize", "10");
        if (et_search.getText().toString()!=null&&!et_search.getText().toString().equals("")){
            getRequest.params("content", et_search.getText().toString());
        }
        getRequest .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        refresh_repairs.finishLoadMore();
                        refresh_repairs.finishRefresh();
                        RepairsCommitBean repairsCommitBean = JSON.parseObject(s, RepairsCommitBean.class);
                        if (repairsCommitBean.isSuccess()) {
                            repairsBeanList.addAll(repairsCommitBean.getData().getRecords());
                            if (repairsBeanList.size() > 0) {
                                ll_empty.setVisibility(View.GONE);
                            } else {
                                ll_empty.setVisibility(View.VISIBLE);
                                image_top.setImageResource(R.mipmap.icon_empty_repairs);
                                tv_msg.setText("暂无报修");
                                tv_btn.setVisibility(View.VISIBLE);
                                tv_btn.setText("我要报修");
                            }
                            repairsCommitAdapter.notifyDataSetChanged();
                        } else {
                            ToastShort(repairsCommitBean.getMsg());
                        }
                    }
                });

    }


}
