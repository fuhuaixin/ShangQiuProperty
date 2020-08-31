package com.fhx.property.activity.mine;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.utils.CutToUtils;
import com.tuo.customview.VerificationCodeView;

/**
 * 输入验证码
 */
public class ChangeCodeActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageLeft;
    private TextView tvTitle;
    private VerificationCodeView codeView;
    private TextView tv_time;
    @Override
    protected int initLayout() {
        return R.layout.activity_change_code;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_time = (TextView) findViewById(R.id.tv_time);
        codeView = (VerificationCodeView) findViewById(R.id.icv);
    }

    @Override
    protected void initData() {
        tvTitle.setText("更换手机号");
//        codeView.setEtNumber(6);
//        codeView.setPwdMode(false);
        tv_time.setEnabled(false);
        timer(5000);
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        tv_time.setOnClickListener(this);
        codeView.setInputCompleteListener(new VerificationCodeView.InputCompleteListener() {
            @Override
            public void inputComplete() {
                if (codeView.getInputContent().length()==6){
                    if (codeView.getInputContent().equals("123456")){
                        CutToUtils.getInstance().JumpTo(ChangeCodeActivity.this,ChangeResultActivity.class);
                    }else {
                        ToastShort("验证码错误");
                    }
                }
            }

            @Override
            public void deleteContent() {

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
            case R.id.tv_time:
                timer(5000);
                break;
        }
    }

    /**
     * 倒计时
     */

    private void timer(long time) {
        CountDownTimer countDownTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv_time.setText(millisUntilFinished / 1000 + "s后可重新发送验证码");
                tv_time.setEnabled(false);
            }

            @Override
            public void onFinish() {
                tv_time.setText(0 + "");
                tv_time.setText("重新发送");
                tv_time.setEnabled(true);
//                ToastShort("完成");
            }
        };
        countDownTimer.start();
    }
}
