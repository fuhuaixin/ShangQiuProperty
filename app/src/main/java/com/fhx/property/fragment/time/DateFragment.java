package com.fhx.property.fragment.time;

import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.fhx.property.R;
import com.fhx.property.base.BaseFragment;
import com.fhx.property.utils.DateTimeChange;


public class DateFragment extends BaseFragment {
    CalendarView calendar;
    @Override
    public int setLayoutId() {
        return R.layout.fragment_date;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        calendar =view.findViewById(R.id.calendar);
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//                Toast.makeText(getContext(), year+"年"+month+"月"+dayOfMonth, Toast.LENGTH_SHORT).show();
                mmkv.encode("chooseDate",year+"-"+(month+1)+"-"+dayOfMonth);
                DateTimeChange.sChangeFragment.change(1);
            }
        });
    }
}
