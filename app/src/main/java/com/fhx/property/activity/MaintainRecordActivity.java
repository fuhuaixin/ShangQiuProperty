package com.fhx.property.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;

/**
 * 维护记录
 */
public class MaintainRecordActivity extends BaseActivity {
    private ImageView imageLeft;
    private TextView tvTitle;
    private RecyclerView recycle_record;
    @Override
    protected int initLayout() {
        return R.layout.activity_maintain_record;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle_record = (RecyclerView) findViewById(R.id.recycle_record);
    }

    @Override
    protected void initData() {
        tvTitle.setText("维护记录");
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
            }
        });

    }
}
