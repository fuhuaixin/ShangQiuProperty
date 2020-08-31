package com.fhx.property.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.ReadLogBean;
import com.fhx.property.bean.WriteLogBean;

import java.util.ArrayList;
import java.util.List;

public class ReadLogAdapter extends BaseQuickAdapter<ReadLogBean, BaseViewHolder> {
    public ReadLogAdapter(@Nullable List<ReadLogBean> data) {
        super(R.layout.adapter_read_log, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ReadLogBean item) {
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_msg, item.getMsg())
                .setText(R.id.tv_time, item.getTime());


        if (item.getImages() != null && item.getImages().size() > 0) {
            helper.setVisible(R.id.ll_image, true);
            RecyclerView recycle_image = helper.getView(R.id.recycle_image);
            ReadImageAdapter readImageAdapter = new ReadImageAdapter(item.getImages());
            recycle_image.setLayoutManager(new GridLayoutManager(mContext, 3));
            recycle_image.setAdapter(readImageAdapter);
        } else {
            helper.setVisible(R.id.ll_image, false);

        }

        helper.addOnClickListener(R.id.ll_item);

    }
}
