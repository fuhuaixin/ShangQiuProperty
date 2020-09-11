package com.fhx.property.activity.mine;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;

/**
 * 薪资详情
 */
public class PayMsgActivity extends BaseActivity implements View.OnClickListener {
    private ImageView image_left;
    private TextView tv_choose;
    @Override
    protected int initLayout() {
        return R.layout.activity_pay_msg;
    }

    @Override
    protected void initView() {
        image_left = (ImageView) findViewById(R.id.image_left);
        tv_choose = (TextView) findViewById(R.id.tv_choose);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListen() {
        image_left.setOnClickListener(this);
        tv_choose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.tv_choose:
                break;
        }
    }



}
