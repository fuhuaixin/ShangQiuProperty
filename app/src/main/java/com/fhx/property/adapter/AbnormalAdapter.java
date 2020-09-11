package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.AbnormalBean;

import java.util.List;

public class AbnormalAdapter extends BaseQuickAdapter<AbnormalBean, BaseViewHolder> {
    public AbnormalAdapter(@Nullable List<AbnormalBean> data) {
        super(R.layout.adapter_abnormal, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AbnormalBean item) {
        helper.setText(R.id.tv_type,item.getType())
                .setText(R.id.tv_time,item.getTime());
    }
}
