package com.fhx.property.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.LeaveAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.LeaveBean;
import com.fhx.property.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 请假界面
 */
public class LeaveActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageLeft,imageRight;
    private TextView tvTitle;
    private RecyclerView recycle_write;
    private LeaveAdapter leaveAdapter ;
    private List<LeaveBean> beanList =new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.activity_leave;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        imageRight = (ImageView) findViewById(R.id.image_right);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle_write = (RecyclerView) findViewById(R.id.recycle_write);
    }

    @Override
    protected void initData() {
        tvTitle.setText("请假");
        imageRight.setVisibility(View.VISIBLE);
        imageRight.setImageResource(R.mipmap.icon_leave_right);

        beanList.add(new LeaveBean(R.mipmap.icon_leave_shi,"事假",0));
        beanList.add(new LeaveBean(R.mipmap.icon_leave_bing,"病假",0));
        beanList.add(new LeaveBean(R.mipmap.icon_leave_pei,"临时假",0));
        beanList.add(new LeaveBean(R.mipmap.icon_leave_nian,"年假",0));
        beanList.add(new LeaveBean(R.mipmap.icon_leave_chan,"产假",0));
        beanList.add(new LeaveBean(R.mipmap.icon_leave_hun,"婚假",0));
        beanList.add(new LeaveBean(R.mipmap.icon_leave_sang,"丧假",0));

        leaveAdapter =new LeaveAdapter(beanList);
        recycle_write.setLayoutManager(new LinearLayoutManager(this));
        recycle_write.setAdapter(leaveAdapter);

    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        imageRight.setOnClickListener(this);
        leaveAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToOne(LeaveActivity.this,LeaveCommitActivity.class,beanList.get(position).getTitle());
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
            case R.id.image_right:
                CutToUtils.getInstance().JumpTo(LeaveActivity.this,LeaveRecordActivity.class);
                break;
        }
    }
}
