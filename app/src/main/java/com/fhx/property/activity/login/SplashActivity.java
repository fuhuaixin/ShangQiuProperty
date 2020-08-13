package com.fhx.property.activity.login;

import android.os.Handler;

import com.fhx.property.MainActivity;
import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.utils.CutToUtils;

/**
 * 闪屏页面
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected int initLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        new Handler().postDelayed(new Runnable(){
            public void run(){
                CutToUtils.getInstance().JumpTo(SplashActivity.this, LoginActivity.class);
                finish();
            }
        },2000);
    }

    @Override
    protected void initData() {
        setSwipeBackEnable(false);
    }

    @Override
    protected void initListen() {

    }
}
