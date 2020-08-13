package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.NotifyListBean;

import java.util.List;

public class NotifyListAdapter extends BaseQuickAdapter<NotifyListBean, BaseViewHolder> {

    public NotifyListAdapter(@Nullable List<NotifyListBean> data) {
        super(R.layout.adapter_notify_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NotifyListBean item) {
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_msg, item.getMsg())
                .setText(R.id.tv_time_job, item.getJob() + " | " + item.getTime());

        helper.addOnClickListener(R.id.ll_item);
    }
}
