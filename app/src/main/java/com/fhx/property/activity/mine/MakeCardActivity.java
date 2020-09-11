package com.fhx.property.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.fragment.CardCommitFragment;
import com.fhx.property.fragment.CardListFragment;
import com.fhx.property.fragment.ExamineFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 补卡
 */
public class MakeCardActivity extends BaseActivity implements View.OnClickListener{

    private ImageView imageLeft;
    private TextView tvTitle;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_make_card;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    @Override
    protected void initData() {
        tvTitle.setText("补卡");
        titles.add("发起提交");
        titles.add("查看数据");

        fragments.add(new CardCommitFragment());
        fragments.add(new CardListFragment());
        setViewPager();
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);

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


    private void setViewPager(){
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }
}
