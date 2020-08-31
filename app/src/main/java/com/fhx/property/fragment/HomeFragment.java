package com.fhx.property.fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.activity.CarManageActivity;
import com.fhx.property.activity.ContactsActivity;
import com.fhx.property.activity.EquManageActivity;
import com.fhx.property.activity.FaultNotifiActivity;
import com.fhx.property.activity.LeaseListActivity;
import com.fhx.property.activity.NotifyListActivity;
import com.fhx.property.activity.ReminderActivity;
import com.fhx.property.activity.RepairsActivity;
import com.fhx.property.adapter.HomeNavAdapter;
import com.fhx.property.adapter.HomeTaskAdapter;
import com.fhx.property.base.BaseFragment;
import com.fhx.property.bean.HomeNavBean;
import com.fhx.property.bean.HomeTaskBean;
import com.fhx.property.utils.ListDialog;
import com.fhx.property.utils.CutToUtils;
import com.to.aboomy.banner.Banner;
import com.to.aboomy.banner.HolderCreator;
import com.to.aboomy.banner.ScaleInTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页Fragment
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener{

    private ListDialog listDialog;
    private Banner home_banner;
    private RecyclerView recycle_nav;
    private RecyclerView recycle_task;
    private RelativeLayout rl_notify_list;
    private ImageView image_weather;
    //banner list
//    private List<String> bannerList =new ArrayList<>();
    private List<Integer> bannerList =new ArrayList<>();
    private HomeNavAdapter homeNavAdapter;
    private HomeTaskAdapter homeTaskAdapter;
    private List<HomeNavBean> homeNavBeanList =new ArrayList<>();
    private List<HomeTaskBean> homeTaskBeanList =new ArrayList<>();
    private List<String> dialogList = new ArrayList<>();
    private LinearLayout ll_fault_notifi;
    @Override
    public int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        home_banner =view.findViewById(R.id.home_banner);
        recycle_nav =view.findViewById(R.id.recycle_nav);
        recycle_task =view.findViewById(R.id.recycle_task);
        rl_notify_list =view.findViewById(R.id.rl_notify_list);
        ll_fault_notifi =view.findViewById(R.id.ll_fault_notifi);
        image_weather =view.findViewById(R.id.image_weather);
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);

        homeNavBeanList.clear();
        homeNavBeanList.add(new HomeNavBean(R.mipmap.icon_repairs,"报修"));
        homeNavBeanList.add(new HomeNavBean(R.mipmap.icon_device,"设备管理"));
        homeNavBeanList.add(new HomeNavBean(R.mipmap.icon_contact,"通讯录"));
        homeNavBeanList.add(new HomeNavBean(R.mipmap.icon_lease,"租赁管理"));
        homeNavBeanList.add(new HomeNavBean(R.mipmap.icon_bill,"费用催缴"));
        homeNavBeanList.add(new HomeNavBean(R.mipmap.icon_goods,"物资申领"));
        homeNavBeanList.add(new HomeNavBean(R.mipmap.icon_maintain,"设备维护"));
        homeNavBeanList.add(new HomeNavBean(R.mipmap.icon_car,"车辆管理"));

        homeTaskBeanList.clear();
        homeTaskBeanList.add(new HomeTaskBean("任务1","任务一详情","10:20",1));
        homeTaskBeanList.add(new HomeTaskBean("任务2","任务二详情","10:30",1));
        homeTaskBeanList.add(new HomeTaskBean("任务3","任务三详情","10:40",1));
        homeTaskBeanList.add(new HomeTaskBean("任务4","任务四详情","10:40",0));

        homeNavAdapter =new HomeNavAdapter(homeNavBeanList);

        bannerList.add(R.mipmap.image_banners);
        bannerList.add(R.mipmap.image_banners);

        recycle_nav.setLayoutManager(new GridLayoutManager(getContext(),5));
        recycle_nav.setAdapter(homeNavAdapter);


        homeTaskAdapter =new HomeTaskAdapter(homeTaskBeanList);
        recycle_task.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle_task.setAdapter(homeTaskAdapter);

        listDialog = new ListDialog(getActivity(), dialogList, new ListDialog.LeaveMyDialogListener() {
            @Override
            public void onClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });

        /**
         * 设置banner 以及点击事件
         */
        home_banner.setIndicator(null)
                .setAutoPlay(true)
                .setAutoTurningTime(2000)
                .setHolderCreator(new HolderCreator() {
                    @Override
                    public View createView(Context context, final int index, Object o) {
                        ImageView iv = new ImageView(context);
                        iv.setScaleType(ImageView.ScaleType.FIT_XY);
                        Glide.with(context).load(o).skipMemoryCache(true).into(iv);
                        iv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getContext(), "点击了"+index, Toast.LENGTH_SHORT).show();
                            }
                        });
                        return iv;
                    }
                })
                .setPageTransformer(true,new ScaleInTransformer())
                .setRoundCorners(10f)
                .setPages(bannerList);
    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);

        homeNavAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (homeNavBeanList.get(position).getTitle().equals("报修")){
                    CutToUtils.getInstance().JumpTo(getActivity(), RepairsActivity.class);
                }else if (homeNavBeanList.get(position).getTitle().equals("设备管理")){
                    CutToUtils.getInstance().JumpTo(getActivity(), EquManageActivity.class);
                }else if (homeNavBeanList.get(position).getTitle().equals("费用催缴")){
                    CutToUtils.getInstance().JumpTo(getActivity(), ReminderActivity.class);
                }else if (homeNavBeanList.get(position).getTitle().equals("租赁管理")){
                    CutToUtils.getInstance().JumpTo(getActivity(), LeaseListActivity.class);
                }else if (homeNavBeanList.get(position).getTitle().equals("车辆管理")){
                    CutToUtils.getInstance().JumpTo(getActivity(), CarManageActivity.class);
                }else if (homeNavBeanList.get(position).getTitle().equals("通讯录")){
                    CutToUtils.getInstance().JumpTo(getActivity(), ContactsActivity.class);
                }
                Toast.makeText(getContext(), "点击了"+position, Toast.LENGTH_SHORT).show();
            }
        });


        homeTaskAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getContext(), "点击了item"+position, Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * banner自动轮播监听
         */
        home_banner.setOuterPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                Log.e("fhxx","轮播到了"+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rl_notify_list.setOnClickListener(this);
        ll_fault_notifi.setOnClickListener(this);
        image_weather.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_notify_list:
                CutToUtils.getInstance().JumpTo(getActivity(), NotifyListActivity.class);
                break;
            case R.id.ll_fault_notifi:
                CutToUtils.getInstance().JumpTo(getActivity(), FaultNotifiActivity.class);
                break;
            case R.id.image_weather:

                break;
        }
    }
}
