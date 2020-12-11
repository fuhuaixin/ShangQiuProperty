package com.fhx.property.activity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.fhx.property.R;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.RepairsCommitBean;
import com.fhx.property.bean.SuccessBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;


/**
 * 维修评价
 */
public class RepairsMsgEvaActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageLeft;
    private ImageView imageRight;
    private TextView tvTitle;
    private RatingBar ratingBar;
    private EditText edit_eva;
    private String repairId;

    @Override
    protected int initLayout() {
        return R.layout.activity_repairs_msg_eva;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        imageRight = (ImageView) findViewById(R.id.image_right);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        edit_eva = (EditText) findViewById(R.id.edit_eva);
    }

    @Override
    protected void initData() {
        tvTitle.setText("评价");
        repairId = getIntent().getStringExtra("jumpOne");
        Log.e("fhxx",repairId);
        imageRight.setVisibility(View.VISIBLE);
        imageLeft.setImageResource(R.mipmap.icon_back_all_x);
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        imageRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.image_right:
                commit();
                break;
        }
    }

    private void commit(){
        EasyHttp.post(AppUrl.EvaluteSubmit)
                .syncRequest(false)
                .params("originType","0")
                .params("originId",repairId)
                .params("rateScore",ratingBar.getNumStars()+"")
                .params("customerId",mmkv.decodeString("userId"))
                .params("content",edit_eva.getText().toString())
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error",e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        SuccessBean successBean = JSON.parseObject(s, SuccessBean.class);
                        if (successBean.isSuccess()){
                            ToastShort("提交成功");
                            finish();
                            overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                        }else {
                            successBean.getMsg();
                        }
                    }
                });
    }
}
