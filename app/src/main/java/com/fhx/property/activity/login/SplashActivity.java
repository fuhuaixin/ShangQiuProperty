package com.fhx.property.activity.login;

import android.os.Handler;
import android.util.Log;

import com.fhx.property.MainActivity;
import com.fhx.property.R;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.utils.CutToUtils;
import com.tencent.mmkv.MMKV;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

/**
 * 闪屏页面
 */
public class SplashActivity extends BaseActivity {

    private String userName;
    private String passWord;

    @Override
    protected int initLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        userName = mmkv.decodeString("userName");
        passWord = mmkv.decodeString("passWord");
        Log.e("fhxx", "存储账号密码" + userName + "\n" + passWord);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (userName != null && passWord != null && !userName.equals("") && !passWord.equals("")) {
                    CutToUtils.getInstance().JumpTo(SplashActivity.this, MainActivity.class);
                    finish();
                } else {
                    CutToUtils.getInstance().JumpTo(SplashActivity.this, LoginActivity.class);
                    finish();
                }
            }
        }, 2000);
    }

    @Override
    protected void initData() {
        setSwipeBackEnable(false);
    }

    @Override
    protected void initListen() {

    }


}
