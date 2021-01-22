package com.fhx.property.fragment;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.activity.CarManageActivity;
import com.fhx.property.activity.ContactsActivity;
import com.fhx.property.activity.EnvironmentActivity;
import com.fhx.property.activity.EquManageActivity;
import com.fhx.property.activity.FaultNotifiActivity;
import com.fhx.property.activity.LeaseListActivity;
import com.fhx.property.activity.NotifyListActivity;
import com.fhx.property.activity.ReminderActivity;
import com.fhx.property.activity.RepairsActivity;
import com.fhx.property.activity.TaskFaultMsgActivity;
import com.fhx.property.activity.TaskListActivity;
import com.fhx.property.adapter.HomeNavAdapter;
import com.fhx.property.adapter.HomeTaskAdapter;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseFragment;
import com.fhx.property.bean.HomeNavBean;
import com.fhx.property.bean.HomeTaskBean;
import com.fhx.property.bean.NotifyListBean;
import com.fhx.property.bean.UserInfoBean;
import com.fhx.property.dialog.CommonDialog;
import com.fhx.property.dialog.ListDialog;
import com.fhx.property.utils.CutToUtils;
import com.fhx.property.utils.NotificationUtil;
import com.to.aboomy.banner.Banner;
import com.to.aboomy.banner.HolderCreator;
import com.to.aboomy.banner.ScaleInTransformer;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页Fragment
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private ListDialog listDialog;
    private Banner home_banner;
    private RecyclerView recycle_nav;
    private RecyclerView recycle_task;
    private RelativeLayout rl_notify_list;
    private ImageView image_weather;
    private TextView tv_inform_one, tv_inform_two;
    private View view_right;
    //    private List<String> bannerList =new ArrayList<>();
    private List<Integer> bannerList = new ArrayList<>();
    private HomeNavAdapter homeNavAdapter;
    private HomeTaskAdapter homeTaskAdapter;
    private List<HomeNavBean> homeNavBeanList = new ArrayList<>();
    private List<HomeTaskBean.DataBean> homeTaskBeanList = new ArrayList<>();
    private List<String> dialogList = new ArrayList<>();
    private LinearLayout ll_fault_notifi;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        home_banner = view.findViewById(R.id.home_banner);
        recycle_nav = view.findViewById(R.id.recycle_nav);
        recycle_task = view.findViewById(R.id.recycle_task);
        rl_notify_list = view.findViewById(R.id.rl_notify_list);
        ll_fault_notifi = view.findViewById(R.id.ll_fault_notifi);
        image_weather = view.findViewById(R.id.image_weather);
        tv_inform_one = view.findViewById(R.id.tv_inform_one);
        tv_inform_two = view.findViewById(R.id.tv_inform_two);
        view_right = view.findViewById(R.id.view_right);
    }

    @Override
    public void onResume() {
        super.onResume();
        //通知栏权限
        if (!NotificationManagerCompat.from(getContext()).areNotificationsEnabled()) {
            notifiDialog.show();
        } else {
            notifiDialog.dismiss();
        }
        getNotify();//通知
        getMyProcess();//任务列表
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        showNotification();

        getUserInfo(); //我的详情
        homeNavBeanList.clear();
        homeNavBeanList.add(new HomeNavBean(R.mipmap.icon_repairs, "报修"));
        homeNavBeanList.add(new HomeNavBean(R.mipmap.icon_device, "设备管理"));
        homeNavBeanList.add(new HomeNavBean(R.mipmap.icon_contact, "通讯录"));
        homeNavBeanList.add(new HomeNavBean(R.mipmap.icon_lease, "租赁管理"));
        homeNavBeanList.add(new HomeNavBean(R.mipmap.icon_bill, "费用催缴"));
        homeNavBeanList.add(new HomeNavBean(R.mipmap.icon_goods, "物资申领"));
        homeNavBeanList.add(new HomeNavBean(R.mipmap.icon_maintain, "设备维护"));
        homeNavBeanList.add(new HomeNavBean(R.mipmap.icon_car, "车辆管理"));


        homeNavAdapter = new HomeNavAdapter(homeNavBeanList);

        bannerList.add(R.mipmap.image_banners);
        bannerList.add(R.mipmap.image_banners);

        recycle_nav.setLayoutManager(new GridLayoutManager(getContext(), 5));
        recycle_nav.setAdapter(homeNavAdapter);


        homeTaskAdapter = new HomeTaskAdapter(homeTaskBeanList);
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
                                Toast.makeText(getContext(), "点击了" + index, Toast.LENGTH_SHORT).show();
                            }
                        });
                        return iv;
                    }
                })
                .setPageTransformer(true, new ScaleInTransformer())
                .setRoundCorners(10f)
                .setPages(bannerList);
    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);

        homeNavAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (homeNavBeanList.get(position).getTitle().equals("报修")) {
                    CutToUtils.getInstance().JumpTo(getActivity(), RepairsActivity.class);
                } else if (homeNavBeanList.get(position).getTitle().equals("设备管理")) {
                    CutToUtils.getInstance().JumpTo(getActivity(), EquManageActivity.class);
                } else if (homeNavBeanList.get(position).getTitle().equals("费用催缴")) {
                    CutToUtils.getInstance().JumpTo(getActivity(), ReminderActivity.class);
                } else if (homeNavBeanList.get(position).getTitle().equals("租赁管理")) {
                    CutToUtils.getInstance().JumpTo(getActivity(), LeaseListActivity.class);
                } else if (homeNavBeanList.get(position).getTitle().equals("车辆管理")) {
                    CutToUtils.getInstance().JumpTo(getActivity(), CarManageActivity.class);
                } else if (homeNavBeanList.get(position).getTitle().equals("通讯录")) {
                    CutToUtils.getInstance().JumpTo(getActivity(), ContactsActivity.class);
                }
            }
        });


        homeTaskAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getContext(), TaskFaultMsgActivity.class);
                intent.putExtra("jumpOne", homeTaskBeanList.get(position).getOrderType());
                intent.putExtra("jumpTwo", homeTaskBeanList.get(position).getProcessId());
                intent.putExtra("jumpThree", homeTaskBeanList.get(position).getStatus());
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.activity_in_from_anim, R.anim.activity_in_to_anim);
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
        view_right.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_notify_list:
                CutToUtils.getInstance().JumpTo(getActivity(), NotifyListActivity.class);
                break;
            case R.id.ll_fault_notifi:
                CutToUtils.getInstance().JumpTo(getActivity(), FaultNotifiActivity.class);
                break;
            case R.id.image_weather:
                CutToUtils.getInstance().JumpTo(getActivity(), EnvironmentActivity.class);
                break;
            case R.id.view_right:
                CutToUtils.getInstance().JumpTo(getActivity(), TaskListActivity.class);

                break;
        }
    }

    /**
     * 获取通知
     */
    private void getNotify() {
        EasyHttp.get(AppUrl.NewsList)
                .syncRequest(false)
                .params("pageNum", "1")
                .params("pageSize", "5")
                .params("target", "innerAnnounce")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        NotifyListBean notifyListBean = JSON.parseObject(s, NotifyListBean.class);
                        if (notifyListBean.isSuccess()) {
                            tv_inform_one.setText(notifyListBean.getData().getRecords().get(0).getTitle());
                            tv_inform_two.setText(notifyListBean.getData().getRecords().get(1).getTitle());
                        }
                    }
                });
    }

    /**
     * 获取与我相关任务
     */
    private void getMyProcess() {
        EasyHttp.get(AppUrl.MyProcess)
                .headers("Admin-Token", mmkv.decodeString("token"))
                .params("type", "0")
                .params("page", "1")
                .params("size", "5")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        //orderType  0报修 1 投诉 2 设备维护
                        HomeTaskBean homeTaskBean = JSON.parseObject(s, HomeTaskBean.class);
                        if (homeTaskBean.isSuccess()) {
                            homeTaskBeanList.clear();
                            homeTaskBeanList.addAll(homeTaskBean.getData());
                            homeTaskAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }

    /**
     * 获取我的信息
     */

    private void getUserInfo() {
        EasyHttp.get(AppUrl.UserInfo)
                .headers("Admin-Token", mmkv.decodeString("token"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        Log.e("fhxx", s);
                        UserInfoBean userInfoBean = JSON.parseObject(s, UserInfoBean.class);
                        if (userInfoBean.isSuccess()) {
                            UserInfoBean.DataBean data = userInfoBean.getData();
                            mmkv.encode("userType", data.getCurrentUser().getRoleId());
                            mmkv.encode("deptId", data.getDepartment().getDeptId());
                        }
                    }
                });
    }

    /**
     * 开启通知提示弹窗
     */
    CommonDialog notifiDialog;

    private void showNotification() {
        notifiDialog = new CommonDialog(getContext());
        notifiDialog.setImageResId(-1)
                .setTitle("系统提示")
                .setSingle(false)
                .setMessage("为了您更好的体验，请允许打开通知，谢谢配合。")
                .setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
                    @Override
                    public void onPositiveClick() {
                        NotificationUtil notificationUtil = new NotificationUtil();
                        notificationUtil.goToNotificationSetting(getContext());
                    }

                    @Override
                    public void onNegtiveClick() {
                        notifiDialog.dismiss();
                    }
                });
    }

}
