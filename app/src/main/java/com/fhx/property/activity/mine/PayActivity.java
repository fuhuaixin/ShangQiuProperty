package com.fhx.property.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.PayAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.PayBean;
import com.fhx.property.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 薪资
 */
public class PayActivity extends BaseActivity {
    private ImageView imageLeft;
    private TextView tvTitle;
    private RecyclerView recycle_pay;
    private PayAdapter payAdapter;
    private List<PayBean> payBeanList =new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.activity_pay;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle_pay = (RecyclerView) findViewById(R.id.recycle_pay);
    }

    @Override
    protected void initData() {
        tvTitle.setText("薪资");
        payBeanList.add(new PayBean(PayBean.TYPE_HEADER,"2020"));
        payBeanList.add(new PayBean(PayBean.TYPE_ITEM,"八月份",2025));
        payBeanList.add(new PayBean(PayBean.TYPE_ITEM,"七月份",2587));
        payBeanList.add(new PayBean(PayBean.TYPE_ITEM,"六月份",3000));
        payBeanList.add(new PayBean(PayBean.TYPE_ITEM,"五月份",3200));
        payAdapter =new PayAdapter(payBeanList);
        recycle_pay.setLayoutManager(new LinearLayoutManager(this));
        recycle_pay.setAdapter(payAdapter);
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
            }
        });

        payAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpTo(PayActivity.this,PayMsgActivity.class);
            }
        });
    }
}
