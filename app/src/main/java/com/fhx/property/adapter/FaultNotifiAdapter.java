package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.FaultNotifiBean;

import java.util.List;

public class FaultNotifiAdapter extends BaseQuickAdapter<FaultNotifiBean, BaseViewHolder> {
    public FaultNotifiAdapter( @Nullable List<FaultNotifiBean> data) {
        super(R.layout.adapter_fault_notifi, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FaultNotifiBean item) {
        switch (item.getProgress()){
            case 0:
                helper.setImageResource(R.id.image_header,R.mipmap.icon_repairs_commit);
                helper.setText(R.id.tv_progress,"待指派");
                break;
            case 1:
                helper.setImageResource(R.id.image_header,R.mipmap.icon_repairs_ing);
                helper.setText(R.id.tv_progress,"处理中");
                break;
            case 2:
                helper.setImageResource(R.id.image_header,R.mipmap.icon_repairs_complated);
                helper.setText(R.id.tv_progress,"已完成");
                break;
        }

        helper.setText(R.id.tv_address_time,item.getAddress()+" | "+item.getTime())
        .setText(R.id.tv_title,item.getTitle());

        helper.addOnClickListener(R.id.ll_item);
    }
}
