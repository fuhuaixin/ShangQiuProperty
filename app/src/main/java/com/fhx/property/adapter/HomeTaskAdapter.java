package com.fhx.property.adapter;

import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.HomeTaskBean;

import java.util.List;

public class HomeTaskAdapter extends BaseQuickAdapter<HomeTaskBean, BaseViewHolder> {
    private List<HomeTaskBean> data;
    public HomeTaskAdapter( @Nullable List<HomeTaskBean> data) {
        super(R.layout.adapter_home_task, data);
        this.data =data;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeTaskBean item) {
        View line_view = helper.getView(R.id.line_view);
        if (helper.getPosition()==(data.size()-1)){
            line_view.setVisibility(View.GONE);
        }else {
            line_view.setVisibility(View.VISIBLE);
        }

        if (item.getState()==0){ //0是已完成  1 是进行中
            helper.setImageResource(R.id.image_task_state,R.mipmap.icon_task_end);
        }else if (item.getState()==1){
            helper.setImageResource(R.id.image_task_state,R.mipmap.icon_task_ing);
        }

        helper.setText(R.id.tv_title,item.getTitle())
                .setText(R.id.tv_time,item.getTime())
                .setText(R.id.tv_msg,item.getMsg());

        helper.addOnClickListener(R.id.rl_item);

    }
}
