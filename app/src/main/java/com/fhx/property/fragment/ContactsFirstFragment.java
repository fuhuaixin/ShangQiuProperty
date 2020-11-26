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
import com.fhx.property.bean.ChooseBean;
import com.fhx.property.bean.ContactsListBean;
import com.fhx.property.bean.EventContactsBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class ContactsFirstFragment extends BaseFragment {
    private EventContactsBean postBean;

    private RecyclerView recycle_first;
    private ContactsFirstAdapter firstAdapter;
    private List<ContactsListBean> beanList = new ArrayList<>();
    private List<String> bumen =new ArrayList<>();

    @Override
    public int setLayoutId() {
        return R.layout.fragment_contacts_first;
    }

    public ContactsFirstFragment(List<String> bumen) {
        this.bumen = bumen;
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        Log.e("fhxx", "size ===" + getActivity().getSupportFragmentManager().getBackStackEntryCount());
        postBean = new EventContactsBean();
        recycle_first = view.findViewById(R.id.recycle_first);
        beanList.clear();
        for (int i = 0; i < bumen.size(); i++) {
            beanList.add(new ContactsListBean(bumen.get(i), 6));

        }
       /* beanList.add(new ContactsListBean("部门2", 16));
        beanList.add(new ContactsListBean("部门3", 8));
        beanList.add(new ContactsListBean("部门4", 12));*/
        firstAdapter = new ContactsFirstAdapter(beanList);

        recycle_first.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle_first.setAdapter(firstAdapter);

    }




    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);

        firstAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                postBean.setTag("201");
                postBean.setTitle(" / "+beanList.get(position).getBranch());
                mmkv.encode("click",position);
                EventBus.getDefault().post(postBean);
                startToFragment(getContext(), R.id.frameLayout, new ContactsSecondFragment(), "201");
            }
        });

    }


}
