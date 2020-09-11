package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;
import com.fhx.property.R;
import com.fhx.property.bean.LeaveRecordBean;

import java.util.List;

public class LeaveRecordAdapter extends BaseMultiItemQuickAdapter<LeaveRecordBean, BaseViewHolder> {


    private List<LeaveRecordBean> data;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public LeaveRecordAdapter(List<LeaveRecordBean> data) {
        super(data);
        addItemType(LeaveRecordBean.Header, R.layout.adapter_leave_record_header);
        addItemType(LeaveRecordBean.Item, R.layout.adapter_leave_record);
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, LeaveRecordBean item) {
        switch (helper.getItemViewType()) {
            case LeaveRecordBean.Header:
                int size = 0;
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getItemType() == 2) {
                        size++;
                    }
                }
                helper.setText(R.id.tv_total, "共有" + size + "条请假记录");
                break;
            case LeaveRecordBean.Item:
                switch (item.getProgress()) {
                    case 0:
                        helper.setText(R.id.tv_progress, "审批中");
                        helper.setTextColor(R.id.tv_progress, mContext.getResources().getColor(R.color.leave_ing));
                        break;
                    case 1:
                        helper.setText(R.id.tv_progress, "审批通过");
                        helper.setTextColor(R.id.tv_progress, mContext.getResources().getColor(R.color.leave_pass));
                        break;
                    case 2:
                        helper.setText(R.id.tv_progress, "退回");
                        helper.setTextColor(R.id.tv_progress, mContext.getResources().getColor(R.color.leave_no_pass));
                        break;
                }
                helper.setText(R.id.tv_title, item.getTitle())
                        .setText(R.id.tv_commit_time, item.getCommitTime())
                        .setText(R.id.tv_start_time, "开始：" + item.getStartTime())
                        .setText(R.id.tv_end_time, "结束:" + item.getEndTime())
                        .setText(R.id.tv_type, item.getEventType());

                helper.addOnClickListener(R.id.ll_item);
                break;
        }

    }
}
