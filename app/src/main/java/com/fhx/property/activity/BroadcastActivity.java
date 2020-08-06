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

import java.util.ArrayList;
import java.util.List;

/**
 * 背景音乐  公共广播
 */
public class BroadcastActivity extends BaseActivity implements View.OnClickListener{

    private ImageView imageLeft;
    private TextView tvTitle;

    private RecyclerView recycle_broadcast;
    private EquBroadAdapter equBroadAdapter;
    private List<EquBroadBean> equBroadBeanList =new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.activity_broadcast;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle_broadcast = (RecyclerView) findViewById(R.id.recycle_broadcast);
    }

    @Override
    protected void initData() {
        tvTitle.setText("背景音乐和公共广播");
        equBroadBeanList.add(new EquBroadBean("一区设备","小红帽.mp3",0));
        equBroadBeanList.add(new EquBroadBean("二区设备","爱丽丝的围裙.mp3",1));
        equBroadBeanList.add(new EquBroadBean("三区设备","狂野大灰狼.avm",0));
        recycle_broadcast.setLayoutManager(new LinearLayoutManager(this));
        equBroadAdapter = new EquBroadAdapter(equBroadBeanList);
        recycle_broadcast.setAdapter(equBroadAdapter);


    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);

        equBroadAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

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
