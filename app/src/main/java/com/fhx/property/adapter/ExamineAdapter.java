package com.fhx.property.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.ExamineBean;

import java.util.List;

public class ExamineAdapter extends BaseMultiItemQuickAdapter<ExamineBean, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    private int Type;
    public ExamineAdapter(List<ExamineBean> data,int Type) {
        super(data);
        this.Type =Type;
        addItemType(ExamineBean.TYPE_LEAVE, R.layout.adapter_examine_leave);
        addItemType(ExamineBean.TYPE_CARD, R.layout.adapter_examine_card);
    }

    @Override
    protected void convert(BaseViewHolder helper, ExamineBean item) {
        switch (helper.getItemViewType()){
            case ExamineBean.TYPE_LEAVE:
                helper.setText(R.id.tv_title,item.getTitle())
                        .setText(R.id.tv_commit_time,item.getCommitTime())
                        .setText(R.id.tv_start_time,"开始："+item.getStartTime())
                        .setText(R.id.tv_end_time,"结束："+item.getEndTime())
                        .setText(R.id.tv_type,item.getLeaveType());
                helper.addOnClickListener(R.id.ll_leave_item);


                break;

                case ExamineBean.TYPE_CARD:
                    helper.setText(R.id.tv_title,item.getTitle())
                            .setText(R.id.tv_commit_time,item.getCommitTime())
                            .setText(R.id.tv_start_time,"补卡时间："+item.getCardTime());
                    helper.addOnClickListener(R.id.ll_card_item);

                    break;
        }
        switch (item.getProgress()){
            case 0:
                if (Type==1){
                    helper.setText(R.id.tv_progress,"审批中");
                }else {
                    helper.setText(R.id.tv_progress,"待处理");
                }
                helper.setTextColor(R.id.tv_progress,mContext.getResources().getColor(R.color.leave_ing));
                break;
            case 1:
                helper.setText(R.id.tv_progress,"已通过");
                helper.setTextColor(R.id.tv_progress,mContext.getResources().getColor(R.color.leave_pass));
                break;
            case 2:
                helper.setText(R.id.tv_progress,"退回");
                helper.setTextColor(R.id.tv_progress,mContext.getResources().getColor(R.color.leave_no_pass));
                break;
        }

    }
}
