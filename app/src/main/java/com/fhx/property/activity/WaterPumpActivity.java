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
 * 蓄水池 水泵列表
 * 新风列表
 * 排风列表
 */
public class WaterPumpActivity extends BaseActivity implements View.OnClickListener, BaseQuickAdapter.OnItemChildClickListener {

    private ImageView imageLeft;
    private TextView tvTitle;
    private RecyclerView recycle_broadcast;
    private EquBroadAdapter adapter;
    private List<EquBroadBean> mList =new ArrayList<>();

    private String type;

    @Override
    protected int initLayout() {
        type = getIntent().getStringExtra("jumpOne");
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
        switch (type){
            case "pump":
                tvTitle.setText("水泵检测");
                mList.add(new EquBroadBean("集水坑1","地下一层",0,3.1));
                mList.add(new EquBroadBean("集水坑2","地下一层2",0,2.0));
                adapter =new EquBroadAdapter(mList,"pump");
                recycle_broadcast.setLayoutManager(new LinearLayoutManager(this));
                recycle_broadcast.setAdapter(adapter);
                adapter.setOnItemChildClickListener(this);
                break;
            case "fresh":
                tvTitle.setText("新风机");
                mList.add(new EquBroadBean("新风设备1","位置1",0,"手动"));
                mList.add(new EquBroadBean("新风设备2","位置2",1,"自动"));
                mList.add(new EquBroadBean("新风设备3","位置3",1,"自动"));
                adapter =new EquBroadAdapter(mList,"fresh");
                recycle_broadcast.setLayoutManager(new LinearLayoutManager(this));
                recycle_broadcast.setAdapter(adapter);
                adapter.setOnItemChildClickListener(this);
                break;
            case "ventilate":
                tvTitle.setText("排风扇");
                mList.add(new EquBroadBean("排风扇设备1","位置1",1,"自动"));
                mList.add(new EquBroadBean("排风扇设备2","位置2",0,"手动"));
                mList.add(new EquBroadBean("排风扇设备3","位置3",1,"自动"));
                adapter =new EquBroadAdapter(mList,"ventilate");
                recycle_broadcast.setLayoutManager(new LinearLayoutManager(this));
                recycle_broadcast.setAdapter(adapter);
                adapter.setOnItemChildClickListener(this);
                break;
        }




    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
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

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (type){
            case "pump":
                CutToUtils.getInstance().JumpToOne(WaterPumpActivity.this,WaterPumpMsgActivity.class,mList.get(position).getTitle());
                break;
            case "fresh":
                CutToUtils.getInstance().JumpToTwo(WaterPumpActivity.this,FreshVentilateActivity.class,mList.get(position).getTitle(),"fresh");
                break;
            case "ventilate":
                CutToUtils.getInstance().JumpToTwo(WaterPumpActivity.this,FreshVentilateActivity.class,mList.get(position).getTitle(),"ventilate");
                break;
        }
    }
}
