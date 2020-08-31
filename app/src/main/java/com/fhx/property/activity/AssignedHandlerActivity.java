package com.fhx.property.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.AssignedAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.AssignedBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 指派处理人
 */
public class AssignedHandlerActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageLeft,imageRight;
    private TextView tvTitle;

    private RecyclerView recycle_ass;
    private AssignedAdapter assignedAdapter;

    private List<AssignedBean> assignedBeanList =new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_assigned_handler;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        imageRight = (ImageView) findViewById(R.id.image_right);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle_ass = (RecyclerView) findViewById(R.id.recycle_ass);
    }

    @Override
    protected void initData() {
        tvTitle.setText("指派处理人");
        imageLeft.setImageResource(R.mipmap.icon_back_all_x);
        imageRight.setVisibility(View.VISIBLE);
        imageRight.setImageResource(R.mipmap.icon_sava_all);
        assignedBeanList.add(new AssignedBean(AssignedBean.TYPE_HEADER,"安保部"));
        assignedBeanList.add(new AssignedBean(AssignedBean.TYPE_ITEM,"王欢",0));
        assignedBeanList.add(new AssignedBean(AssignedBean.TYPE_ITEM,"王欢2",0));
        assignedBeanList.add(new AssignedBean(AssignedBean.TYPE_ITEM,"王欢3",0));
        assignedBeanList.add(new AssignedBean(AssignedBean.TYPE_ITEM,"王欢4",0));
        assignedBeanList.add(new AssignedBean(AssignedBean.TYPE_HEADER,"保洁部"));
        assignedBeanList.add(new AssignedBean(AssignedBean.TYPE_ITEM,"黄四郎",0));
        assignedBeanList.add(new AssignedBean(AssignedBean.TYPE_ITEM,"黄四郎2",0));
        assignedBeanList.add(new AssignedBean(AssignedBean.TYPE_ITEM,"黄四郎3",0));
        assignedBeanList.add(new AssignedBean(AssignedBean.TYPE_ITEM,"黄四郎4",0));
        assignedBeanList.add(new AssignedBean(AssignedBean.TYPE_HEADER,"内务部"));
        assignedBeanList.add(new AssignedBean(AssignedBean.TYPE_ITEM,"蔡琰",0));
        assignedBeanList.add(new AssignedBean(AssignedBean.TYPE_ITEM,"蔡琰2",0));
        assignedBeanList.add(new AssignedBean(AssignedBean.TYPE_ITEM,"蔡琰3",0));
        assignedBeanList.add(new AssignedBean(AssignedBean.TYPE_ITEM,"蔡琰4",0));
        assignedAdapter =new AssignedAdapter(assignedBeanList);
        recycle_ass.setLayoutManager(new LinearLayoutManager(this));
        recycle_ass.setAdapter(assignedAdapter);


    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        imageRight.setOnClickListener(this);
        assignedAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.ll_item_item:
                        for (int i = 0; i < assignedBeanList.size(); i++) {
                            assignedBeanList.get(i).setIsChoose(0);
                        }
                        assignedBeanList.get(position).setIsChoose(1);
                        assignedAdapter.notifyDataSetChanged();
                        break;
                }
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
            case R.id.image_right:
                ToastShort("点击了确定");
                break;
        }
    }
}
