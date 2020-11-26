package com.fhx.property.activity.mine;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.AbnormalAdapter;
import com.fhx.property.adapter.MonthChooseAdapter;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.AbnormalBean;
import com.fhx.property.bean.AttendRecordStatBean;
import com.fhx.property.bean.ChooseBean;
import com.fhx.property.utils.CutToUtils;
import com.fhx.property.utils.TitleDialog;
import com.fhx.property.utils.WeekUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 考勤统计
 */
public class RecordCheckActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageLeft;
    private TextView tv_abnormal;
    private RecyclerView recycle_month;
    private LinearLayout ll_work_month;
    private TextView tv_countSign, tv_countLate, tv_countEarly;

    private MonthChooseAdapter chooseAdapter;
    private List<ChooseBean> chooseBeanList = new ArrayList<>();
    private TitleDialog titleDialog;
    private Calendar cal;
    private int year;//获取year
    private int month;//获取month

    @Override
    protected int initLayout() {
        return R.layout.activity_record_check;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        recycle_month = (RecyclerView) findViewById(R.id.recycle_month);
        tv_abnormal = (TextView) findViewById(R.id.tv_abnormal);
        tv_countSign = (TextView) findViewById(R.id.tv_countSign);
        tv_countLate = (TextView) findViewById(R.id.tv_countLate);
        tv_countEarly = (TextView) findViewById(R.id.tv_countEarly);
        ll_work_month = (LinearLayout) findViewById(R.id.ll_work_month);
    }

    @Override
    protected void initData() {
        cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;

        chooseBeanList.add(new ChooseBean("一月", 0));
        chooseBeanList.add(new ChooseBean("二月", 0));
        chooseBeanList.add(new ChooseBean("三月", 0));
        chooseBeanList.add(new ChooseBean("四月", 0));
        chooseBeanList.add(new ChooseBean("五月", 0));
        chooseBeanList.add(new ChooseBean("六月", 0));
        chooseBeanList.add(new ChooseBean("七月", 0));
        chooseBeanList.add(new ChooseBean("八月", 0));
        chooseBeanList.add(new ChooseBean("九月", 0));
        chooseBeanList.add(new ChooseBean("十月", 0));
        chooseBeanList.add(new ChooseBean("十一月", 0));
        chooseBeanList.add(new ChooseBean("十二月", 0));
        switch (month) {
            case 1:
                chooseBeanList.get(0).setIsChoose(1);
                break;
            case 2:
                chooseBeanList.get(1).setIsChoose(1);
                break;
            case 3:
                chooseBeanList.get(2).setIsChoose(1);
                break;
            case 4:
                chooseBeanList.get(3).setIsChoose(1);
                break;
            case 5:
                chooseBeanList.get(4).setIsChoose(1);
                break;
            case 6:
                chooseBeanList.get(5).setIsChoose(1);
                break;
            case 7:
                chooseBeanList.get(6).setIsChoose(1);
                break;
            case 8:
                chooseBeanList.get(7).setIsChoose(1);
                break;
            case 9:
                chooseBeanList.get(8).setIsChoose(1);
                break;
            case 10:
                chooseBeanList.get(9).setIsChoose(1);
                break;
            case 11:
                chooseBeanList.get(10).setIsChoose(1);
                break;
            case 12:
                chooseBeanList.get(11).setIsChoose(1);
                break;
        }
        chooseAdapter = new MonthChooseAdapter(chooseBeanList);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycle_month.setLayoutManager(layout);
        recycle_month.setAdapter(chooseAdapter);
        for (int i = 0; i < chooseBeanList.size(); i++) {
            if (chooseBeanList.get(i).getIsChoose() == 1) {
                Log.e("fhxx", "选中了" + i);
                recycle_month.scrollToPosition(i);
            }
        }
        getMsg(month);
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        tv_abnormal.setOnClickListener(this);
        ll_work_month.setOnClickListener(this);


        chooseAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                for (int i = 0; i < chooseBeanList.size(); i++) {
                    chooseBeanList.get(i).setIsChoose(0);
                }
                chooseBeanList.get(position).setIsChoose(1);
                chooseAdapter.notifyDataSetChanged();
                switch (position) {
                    case 0:
                        month = 1;
                        getMsg(month);
                        break;
                    case 1:
                        month = 2;
                        getMsg(month);
                        break;
                    case 2:
                        month = 3;
                        getMsg(month);
                        break;
                    case 3:
                        month = 4;
                        getMsg(month);
                        break;
                    case 4:
                        month = 5;
                        getMsg(month);
                        break;
                    case 5:
                        month = 6;
                        getMsg(month);
                        break;
                    case 6:
                        month = 7;
                        getMsg(month);
                        break;
                    case 7:
                        month = 8;
                        getMsg(month);
                        break;
                    case 8:
                        month = 9;
                        getMsg(month);
                        break;
                    case 9:
                        month = 10;
                        getMsg(month);
                        break;
                    case 10:
                        month = 11;
                        getMsg(month);
                        break;
                    case 11:
                        month = 12;
                        getMsg(month);
                        break;
                }
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
            case R.id.tv_abnormal:
                ShowDialog();
                break;
            case R.id.ll_work_month:
                String month = null;
                for (int i = 0; i < chooseBeanList.size(); i++) {
                    if (chooseBeanList.get(i).getIsChoose() == 1) {
                        month = chooseBeanList.get(i).getTitle();
                    }
                }
                CutToUtils.getInstance().JumpToOne(RecordCheckActivity.this, ClockDayActivity.class, month);
                break;
        }
    }

    private AbnormalAdapter abnormalAdapter;
    private List<AbnormalBean> abnormalBeans = new ArrayList<>();

    private void ShowDialog() {
        titleDialog = new TitleDialog(RecordCheckActivity.this, R.layout.dialog_abnormal);
        titleDialog.show();
        ImageView image_close = titleDialog.findViewById(R.id.image_close);
        RecyclerView recycle_record = titleDialog.findViewById(R.id.recycle_record);
        abnormalBeans.clear();
        abnormalBeans.add(new AbnormalBean("缺卡", "2020-08-12 09:00"));
        abnormalBeans.add(new AbnormalBean("早退", "2020-08-12 09:00"));
        abnormalBeans.add(new AbnormalBean("外勤", "2020-08-12 09:00"));
        abnormalAdapter = new AbnormalAdapter(abnormalBeans);
        recycle_record.setLayoutManager(new LinearLayoutManager(this));
        recycle_record.setAdapter(abnormalAdapter);
        image_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleDialog.dismiss();
            }
        });
    }

    private void getMsg(int moth) {
        int monthOfDay = WeekUtils.getInstance().getMonthOfDay(year, moth);
        String startDate, endDate;
        if (moth > 9) {
            startDate = year + "-" + moth + "-1";
            endDate = year + "-" + moth + "-" + monthOfDay;
        } else {
            startDate = year + "-0" + moth + "-1";
            endDate = year + "-0" + moth + "-" + monthOfDay;

        }
        EasyHttp.get(AppUrl.AttendRecordStat)
                .syncRequest(false)
                .headers("Admin-Token", mmkv.decodeString("token"))
                .params("employeeid", mmkv.decodeString("originId"))
                .params("startdate", startDate)
                .params("enddate", endDate)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        AttendRecordStatBean attendRecordStatBean = JSON.parseObject(s, AttendRecordStatBean.class);
                        if (attendRecordStatBean.isSuccess()) {
                            AttendRecordStatBean.DataBean dataBean = attendRecordStatBean.getData().get(0);
                            tv_countSign.setText(dataBean.getCountSign() + "");
                            tv_countLate.setText(dataBean.getCountLate() + "");
                            tv_countEarly.setText(dataBean.getCountEarly() + "");
                        } else {
                            ToastShort(attendRecordStatBean.getMsg());
                        }

                    }
                });
    }

}
