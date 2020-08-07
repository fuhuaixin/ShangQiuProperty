package com.fhx.property.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.BroadDayChooseAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.BroadDayChooseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 信息发布时间设置
 */
public class InformationTempActivity extends BaseActivity implements View.OnClickListener{

    private ImageView imageRight;
    private ImageView imageLeft;
    private TextView tvTitle;
    private RecyclerView recycle_choose_day;
    private BroadDayChooseAdapter dayAdapter;
    private List<BroadDayChooseBean> dayList = new ArrayList<>();
    private List<String> titleList = new ArrayList<String>();
    private List<Integer> statusList = new ArrayList();

    @Override
    protected int initLayout() {
        return R.layout.activity_information_temp;
    }

    @Override
    protected void initView() {
        imageRight = (ImageView) findViewById(R.id.image_right);
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle_choose_day = (RecyclerView) findViewById(R.id.recycle_choose_day);
    }

    @Override
    protected void initData() {
        tvTitle.setText("临时播放");
        imageRight.setVisibility(View.VISIBLE);
        titleList.add("重复一次");
        statusList.add(0);
        titleList.add("星期一");
        statusList.add(0);
        titleList.add("星期二");
        statusList.add(0);
        titleList.add("星期三");
        statusList.add(0);
        titleList.add("星期四");
        statusList.add(0);
        titleList.add("星期五");
        statusList.add(0);
        titleList.add("星期六");
        statusList.add(0);
        titleList.add("星期日");
        statusList.add(0);
        for (int i = 0; i < titleList.size(); i++) {
            dayList.add(new BroadDayChooseBean(titleList.get(i), statusList.get(i)));
        }
        recycle_choose_day.setLayoutManager(new GridLayoutManager(this, 3));
        dayAdapter = new BroadDayChooseAdapter(dayList);
        recycle_choose_day.setAdapter(dayAdapter);


    }
    @Override
    protected void initListen() {
        imageRight.setOnClickListener(this);
        imageLeft.setOnClickListener(this);
        dayAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (statusList.get(position) == 0) {
                    statusList.set(position, 1);
                } else {
                    statusList.set(position, 0);
                }
                Log.e("fhxx", statusList.toString());
                dayList.set(position, new BroadDayChooseBean(titleList.get(position), statusList.get(position)));
                dayAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_right:
                ToastShort("保存");
                break;
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
        }
    }
}
