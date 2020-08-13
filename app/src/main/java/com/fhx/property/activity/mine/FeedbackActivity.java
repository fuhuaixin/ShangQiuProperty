package com.fhx.property.activity.mine;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;

/**
 * 投诉反馈
 */
public class FeedbackActivity extends BaseActivity implements View.OnClickListener{
    private ImageView imageLeft,imageRight;
    private TextView tvTitle;
    private EditText etFeedback;
    @Override
    protected int initLayout() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void initView() {
        etFeedback = (EditText) findViewById(R.id.et_feedback);
        imageLeft = (ImageView) findViewById(R.id.image_left);
        imageRight = (ImageView) findViewById(R.id.image_right);
        tvTitle = (TextView) findViewById(R.id.tv_title);
    }

    @Override
    protected void initData() {
        imageRight.setVisibility(View.VISIBLE);
        tvTitle.setText("投诉反馈");
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
            case R.id.image_right:
                ToastShort("保存");
                break;
        }
    }
}
