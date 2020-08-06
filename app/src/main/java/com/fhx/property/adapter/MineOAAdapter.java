package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.MineOABean;

import java.util.List;

public class MineOAAdapter extends BaseQuickAdapter<MineOABean, BaseViewHolder> {
    public MineOAAdapter(@Nullable List<MineOABean> data) {
        super(R.layout.adapter_mine_oa, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MineOABean item) {
        helper.setImageResource(R.id.image_head, item.getImage());
        if (item.getTotal() != 0) {
            helper.setVisible(R.id.tv_total, true);
            helper.setText(R.id.tv_total, item.getTotal() + "");
        } else {
            helper.setVisible(R.id.tv_total, false);
        }
        helper.setText(R.id.tv_title, item.getTitle());

        helper.addOnClickListener(R.id.rl_item);
    }


}
