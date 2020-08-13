package com.fhx.property.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.ContactsFirstAdapter;
import com.fhx.property.base.BaseFragment;
import com.fhx.property.bean.ContactsListBean;
import com.fhx.property.bean.EventContactsBean;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class ContactsSecondFragment extends BaseFragment {
    private RecyclerView recycle_first;
    private ContactsFirstAdapter firstAdapter;
    private List<ContactsListBean> beanList = new ArrayList<>();
    private EventContactsBean postBean;
    @Override
    public int setLayoutId() {
        return R.layout.fragment_contacts_first;
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        postBean =new EventContactsBean();
        recycle_first = view.findViewById(R.id.recycle_first);
        beanList.clear();
        beanList.add(new ContactsListBean("子部门11", 3));
        beanList.add(new ContactsListBean("子部门22", 2));
        beanList.add(new ContactsListBean("子部门33", 3));
        beanList.add(new ContactsListBean("子部门44", 4));
        firstAdapter = new ContactsFirstAdapter(beanList);

        recycle_first.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle_first.setAdapter(firstAdapter);
        Log.e("fhxx","size ==="+getActivity().getSupportFragmentManager().getBackStackEntryCount());

    }
    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);
        firstAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                postBean.setTag("202");
                postBean.setTitle(" / "+beanList.get(position).getBranch());
                EventBus.getDefault().post(postBean);
                startToFragment(getContext(), R.id.frameLayout, new ContactsThirdFragment(), "202");
            }
        });

    }
}
