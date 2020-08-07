package com.fhx.property.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;

/**
 * 新风 排风 通用详情页
 */
public class FreshVentilateActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageLeft,imageRight;
    private TextView tvTitle;
    private LinearLayout ll_fresh;

    String jumpOne,jumpTwo;

    @Override
    protected int initLayout() {
        return R.layout.activity_fresh_ventilate;
    }

    @Override
    protected void initView() {
        imageLeft= (ImageView) findViewById(R.id.image_left);
        imageRight = (ImageView) findViewById(R.id.image_right);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        ll_fresh = (LinearLayout) findViewById(R.id.ll_fresh);
    }

    @Override
    protected void initData() {
        jumpOne= getIntent().getStringExtra("jumpOne");
        jumpTwo= getIntent().getStringExtra("jumpTwo");
        tvTitle.setText(jumpOne);
        imageRight.setVisibility(View.VISIBLE);
        imageRight.setImageResource(R.mipmap.icon_title_right_more);

        if (jumpTwo.equals("fresh")){
            ll_fresh.setVisibility(View.VISIBLE);
        }else {
            ll_fresh.setVisibility(View.GONE);
        }

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
