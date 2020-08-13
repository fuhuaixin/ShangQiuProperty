package com.fhx.property.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.activity.ContactsMsgActivity;
import com.fhx.property.adapter.ContactsEndAdapter;
import com.fhx.property.base.BaseFragment;
import com.fhx.property.bean.ContactsListBean;
import com.fhx.property.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

public class ContactsThirdFragment extends BaseFragment {

    private ContactsEndAdapter endAdapter;
    private RecyclerView endRecycle;
    private List<ContactsListBean> mList = new ArrayList<>();

    @Override
    public int setLayoutId() {
        return R.layout.fragment_contacts_first;
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        endRecycle = view.findViewById(R.id.recycle_first);

        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                mList.add(new ContactsListBean("部门1", "名字" + 1, "job" + i, "经理", "电话" + i));
            } else {
                mList.add(new ContactsListBean("部门1", "名字" + 1, "job" + i, "", "电话" + i));
            }
        }
        endAdapter = new ContactsEndAdapter(mList);
        endRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        endRecycle.setAdapter(endAdapter);


        Log.e("fhxx", "size ===" + getActivity().getSupportFragmentManager().getBackStackEntryCount());
    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);
        endAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToBean(getActivity(), ContactsMsgActivity.class,mList.get(position));
            }
        });
    }
}
