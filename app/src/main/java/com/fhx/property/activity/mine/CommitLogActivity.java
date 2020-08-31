package com.fhx.property.activity.mine;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;

/**
 * 日报等填写
 */
public class CommitLogActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageLeft;
    private TextView tvTitle;

    private TextView tv_one, tv_two, tv_three;
    private EditText et_one, et_two, et_three;
    private String type;

    @Override
    protected int initLayout() {
        return R.layout.activity_commit_log;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);

        tv_one = (TextView) findViewById(R.id.tv_one);
        tv_two = (TextView) findViewById(R.id.tv_two);
        tv_three = (TextView) findViewById(R.id.tv_three);

        et_one = (EditText) findViewById(R.id.et_one);
        et_two = (EditText) findViewById(R.id.et_two);
        et_three = (EditText) findViewById(R.id.et_three);
    }

    @Override
    protected void initData() {

        type = getIntent().getStringExtra("jumpOne");
        switch (type) {
            case "日报":
                tvTitle.setText("日报填写");

                tv_one.setText("今日完成工作");
                tv_two.setText("明日工作计划");
                tv_three.setText("未完成工作");

                et_one.setHint("请填写今日完成工作内容");
                et_two.setHint("请填写明日工作计划");
                et_three.setHint("请填写今日未完成的工作内容");
                break;
            case "周报":
                tvTitle.setText("周报填写");

                tv_one.setText("本周完成工作");
                tv_two.setText("下周工作计划");
                tv_three.setText("本周工作总结");

                et_one.setHint("请填写本周完成工作");
                et_two.setHint("请填写下周工作计划");
                et_three.setHint("请填写本周工作总结");
                break;
            case "月报":
                tvTitle.setText("月报填写");

                tv_one.setText("本月完成工作");
                tv_two.setText("下月工作计划");
                tv_three.setText("本月工作总结");

                et_one.setHint("请填写本月完成工作");
                et_two.setHint("请填写下月工作计划");
                et_three.setHint("请填写本月工作总结");
                break;
        }
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
        }
    }
}
