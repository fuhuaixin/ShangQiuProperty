package com.fhx.property.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.AssignedBean;
import com.fhx.property.bean.PayBean;

import java.util.List;

public class PayAdapter extends BaseMultiItemQuickAdapter<PayBean, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public PayAdapter(List<PayBean> data) {
        super(data);
        addItemType(PayBean.TYPE_HEADER, R.layout.adapter_assigned_header);
        addItemType(PayBean.TYPE_ITEM, R.layout.adapter_pay_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, PayBean item) {
        switch (helper.getItemViewType()){
            case PayBean.TYPE_HEADER:
                helper.setText(R.id.tv_header,item.getHeader());
                break;
            case PayBean.TYPE_ITEM:
                helper.setText(R.id.tv_month,item.getMonth())
                .setText(R.id.tv_money,""+item.getMoney());

                helper.addOnClickListener(R.id.ll_item);
                break;
        }
    }
}
