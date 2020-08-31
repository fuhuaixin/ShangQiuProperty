package com.fhx.property.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.activity.mine.CommitLogActivity;
import com.fhx.property.adapter.WriteLogAdapter;
import com.fhx.property.base.BaseFragment;
import com.fhx.property.bean.WriteLogBean;
import com.fhx.property.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

public class WriteLogFragment extends BaseFragment {

    private ImageView imageLeft;
    private TextView tvTitle;
    private RecyclerView recycle_write;
    private WriteLogAdapter logAdapter;
    private List<WriteLogBean> logBeanList = new ArrayList<>();
    @Override
    public int setLayoutId() {
        return R.layout.fragment_write_log;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        imageLeft =view.findViewById(R.id.image_left);
        tvTitle =view.findViewById(R.id.tv_title);
        recycle_write =view.findViewById(R.id.recycle_write);
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        tvTitle.setText("写日志");
        logBeanList.clear();
        logBeanList.add(new WriteLogBean("日报","本日工作进度汇报",R.mipmap.icon_report_day));
        logBeanList.add(new WriteLogBean("周报","本周工作进度汇报",R.mipmap.icon_report_day));
        logBeanList.add(new WriteLogBean("月报","本月工作进度汇报",R.mipmap.icon_report_day));

        logAdapter =new WriteLogAdapter(logBeanList);
        recycle_write.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle_write.setAdapter(logAdapter);

    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);
        imageLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
                getActivity().overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
            }
        });

        logAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToOne(getActivity(), CommitLogActivity.class,logBeanList.get(position).getTitle());
            }
        });

    }
}
