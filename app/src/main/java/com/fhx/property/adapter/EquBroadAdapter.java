package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.EquBroadBean;

import java.util.List;

public class EquBroadAdapter extends BaseQuickAdapter<EquBroadBean, BaseViewHolder> {
    public EquBroadAdapter(@Nullable List<EquBroadBean> data) {
        super(R.layout.adapter_equ_broad, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, EquBroadBean item) {
       if (item.getStatus()==0){  //状态  0 未播放  1播放中
           helper.setImageResource(R.id.image_status,R.drawable.shape_oval_gray);
           helper.setText(R.id.tv_status,"已关闭");
       }else if (item.getStatus() ==1){
           helper.setImageResource(R.id.image_status,R.drawable.shape_oval_blue);
           helper.setText(R.id.tv_status,"已开启");

       }

       helper.setText(R.id.tv_title,item.getTitle())
               .setText(R.id.tv_music,item.getMusic());


        helper.addOnClickListener(R.id.rl_item);
    }
}
