package com.fhx.property.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.fragment.EnvironmentOneFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 环境监测
 */
public class EnvironmentActivity extends BaseActivity {
    private ImageView imageLeft;
    private TextView tvTitle;
    private ViewPager viewpager;
    List<Fragment> fragments = new ArrayList<>();
    private FragmentManager supportFragmentManager;

    @Override
    protected int initLayout() {
        return R.layout.activity_environment;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        viewpager = (ViewPager) findViewById(R.id.viewpager);

    }

    @Override
    protected void initData() {
        tvTitle.setText("环境监测");
        initViewPager();
    }

    private void initViewPager() {
        fragments.add(new EnvironmentOneFragment(1));
        fragments.add(new EnvironmentOneFragment(2));
        fragments.add(new EnvironmentOneFragment(3));
        supportFragmentManager = getSupportFragmentManager();
        viewpager.setAdapter(new pagerAdapter(supportFragmentManager));
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewpager.setCurrentItem(0);

    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
            }
        });
    }

    class pagerAdapter extends FragmentPagerAdapter {
        //        List<Fragment> fragments;
        public pagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
//            this.fragments =fragments;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
