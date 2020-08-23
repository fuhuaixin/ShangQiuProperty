package com.fhx.property.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.RepairsCommitAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.RepairsCommitBean;
import com.fhx.property.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 报修
 */
public class RepairsActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvTitle;
    private ImageView imageBack;
    private TextView tv_to_repairs;

    private RecyclerView recycle_repairs;
    private List<RepairsCommitBean> repairsBeanList = new ArrayList<>();
    private RepairsCommitAdapter repairsCommitAdapter;

    /*空界面*/
    private LinearLayout ll_empty;
    private ImageView image_top;
    private TextView tv_msg;
    private TextView tv_btn;


    @Override
    protected int initLayout() {
        return R.layout.activity_repairs;
    }

    @Override
    protected void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_to_repairs = (TextView) findViewById(R.id.tv_to_repairs);
        imageBack = (ImageView)findViewById(R.id.image_left);
        recycle_repairs = (RecyclerView) findViewById(R.id.recycle_repairs);

        ll_empty = (LinearLayout) findViewById(R.id.ll_empty);
        image_top = (ImageView) findViewById(R.id.image_top);
        tv_msg = (TextView) findViewById(R.id.tv_msg);
        tv_btn = (TextView) findViewById(R.id.tv_btn);


    }

    @Override
    protected void initData() {
        tvTitle.setText("报修");

        repairsBeanList.clear();
        repairsBeanList.add(new RepairsCommitBean("办公室电动玻璃门无法关闭","类型1","房间一",1));
        repairsBeanList.add(new RepairsCommitBean("办公室电动玻璃门无法关闭,办公室电动玻璃门无法关闭,aaaaaaa","类型2","房间一",2));
        repairsBeanList.add(new RepairsCommitBean("办公室电动玻璃门无法关闭","类型1","房间3",3));
        repairsBeanList.add(new RepairsCommitBean("办公室电动玻璃门无法关闭","类型2","房间4",4));
        repairsBeanList.add(new RepairsCommitBean("办公室电动玻璃门无法关闭","类型1","房间一",1));
        repairsBeanList.add(new RepairsCommitBean("办公室电动玻璃门无法关闭,办公室电动玻璃门无法关闭,aaaaaaa","类型2","房间一",2));
        repairsBeanList.add(new RepairsCommitBean("办公室电动玻璃门无法关闭","类型1","房间3",3));
        repairsBeanList.add(new RepairsCommitBean("办公室电动玻璃门无法关闭","类型2","房间4",4));

        if (repairsBeanList.size()>0){
            ll_empty.setVisibility(View.GONE);
        }else {
            ll_empty.setVisibility(View.VISIBLE);
            image_top.setImageResource(R.mipmap.icon_empty_repairs);
            tv_msg.setText("暂无报修");
            tv_btn.setVisibility(View.VISIBLE);
            tv_btn.setText("我要报修");
        }

        repairsCommitAdapter =new RepairsCommitAdapter(repairsBeanList);
        recycle_repairs.setLayoutManager(new LinearLayoutManager(this));
        recycle_repairs.setAdapter(repairsCommitAdapter);
    }

    @Override
    protected void initListen() {
        imageBack.setOnClickListener(this);
        tv_to_repairs.setOnClickListener(this);
        tv_btn.setOnClickListener(this);

        repairsCommitAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToBean(RepairsActivity.this,RepairsMsgActivity.class,repairsBeanList.get(position));
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation,R.anim.activity_out_to_animation);
                break;
            case R.id.tv_to_repairs:
            case R.id.tv_btn:
                CutToUtils.getInstance().JumpTo(RepairsActivity.this,RepairsCommitActivity.class);
                break;
        }
    }


}
