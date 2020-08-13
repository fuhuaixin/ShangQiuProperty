package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.CarManageBean;

import java.util.List;

public class CarManageAdapter extends BaseQuickAdapter<CarManageBean, BaseViewHolder> {

    public CarManageAdapter(@Nullable List<CarManageBean> data) {
        super(R.layout.adapter_car_manage, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CarManageBean item) {

        helper.setText(R.id.tv_car_num,item.getCarNum())
                .setText(R.id.tv_owner_room,item.getCarOwner()+" | "+item.getRoom());

        helper.addOnClickListener(R.id.ll_item);
    }
}
