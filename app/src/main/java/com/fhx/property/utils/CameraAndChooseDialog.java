package com.fhx.property.utils;

import android.app.Activity;
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
 * 图片选择 和 照片选择dialog
 */
public class CameraAndChooseDialog extends Dialog implements View.OnClickListener {


    private TextView tv_cancel, tv_camera, tv_choose;
    private LeaveMyDialogListener listener;

    public CameraAndChooseDialog(@NonNull Context context) {
        super(context, R.style.CustomDialog);

    }
    public CameraAndChooseDialog(@NonNull Context context,LeaveMyDialogListener listener) {
        super(context, R.style.CustomDialog);
        this.listener =listener;
    }
    public interface LeaveMyDialogListener{
        public void onClick(View view);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_camera_choose);

        Window window = getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.dialogAnimations);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);

        initViews();
        initData();
    }

    private void initViews() {
        tv_cancel = findViewById(R.id.tv_cancel);
        tv_camera = findViewById(R.id.tv_camera);
        tv_choose = findViewById(R.id.tv_choose);

        tv_choose.setOnClickListener(this);
        tv_camera.setOnClickListener(this);
        tv_cancel.setOnClickListener(this);
    }

    private void initData() {

    }


    @Override
    public void onClick(View v) {
        listener.onClick(v);
        switch (v.getId()) {
           /* case R.id.tv_choose:

                break;
            case R.id.tv_camera:

                break;*/

            case R.id.tv_cancel:
                dismiss();
                break;
        }
    }

}
