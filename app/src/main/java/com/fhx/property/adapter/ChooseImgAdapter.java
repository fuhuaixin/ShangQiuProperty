package com.fhx.property.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;

import java.util.List;

public class ChooseImgAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public ChooseImgAdapter(@Nullable List<String> data) {
        super(R.layout.adapter_repairs_choose_two, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImageView image = helper.getView(R.id.image);
        Glide.with(mContext).load(item).into(image);

        helper.addOnClickListener(R.id.image_del);
    }
}
