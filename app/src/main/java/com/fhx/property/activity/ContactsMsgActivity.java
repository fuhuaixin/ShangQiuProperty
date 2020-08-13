package com.fhx.property.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.ContactsListBean;

/**
 * 人员详情
 */
public class ContactsMsgActivity extends BaseActivity {
    private TextView tvTitle,tv_name,tv_job,tv_phone;
    private ImageView imageLeft;

    private ContactsListBean bean;

    @Override
    protected int initLayout() {
        return R.layout.activity_contacts_msg;
    }

    @Override
    protected void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_job = (TextView) findViewById(R.id.tv_job);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        imageLeft = (ImageView) findViewById(R.id.image_left);

    }

    @Override
    protected void initData() {
        tvTitle.setText("人员详情");
        bean = (ContactsListBean) getIntent().getSerializableExtra("bean");
        tv_name .setText(bean.getName());
        tv_job .setText(bean.getJob());
        tv_phone .setText(bean.getPhone());
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
