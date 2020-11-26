package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;
import com.fhx.property.R;
import com.fhx.property.bean.LeaveRecordBean;

import java.util.List;

public class LeaveRecordAdapter extends BaseQuickAdapter<LeaveRecordBean.DataBean.RecordsBean, BaseViewHolder> {



    public LeaveRecordAdapter(@Nullable List<LeaveRecordBean.DataBean.RecordsBean> data) {
        super(R.layout.adapter_leave_record, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LeaveRecordBean.DataBean.RecordsBean item) {
        switch (item.getSheetStatus()) {
            case "1":
                helper.setText(R.id.tv_progress, "待发送");
                helper.setTextColor(R.id.tv_progress, mContext.getResources().getColor(R.color.leave_ing));
                break;
            case "3":
                helper.setText(R.id.tv_progress, "审批中");

                helper.setTextColor(R.id.tv_progress, mContext.getResources().getColor(R.color.leave_ing));
                break;
            case "4":
                helper.setText(R.id.tv_progress, "审批通过");

                helper.setTextColor(R.id.tv_progress, mContext.getResources().getColor(R.color.leave_pass));
                break;
            case "2":
                helper.setText(R.id.tv_progress, "退回");

                helper.setTextColor(R.id.tv_progress, mContext.getResources().getColor(R.color.leave_no_pass));
                break;
            case "5":
                helper.setText(R.id.tv_progress, "不通过");

                helper.setTextColor(R.id.tv_progress, mContext.getResources().getColor(R.color.leave_no_pass));
                break;
        }
        if ( item.getUpdatetime()!=null){
           helper.setText(R.id.tv_commit_time, item.getUpdatetime().toString());
        }
        helper.setText(R.id.tv_title, item.getStarterName()+"的请假")
                .setText(R.id.tv_start_time, "开始：" + item.getBegintime())
                .setText(R.id.tv_end_time, "结束：" + item.getEndtime());
        switch (item.getLeaveType()){
            case "1":
                helper.setText(R.id.tv_type, "事假");
                break;
            case "2":
                helper.setText(R.id.tv_type, "病假");

                break;
            case "3":
                helper.setText(R.id.tv_type, "临时假");

                break;
            case "4":
                helper.setText(R.id.tv_type, "年假");

                break;
            case "5":
                helper.setText(R.id.tv_type, "婚假");

                break;
            case "6":
                helper.setText(R.id.tv_type, "丧假");
                break;
            case "7":
                helper.setText(R.id.tv_type, "产假");
                break;
        }

        helper.addOnClickListener(R.id.ll_item);

    }
}
