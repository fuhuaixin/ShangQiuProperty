package com.fhx.property.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.fhx.property.R;

/**
 * 反馈提交dialog
 */
public class CoupleBackDialog extends Dialog {
    private TextView tv_cancel;

    public CoupleBackDialog(@NonNull Context context) {
        super(context, R.style.CustomDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_couple_back);
        Window window = getWindow();
        window.setGravity(Gravity.CENTER);
//        window.setWindowAnimations(R.style.dialogAnimations);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);

initViews();
        initOnClick();
    }

    private void initViews() {
        tv_cancel =findViewById(R.id.tv_cancel );
    }

    private void initOnClick() {
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }


}
