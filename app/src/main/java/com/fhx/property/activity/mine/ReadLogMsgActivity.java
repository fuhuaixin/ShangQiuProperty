package com.fhx.property.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;

/**
 * 日志详情
 */
public class ReadLogMsgActivity extends BaseActivity implements View.OnClickListener {
    private ImageView image_left;
    @Override
    protected int initLayout() {
        return R.layout.activity_read_log_msg;
    }

    @Override
    protected void initView() {
        image_left = (ImageView) findViewById(R.id.image_left);
    }

    @Override
    protected void initData() {

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
