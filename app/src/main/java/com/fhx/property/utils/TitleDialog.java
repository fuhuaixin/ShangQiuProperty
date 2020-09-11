package com.fhx.property.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.fhx.property.R;

public class TitleDialog extends Dialog {
    Activity mActivity;
    int layout;
    public TitleDialog(@NonNull Activity mActivity,int layout) {
        super(mActivity, R.style.ListDialog);
        this.mActivity =mActivity;
        this.layout=layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout);
        Window window = getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.dialogAnimations);

        int screenWidth = mActivity.getWindowManager().getDefaultDisplay().getWidth(); // 屏幕宽
        int screenHeight = mActivity.getWindowManager().getDefaultDisplay().getHeight(); // 屏幕高

        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = (int) (screenHeight*0.85);
        window.setAttributes(lp);

    }
}
