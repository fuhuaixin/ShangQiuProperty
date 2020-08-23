package com.fhx.property.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.FaultNotifiAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.FaultNotifiBean;
import com.fhx.property.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 故障通知
 */
public class FaultNotifiActivity extends BaseActivity implements View.OnClickListener{
    private TextView tvTitle;
    private ImageView imageBack;
    private RecyclerView recycle_fault;
    private FaultNotifiAdapter notifiAdapter;
    private List<FaultNotifiBean> notifiBeanList =new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.activity_fault_notifi;
    }

    @Override
    protected void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        imageBack = (ImageView)findViewById(R.id.image_left);
        recycle_fault = (RecyclerView) findViewById(R.id.recycle_fault);
    }

    @Override
    protected void initData() {
        tvTitle.setText("故障通知");
        notifiBeanList.add(new FaultNotifiBean("0#消防栓水压过高","A座2404","1分钟前",0));
        notifiBeanList.add(new FaultNotifiBean("0#1#消防栓水压过高，管道监测 有异物","A座2404","2小时前",1));
        notifiBeanList.add(new FaultNotifiBean("A006#烟感报警器离线","A座2404","8月10日",1));
        notifiBeanList.add(new FaultNotifiBean("0#消防栓水压过高","A座2404","1分钟前",2));
        notifiBeanList.add(new FaultNotifiBean("8302#阀门温度过高","A座2404","4月6日",2));
        notifiAdapter =new FaultNotifiAdapter(notifiBeanList);
        recycle_fault.setLayoutManager(new LinearLayoutManager(this));
        recycle_fault.setAdapter(notifiAdapter);
    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);

        notifiAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToOne(FaultNotifiActivity.this,FaultNotifiMsgActivity.class,""+notifiBeanList.get(position).getProgress());
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation,R.anim.activity_out_to_animation);
                break;
        }
    }
}
