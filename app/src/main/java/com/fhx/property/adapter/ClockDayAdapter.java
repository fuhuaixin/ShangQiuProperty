package com.fhx.property.adapter;

import android.util.Log;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.AgainClockDayBean;
import com.fhx.property.bean.ClockDayBean;
import com.fhx.property.utils.WeekUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ClockDayAdapter extends BaseQuickAdapter<AgainClockDayBean, BaseViewHolder> {
    public ClockDayAdapter(@Nullable List<AgainClockDayBean> data) {
        super(R.layout.adapter_clock_day, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AgainClockDayBean item) {
        helper.setText(R.id.tv_date, item.getDate());
        switch (item.getDayType()) {
            case "restday":
                helper.setText(R.id.tv_week, item.getWeek() + "(休息日)");

                break;
            case "workday":
                helper.setText(R.id.tv_week, item.getWeek() + "(工作日)");

                break;
            case "holiday":
                helper.setText(R.id.tv_week, item.getWeek() + "(" + item.getHolidayname() + ")");

                break;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());
        final String sim = dateFormat.format(curDate);
        int timeCompareSize = WeekUtils.getInstance().getTimeCompareSize(sim, item.getDate());


        if (timeCompareSize == 1 || timeCompareSize == 2) {
            if (item.getAmTime() == null) {
                if (item.getDayType().equals("workday")) {
                    helper.setText(R.id.tv_am, "上班：" + "未打卡(异常)");
                } else {
                    helper.setText(R.id.tv_am, "上班：" + "休息");

                }
            } else {
                helper.setText(R.id.tv_am, "上班：" + item.getAmTime());
            }
            if (item.getPmTime() == null) {
                if (item.getDayType().equals("workday")) {
                    helper.setText(R.id.tv_pm, "下班：" + "未打卡(异常)");
                } else {
                    helper.setText(R.id.tv_pm, "下班：" + "休息");

                }

            } else {
                helper.setText(R.id.tv_pm, "pm：" + item.getPmTime());
            }
        } else {
            helper.setText(R.id.tv_am, "")
                    .setText(R.id.tv_pm, "");
        }


    }
}
