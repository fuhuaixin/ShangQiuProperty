package com.fhx.property.activity.mine;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.fhx.property.R;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.SuccessBean2;
import com.fhx.property.event.EventLeaveComBean;
import com.fhx.property.dialog.DateAndTimeDialog;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * 提交请假
 */

public class LeaveCommitActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageLeft;
    private TextView tvTitle;
    private TextView tv_type,tv_commit,tv_start_time,tv_end_time;
    private EditText et_notes;
    private String strType,leaveType;
    private DateAndTimeDialog dateAndTimeDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_leave_commit;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_type = (TextView) findViewById(R.id.tv_type);
        tv_commit = (TextView) findViewById(R.id.tv_commit);
        tv_start_time = (TextView) findViewById(R.id.tv_start_time);
        tv_end_time = (TextView) findViewById(R.id.tv_end_time);
        et_notes = (EditText) findViewById(R.id.et_notes);
    }

    @Override
    protected void initData() {
        tvTitle.setText("请假提交");
        strType = getIntent().getStringExtra("jumpOne");
        tv_type.setText(strType);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMessage(EventLeaveComBean eventLeaveComBean) {
        Log.e("fhxx","---------"+eventLeaveComBean.getTag()+"         "+eventLeaveComBean.getTime());
        switch (eventLeaveComBean.getTag()){
            case "start":
                tv_start_time.setText(eventLeaveComBean.getTime());
                break;
            case "end":
                tv_end_time.setText(eventLeaveComBean.getTime());
                break;
        }
    }
    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        tv_commit.setOnClickListener(this);
        tv_start_time.setOnClickListener(this);
        tv_end_time.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.tv_commit:
                if (tv_start_time.getText().toString().equals("请选择")){
                    ToastShort("请选择开始时间");
                    return;
                }
                if (tv_end_time.getText().toString().equals("请选择")){
                    ToastShort("请选择结束时间");
                    return;
                }
                if (TextUtils.isEmpty(et_notes.getText().toString())){
                    ToastShort("请输入请假事由");
                    return;
                }

                commit();
                break;
            case R.id.tv_start_time:
                dateAndTimeDialog = new DateAndTimeDialog("start");

                dateAndTimeDialog.show(getSupportFragmentManager(),"start");
                break;
            case R.id.tv_end_time:
                dateAndTimeDialog = new DateAndTimeDialog("end");

                dateAndTimeDialog.show(getSupportFragmentManager(),"end");
                break;
        }
    }


    /**
     * 提交请假
     */
    private void commit(){
        switch (strType){
            case "事假":
                leaveType="1";
                break;
            case "病假":
                leaveType="2";
                break;
            case "临时假":
                leaveType="3";
                break;
            case "年假":
                leaveType="4";
                break;
            case "婚假":
                leaveType="5";
                break;
            case "丧假":
                leaveType="6";
                break;
            case "产假":
                leaveType="7";
                break;
        }
        HashMap<String, String> params = new HashMap<>();
        params.put("begintime", tv_start_time.getText().toString());
        params.put("endtime", tv_end_time.getText().toString());
        params.put("leaveType",leaveType);
        params.put("mark", et_notes.getText().toString());
        params.put("operation", "commit");
        params.put("sheetNo", String.valueOf(System.currentTimeMillis()));
        JSONObject jsonObject = new JSONObject(params);

        EasyHttp.post(AppUrl.LeaveSubmit)
                .syncRequest(false)
                .headers("Admin-Token",mmkv.decodeString("token"))
                .upJson(jsonObject.toString())
        .execute(new SimpleCallBack<String >() {
            @Override
            public void onError(ApiException e) {
                Log.e("error",e.getMessage());
            }

            @Override
            public void onSuccess(String s) {
                SuccessBean2 successBean2 = JSON.parseObject(s, SuccessBean2.class);
                if (successBean2.isSuccess()){
                    ToastShort("提交成功");
                    finish();
                    overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);

                }else {
                    ToastShort(successBean2.getMsg());
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
