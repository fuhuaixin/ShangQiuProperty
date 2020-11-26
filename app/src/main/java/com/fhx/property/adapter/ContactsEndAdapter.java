package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.ContactsListBean;
import com.fhx.property.bean.ContactsThirdBean;

import java.util.List;

public class ContactsEndAdapter extends BaseQuickAdapter<ContactsThirdBean.DataBean, BaseViewHolder> {

    public ContactsEndAdapter(@Nullable List<ContactsThirdBean.DataBean> data) {
        super(R.layout.adapter_contacts_end, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactsThirdBean.DataBean item) {

        helper.setText(R.id.tv_branch, item.getEmployeeName())
                .setText(R.id.tv_phone,"电话："+item.getPhone())
               .setText(R.id.tv_no, "员工编号："+item.getEmployeeNo());

      /*   if (item.getTag() != null && !item.getTag().equals("")) {
            helper.setVisible(R.id.tv_tag, true);
            helper.setText(R.id.tv_tag, item.getTag());
        } else {
            helper.setVisible(R.id.tv_tag, false);
        }*/


        helper.addOnClickListener(R.id.ll_item);
    }
}
