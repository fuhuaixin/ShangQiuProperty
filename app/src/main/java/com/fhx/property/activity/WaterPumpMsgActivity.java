package com.fhx.property.activity;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;

/**
 * 集水坑详情
 */
public class WaterPumpMsgActivity extends BaseActivity implements View.OnClickListener{
    private ImageView imageLeft,image_more_one,image_more_two;
    private TextView tvTitle;

    @Override
    protected int initLayout() {
        return R.layout.activity_water_pump_msg;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        image_more_one = (ImageView) findViewById(R.id.image_more_one);
        image_more_two = (ImageView) findViewById(R.id.image_more_two);
        tvTitle = (TextView) findViewById(R.id.tv_title);
    }

    @Override
    protected void initData() {
        tvTitle.setText("集水坑");
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        image_more_one.setOnClickListener(this);
        image_more_two.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.image_more_one:
                ShowMenu(WaterPumpMsgActivity.this,image_more_one);
                break;
            case R.id.image_more_two:
                ShowMenu(WaterPumpMsgActivity.this,image_more_two);
                break;
        }
    }



}
