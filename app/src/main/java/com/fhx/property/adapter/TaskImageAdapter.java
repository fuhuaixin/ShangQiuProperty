package com.fhx.property.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;

import java.util.List;

public class TaskImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public TaskImageAdapter(@Nullable List<String> data) {
        super(R.layout.adapter_task_image, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImageView image_add = helper.getView(R.id.image_add);
        Glide.with(mContext).load(item).into(image_add);
        if (helper.getPosition()==0){
            helper.setVisible(R.id.view_line,false);
        }else {
            helper.setVisible(R.id.view_line,true);

        }

        helper.addOnClickListener(R.id.image_add);
    }
}
