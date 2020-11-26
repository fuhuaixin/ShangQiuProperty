package com.fhx.property.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.ContactsFirstAdapter;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseFragment;
import com.fhx.property.bean.ContactsBean;
import com.fhx.property.bean.ContactsListBean;
import com.fhx.property.bean.EventContactsBean;
import com.lljjcoder.style.citylist.Toast.ToastUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class ContactsSecondFragment extends BaseFragment {
    private RecyclerView recycle_first;
    private ContactsFirstAdapter firstAdapter;
    private List<ContactsListBean> beanList = new ArrayList<>();
    private EventContactsBean postBean;
    private List<String> deptId = new ArrayList<>();

    @Override
    public int setLayoutId() {
        return R.layout.fragment_contacts_first;
    }


    @Override
    public void onResume() {
        super.onResume();
        int click = mmkv.decodeInt("click");
        getList(click);
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);

        postBean = new EventContactsBean();
        recycle_first = view.findViewById(R.id.recycle_first);

        firstAdapter = new ContactsFirstAdapter(beanList);

        recycle_first.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle_first.setAdapter(firstAdapter);
        Log.e("fhxx", "size ===" + getActivity().getSupportFragmentManager().getBackStackEntryCount());
    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);
        firstAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                postBean.setTag("202");
                postBean.setTitle(" / " + beanList.get(position).getBranch());
                mmkv.encode("deptId", deptId.get(position));
                EventBus.getDefault().post(postBean);
                startToFragment(getContext(), R.id.frameLayout, new ContactsThirdFragment(), "202");
            }
        });

    }


    private void getList(final int position) {
        EasyHttp.get(AppUrl.DeptreeList)
                .syncRequest(false)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        ContactsBean contactsBean = JSON.parseObject(s, ContactsBean.class);
                        if (contactsBean.isSuccess()) {
                            beanList.clear();
                            for (int i = 0; i < contactsBean.getData().get(position).getChildren().size(); i++) {
                                beanList.add(new ContactsListBean(contactsBean.getData().get(position).getChildren().get(i).getName(), 3));
                                deptId.add(contactsBean.getData().get(position).getChildren().get(i).getId());
                                for (int j = 0; j < contactsBean.getData().get(position).getChildren().get(i).getChildren().size(); j++) {
                                    beanList.add(new ContactsListBean(contactsBean.getData().get(position).getChildren().get(i).getChildren().get(j).getName(), 3));
                                    deptId.add(contactsBean.getData().get(position).getChildren().get(i).getChildren().get(j).getId());
                                    if (contactsBean.getData().get(position).getChildren().get(i).getChildren().get(j).getChildren() != null) {
                                        for (int k = 0; k < contactsBean.getData().get(position).getChildren().get(i).getChildren().get(j).getChildren().size(); k++) {
                                            beanList.add(new ContactsListBean(contactsBean.getData().get(position).getChildren().get(i).getChildren().get(j).getChildren().get(k).getName(), 3));
                                            deptId.add(contactsBean.getData().get(position).getChildren().get(i).getChildren().get(j).getChildren().get(k).getName());
                                        }
                                    }

                                }
                            }
                            firstAdapter.notifyDataSetChanged();
                        } else {
                            ToastUtils.showShortToast(getContext(), contactsBean.getMsg());
                        }
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
