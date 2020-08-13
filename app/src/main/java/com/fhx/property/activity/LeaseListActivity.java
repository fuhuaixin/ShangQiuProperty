package com.fhx.property.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.LeaseListAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.LeaseListBean;
import com.fhx.property.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 租赁管理列表
 */
public class LeaseListActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageLeft;
    private TextView tvTitle;
    private RecyclerView recycle_lease;

    private LeaseListAdapter adapter;
    private List<LeaseListBean> mList =new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_reminder;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle_lease = (RecyclerView) findViewById(R.id.recycle_reminder);
    }

    @Override
    protected void initData() {
        tvTitle.setText("租赁管理");
        for (int i = 0; i < 7; i++) {
            mList.add(new LeaseListBean("title"+i,"房号：room"+i));
        }
        adapter =new LeaseListAdapter(mList);
        recycle_lease.setLayoutManager(new LinearLayoutManager(this));
        recycle_lease.setAdapter(adapter);
//        imageLeft.setImageResource(R.mipmap.icon_title_right_more);
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpTo(LeaseListActivity.this,LeaseMsgActivity.class);
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
}
