package com.fhx.property.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;

/**
 * 音乐 广播详情
 */
public class BroadcastMsgActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageRight;
    private ImageView imageLeft;
    private TextView tvTitle;
    @Override
    protected int initLayout() {
        return R.layout.activity_broadcast_msg;
    }

    @Override
    protected void initView() {
        imageRight = (ImageView) findViewById(R.id.image_right);
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
    }

    @Override
    protected void initData() {
        tvTitle.setText("");
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        imageRight.setOnClickListener(this);
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
