package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.BroadDayChooseBean;

import java.util.List;

public class BroadDayChooseAdapter extends BaseQuickAdapter<BroadDayChooseBean, BaseViewHolder> {
    public BroadDayChooseAdapter(@Nullable List<BroadDayChooseBean> data) {
        super(R.layout.adapter_broad_day_choose, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BroadDayChooseBean item) {


        helper.setText(R.id.tv_title, item.getTitle());
        if (item.getStatus() == 0) { //0 未选 1 选中
            helper.setTextColor(R.id.tv_title, mContext.getResources().getColor(R.color.tv888));
            helper.setBackgroundRes(R.id.tv_title, R.drawable.shape_choose_day_unsel);
        } else {
            helper.setTextColor(R.id.tv_title, mContext.getResources().getColor(R.color.white));
            helper.setBackgroundRes(R.id.tv_title, R.drawable.shape_choose_day_sel);
        }

        helper.addOnClickListener(R.id.ll_item);
    }
}
