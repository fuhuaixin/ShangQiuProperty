package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.BroadMsgBean;

import java.util.List;

public class BroadMSgAdapter extends BaseQuickAdapter<BroadMsgBean, BaseViewHolder> {
    public BroadMSgAdapter(@Nullable List<BroadMsgBean> data) {
        super(R.layout.adapter_broad_msg, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BroadMsgBean item) {
        if (helper.getPosition()==0){
            helper.setVisible(R.id.line_view,false);
        }else {
            helper.setVisible(R.id.line_view,true);
        }
        if (item.getIsOpen()==0){ //0 关闭  1开启
            helper.setImageResource(R.id.image_swith,R.mipmap.icon_swith_unsel);
        }else {
            helper.setImageResource(R.id.image_swith,R.mipmap.image_switch_sel);
        }

        helper.setText(R.id.tv_title,item.getBroadTitle())
        .setText(R.id.tv_time_day,item.getStartTime()+"~"+item.getEndTime()+" | "+item.getRepetitionList().toString());

        helper.addOnClickListener(R.id.ll_item);
    }
}
