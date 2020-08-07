package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.EquBroadBean;

import java.util.List;

public class EquBroadAdapter extends BaseQuickAdapter<EquBroadBean, BaseViewHolder> {
    String type;
    public EquBroadAdapter(@Nullable List<EquBroadBean> data,String type) {
        super(R.layout.adapter_equ_broad, data);
        this.type =type;
    }

    @Override
    protected void convert(BaseViewHolder helper, EquBroadBean item) {
        if (type.equals("pump")){
            if (item.getWaterLevel() < 3.0){
                helper.setImageResource(R.id.image_status,R.mipmap.icon_water_normal);
                helper.setText(R.id.tv_status,item.getWaterLevel()+"m");
            }else {
                helper.setImageResource(R.id.image_status,R.mipmap.icon_water_alarm);
                helper.setText(R.id.tv_status,"告警："+item.getWaterLevel()+"m");
                helper.setBackgroundRes(R.id.tv_status,R.drawable.shape_pump_alarm);
                helper.setTextColor(R.id.tv_status,mContext.getResources().getColor(R.color.white));
            }



        }else {
            if (item.getStatus()==0){  //状态  0 未播放  1播放中
                helper.setImageResource(R.id.image_status,R.drawable.shape_oval_gray);
                helper.setText(R.id.tv_status,"已关闭");
            }else if (item.getStatus() ==1){
                helper.setImageResource(R.id.image_status,R.drawable.shape_oval_blue);
                helper.setText(R.id.tv_status,"已开启");
            }

        }



       if (type.equals("broad")){
           helper.setVisible(R.id.image_little,true);
           helper.setImageResource(R.id.image_little,R.mipmap.icon_equ_little_music);
           helper.setText(R.id.tv_music,item.getMusic());
       }else if (type.equals("light")){
           helper.setVisible(R.id.image_little,true);
           helper.setImageResource(R.id.image_little,R.mipmap.icon_little_light);
           helper.setText(R.id.tv_music,item.getMusic());
       }else if (type.equals("pump")){
           helper.setText(R.id.tv_music,item.getAddress());

       }else if (type.equals("fresh")){
           helper.setVisible(R.id.image_little,true);
           helper.setImageResource(R.id.image_little,R.mipmap.icon_little_fresh);
           helper.setText(R.id.tv_music,item.getMode()+" | "+item.getAddress());
       }else if (type.equals("ventilate")){
           helper.setVisible(R.id.image_little,true);
           helper.setImageResource(R.id.image_little,R.mipmap.icon_little_fresh);
           helper.setText(R.id.tv_music,item.getMode());
       }

       helper.setText(R.id.tv_title,item.getTitle());


       helper.addOnClickListener(R.id.rl_item);
    }
}
