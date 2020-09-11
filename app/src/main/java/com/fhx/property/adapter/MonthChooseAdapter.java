package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.ChooseBean;

import java.util.List;

public class MonthChooseAdapter extends BaseQuickAdapter<ChooseBean, BaseViewHolder> {
    public MonthChooseAdapter(@Nullable List<ChooseBean> data) {
        super(R.layout.adapter_month_choose, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChooseBean item) {
        if (item.getIsChoose()==0){
            helper.setVisible(R.id.image_sel,false);
        }else {
            helper.setVisible(R.id.image_sel,true);
        }
        helper.setText(R.id.tv_month,item.getTitle());

        helper.addOnClickListener(R.id.rl_item);
    }
}
