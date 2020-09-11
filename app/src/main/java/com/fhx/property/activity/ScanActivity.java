package com.fhx.property.activity;

import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;

import cn.bingoogolapple.qrcode.core.QRCodeView;

/**
 * 扫一扫界面
 */
public class ScanActivity extends BaseActivity implements View.OnClickListener, QRCodeView.Delegate {
    private TextView tv_home;
    private QRCodeView qrCodeView;
    private ImageView image_light;
    private ImageView image_left;

    private int isOpen = 0; //是否开灯

    @Override
    protected int initLayout() {
        return R.layout.fragment_scan;
    }

    @Override
    protected void initView() {
        image_left = (ImageView) findViewById(R.id.image_left);
        tv_home = (TextView) findViewById(R.id.tv_home);
        image_light = (ImageView) findViewById(R.id.image_light);
        qrCodeView = (QRCodeView) findViewById(R.id.qrZBar);
        qrCodeView.setDelegate(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListen() {
        image_left.setOnClickListener(this);
        image_light.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_light:
                if (isOpen == 0) {
                    qrCodeView.openFlashlight();//开灯
                    isOpen = 1;
                } else if (isOpen == 1) {
                    qrCodeView.closeFlashlight();//开灯
                    isOpen = 0;
                }
                break;
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
        }
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        vibrate();//震动手机
        //扫描成功后处理事件
        qrCodeView.startSpot();//继续扫描
        tv_home.setText(result);
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Toast.makeText(ScanActivity.this, "错误", Toast.LENGTH_SHORT).show();

    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    @Override
    public void onStart() {
        super.onStart();
        qrCodeView.startCamera();//打开后置摄像头开始预览，但是并未开始识别;
        qrCodeView.startSpotAndShowRect(); // 显示扫描框，并开始识别

//        mQRCodeView.showScanRect();//显示扫描框
//        qrCodeView.startSpot();//开始识别二维码
//        qrCodeView.openFlashlight();//开灯
        //mQRCodeView.closeFlashlight();//关灯
    }


    @Override
    public void onStop() {
        qrCodeView.stopCamera();// 关闭摄像头预览，并且隐藏扫描框
        super.onStop();
    }


    @Override
    public void onDestroy() {
        qrCodeView.onDestroy();
        super.onDestroy();
    }
}
