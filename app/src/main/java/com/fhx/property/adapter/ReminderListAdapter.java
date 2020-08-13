package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.ReminderListBean;

import java.util.List;

public class ReminderListAdapter extends BaseQuickAdapter<ReminderListBean, BaseViewHolder> {

    public ReminderListAdapter( @Nullable List<ReminderListBean> data) {
        super(R.layout.adapter_reminder_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ReminderListBean item) {
        if (item.getIsPay()==0){
            helper.setTextColor(R.id.tv_pay,mContext.getResources().getColor(R.color.white));
            helper.setBackgroundRes(R.id.tv_pay,R.drawable.shape_reminder_blue);
        }else {
            helper.setTextColor(R.id.tv_pay,mContext.getResources().getColor(R.color.tvaaa));
            helper.setBackgroundRes(R.id.tv_pay,R.drawable.shape_reminder_gray);
        }
        helper.setText(R.id.tv_title,item.getTitle())
                .setText(R.id.tv_room,item.getRoom())
                .setText(R.id.tv_price,item.getPrice());

        helper.addOnClickListener(R.id.ll_item,R.id.tv_pay);
    }
}
