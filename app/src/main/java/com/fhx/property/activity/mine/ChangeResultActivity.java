package com.fhx.property.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.property.MainActivity;
import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.utils.CutToUtils;

/**
 * 修改手机号结果页面
 */
public class ChangeResultActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageLeft;
    private TextView tvTitle;
    private TextView tv_back;

    @Override
    protected int initLayout() {
        return R.layout.activity_change_result;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_back = (TextView) findViewById(R.id.tv_back);
    }

    @Override
    protected void initData() {
        tvTitle.setText("更换手机号");
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        tv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.tv_back:

                CutToUtils.getInstance().JumpTo(ChangeResultActivity.this, MainActivity.class);
                break;
        }
    }
}
