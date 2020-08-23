package com.fhx.property.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;

/**
 * z故障详情
 */
public class FaultNotifiMsgActivity extends BaseActivity implements View.OnClickListener {

    private ImageView image_left,image_bg;
    private TextView tv_address,tv_time;
    private LinearLayout ll_bot_one,ll_bot_two,ll_bot_three;

    private int type;

    @Override
    protected int initLayout() {
        return R.layout.activity_fault_notifi_msg;
    }

    @Override
    protected void initView() {
        image_left = (ImageView) findViewById(R.id.image_left);
        image_bg = (ImageView) findViewById(R.id.image_bg);
        tv_address = (TextView) findViewById(R.id.tv_address);
        tv_time = (TextView) findViewById(R.id.tv_time);

        ll_bot_one = (LinearLayout) findViewById(R.id.ll_bot_one);
        ll_bot_two = (LinearLayout) findViewById(R.id.ll_bot_two);
        ll_bot_three = (LinearLayout) findViewById(R.id.ll_bot_three);


    }

    @Override
    protected void initData() {
        type =Integer.parseInt(getIntent().getStringExtra("jumpOne"));
        switch (type){
            case 0:
                ll_bot_one.setVisibility(View.VISIBLE);
                break;
            case 1:
                ll_bot_two.setVisibility(View.VISIBLE);
                break;
            case 2:
                tv_address.setTextColor(getResources().getColor(R.color.bcffd4));
                tv_time.setTextColor(getResources().getColor(R.color.bcffd4));
                image_bg.setImageResource(R.mipmap.image_fault_msg_green);
                ll_bot_three.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    protected void initListen() {
        image_left.setOnClickListener(this);
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
