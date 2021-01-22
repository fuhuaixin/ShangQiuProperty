package com.fhx.property.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.TaskImageAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.dialog.CoupleBackDialog;
import com.fhx.property.dialog.TitleDialog;
import com.fhx.property.fragment.TaskDealFragment;
import com.fhx.property.fragment.TaskRedeployFragment;
import com.fhx.property.utils.ActivityControl;
import com.fhx.property.utils.AutoHeightViewPager;
import com.fhx.property.utils.CutToUtils;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务-设备故障-详情
 */
public class TaskFaultMsgActivity extends BaseActivity implements View.OnClickListener {
    private ImageView image_left;
    private RecyclerView image_recycle;
    private TextView tv_check_more;
    private TabLayout tabLayout;
    private AutoHeightViewPager viewPager;
    private LinearLayout ll_add, ll_deal_add, ll_bot_three;
    private ImageView image_add_people, image_bg;
    private RelativeLayout rl_title;
    private LinearLayout ll_no_deal, ll_deal, ll_order_type, ll_order_no;


    private List<String> imageList = new ArrayList<>();
    private TaskImageAdapter imageAdapter;
    private TitleDialog titleDialog;

    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();
    public static String type, processId, status;

    @Override
    protected int initLayout() {
        return R.layout.activity_task_fault_msg;
    }

    @Override
    protected void initView() {
        image_recycle = (RecyclerView) findViewById(R.id.image_recycle);
        image_left = (ImageView) findViewById(R.id.image_left);
        tv_check_more = (TextView) findViewById(R.id.tv_check_more);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (AutoHeightViewPager) findViewById(R.id.viewPager);
        ll_add = (LinearLayout) findViewById(R.id.ll_add);
        ll_deal_add = (LinearLayout) findViewById(R.id.ll_deal_add);
        ll_bot_three = (LinearLayout) findViewById(R.id.ll_bot_three);
        image_add_people = (ImageView) findViewById(R.id.image_add_people);
        image_bg = (ImageView) findViewById(R.id.image_bg);
        rl_title = (RelativeLayout) findViewById(R.id.rl_title);
        ll_no_deal = (LinearLayout) findViewById(R.id.ll_no_deal);
        ll_deal = (LinearLayout) findViewById(R.id.ll_deal);
        ll_order_type = (LinearLayout) findViewById(R.id.ll_order_type);
        ll_order_no = (LinearLayout) findViewById(R.id.ll_order_no);
    }

    @Override
    protected void initData() {
        type = getIntent().getStringExtra("jumpOne");
        processId = getIntent().getStringExtra("jumpTwo");
        status = getIntent().getStringExtra("jumpThree");
        ActivityControl.getInstance().add(TaskFaultMsgActivity.this);
        titles.add("处理");
        titles.add("转派");
        fragments.add(new TaskDealFragment());
        fragments.add(new TaskRedeployFragment());
        imageList.add("http://00.minipic.eastday.com/20170516/20170516175928_3c915f9aafa7af3b8c5c1d7794a97538_1.jpeg");
        imageList.add("http://00.minipic.eastday.com/20170516/20170516175928_3c915f9aafa7af3b8c5c1d7794a97538_1.jpeg");
        imageList.add("http://00.minipic.eastday.com/20170516/20170516175928_3c915f9aafa7af3b8c5c1d7794a97538_1.jpeg");

        image_recycle.setLayoutManager(new GridLayoutManager(this, 3));
        imageAdapter = new TaskImageAdapter(imageList);
        image_recycle.setAdapter(imageAdapter);
        image_recycle.setItemAnimator(null);

        titleDialog = new TitleDialog(this, R.layout.dialog_check_more);

        setViewPager();

//
    }

    @Override
    protected void initListen() {
        image_left.setOnClickListener(this);
        tv_check_more.setOnClickListener(this);
        image_add_people.setOnClickListener(this);

        imageAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                Intent intent = new Intent(TaskFaultMsgActivity.this, ImageMagnifyActivity.class);
                intent.putStringArrayListExtra("imageList", (ArrayList<String>) imageList);
                intent.putExtra("position", position);
                startActivity(intent);
                overridePendingTransition(R.anim.activity_in_from_anim, R.anim.activity_in_to_anim);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_check_more:
                titleDialog.show();
                dialogFindViewById();
                break;
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.image_close:
                titleDialog.dismiss();
                break;
            case R.id.image_add_people:
                CutToUtils.getInstance().JumpToOne(TaskFaultMsgActivity.this, TaskChoosePeopleActivity.class, processId);
                break;
            case R.id.ll_no_deal:
                CoupleBackDialog coupleBackDialog = new CoupleBackDialog(TaskFaultMsgActivity.this);
                coupleBackDialog.show();
                break;
            case R.id.ll_deal:
                ToastShort("已解决");
                break;
        }
    }


    private void dialogFindViewById() {
        switch (type) {
            case "2":
                titleDialog.findViewById(R.id.include_fault).setVisibility(View.VISIBLE);
                break;
            case "1":
                titleDialog.findViewById(R.id.include_complain).setVisibility(View.VISIBLE);
                break;
            case "0":
                titleDialog.findViewById(R.id.include_repair).setVisibility(View.VISIBLE);
                break;
        }
        titleDialog.findViewById(R.id.image_close).setOnClickListener(this);

    }


    private void setViewPager() {

        switch (getIntent().getStringExtra("jumpThree")) {
            case "0":
            case "1":
            case "2":
                String userType = mmkv.decodeString("userType");
                String[] split = userType.split(",");
                for (int i = 0; i < split.length; i++) {
                    Log.e("split", split[i]);

                    switch (split[i]) {
                        case "KF_EMP_003":
                        case "BD_GC_001":
                            ll_add.setVisibility(View.VISIBLE);
                            break;
                        case "GC_EMP_004":
                            ll_deal_add.setVisibility(View.VISIBLE);
                            break;
                        case "GC_EMP_005":
                            ll_deal_add.setVisibility(View.VISIBLE);
                            titles.remove(1);
                            fragments.remove(1);
                            break;
                    }
                }
                break;
            case "3":
                ll_bot_three.setVisibility(View.VISIBLE);
                rl_title.setBackgroundResource(R.color.title_green);
                image_bg.setImageResource(R.mipmap.image_fault_msg_green);
                ll_order_type.setBackgroundResource(R.mipmap.bg_task_green_msg);
                ll_order_no.setBackgroundResource(R.mipmap.bg_task_green_msg);
                ll_no_deal.setOnClickListener(this);
                ll_deal.setOnClickListener(this);
                break;
            case "4":
            case "5":
                ll_bot_three.setVisibility(View.VISIBLE);
                rl_title.setBackgroundResource(R.color.title_green);
                image_bg.setImageResource(R.mipmap.image_fault_msg_green);
                ll_order_type.setBackgroundResource(R.mipmap.bg_task_green_msg);
                ll_order_no.setBackgroundResource(R.mipmap.bg_task_green_msg);
                break;
        }

//        String userType = mmkv.decodeString("userType");


        viewPager.initIndexList(fragments.size());

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

        //添加viewpager 切换监听
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                //在每次切换的时候更新高度
                viewPager.updateHeight(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }

}
