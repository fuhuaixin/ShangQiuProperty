package com.fhx.property.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.CarManageAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.CarManageBean;
import com.fhx.property.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 车辆管理列表
 */
public class CarManageActivity extends BaseActivity implements View.OnClickListener {

    private EditText et_search;
    private TextView tvTitle;
    private ImageView imageLeft;
    private RecyclerView recyclerCar;

    /*空界面*/
    private LinearLayout ll_empty;
    private ImageView image_top;
    private TextView tv_msg;
    private TextView tv_btn;

    private CarManageAdapter adapter;
    private List<CarManageBean> mList = new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_reminder;
    }

    @Override
    protected void initView() {
        et_search = (EditText) findViewById(R.id.et_search);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        imageLeft = (ImageView) findViewById(R.id.image_left);
        recyclerCar = (RecyclerView) findViewById(R.id.recycle_reminder);

        ll_empty = (LinearLayout) findViewById(R.id.ll_empty);
        image_top = (ImageView) findViewById(R.id.image_top);
        tv_msg = (TextView) findViewById(R.id.tv_msg);
        tv_btn = (TextView) findViewById(R.id.tv_btn);
    }

    @Override
    protected void initData() {
        et_search.setHint("搜索车牌号、车主及房号");
        tvTitle.setText("车辆管理");

        for (int i = 0; i < 6; i++) {
            mList.add(new CarManageBean("豫A8888" + i, "车主名字" + i, "房间号" + i));
        }

        if (mList.size()>0){
            ll_empty.setVisibility(View.GONE);
        }else {
            ll_empty.setVisibility(View.VISIBLE);
            image_top.setImageResource(R.mipmap.icon_empty_car);
            tv_msg.setText("暂无登记车辆");
//            tv_btn.setVisibility(View.VISIBLE);
//            tv_btn.setText("我要报修");
        }

        adapter = new CarManageAdapter(mList);
        recyclerCar.setLayoutManager(new LinearLayoutManager(this));
        recyclerCar.setAdapter(adapter);

    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToBean(CarManageActivity.this, CarMsgActivity.class, mList.get(position));
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

        }
    }
}
