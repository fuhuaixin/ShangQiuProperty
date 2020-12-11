package com.fhx.property.activity.mine;

import android.app.DatePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.utils.CutToUtils;
import com.fhx.property.utils.ListDialog;
import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citypickerview.CityPickerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 修改个人信息
 */
public class ChangeDetailsActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageLeft;
    private TextView tvTitle;
    private LinearLayout ll_birthday, ll_sex, ll_phone, ll_area, ll_header;
    private TextView tv_birthday, tv_sex, tv_phone, tv_area;

    private ListDialog listDialog;
    private CityPickerView cityPickerView;
    private CityConfig config;
    private Calendar c;//获取当前时间

    @Override
    protected int initLayout() {
        return R.layout.activity_change_details;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_birthday = (TextView) findViewById(R.id.tv_birthday);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        tv_area = (TextView) findViewById(R.id.tv_area);
        ll_birthday = (LinearLayout) findViewById(R.id.ll_birthday);
        ll_sex = (LinearLayout) findViewById(R.id.ll_sex);
        ll_phone = (LinearLayout) findViewById(R.id.ll_phone);
        ll_area = (LinearLayout) findViewById(R.id.ll_area);
        ll_header = (LinearLayout) findViewById(R.id.ll_header);
    }

    @Override
    protected void initData() {
        c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());

        tvTitle.setText("个人信息");
        cityPickerView = new CityPickerView();
        cityPickerView.init(this);
        setArea();
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        ll_birthday.setOnClickListener(this);
        ll_sex.setOnClickListener(this);
        ll_phone.setOnClickListener(this);
        ll_area.setOnClickListener(this);
        ll_header.setOnClickListener(this);

        cityPickerView.setOnCityItemClickListener(new OnCityItemClickListener() {
            @Override
            public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                super.onSelected(province, city, district);
                tv_area.setText(province + "-" + city + "-" + district);
            }

            @Override
            public void onCancel() {
                super.onCancel();
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
            case R.id.ll_birthday:
                int year = c.get(Calendar.YEAR);
                int mouth = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                //修改颜色使用 R.style.MyDatePickerDialogTheme
                DatePickerDialog datePickerDialog = new DatePickerDialog(ChangeDetailsActivity.this, DatePickerDialog.THEME_DEVICE_DEFAULT_LIGHT, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String mMonth = null;
                        String day = null;
                        if (month < 9) {
                            mMonth = "0" + (month + 1);
                        } else {
                            mMonth = String.valueOf((month + 1));
                        }
                        if (dayOfMonth < 10) {
                            day = "0" + dayOfMonth;
                        } else {
                            day = String.valueOf(dayOfMonth);
                        }
                        tv_birthday.setText(year + "-" + mMonth + "-" + day);
                    }
                }, year, mouth, day);
                datePickerDialog.show();
                break;
            case R.id.ll_sex:

                setSex(2);//设置性别

                listDialog.show();
                break;
            case R.id.ll_phone:
                CutToUtils.getInstance().JumpTo(ChangeDetailsActivity.this, ChangeNumberActivity.class);
                break;

            case R.id.ll_area:
                //添加配置
                cityPickerView.setConfig(config);
                //显示
                cityPickerView.showCityPicker();
                break;
            case R.id.ll_header:

                setSex(1);//设置头像
                listDialog.show();
                break;

        }
    }


    private void setSex(final int i) {
        final List<String> mList = new ArrayList<>();
        if (i == 1) {
            mList.add("相机");
            mList.add("选择照片");
        } else if (i == 2) {
            mList.add("男");
            mList.add("女");
            mList.add("保密");
        }
        listDialog = new ListDialog(ChangeDetailsActivity.this, mList, new ListDialog.LeaveMyDialogListener() {
            @Override
            public void onClick(BaseQuickAdapter adapter, View view, int position) {
                if (i == 1) {
                    ToastShort(mList.get(position));
                } else if (i == 2) {
                    tv_sex.setText(mList.get(position));
                }
                listDialog.dismiss();
            }
        });

    }

    private void setArea() {
        config = new CityConfig.Builder()
                .title("选择地区")//标题
                .titleTextSize(20)//标题文字大小
                .titleTextColor("#333333")//标题文字颜  色
                .titleBackgroundColor("#ffffff")//标题栏背景色
                .confirTextColor("#666666")//确认按钮文字颜色
                .confirmText("确定")//确认按钮文字
                .confirmTextSize(16)//确认按钮文字大小
                .cancelTextColor("#666666")//取消按钮文字颜色
                .cancelText("取消")//取消按钮文字
                .cancelTextSize(16)//取消按钮文字大小
                .setCityWheelType(CityConfig.WheelType.PRO_CITY_DIS)//显示类，只显示省份一级，显示省市两级还是显示省市区三级
                .showBackground(true)//是否显示半透明背景
                .visibleItemsCount(5)//显示item的数量
                .province("河南省")//默认显示的省份
                .city("郑州市")//默认显示省份下面的城市
                .district("金水区")//默认显示省市下面的区县数据
                .provinceCyclic(false)//省份滚轮是否可以循环滚动
                .cityCyclic(false)//城市滚轮是否可以循环滚动
                .districtCyclic(false)//区县滚轮是否循环滚动
                .setCustomItemLayout(R.layout.item_city)//自定义item的布局
                .setCustomItemTextViewId(R.id.item_city_name_tv)//自定义item布局里面的textViewid
                .drawShadows(true)//滚轮不显示模糊效果
                .setLineColor("#f2f2f2")//中间横线的颜色
                .setLineHeigh(2)//中间横线的高度
                .setShowGAT(true)//是否显示港澳台数据，默认不显示
                .build();

    }
}
