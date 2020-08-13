package com.fhx.property.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;

/*
    催缴详情
 */
public class ReminderMsgActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageLeft;
    private TextView tvTitle;
    @Override
    protected int initLayout() {
        return R.layout.activity_reminder_msg;
    }

    @Override
    protected void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        imageLeft = (ImageView) findViewById(R.id.image_left);
    }

    @Override
    protected void initData() {
        tvTitle.setText("费用详情");
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
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
