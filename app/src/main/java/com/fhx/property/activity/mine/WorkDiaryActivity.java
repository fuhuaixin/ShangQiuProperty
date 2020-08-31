package com.fhx.property.activity.mine;

import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.fragment.HomeFragment;
import com.fhx.property.fragment.MineFragment;
import com.fhx.property.fragment.ReadLogFragment;
import com.fhx.property.fragment.ScanFragment;
import com.fhx.property.fragment.WriteLogFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 写读日志
 */
public class WorkDiaryActivity extends BaseActivity {
    private RadioGroup rg_log;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_work_diary;
    }

    @Override
    protected void initView() {
        rg_log = (RadioGroup) findViewById(R.id.rg_log);
    }

    @Override
    protected void initData() {
        fragments.add(new WriteLogFragment());
        fragments.add(new ReadLogFragment());

        SwitchFragment(0);
    }

    @Override
    protected void initListen() {
        rg_log.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_write:
                        SwitchFragment(0);

                        break;
                    case R.id.rb_read:
                        SwitchFragment(1);

                        break;
                }
            }
        });

    }


    public void SwitchFragment(int i) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragments.get(i));
        fragmentTransaction.commit();
    }
}
