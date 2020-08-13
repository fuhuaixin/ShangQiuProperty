package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.LeaseListBean;
import com.fhx.property.bean.ReminderListBean;

import java.util.List;

public class LeaseListAdapter extends BaseQuickAdapter<LeaseListBean, BaseViewHolder> {

    public LeaseListAdapter(@Nullable List<LeaseListBean> data) {
        super(R.layout.adapter_lease_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LeaseListBean item) {

        helper.setText(R.id.tv_title,item.getTitle())
                .setText(R.id.tv_room,item.getRoom());

        helper.addOnClickListener(R.id.ll_item);
    }
}
