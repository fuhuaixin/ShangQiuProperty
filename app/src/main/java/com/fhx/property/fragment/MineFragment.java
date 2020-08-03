package com.fhx.property.fragment;

import android.view.View;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseFragment;

/**
 * 我的fragment
 */
public class MineFragment extends BaseFragment {

    private TextView tv_home;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        tv_home =view.findViewById(R.id.tv_home);
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        tv_home.setText("变成了 Mine");
    }
}
