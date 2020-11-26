package com.fhx.property.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.LeaseListAdapter;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.LeaseListBean;
import com.fhx.property.bean.TenantByPageBean;
import com.fhx.property.utils.CutToUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 租赁管理列表
 */
public class LeaseListActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageLeft;
    private TextView tvTitle;
    private RecyclerView recycle_lease;

    /*空界面*/
    private LinearLayout ll_empty;
    private ImageView image_top;
    private TextView tv_msg;
    private TextView tv_btn;

    private LeaseListAdapter adapter;
    private List<LeaseListBean> mList = new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_reminder;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle_lease = (RecyclerView) findViewById(R.id.recycle_reminder);

        ll_empty = (LinearLayout) findViewById(R.id.ll_empty);
        image_top = (ImageView) findViewById(R.id.image_top);
        tv_msg = (TextView) findViewById(R.id.tv_msg);
        tv_btn = (TextView) findViewById(R.id.tv_btn);
    }

    @Override
    protected void initData() {
        tvTitle.setText("租赁管理");

        adapter = new LeaseListAdapter(mList);
        recycle_lease.setLayoutManager(new LinearLayoutManager(this));
        recycle_lease.setAdapter(adapter);
//        imageLeft.setImageResource(R.mipmap.icon_title_right_more);

        getList();
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                CutToUtils.getInstance().JumpTo();
                Intent intent = new Intent(LeaseListActivity.this, LeaseMsgActivity.class);
                intent.putExtra("spaceId",mList.get(position).getSpaceId());
                intent.putExtra("bean",bean);
                startActivity(intent);
                overridePendingTransition(R.anim.activity_in_from_anim, R.anim.activity_in_to_anim);

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
     * 获取列表信息
     */
    TenantByPageBean bean;
    private void getList() {
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNum", "1");
        params.put("pageSize", "10");
//        params.put("key3", "也可以使用三方工具将对象转成json字符串");
        JSONObject jsonObject = new JSONObject(params);
        EasyHttp.post(AppUrl.TenantByPage)
                .upJson(jsonObject.toString())
                .syncRequest(false)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        bean = JSON.parseObject(s, TenantByPageBean.class);
                        if (bean.isSuccess()) {
                            List<TenantByPageBean.DataBean.RecordsBean> records = bean.getData().getRecords();

                            for (int i = 0; i < records.size(); i++) {
                                for (int j = 0; j < records.get(i).getContracts().size(); j++) {
                                    mList.add(new LeaseListBean(records.get(i).getCompany(),
                                            "房号：" + records.get(i).getContracts().get(j).getRoom(),
                                            records.get(i).getContracts().get(j).getSpaceId()));
                                }
                            }

                            if (mList.size() > 0) {
                                ll_empty.setVisibility(View.GONE);
                            } else {
                                ll_empty.setVisibility(View.VISIBLE);
                                image_top.setImageResource(R.mipmap.icon_empty_lease);
                                tv_msg.setText("暂无登记租户");
//            tv_btn.setVisibility(View.VISIBLE);
//            tv_btn.setText("我要报修");
                            }
                            adapter.notifyDataSetChanged();
                        } else {
                            ToastShort(bean.getMsg());
                        }
                    }
                });

    }
}
