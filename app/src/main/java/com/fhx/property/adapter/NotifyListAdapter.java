package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.NotifyListBean;

import java.util.List;

public class NotifyListAdapter extends BaseQuickAdapter<NotifyListBean.DataBean.RecordsBean, BaseViewHolder> {

    public NotifyListAdapter(@Nullable List<NotifyListBean.DataBean.RecordsBean> data) {
        super(R.layout.adapter_notify_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NotifyListBean.DataBean.RecordsBean item) {
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_msg, item.getContent())
                .setText(R.id.tv_time_job, item.getNewsType() + " | " + item.getCreateTime());

        helper.addOnClickListener(R.id.ll_item);
    }


}
