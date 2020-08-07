package com.fhx.property.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.EquBroadAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.EquBroadBean;
import com.fhx.property.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 智能照明列表
 */
public class LightActivity extends BaseActivity implements View.OnClickListener{

    private ImageView imageLeft;
    private TextView tvTitle;

    private RecyclerView recycle_light;
    private EquBroadAdapter equBroadAdapter;
    private List<EquBroadBean> equBroadBeanList =new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.activity_light;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle_light = (RecyclerView) findViewById(R.id.recycle_light);
    }

    @Override
    protected void initData() {
        tvTitle.setText("智能照明");
        equBroadBeanList.add(new EquBroadBean("负一楼照明","暖光",0));
        equBroadBeanList.add(new EquBroadBean("负二楼照明","无场景",1));
        equBroadBeanList.add(new EquBroadBean("一楼照明","白昼",0));
        equBroadBeanList.add(new EquBroadBean("四至十七楼照明","白昼",1));
        recycle_light.setLayoutManager(new LinearLayoutManager(this));
        equBroadAdapter = new EquBroadAdapter(equBroadBeanList,"light");
        recycle_light.setAdapter(equBroadAdapter);
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);

        equBroadAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToBean(LightActivity.this,LightSettingActivity.class,equBroadBeanList.get(position));
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;

        }
    }
}
