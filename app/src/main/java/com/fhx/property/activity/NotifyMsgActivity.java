package com.fhx.property.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.fhx.property.R;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.NotifyMsgBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

/**
 * 通知公告详情
 */
public class NotifyMsgActivity extends BaseActivity {

    private ImageView imageLeft;
    private TextView tvTitle;

    private TextView tv_msg_title, tv_time, tv_content;
    private ImageView image_center;
    private String newsId;

    @Override
    protected int initLayout() {
        return R.layout.activity_notify_msg;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        image_center = (ImageView) findViewById(R.id.image_center);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_msg_title = (TextView) findViewById(R.id.tv_msg_title);
        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_content = (TextView) findViewById(R.id.tv_content);
    }

    @Override
    protected void initData() {
        tvTitle.setText("公告详情");
        newsId = getIntent().getStringExtra("jumpOne");
        image_center.setVisibility(View.GONE);
        getMsg(newsId);
    }


    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
            }
        });
    }

    private void getMsg(String newsId) {
        EasyHttp.get(AppUrl.NewsMsg)
                .syncRequest(false)
                .params("id", newsId)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                        tv_msg_title.setText("网络错误");
                    }

                    @Override
                    public void onSuccess(String s) {
                        NotifyMsgBean notifyMsgBean = JSON.parseObject(s, NotifyMsgBean.class);
                        if (notifyMsgBean.isSuccess()) {
                            tv_msg_title.setText(notifyMsgBean.getData().getTitle());
                            tv_time.setText(notifyMsgBean.getData().getNewsType() + " | " + notifyMsgBean.getData().getCreateTime());
                            tv_content.setText(notifyMsgBean.getData().getContent());
                        } else {
                            tv_msg_title.setText("网络错误");
                        }
                    }
                });
    }

}
