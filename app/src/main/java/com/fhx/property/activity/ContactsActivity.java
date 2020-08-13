package com.fhx.property.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.ContactsTitleAdapter;
import com.fhx.property.bean.ChooseBean;
import com.fhx.property.bean.EventContactsBean;
import com.fhx.property.fragment.ContactsFirstFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 通讯录
 */
public class ContactsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvTitle;

    private ImageView imageLeft;
    private FrameLayout frameLayout;
    private RecyclerView recycle_title;
    private ContactsTitleAdapter titleAdapter;
    public List<String> mTag = new ArrayList<>();
    public List<ChooseBean> mTitle = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        EventBus.getDefault().register(this);
        initViews();
        initData();
        initListen();

    }

    private void initViews() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        imageLeft = (ImageView) findViewById(R.id.image_left);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        recycle_title = findViewById(R.id.recycle_title);
    }


    private void initData() {
        tvTitle.setText("通讯录");
        mTag.add("tag");
        mTitle.add(new ChooseBean("华庭物业有限公司",1));
        titleAdapter = new ContactsTitleAdapter(mTitle);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycle_title.setLayoutManager(linearLayoutManager);
        recycle_title.setAdapter(titleAdapter);
        ContactsFirstFragment contactsFirstFragment = new ContactsFirstFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frameLayout, contactsFirstFragment);
        fragmentTransaction.commit();
    }

    private void initListen() {
        imageLeft.setOnClickListener(this);

        titleAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView tv_title = view.findViewById(R.id.tv_title);
                if (position==0){
                    return;
                }
                mTitle.set(position-1,new ChooseBean(mTitle.get(position-1).getTitle(),1));
                getSupportFragmentManager().popBackStackImmediate(mTag.get(position), 1);
                Log.e("fhxx",mTag.size()+"");

                switch (mTag.size() - position){
                    case 1:
                        mTag.remove(position);
                        mTitle.remove(position);
                        break;
                    case 2:
                        mTag.remove(position+1);
                        mTitle.remove(position+1);
                        mTag.remove(position);
                        mTitle.remove(position);
                        break;
                }

                titleAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.e("fhxx", getSupportFragmentManager().getBackStackEntryCount() + "activity");
        if (mTag.size() > 0) {
            getSupportFragmentManager().popBackStackImmediate(mTag.get(mTag.size()-1 ), 1);
            mTag.remove(mTag.get(mTag.size() -1));
            mTitle.remove(mTitle.get(mTitle.size()-1));
            if (mTitle.size()>1){
                mTitle.set(mTitle.size()-1,new ChooseBean(mTitle.get(mTitle.size()-1).getTitle(),1));
            }
            titleAdapter.notifyDataSetChanged();
        } else {
            finish();
            overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getmList(EventContactsBean bean) {
        mTag.add(bean.getTag());
        mTitle.add(new ChooseBean(bean.getTitle(),1));
        for (int i = 0; i < mTitle.size()-1; i++) {
            mTitle.set(i,new ChooseBean(mTitle.get(i).getTitle(),0));
        }
        Log.e("fhxx", "mTag --->" + mTag.toString() + "\nmTitle --->" + mTitle.toString());
        titleAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
