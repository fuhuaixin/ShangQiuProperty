package com.fhx.property.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.ChooseBean;

import java.util.List;

public class ContactsTitleAdapter extends BaseQuickAdapter<ChooseBean, BaseViewHolder> {
    private List<ChooseBean> mData;

    public ContactsTitleAdapter(@Nullable List<ChooseBean> data) {
        super(R.layout.adapter_contacts_title, data);
        this.mData =data;
    }

    @Override
    protected void convert(BaseViewHolder helper, ChooseBean item) {
        TextView tv_title = helper.getView(R.id.tv_title);

//        if (mData.size())

        if (item.getIsChoose()==1){
            if (helper.getPosition()==0){
                tv_title.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(R.mipmap.icon_company_little_gray),null,null,null);
                tv_title.setCompoundDrawablePadding(10);
            }
            tv_title.setTextColor(mContext.getResources().getColor(R.color.tv888));
        }else {
            if (helper.getPosition()==0){
                tv_title.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(R.mipmap.icon_company_little_blue),null,null,null);
                tv_title.setCompoundDrawablePadding(10);
            }
            tv_title.setTextColor(mContext.getResources().getColor(R.color.col_repairs_blue));
        }
        /*if (helper.getPosition()==0){
            tv_title.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(R.mipmap.icon_company_little_gray),null,null,null);
            tv_title.setCompoundDrawablePadding(10);
        }*/
        helper.setText(R.id.tv_title,item.getTitle());

        helper.addOnClickListener(R.id.tv_title);
    }
}
