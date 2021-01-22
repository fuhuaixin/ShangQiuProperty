package com.fhx.property.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.DepartmentBean;

import java.util.List;

public class TaskChoosePeopleAdapter extends BaseQuickAdapter<DepartmentBean.DataBean.ChildDeptBean, BaseViewHolder> {
    public TaskChoosePeopleAdapter(@Nullable List<DepartmentBean.DataBean.ChildDeptBean> data) {
        super(R.layout.adapter_task_choose_people, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DepartmentBean.DataBean.ChildDeptBean item) {
        ImageView image_unsel = helper.getView(R.id.image_unsel);

        if (item.getDeptLeader()!=null){
            helper.setText(R.id.tv_name,item.getDeptName()+"("+item.getDeptLeader().getEmployeeName()+")");
            helper.addOnClickListener(R.id.image_unsel,R.id.tv_name,R.id.image_right);
        }else {

            helper.setText(R.id.tv_name,item.getDeptName());
            image_unsel.setClickable(false);
            helper.addOnClickListener(R.id.tv_name,R.id.image_right);
        }

        if (item.getChoose()==1){
            image_unsel.setImageResource(R.drawable.icon_check_select);
        }else {
            image_unsel.setImageResource(R.drawable.icon_check_unsel);
        }

//        helper.addOnClickListener(R.id.image_unsel,R.id.tv_name,R.id.image_right);

    }
}
