package com.fhx.property.fragment;

import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fhx.property.R;
import com.fhx.property.base.BaseFragment;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zbar.ZBarView;

import static android.content.Context.VIBRATOR_SERVICE;

/**
 * 扫一扫Fragment
 */
public class ScanFragment extends BaseFragment implements QRCodeView.Delegate {

    private TextView tv_home;
    private QRCodeView qrCodeView;
//    private ZBarView zBarView;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_scan;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        tv_home =view.findViewById(R.id.tv_home);
        qrCodeView  = view.findViewById(R.id.qrZBar);
        qrCodeView.setDelegate(this);
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
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
        Toast.makeText(getContext(), "错误", Toast.LENGTH_SHORT).show();
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

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getContext().getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
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
