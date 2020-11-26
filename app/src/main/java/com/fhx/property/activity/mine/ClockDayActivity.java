package com.fhx.property.activity.mine;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.fhx.property.R;
import com.fhx.property.adapter.ClockDayAdapter;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.AgainClockDayBean;
import com.fhx.property.bean.ClockDayBean;
import com.fhx.property.utils.WeekUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 考勤天数记录
 */
public class ClockDayActivity extends BaseActivity {
    private ImageView imageLeft;
    private TextView tvTitle;
    private RecyclerView recycle_day;

    private String intentMonth;
    private WeekUtils instance;
    private int monthDay;
    private String startTime;
    private String endTime;
    private Calendar calendar;
    private int year,month;

    private ClockDayAdapter clockDayAdapter;
    private List<AgainClockDayBean> mList =new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.activity_clock_day;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle_day = (RecyclerView) findViewById(R.id.recycle_day);
    }

    @Override
    protected void initData() {
        intentMonth =getIntent().getStringExtra("jumpOne");
        tvTitle.setText("考勤");
        instance = WeekUtils.getInstance();
        getMonthDay();
        recycle_day.setLayoutManager(new LinearLayoutManager(this));
        clockDayAdapter= new ClockDayAdapter(mList);
        recycle_day.setAdapter(clockDayAdapter);
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

    /**
     * 获取列表
     */
    private void getList(){
        EasyHttp.post(AppUrl.AttendRecordList)
                .syncRequest(false)
                .headers("Admin-Token",mmkv.decodeString("token"))
                .params("employeeid",mmkv.decodeString("originId"))
                .params("startdate",startTime)
                .params("enddate",endTime)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error",e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        ClockDayBean clockDayBean = JSON.parseObject(s, ClockDayBean.class);
                        if (clockDayBean.isSuccess()){
                            List<ClockDayBean.DataBean.ListRecordsBean> data = clockDayBean.getData().getListRecords();
                            List<ClockDayBean.DataBean.ListDaysBean> listDays = clockDayBean.getData().getListDays();
                            String newStart,week;
                            for (int j = 0; j < monthDay; j++) {
                                AgainClockDayBean againClockDayBean = new AgainClockDayBean();
                                if (j<9){
                                    newStart=year+"-"+month+"-0"+(j+1);
                                }else {
                                    newStart=year+"-"+month+"-"+(j+1);
                                }
                                week=instance.Week(newStart);
                                againClockDayBean.setDate(newStart);
                                againClockDayBean.setWeek(week);
                                for (int k = 0; k <listDays.size(); k++) {
                                    Log.e("fhxx",newStart+"\n"+newStart.equals(listDays.get(k).getDate())+"\n"+listDays.get(k).getDate());

                                    if (newStart.equals(listDays.get(k).getDate())){
                                        againClockDayBean.setDayType(listDays.get(k).getType());
                                        if (listDays.get(k).getType().equals("holiday")){
                                            againClockDayBean.setHolidayname(listDays.get(k).getHolidayname());
                                        }
                                    }
                                    for (int i = 0; i <data.size() ; i++) {
                                        Log.e("fhxx",newStart+"\n"+newStart.equals(data.get(i).getCheckday())+"\n"+data.get(i).getCheckday());
                                        if (newStart.equals(data.get(i).getCheckday())){
                                            if (data.get(i).getCheckType().equals("am")){
                                                againClockDayBean.setAmTime(data.get(i).getChecktime());
                                            }else if (data.get(i).getCheckType().equals("pm")){
                                                againClockDayBean.setPmTime(data.get(i).getChecktime());
                                            }
                                        }
                                    }
                                }

                                mList.add(againClockDayBean);
                            }

                            clockDayAdapter.notifyDataSetChanged();
                        }else {
                            ToastShort(clockDayBean.getMsg());
                        }
                    }
                });
    }


    //获取月份天数
    private void getMonthDay(){
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        switch (intentMonth){
            case "一月":
                monthDay=instance.getMonthOfDay(year,1);
                month=1;
                startTime =year+"-1-1";
                endTime =year+"-1-"+monthDay;
                break;
            case "二月":
                monthDay=instance.getMonthOfDay(year,2);
                month=2;

                startTime =year+"-2-1";
                endTime =year+"-2-"+monthDay;
                break;
            case "三月":
                monthDay=instance.getMonthOfDay(year,3);
                month=3;

                startTime =year+"-3-1";
                endTime =year+"-3-"+monthDay;
                break;
            case "四月":
                monthDay=instance.getMonthOfDay(year,4);
                month=4;

                startTime =year+"-4-1";
                endTime =year+"-4-"+monthDay;
                break;
            case "五月":
                month=5;

                monthDay=instance.getMonthOfDay(year,5);
                startTime =year+"-5-1";
                endTime =year+"-5-"+monthDay;
                break;
            case "六月":
                month=6;

                monthDay=instance.getMonthOfDay(year,6);
                startTime =year+"-6-1";
                endTime =year+"-6-"+monthDay;
                break;
            case "七月":
                month=7;

                monthDay=instance.getMonthOfDay(year,7);
                startTime =year+"-7-1";
                endTime =year+"-7-"+monthDay;
                break;
            case "八月":
                month=8;

                monthDay=instance.getMonthOfDay(year,8);
                startTime =year+"-8-1";
                endTime =year+"-8-"+monthDay;
                break;
            case "九月":
                month=9;

                monthDay=instance.getMonthOfDay(year,9);
                startTime =year+"-9-1";
                endTime =year+"-9-"+monthDay;
                break;
            case "十月":
                month=10;

                monthDay=instance.getMonthOfDay(year,10);
                startTime =year+"-10-1";
                endTime =year+"-10-"+monthDay;
                break;
            case "十一月":
                month=11;

                monthDay=instance.getMonthOfDay(year,11);
                startTime =year+"-11-1";
                endTime =year+"-11-"+monthDay;
                break;
            case "十二月":
                month=12;

                monthDay=instance.getMonthOfDay(year,12);
                startTime =year+"-12-1";
                endTime =year+"-12-"+monthDay;
                break;

        }

        getList();
    }
}
