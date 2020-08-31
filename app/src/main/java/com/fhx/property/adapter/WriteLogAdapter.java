package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.WriteLogBean;

import java.util.List;

public class WriteLogAdapter extends BaseQuickAdapter<WriteLogBean, BaseViewHolder> {
    public WriteLogAdapter(@Nullable List<WriteLogBean> data) {
        super(R.layout.adapter_write_log, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WriteLogBean item) {
        helper.setImageResource(R.id.image_header,item.getImage());
        helper.setText(R.id.tv_title,item.getTitle())
                .setText(R.id.tv_msg,item.getMsg());

        helper.addOnClickListener(R.id.ll_item);

    }
}
