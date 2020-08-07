package com.fhx.property.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.InformationAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.InformationBean;
import com.fhx.property.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 信息发布列表页
 */
public class InformationActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageLeft;
    private TextView tvTitle;
    private RecyclerView recycle_information;
    private InformationAdapter adapter ;
    private List<InformationBean> beanList =new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.activity_information;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle_information = (RecyclerView) findViewById(R.id.recycle_information);

    }

    @Override
    protected void initData() {
        tvTitle.setText("信息发布系统");
        beanList.add(new InformationBean(0,"一层LED显示屏","10h"));
        beanList.add(new InformationBean(1,"电梯19寸发布屏","20h"));
        beanList.add(new InformationBean(0,"电梯32寸一体机","15h"));
        adapter =new InformationAdapter(beanList);
        recycle_information.setLayoutManager(new LinearLayoutManager(this));
        recycle_information.setAdapter(adapter);
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToBean(InformationActivity.this,InformationMsgActivity.class,beanList.get(position));
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
