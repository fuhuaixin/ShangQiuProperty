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
import com.fhx.property.adapter.NotifyListAdapter;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.NotifyListBean;
import com.fhx.property.utils.CutToUtils;
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
 * 通知列表
 */
public class NotifyListActivity extends BaseActivity {

    private ImageView imageLeft;
    private TextView tvTitle;
    private EditText etSearch;
    private RecyclerView recycleNotify;
    private SmartRefreshLayout refreshLayout;

    /*空界面*/
    private LinearLayout ll_empty;
    private ImageView image_top;
    private TextView tv_msg;
    private TextView tv_btn;

    private NotifyListAdapter adapter;

    private List<NotifyListBean.DataBean.RecordsBean> mList = new ArrayList<>();
    private int page = 1; //第几页

    @Override
    protected int initLayout() {
        return R.layout.activity_reminder;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        etSearch = (EditText) findViewById(R.id.et_search);
        recycleNotify = (RecyclerView) findViewById(R.id.recycle_reminder);
        refreshLayout = (SmartRefreshLayout) findViewById(R.id.refreshLayout);

        ll_empty = (LinearLayout) findViewById(R.id.ll_empty);
        image_top = (ImageView) findViewById(R.id.image_top);
        tv_msg = (TextView) findViewById(R.id.tv_msg);
        tv_btn = (TextView) findViewById(R.id.tv_btn);
    }

    @Override
    protected void initData() {
        tvTitle.setText("通知公告");
        etSearch.setHint("搜索公告标题及内容");

        recycleNotify.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NotifyListAdapter(mList);
        recycleNotify.setAdapter(adapter);

        getNews(1);

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

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToOne(NotifyListActivity.this, NotifyMsgActivity.class, mList.get(position).getNewsId());
            }
        });

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mList.clear();
                page = 1;
                getNews(page);
            }
        });

        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                getNews(page);
            }
        });
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == KeyEvent.KEYCODE_ENTER) {
                    //先隐藏键盘
                    ((InputMethodManager) etSearch.getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(
                                    NotifyListActivity.this
                                            .getCurrentFocus()
                                            .getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
                    //实现搜索逻辑
//                    gotoSearch();
                    mList.clear();
                    page=1;
                    getNews(page);
                    return true;
                }
                return false;
            }
        });
    }

    /**
     * 获取通知公告
     */
    private void getNews(int page) {

        GetRequest getRequest = EasyHttp.get(AppUrl.NewsList);
        getRequest.syncRequest(false);
        getRequest.params("pageNum", String.valueOf(page));
        getRequest.params("pageSize", "5");
        if (etSearch.getText().toString()!=null&&!etSearch.getText().toString().equals("")){
            getRequest.params("title", etSearch.getText().toString());
        }
        getRequest.execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        refreshLayout.finishLoadMore();
                        refreshLayout.finishRefresh();
                        NotifyListBean notifyListBean = JSON.parseObject(s, NotifyListBean.class);
                        if (notifyListBean.isSuccess()) {
                            NotifyListBean.DataBean data = notifyListBean.getData();
                            mList.addAll(data.getRecords());
                            if (mList.size() > 0) {
                                ll_empty.setVisibility(View.GONE);
                            } else {
                                ll_empty.setVisibility(View.VISIBLE);
                                image_top.setImageResource(R.mipmap.icon_empty_notice);
                                tv_msg.setText("暂无公告");
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
    }



}
