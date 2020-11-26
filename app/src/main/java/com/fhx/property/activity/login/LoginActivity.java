package com.fhx.property.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.fhx.property.MainActivity;
import com.fhx.property.R;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.LoginBean;
import com.fhx.property.utils.CutToUtils;
import com.lljjcoder.style.citylist.Toast.ToastUtils;
import com.tencent.mmkv.MMKV;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

/**
 * 登录
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout ll_user, ll_password;
    private ImageView image_user, image_password, image_user_del, image_password_del;
    private TextView tv_forget, image_login;
    private EditText edit_password, edit_user;
    public MMKV mmkv;

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
        image_login = (TextView) findViewById(R.id.image_login);
        tv_forget = (TextView) findViewById(R.id.tv_forget);
        edit_user = (EditText) findViewById(R.id.edit_user);
        edit_password = (EditText) findViewById(R.id.edit_password);
    }

    @Override
    protected void initData() {
        mmkv= MMKV.defaultMMKV();
//        mmkv.encode("存在","存进去的村长");
//        ToastUtils.showLongToast(this,mmkv.decodeString("存在"));
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
                if (edit_user.getText().toString().equals("")){
                    ToastShort("请填写账号");
                }else if (edit_password.getText().toString().equals("")){
                    ToastShort("请填写密码");
                }else {
                    toLogin(edit_user.getText().toString(),edit_password.getText().toString());
                }
                break;
            case R.id.image_user_del:
                edit_user.setText("");
                break;
            case R.id.image_password_del:
                edit_password.setText("");
                break;
        }
    }

    private void toLogin(String user,String password){
        EasyHttp.post(AppUrl.Login)
                .syncRequest(false)
                .params("userName",user)
                .params("password",password)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error",e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        LoginBean loginBean = JSON.parseObject(s, LoginBean.class);
                        if (loginBean.isSuccess()){
                            mmkv.encode("userName",edit_user.getText().toString());
                            mmkv.encode("passWord",edit_password.getText().toString());
                            finish();
                            CutToUtils.getInstance().JumpTo(LoginActivity.this, MainActivity.class);
                            //存
                            mmkv.encode("token",loginBean.getData().getToken());
                            mmkv.encode("userId",loginBean.getData().getUser().getUserId());
                            mmkv.encode("originId",loginBean.getData().getUser().getOriginId());
                            Log.e("fhxx","取token"+mmkv.decodeString("token"));
                        }else {
                            ToastUtils.showShortToast(LoginActivity.this,loginBean.getMsg());
                        }
                    }
                });

    }

}
