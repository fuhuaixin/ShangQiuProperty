package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.CarManageBean;

import java.util.List;

public class CarManageAdapter extends BaseQuickAdapter<CarManageBean.DataBean.RecordsBean, BaseViewHolder> {

    public CarManageAdapter(@Nullable List<CarManageBean.DataBean.RecordsBean> data) {
        super(R.layout.adapter_car_manage, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CarManageBean.DataBean.RecordsBean item) {

        helper.setText(R.id.tv_car_num,item.getCarNo())
                .setText(R.id.tv_owner_room,item.getCarOwner()+" | "+item.getOwnerPhone());

        helper.addOnClickListener(R.id.ll_item);
    }
}
