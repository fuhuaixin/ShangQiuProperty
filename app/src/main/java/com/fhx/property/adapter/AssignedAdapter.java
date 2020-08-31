package com.fhx.property.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.AssignedBean;

import java.util.List;

public class AssignedAdapter extends BaseMultiItemQuickAdapter<AssignedBean, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public AssignedAdapter(List<AssignedBean> data) {
        super(data);
        addItemType(AssignedBean.TYPE_HEADER, R.layout.adapter_assigned_header);
        addItemType(AssignedBean.TYPE_ITEM, R.layout.adapter_assigned_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, AssignedBean item) {
        switch (helper.getItemViewType()){
            case AssignedBean.TYPE_HEADER:
                helper.setText(R.id.tv_header,item.getHeader());
                break;
            case AssignedBean.TYPE_ITEM:
                helper.setText(R.id.tv_name,item.getName());
                if (item.getIsChoose() == 0) {
                    helper.setVisible(R.id.image_sel, false);
                } else {
                    helper.setVisible(R.id.image_sel, true);
                }

                helper.addOnClickListener(R.id.ll_item_item);
                break;
        }
    }
}
