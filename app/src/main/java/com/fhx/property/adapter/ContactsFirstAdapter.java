package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.ContactsListBean;

import java.util.List;

public class ContactsFirstAdapter extends BaseQuickAdapter<ContactsListBean, BaseViewHolder> {

    public ContactsFirstAdapter(@Nullable List<ContactsListBean> data) {
        super(R.layout.adapter_contacts_first, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactsListBean item) {

        helper.setText(R.id.tv_branch, item.getBranch())
                .setText(R.id.tv_total, "(" + item.getTotal() + ")");

        helper.addOnClickListener(R.id.ll_item);
    }
}
