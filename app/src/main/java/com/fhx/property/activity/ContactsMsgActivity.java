package com.fhx.property.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.fhx.property.R;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.ContactsListBean;
import com.fhx.property.bean.EmployeeDetailBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

/**
 * 人员详情
 */
public class ContactsMsgActivity extends BaseActivity {
    private TextView tvTitle, tv_name, tv_employeeNo, tv_phone, tv_sex, tv_job_top, tv_nation;
    private TextView tv_birthday, tv_mail;
    private ImageView imageLeft;

    private String id;

    @Override
    protected int initLayout() {
        return R.layout.activity_contacts_msg;
    }

    @Override
    protected void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_employeeNo = (TextView) findViewById(R.id.tv_employeeNo);
        tv_job_top = (TextView) findViewById(R.id.tv_job_top);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_nation = (TextView) findViewById(R.id.tv_nation);
        tv_birthday = (TextView) findViewById(R.id.tv_birthday);
        tv_mail = (TextView) findViewById(R.id.tv_mail);
        imageLeft = (ImageView) findViewById(R.id.image_left);

    }

    @Override
    protected void initData() {
        tvTitle.setText("人员详情");
        id = getIntent().getStringExtra("jumpOne");
        tv_name.setText(id);

        getDetail();
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

    /**
     * 获取个人新乡详情
     */
    private void getDetail() {
        EasyHttp.get(AppUrl.EmployeeDetail)
                .syncRequest(false)
                .params("id", id)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        EmployeeDetailBean employeeDetailBean = JSON.parseObject(s, EmployeeDetailBean.class);
                        if (employeeDetailBean.isSuccess()) {
                            EmployeeDetailBean.DataBean data = employeeDetailBean.getData();
                            tv_name.setText(data.getEmployeeName());
                            ;//0 =女  1=男
                            switch (data.getSex()) {
                                case "0":
                                    tv_sex.setText("女");
                                    break;
                                case "1":
                                    tv_sex.setText("男");
                                    break;

                            }
                            tv_job_top.setText(data.getDutyName());
                            tv_employeeNo.setText(data.getEmployeeNo());
                            tv_phone.setText(data.getPhone());
                            tv_nation.setText(data.getNation());
                            tv_birthday.setText(data.getBirthday());
                            tv_mail.setText(data.getMail());


                        } else {
                            ToastShort(employeeDetailBean.getMsg());
                        }
                    }
                });
    }


}
