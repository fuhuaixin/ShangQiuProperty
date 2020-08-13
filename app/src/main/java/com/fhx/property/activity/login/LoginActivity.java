package com.fhx.property.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fhx.property.MainActivity;
import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.utils.CutToUtils;

/**
 * 登录
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout ll_user, ll_password;
    private ImageView image_user, image_password, image_user_del, image_password_del, image_login;
    private TextView tv_forget;
    private EditText edit_password, edit_user;

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        ll_user = (LinearLayout) findViewById(R.id.ll_user);
        ll_password = (LinearLayout) findViewById(R.id.ll_password);
        image_user = (ImageView) findViewById(R.id.image_user);
        image_password = (ImageView) findViewById(R.id.image_password);
        image_user_del = (ImageView) findViewById(R.id.image_user_del);
        image_password_del = (ImageView) findViewById(R.id.image_password_del);
        image_login = (ImageView) findViewById(R.id.image_login);
        tv_forget = (TextView) findViewById(R.id.tv_forget);
        edit_user = (EditText) findViewById(R.id.edit_user);
        edit_password = (EditText) findViewById(R.id.edit_password);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListen() {
        image_login.setOnClickListener(this);
        image_user_del.setOnClickListener(this);
        image_password_del.setOnClickListener(this);

        edit_user.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    ll_user.setBackgroundResource(R.drawable.shape_user_sel_bg);
                    ll_password.setBackgroundResource(R.drawable.shape_user_unsel_bg);
                    image_user.setImageResource(R.mipmap.icon_little_user_blue);
                    image_password.setImageResource(R.mipmap.icon_little_password_gray);
                }
            }
        });
        edit_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    ll_user.setBackgroundResource(R.drawable.shape_user_unsel_bg);
                    ll_password.setBackgroundResource(R.drawable.shape_user_sel_bg);
                    image_user.setImageResource(R.mipmap.icon_little_user_gray);
                    image_password.setImageResource(R.mipmap.icon_little_password_blue);
                }
            }
        });
        edit_user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
               if (s.length()>0){
                   image_user_del.setVisibility(View.VISIBLE);
               }else {
                   image_user_del.setVisibility(View.GONE);

               }
            }
        });
        edit_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()>0){
                    image_password_del.setVisibility(View.VISIBLE);
                }else {
                    image_password_del.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_login:
                finish();
                CutToUtils.getInstance().JumpTo(LoginActivity.this, MainActivity.class);
                break;
            case R.id.image_user_del:
                edit_user.setText("");
                break;
            case R.id.image_password_del:
                edit_password.setText("");
                break;
        }
    }


}
