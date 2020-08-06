package com.fhx.property.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;


/**
 * 维修评价
 */
public class RepairsMsgEvaActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageLeft;
    private ImageView imageRight;
    private TextView tvTitle;

    @Override
    protected int initLayout() {
        return R.layout.activity_repairs_msg_eva;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        imageRight = (ImageView) findViewById(R.id.image_right);
        tvTitle = (TextView) findViewById(R.id.tv_title);
    }

    @Override
    protected void initData() {
        tvTitle.setText("评价");
        imageRight.setVisibility(View.VISIBLE);
        imageLeft.setImageResource(R.mipmap.icon_back_all_x);
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        imageRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.image_right:
                ToastShort("提交并执行退出动画");
                break;
        }
    }
}
