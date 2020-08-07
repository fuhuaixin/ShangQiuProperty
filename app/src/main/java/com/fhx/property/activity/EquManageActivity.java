package com.fhx.property.activity;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.utils.CutToUtils;

/**
 * 设备管理
 */
public class EquManageActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageLeft;
    private ImageView image_public;
    private ImageView image_information;
    private ImageView image_light;
    private ImageView image_pump;
    private ImageView image_fresh;
    private ImageView image_ventilating;
    private TextView tvTitle;


    @Override
    protected int initLayout() {
        return R.layout.activity_equ_manage;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        image_public = (ImageView) findViewById(R.id.image_public);
        image_information = (ImageView) findViewById(R.id.image_information);
        image_light = (ImageView) findViewById(R.id.image_light);
        image_pump = (ImageView) findViewById(R.id.image_pump);
        image_fresh = (ImageView) findViewById(R.id.image_fresh);
        image_ventilating = (ImageView) findViewById(R.id.image_ventilating);
        tvTitle = (TextView) findViewById(R.id.tv_title);

    }

    @Override
    protected void initData() {
        tvTitle.setText("设备管理");
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        image_public.setOnClickListener(this);
        image_information.setOnClickListener(this);
        image_light.setOnClickListener(this);
        image_pump.setOnClickListener(this);
        image_fresh.setOnClickListener(this);
        image_ventilating.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.image_public: //背景音乐广播
                JumpTo(BroadcastActivity.class);
                break;
            case R.id.image_information: //信息 广告屏 发布
                JumpTo(InformationActivity.class);
                break;
            case R.id.image_light:
                JumpTo(LightActivity.class);
                break;
            case R.id.image_pump:
                CutToUtils.getInstance().JumpToOne(EquManageActivity.this,WaterPumpActivity.class,"pump");
                break;

            case R.id.image_fresh:
                CutToUtils.getInstance().JumpToOne(EquManageActivity.this,WaterPumpActivity.class,"fresh");

                break;

            case R.id.image_ventilating:
                CutToUtils.getInstance().JumpToOne(EquManageActivity.this,WaterPumpActivity.class,"ventilate");

                break;

        }
    }

    private void JumpTo(Class<? extends Activity> activity){
        CutToUtils.getInstance().JumpTo(EquManageActivity.this,activity);
    }
}
