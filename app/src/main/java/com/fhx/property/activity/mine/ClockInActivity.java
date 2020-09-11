package com.fhx.property.activity.mine;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.DistanceUtil;
import com.fhx.property.R;
import com.fhx.property.adapter.AbnormalAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.AbnormalBean;
import com.fhx.property.utils.CutToUtils;
import com.fhx.property.utils.TitleDialog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 考勤打卡
 */
public class ClockInActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageLeft, imageRight;
    private TextView tvTitle;
    private TextView tv_time, tv_location;
    private RelativeLayout rl_group;
    private Timer timer;

    @Override
    protected int initLayout() {
        return R.layout.activity_clock_in;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        imageRight = (ImageView) findViewById(R.id.image_right);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_location = (TextView) findViewById(R.id.tv_location);
        rl_group = (RelativeLayout) findViewById(R.id.rl_group);

    }

    @Override
    protected void initData() {
        Client(); //获取定位
        tvTitle.setText("考勤打卡");
        imageRight.setVisibility(View.VISIBLE);
        imageRight.setImageResource(R.mipmap.icon_statistic);
        getDate();
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        imageRight.setOnClickListener(this);
        rl_group.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.image_right:
                CutToUtils.getInstance().JumpTo(ClockInActivity.this, RecordCheckActivity.class);
                break;
            case R.id.rl_group:
                ShowDialog();
                break;
        }
    }


    private void getDate() {

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // (1) 使用handler发送消息
                Message message = new Message();
                Bundle bundle = new Bundle();
                message.what = 0;
                message.setData(bundle);
                mHandler.sendMessage(message);
            }
        }, 0, 1000);

    }


    // (2) 使用handler处理接收到的消息
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                /**
                 * 在这里写我们需要一直重复执行的代码
                 * */
                Date date = new Date();
                String s = date.toLocaleString();

                Log.e("md", "时间time为： " + s);

                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

                String sim = dateFormat.format(date);

                Log.e("md", "时间sim为： " + sim);
                tv_time.setText(sim);
            }
        }
    };

    /**
     * 考勤规则弹窗
     */
    private TitleDialog titleDialog;

    private void ShowDialog() {
        titleDialog = new TitleDialog(ClockInActivity.this, R.layout.dialog_group);
        titleDialog.show();

        final ImageView image_close = titleDialog.findViewById(R.id.image_close);
        TextView tv_group_type = titleDialog.findViewById(R.id.tv_group_type);
        TextView tv_group_rule = titleDialog.findViewById(R.id.tv_group_rule);
        image_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleDialog.dismiss();
            }
        });

    }

    /**
     * 定位
     */

    private void Client() {
        //定位初始化
        LocationClient locationClient = new LocationClient(this);
        //通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);

        //设置locationClientOption
        locationClient.setLocOption(option);

        //注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener();
        locationClient.registerLocationListener(myLocationListener);
        //开启地图定位图层
        locationClient.start();

    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {

            if (location == null) {
                return;
            }
            tv_location.setText("纬度---" + location.getLatitude() + "-经度---" + location.getLongitude());
            LatLng latLng1 = new LatLng(location.getLongitude(), location.getLatitude());
            LatLng latLng2 = new LatLng(113.81, 34.79);
            Log.e("fhxx", "纬度---" + location.getLatitude() + "-经度---" + location.getLongitude());
            Log.e("fhxx", "距离" + DistanceUtil.getDistance(latLng1, latLng2));
        }
    }

}
