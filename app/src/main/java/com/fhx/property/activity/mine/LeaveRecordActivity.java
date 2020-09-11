package com.fhx.property.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.LeaveRecordAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.LeaveRecordBean;
import com.fhx.property.utils.CutToUtils;

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
    private LeaveRecordAdapter recordAdapter;
    private List<LeaveRecordBean> recordBeanList =new ArrayList<>();
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
    }

    @Override
    protected void initData() {
        tvTitle.setText("请假记录");
        tv_msg.setText("你还没有提交过请假");
        image_top.setImageResource(R.mipmap.icon_empty_notice);

        recordBeanList.add(new LeaveRecordBean(1,"李明哲提交的请假","2020-08-12 16:54","2020-08-12 16:00","2020-08-16 16:54","事假",0));
        recordBeanList.add(new LeaveRecordBean(2,"李明哲提交的请假","2020-08-12 16:54","2020-08-12 16:00","2020-08-16 16:54","病假",1));
        recordBeanList.add(new LeaveRecordBean(2,"李明哲提交的请假","2020-08-12 16:54","2020-08-12 16:00","2020-08-16 16:54","婚假",2));
        recordBeanList.add(new LeaveRecordBean(2,"李明哲提交的请假","2020-08-12 16:54","2020-08-12 16:00","2020-08-16 16:54","事假",0));
        recordBeanList.add(new LeaveRecordBean(2,"李明哲提交的请假","2020-08-12 16:54","2020-08-12 16:00","2020-08-16 16:54","事假",0));
        recordBeanList.add(new LeaveRecordBean(2,"李明哲提交的请假","2020-08-12 16:54","2020-08-12 16:00","2020-08-16 16:54","事假",0));
        recordBeanList.add(new LeaveRecordBean(2,"李明哲提交的请假","2020-08-12 16:54","2020-08-12 16:00","2020-08-16 16:54","事假",0));

        if (recordBeanList.size()>0){
            ll_empty.setVisibility(View.GONE);
            recordAdapter =new LeaveRecordAdapter(recordBeanList);
            recycle_record.setLayoutManager(new LinearLayoutManager(this));
            recycle_record.setAdapter(recordAdapter);
        }else {
            ll_empty.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        recordAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToTwo(LeaveRecordActivity.this,LeaveMsgActivity.class,1,recordBeanList.get(position).getProgress());
//                CutToUtils.getInstance().JumpToBean(LeaveRecordActivity.this,LeaveMsgActivity.class,recordBeanList.get(position));
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
