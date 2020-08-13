package com.fhx.property.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;

/**
 * 修改密码
 */
public class ChangePasswordActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageLeft,imageRight;
    private TextView tvTitle;
    @Override
    protected int initLayout() {
        return R.layout.activity_change_password;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        imageRight = (ImageView) findViewById(R.id.image_right);
        tvTitle = (TextView) findViewById(R.id.tv_title);

    }

    @Override
    protected void initData() {
        imageRight.setVisibility(View.VISIBLE);
        tvTitle.setText("修改密码");
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
