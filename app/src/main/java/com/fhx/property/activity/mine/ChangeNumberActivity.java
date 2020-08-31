package com.fhx.property.activity.mine;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.utils.CutToUtils;

/**
 * 更换手机号
 */
public class ChangeNumberActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageLeft;
    private TextView tvTitle;
    private EditText et_number;
    private TextView tv_getCode;
    @Override
    protected int initLayout() {
        return R.layout.activity_change_number;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_getCode = (TextView) findViewById(R.id.tv_getCode);
        et_number = (EditText) findViewById(R.id.et_number);
    }

    @Override
    protected void initData() {
        tvTitle.setText("更换手机号");
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        tv_getCode.setOnClickListener(this);

        /**
         * 选中监听
         */
        et_number.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    et_number.setBackgroundResource(R.drawable.shape_f2_blue_28);
                }else {
                    et_number.setBackgroundResource(R.drawable.shape_f2_0_28);
                }
            }
        });
        /**
         * 输入监听
         */
        et_number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()>0){
                    tv_getCode.setBackgroundResource(R.mipmap.image_login_btn);
                }else {
                    tv_getCode.setBackgroundResource(R.drawable.shape_c9_0_28);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.tv_getCode:
                if (tv_getCode.getText().toString().length()>0){
                    ToastShort("点击了");
                    CutToUtils.getInstance().JumpTo(ChangeNumberActivity.this,ChangeCodeActivity.class);
                }else {
                    ToastShort("请输入手机号");
                }
                break;
        }
    }
}
