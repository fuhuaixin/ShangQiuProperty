package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.ExamineBean;

import java.util.List;

public class CardListAdapter extends BaseQuickAdapter<ExamineBean, BaseViewHolder> {
    public CardListAdapter(@Nullable List<ExamineBean> data) {
        super(R.layout.adapter_examine_card, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ExamineBean item) {
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_commit_time, item.getCommitTime())
                .setText(R.id.tv_start_time, "补卡时间：" + item.getCardTime());
        helper.addOnClickListener(R.id.ll_card_item);
        switch (item.getProgress()) {
            case 0:
                helper.setText(R.id.tv_progress, "审批中");
                helper.setTextColor(R.id.tv_progress, mContext.getResources().getColor(R.color.leave_ing));
                break;
            case 1:
                helper.setText(R.id.tv_progress, "已通过");
                helper.setTextColor(R.id.tv_progress, mContext.getResources().getColor(R.color.leave_pass));
                break;
            case 2:
                helper.setText(R.id.tv_progress, "退回");
                helper.setTextColor(R.id.tv_progress, mContext.getResources().getColor(R.color.leave_no_pass));
                break;
        }
    }
}
