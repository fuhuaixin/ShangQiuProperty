package com.fhx.property.fragment;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.MineOAAdapter;
import com.fhx.property.base.BaseFragment;
import com.fhx.property.bean.MineOABean;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的fragment
 */
public class MineFragment extends BaseFragment {

    private RecyclerView recycle_oa;
    private MineOAAdapter mineOAAdapter;

    private List<MineOABean> mineOABeanList =new ArrayList<>();

    @Override
    public int setLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        recycle_oa =view.findViewById(R.id.recycle_oa);
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        mineOABeanList.clear();
        mineOABeanList.add(new MineOABean(R.mipmap.icon_mine_clock,"考勤打卡",0));
        mineOABeanList.add(new MineOABean(R.mipmap.icon_mine_leave,"请假",0));
        mineOABeanList.add(new MineOABean(R.mipmap.icon_mine_log,"日志",0));
        mineOABeanList.add(new MineOABean(R.mipmap.icon_mine_examine,"审批",1));
        mineOABeanList.add(new MineOABean(R.mipmap.icon_mine_mk_card,"补卡",0));
        mineOABeanList.add(new MineOABean(R.mipmap.icon_mine_salary,"薪资",0));


        recycle_oa.setLayoutManager(new GridLayoutManager(getContext(),5));
        mineOAAdapter =new MineOAAdapter(mineOABeanList);
        recycle_oa.setAdapter(mineOAAdapter);
    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);
        mineOAAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getContext(), "dinaji le "+position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
