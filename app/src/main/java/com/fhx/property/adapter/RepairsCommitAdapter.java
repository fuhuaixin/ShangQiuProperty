package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.RepairsCommitBean;

import java.util.List;

public class RepairsCommitAdapter extends BaseQuickAdapter<RepairsCommitBean.DataBean.RecordsBean, BaseViewHolder> {
    public RepairsCommitAdapter( @Nullable List<RepairsCommitBean.DataBean.RecordsBean> data) {
        super(R.layout.adapter_repairs_commit, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RepairsCommitBean.DataBean.RecordsBean item) {

        helper.setText(R.id.tv_msg,item.getContent())
                .setText(R.id.tv_type_room,item.getNotes()+"");

        switch (item.getStatus()){ // 1 已提交  2 处理中  3 已完成但未评价 4 已完成已评价
            case "0":
                helper.setImageResource(R.id.image_status,R.mipmap.icon_repairs_commit);
                helper.setText(R.id.tv_status,"已提交");
                break;
            case "1":
                helper.setImageResource(R.id.image_status,R.mipmap.icon_repairs_ing);
                helper.setText(R.id.tv_status,"处理中");
                break;
            case "3":
                helper.setImageResource(R.id.image_status,R.mipmap.icon_repairs_complated);
                helper.setText(R.id.tv_status,"已撤回");
                break;
            case "4":
                helper.setImageResource(R.id.image_status,R.mipmap.icon_repairs_complated);
                helper.setText(R.id.tv_status,"待评价");
                break;
            case "5":
                helper.setImageResource(R.id.image_status,R.mipmap.icon_repairs_complated);
                helper.setText(R.id.tv_status,"已完成");
                break;
        }

        helper.addOnClickListener(R.id.rl_item);
    }
}
