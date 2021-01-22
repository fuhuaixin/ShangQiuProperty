package com.fhx.property.activity.login;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.alibaba.fastjson.JSON;
import com.fhx.property.MainActivity;
import com.fhx.property.R;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.LoginBean;
import com.fhx.property.bean.WebSocketBean;
import com.fhx.property.utils.CutToUtils;
import com.fhx.property.utils.JWebSocketClient;
import com.fhx.property.utils.NotificationClickReceiver;
import com.lljjcoder.style.citylist.Toast.ToastUtils;
import com.tencent.mmkv.MMKV;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.net.URI;

/**
 * 闪屏页面
 */
public class SplashActivity extends BaseActivity {

    //推送
    private JWebSocketClient client;
    private URI uri;

    private String userName;
    private String passWord;

    @Override
    protected int initLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

        uri = URI.create("ws://192.168.10.219:8083/wuye/"+mmkv.decodeString("userId"));//

        client = new JWebSocketClient(uri) {
            @Override
            public void onMessage(String message) {
                //message就是接收到的消息
                Log.e("JWebSClientService2", message);
                sendChatMsg(message);
            }
        };

        connect();

        userName = mmkv.decodeString("userName");
        passWord = mmkv.decodeString("passWord");
        Log.e("fhxx", "存储账号密码" + userName + "\n" + passWord);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (userName != null && passWord != null && !userName.equals("") && !passWord.equals("")) {
                    toLogin(userName, passWord);
                } else {
                    CutToUtils.getInstance().JumpTo(SplashActivity.this, LoginActivity.class);
                    finish();
                }
            }
        }, 2000);


    }

    @Override
    protected void initData() {
        setSwipeBackEnable(false);
    }

    @Override
    protected void initListen() {

    }

    //WebSocket开启连接
    private void connect() {
        try {
            client.connectBlocking();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int requestCode = 0;

    public void sendChatMsg(String msg) {
        WebSocketBean webSocketBean = JSON.parseObject(msg, WebSocketBean.class);
        requestCode++;
        Intent intent = new Intent(this, NotificationClickReceiver.class);
        Log.e("fhxx", "这是我准备发送的" + msg + " -----  >" + requestCode);
        intent.putExtra("msg", msg);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this, "chat")
                .setContentTitle(webSocketBean.getType())
                .setContentText(webSocketBean.getContent())
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.icon_logo)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.icon_logo))
                .setDefaults(Notification.GROUP_ALERT_ALL) //设置默认的提示音，振动方式，灯光
                .setAutoCancel(true)
                .setContentIntent(broadcast)
                .build();
        manager.notify(requestCode, notification);

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    private void toLogin(final String user, final String password) {
        EasyHttp.post(AppUrl.Login)
                .syncRequest(false)
                .params("userName", user)
                .params("password", password)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        LoginBean loginBean = JSON.parseObject(s, LoginBean.class);
                        if (loginBean.isSuccess()) {
                            mmkv.encode("userName", user);
                            mmkv.encode("passWord", password);

                            mmkv.encode("token", loginBean.getData().getToken());
                            mmkv.encode("userId", loginBean.getData().getUser().getUserId());
                            mmkv.encode("originId", loginBean.getData().getUser().getOriginId());

                            finish();
                            CutToUtils.getInstance().JumpTo(SplashActivity.this, MainActivity.class);

                        } else {
                            ToastUtils.showShortToast(SplashActivity.this, loginBean.getMsg());
                        }
                    }
                });

    }

}
