package com.fhx.property.activity.mine;

import android.app.Dialog;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.LeaveRecordBean;

/**
 * 补卡详情
 */
public class MakeCardMsgActivity extends BaseActivity implements View.OnClickListener {
    private ImageView image_left;
    private ImageView image_type_header;
    private TextView tv_progress,tv_back_cause,tv_leave_title,tv_commit_time,tv_back,tv_pass;
    private LinearLayout ll_progress,ll_bottom;
    private LeaveRecordBean leaveRecordBean;
    private int type; //1是看 2是处理
    private int progress;
    private Dialog backDialog;
    @Override
    protected int initLayout() {
        return R.layout.activity_make_card_msg;
    }

    @Override
    protected void initView() {
        image_left = (ImageView) findViewById(R.id.image_left);
        image_type_header = (ImageView) findViewById(R.id.image_type_header);
        tv_progress = (TextView) findViewById(R.id.tv_progress);
        tv_back_cause = (TextView) findViewById(R.id.tv_back_cause);
        tv_leave_title = (TextView) findViewById(R.id.tv_leave_title);
        tv_commit_time = (TextView) findViewById(R.id.tv_commit_time);
        tv_back = (TextView) findViewById(R.id.tv_back);
        tv_pass = (TextView) findViewById(R.id.tv_pass);
        ll_progress = (LinearLayout) findViewById(R.id.ll_progress);
        ll_bottom = (LinearLayout) findViewById(R.id.ll_bottom);
    }

    @Override
    protected void initData() {
        type = getIntent().getIntExtra("jumpOne",0);
        progress = getIntent().getIntExtra("jumpTwo",0);
        Log.e("fhxx",type+"--- "+progress);

        switch (type){
            case 1:
                ll_progress.setVisibility(View.VISIBLE);
                ll_bottom.setVisibility(View.GONE);
                break;
            case 2:
                ll_progress.setVisibility(View.GONE);
                ll_bottom.setVisibility(View.VISIBLE);
                break;
        }
        switch (progress){
            case 0:
                tv_back_cause.setVisibility(View.GONE);

                tv_progress.setText("审批中");
                image_type_header.setImageResource(R.mipmap.icon_leave_ing);
                break;
            case 1:
                tv_back_cause.setVisibility(View.GONE);
                tv_progress.setText("审批通过");
                image_type_header.setImageResource(R.mipmap.icon_leave_pass);

                break;
            case 2:
                tv_back_cause.setVisibility(View.VISIBLE);
                tv_progress.setText("退回");
                image_type_header.setImageResource(R.mipmap.icon_leave_back);

                break;
        }

    }

    @Override
    protected void initListen() {
        image_left.setOnClickListener(this);
        tv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.tv_back:
                backDialog();
                break;
        }
    }

    private void backDialog(){
        backDialog = new Dialog(MakeCardMsgActivity.this,R.style.CustomDialog);
        backDialog.setContentView(R.layout.dialog_leave_back);
        backDialog.show();
        Window window = backDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        int screenWidth = getWindowManager().getDefaultDisplay().getWidth(); // 屏幕宽
        lp.width =(int) screenWidth;
        window.setAttributes(lp);
        TextView tv_cancel = backDialog.findViewById(R.id.tv_cancel);
        TextView tv_back = backDialog.findViewById(R.id.tv_back);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backDialog.dismiss();
            }
        });
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastShort("调用接口");
            }
        });
    }
}
