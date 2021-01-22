package com.fhx.property.adapter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.HomeTaskBean;
import com.lljjcoder.style.citylist.Toast.ToastUtils;

import java.util.List;

public class HomeTaskAdapter extends BaseQuickAdapter<HomeTaskBean.DataBean, BaseViewHolder> {
    private List<HomeTaskBean.DataBean> data;

    public HomeTaskAdapter(@Nullable List<HomeTaskBean.DataBean> data) {
        super(R.layout.adapter_home_task, data);
        this.data = data;
    }

    String status;
    boolean click = false;

    @Override
    protected void convert(BaseViewHolder helper, HomeTaskBean.DataBean item) {
        View line_view = helper.getView(R.id.line_view);
        ImageView image_big = helper.getView(R.id.image_big);
        if (helper.getPosition() == (data.size() - 1)) {
            line_view.setVisibility(View.GONE);
        } else {
            line_view.setVisibility(View.VISIBLE);
        }

        switch (item.getOrderType()) {  //0报修 1 投诉 2 设备维护
            case "0":
                image_big.setImageResource(R.mipmap.icon_list_task_repair);
                break;
            case "1":
                image_big.setImageResource(R.mipmap.icon_list_task_complain);
                break;
            case "2":
                image_big.setImageResource(R.mipmap.icon_list_task_fault);
                break;
        }
        switch (item.getStatus()) {
            case "0":
                status = "未提交";
                click = false;
                break;
            case "1":
                status = "待分配";
                click = true;
                break;
            case "2":
                status = "处理中";
                click = true;
                break;
            case "3":
                status = "处理完成";
                click = true;
                break;
            case "4":
                status = "回访完成";
                click = true;
                break;
            case "5":
                status = "已评价";
                click = true;
                break;
        }
        String[] s = item.getStartTime().split(" ");
        Log.e("截取空格",s[0]+"  "+s[1]);
        helper.setText(R.id.tv_title, item.getProcessName() + "(" + status + ")")
                .setText(R.id.tv_order, item.getProcessId())
        .setText(R.id.tv_time,s[1]);
        if (click) {
            helper.addOnClickListener(R.id.rl_item);
        }

    }
}
