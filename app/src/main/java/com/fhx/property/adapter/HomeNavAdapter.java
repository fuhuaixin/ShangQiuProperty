package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.HomeNavBean;

import java.util.List;

public class HomeNavAdapter extends BaseQuickAdapter<HomeNavBean, BaseViewHolder> {
    public HomeNavAdapter( @Nullable List<HomeNavBean> data) {
        super(R.layout.adapter_home_nav, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeNavBean item) {
        helper.setText(R.id.tv_title,item.getTitle());
        helper.setImageResource(R.id.image_header,item.getImage());

        helper.addOnClickListener(R.id.ll_item);
    }
}
