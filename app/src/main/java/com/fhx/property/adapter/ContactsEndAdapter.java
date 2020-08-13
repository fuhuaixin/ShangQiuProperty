package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.ContactsListBean;

import java.util.List;

public class ContactsEndAdapter extends BaseQuickAdapter<ContactsListBean, BaseViewHolder> {

    public ContactsEndAdapter(@Nullable List<ContactsListBean> data) {
        super(R.layout.adapter_contacts_end, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactsListBean item) {

        helper.setText(R.id.tv_branch, item.getBranch())
                .setText(R.id.tv_job, item.getJob());

        if (item.getTag() != null && !item.getTag().equals("")) {
            helper.setVisible(R.id.tv_tag, true);
            helper.setText(R.id.tv_tag, item.getTag());
        } else {
            helper.setVisible(R.id.tv_tag, false);
        }


        helper.addOnClickListener(R.id.ll_item);
    }
}
