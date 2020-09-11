package com.fhx.property.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;

/**
 * 提交请假
 */
public class LeaveCommitActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageLeft;
    private TextView tvTitle;
    private TextView tv_type;
    private String strType;

    @Override
    protected int initLayout() {
        return R.layout.activity_leave_commit;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_type = (TextView) findViewById(R.id.tv_type);
    }

    @Override
    protected void initData() {
        tvTitle.setText("请假提交");
        strType = getIntent().getStringExtra("jumpOne");
        tv_type.setText(strType);
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
