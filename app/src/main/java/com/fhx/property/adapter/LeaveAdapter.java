package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.LeaveBean;

import java.util.List;

public class LeaveAdapter extends BaseQuickAdapter<LeaveBean, BaseViewHolder> {
    public LeaveAdapter(@Nullable List<LeaveBean> data) {
        super(R.layout.adapter_leave, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LeaveBean item) {
        helper.setImageResource(R.id.image_header, item.getImage());
        helper.setText(R.id.tv_title, item.getTitle());
        if (item.getRemain() > 0) {
            helper.setVisible(R.id.tv_remain, true);
            helper.setText(R.id.tv_remain, "剩余" + item.getRemain() + "天");
        } else {
            helper.setVisible(R.id.tv_remain, false);
        }

        helper.addOnClickListener(R.id.ll_item);
    }
}
