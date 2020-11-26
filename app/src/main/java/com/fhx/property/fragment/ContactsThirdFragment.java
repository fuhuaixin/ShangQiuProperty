package com.fhx.property.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.activity.ContactsMsgActivity;
import com.fhx.property.adapter.ContactsEndAdapter;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseFragment;
import com.fhx.property.bean.ContactsListBean;
import com.fhx.property.bean.ContactsThirdBean;
import com.fhx.property.utils.CutToUtils;
import com.lljjcoder.style.citylist.Toast.ToastUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

public class ContactsThirdFragment extends BaseFragment {

    private ContactsEndAdapter endAdapter;
    private RecyclerView endRecycle;
    private List<ContactsThirdBean.DataBean> mList = new ArrayList<>();

    @Override
    public int setLayoutId() {
        return R.layout.fragment_contacts_first;
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        endRecycle = view.findViewById(R.id.recycle_first);


        endAdapter = new ContactsEndAdapter(mList);
        endRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        endRecycle.setAdapter(endAdapter);

        getEmployee();
        Log.e("fhxx", "size ===" + getActivity().getSupportFragmentManager().getBackStackEntryCount());
    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);
        endAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToOne(getActivity(), ContactsMsgActivity.class, mList.get(position).getEmployeeId());
            }
        });
    }

    private void getEmployee() {
        EasyHttp.get(AppUrl.EmployeeFindDept)
                .syncRequest(false)
                .params("id", mmkv.decodeString("deptId"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        ContactsThirdBean contactsThirdBean = JSON.parseObject(s, ContactsThirdBean.class);
                        if (contactsThirdBean.isSuccess()) {
                            mList.clear();
                            mList.addAll(contactsThirdBean.getData());
                            endAdapter.notifyDataSetChanged();
                        } else {
                            ToastUtils.showShortToast(getContext(), contactsThirdBean.getMsg());
                        }
                    }
                });
    }
}
