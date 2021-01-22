package com.fhx.property.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.DepartmentBean;

import java.util.List;

public class TaskChooseEmpAdapter extends BaseQuickAdapter<DepartmentBean.DataBean.DeptEmployeeBean, BaseViewHolder> {
    public TaskChooseEmpAdapter(@Nullable List<DepartmentBean.DataBean.DeptEmployeeBean> data) {
        super(R.layout.adapter_task_choose_emp, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DepartmentBean.DataBean.DeptEmployeeBean item) {
        helper.setText(R.id.tv_name, item.getEmployeeName())
                .setText(R.id.tv_duty, item.getDutyName());
        ImageView image_check = helper.getView(R.id.image_check);

        if (item.getChoose() == 1) {
            image_check.setImageResource(R.drawable.icon_check_select);
        } else {
            image_check.setImageResource(R.drawable.icon_check_unsel);
        }

        helper.addOnClickListener(R.id.image_check);

    }
}
