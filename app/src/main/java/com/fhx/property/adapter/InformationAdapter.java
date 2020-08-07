package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.InformationBean;

import java.util.List;

public class InformationAdapter extends BaseQuickAdapter<InformationBean, BaseViewHolder> {
    public InformationAdapter( @Nullable List<InformationBean> data) {
        super(R.layout.adapter_information, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, InformationBean item) {
        if (item.getStatus()==0){  //0 未运行  1 运行中
            helper.setBackgroundRes(R.id.images_status,R.drawable.shape_oval_gray);
            helper.setText(R.id.tv_status,"已关闭");
        }else {
            helper.setBackgroundRes(R.id.images_status,R.drawable.shape_oval_blue);
            helper.setText(R.id.tv_status,"已开启");
        }
        helper.setText(R.id.tv_title,item.getTitle())
        .setText(R.id.tv_use_time,"已运行"+item.getUseTime());

        helper.addOnClickListener(R.id.rl_item);
    }
}
