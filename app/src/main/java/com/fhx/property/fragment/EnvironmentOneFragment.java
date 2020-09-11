package com.fhx.property.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseFragment;

public class EnvironmentOneFragment extends BaseFragment {
    private ImageView image_shape_one, image_shape_two, image_shape_three;
    private TextView tv_top_title;
    private int type;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_environment;
    }

    public EnvironmentOneFragment(int type) {
        this.type = type;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        tv_top_title = view.findViewById(R.id.tv_top_title);
        image_shape_one = view.findViewById(R.id.image_shape_one);
        image_shape_two = view.findViewById(R.id.image_shape_two);
        image_shape_three = view.findViewById(R.id.image_shape_three);
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        switch (type) {
            case 1:
                tv_top_title.setText("一层大厅");
                image_shape_one.setImageResource(R.drawable.shape_oval_blue);
                image_shape_two.setImageResource(R.drawable.shape_oval_gray);
                image_shape_three.setImageResource(R.drawable.shape_oval_gray);
                break;
            case 2:
                tv_top_title.setText("十八层自用区");
                image_shape_one.setImageResource(R.drawable.shape_oval_gray);
                image_shape_two.setImageResource(R.drawable.shape_oval_blue);
                image_shape_three.setImageResource(R.drawable.shape_oval_gray);
                break;
            case 3:
                tv_top_title.setText("十九层自用区");
                image_shape_one.setImageResource(R.drawable.shape_oval_gray);
                image_shape_two.setImageResource(R.drawable.shape_oval_gray);
                image_shape_three.setImageResource(R.drawable.shape_oval_blue);
                break;
        }
    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);

    }
}
