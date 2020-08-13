package com.fhx.property.activity;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.core.widget.NestedScrollView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.CarManageBean;

/**
 * 车辆详情
 */
public class CarMsgActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageLeft, imageRight;
    private TextView tv_title, tv_car_number;
    private View view_title;
    private NestedScrollView nested;
    private CarManageBean manageBean;

    @Override
    protected int initLayout() {
        return R.layout.activity_car_msg;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        imageRight = (ImageView) findViewById(R.id.image_right);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_car_number = (TextView) findViewById(R.id.tv_car_number);
        view_title = findViewById(R.id.view_title);
        nested = (NestedScrollView) findViewById(R.id.nested);
    }

    @Override
    protected void initData() {
        manageBean = (CarManageBean) getIntent().getSerializableExtra("bean");
        tv_title.setText("车辆详情");
        tv_car_number.setText(manageBean.getCarNum());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.image_right:
                ShowMenu(imageRight);
                break;
        }
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        imageRight.setOnClickListener(this);
        nestListen();
    }

    /**
     * 弹出窗
     */

    private void ShowMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(CarMsgActivity.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_lease, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.lease:
                        ToastShort("lease");
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }


    private void nestListen() {
        nested.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                imageLeft.setImageResource(R.mipmap.icon_back_all_white);
                imageRight.setImageResource(R.mipmap.icon_title_right_more_white);
                tv_title.setTextColor(getResources().getColor(R.color.white));
                if (scrollY == 0) {
                    view_title.setAlpha(0);
                } else if (scrollY > 0 && scrollY < 10) {
                    view_title.setAlpha(0.01f);
                } else if (scrollY > 10 && scrollY < 20) {
                    view_title.setAlpha(0.02f);
                } else if (scrollY > 20 && scrollY < 30) {
                    view_title.setAlpha(0.03f);
                } else if (scrollY > 30 && scrollY < 40) {
                    view_title.setAlpha(0.04f);
                } else if (scrollY > 40 && scrollY < 50) {
                    view_title.setAlpha(0.05f);
                } else if (scrollY > 50 && scrollY < 60) {
                    view_title.setAlpha(0.06f);
                } else if (scrollY > 60 && scrollY < 70) {
                    view_title.setAlpha(0.07f);
                } else if (scrollY > 70 && scrollY < 80) {
                    view_title.setAlpha(0.08f);
                } else if (scrollY > 80 && scrollY < 90) {
                    view_title.setAlpha(0.09f);
                } else if (scrollY > 90 && scrollY < 100) {
                    view_title.setAlpha(0.1f);
                } else if (scrollY > 100 && scrollY < 110) {
                    view_title.setAlpha(0.11f);
                } else if (scrollY > 110 && scrollY < 120) {
                    view_title.setAlpha(0.12f);
                } else if (scrollY > 120 && scrollY < 130) {
                    view_title.setAlpha(0.13f);
                } else if (scrollY > 130 && scrollY < 140) {
                    view_title.setAlpha(0.14f);
                } else if (scrollY > 140 && scrollY < 150) {
                    view_title.setAlpha(0.15f);
                } else if (scrollY > 150 && scrollY < 160) {
                    view_title.setAlpha(0.16f);
                } else if (scrollY > 160 && scrollY < 170) {
                    view_title.setAlpha(0.17f);
                } else if (scrollY > 170 && scrollY < 180) {
                    view_title.setAlpha(0.18f);
                } else if (scrollY > 180 && scrollY < 190) {
                    view_title.setAlpha(0.19f);
                } else if (scrollY > 190 && scrollY < 200) {
                    view_title.setAlpha(0.2f);
                } else if (scrollY > 200 && scrollY < 210) {
                    view_title.setAlpha(0.21f);
                } else if (scrollY > 210 && scrollY < 220) {
                    view_title.setAlpha(0.22f);
                } else if (scrollY > 220 && scrollY < 230) {
                    view_title.setAlpha(0.23f);
                } else if (scrollY > 230 && scrollY < 240) {
                    view_title.setAlpha(0.24f);
                } else if (scrollY > 240 && scrollY < 250) {
                    view_title.setAlpha(0.25f);
                } else if (scrollY > 250 && scrollY < 260) {
                    view_title.setAlpha(0.26f);
                } else if (scrollY > 260 && scrollY < 270) {
                    view_title.setAlpha(0.27f);
                } else if (scrollY > 270 && scrollY < 280) {
                    view_title.setAlpha(0.28f);
                } else if (scrollY > 280 && scrollY < 290) {
                    view_title.setAlpha(0.29f);
                } else if (scrollY > 290 && scrollY < 300) {
                    view_title.setAlpha(0.3f);
                } else if (scrollY > 300 && scrollY < 310) {
                    view_title.setAlpha(0.31f);
                } else if (scrollY > 310 && scrollY < 320) {
                    view_title.setAlpha(0.32f);
                } else if (scrollY > 320 && scrollY < 330) {
                    view_title.setAlpha(0.33f);
                } else if (scrollY > 330 && scrollY < 340) {
                    view_title.setAlpha(0.34f);
                } else if (scrollY > 340 && scrollY < 350) {
                    view_title.setAlpha(0.35f);
                } else if (scrollY > 350 && scrollY < 360) {
                    view_title.setAlpha(0.36f);
                } else if (scrollY > 360 && scrollY < 370) {
                    view_title.setAlpha(0.37f);
                } else if (scrollY > 370 && scrollY < 380) {
                    view_title.setAlpha(0.38f);
                } else if (scrollY > 380 && scrollY < 390) {
                    view_title.setAlpha(0.39f);
                } else if (scrollY > 390 && scrollY < 400) {
                    view_title.setAlpha(0.4f);
                } else if (scrollY > 400 && scrollY < 410) {
                    view_title.setAlpha(0.41f);
                } else if (scrollY > 410 && scrollY < 420) {
                    view_title.setAlpha(0.42f);
                } else if (scrollY > 420 && scrollY < 430) {
                    view_title.setAlpha(0.43f);
                } else if (scrollY > 430 && scrollY < 440) {
                    view_title.setAlpha(0.44f);
                } else if (scrollY > 440 && scrollY < 450) {
                    view_title.setAlpha(0.45f);
                } else if (scrollY > 450 && scrollY < 460) {
                    view_title.setAlpha(0.46f);
                } else if (scrollY > 460 && scrollY < 470) {
                    view_title.setAlpha(0.47f);
                } else if (scrollY > 470 && scrollY < 480) {
                    view_title.setAlpha(0.48f);
                } else if (scrollY > 480 && scrollY < 490) {
                    view_title.setAlpha(0.49f);
                } else if (scrollY > 490 && scrollY < 500) {
                    view_title.setAlpha(0.5f);
                } else if (scrollY > 500 && scrollY < 510) {
                    view_title.setAlpha(0.51f);
                } else if (scrollY > 510 && scrollY < 520) {
                    view_title.setAlpha(0.52f);
                } else if (scrollY > 520 && scrollY < 530) {
                    view_title.setAlpha(0.53f);
                } else if (scrollY > 530 && scrollY < 540) {
                    view_title.setAlpha(0.54f);
                } else if (scrollY > 540 && scrollY < 550) {
                    view_title.setAlpha(0.55f);
                } else if (scrollY > 550 && scrollY < 560) {
                    view_title.setAlpha(0.56f);
                } else if (scrollY > 560 && scrollY < 570) {
                    view_title.setAlpha(0.57f);
                } else if (scrollY > 570 && scrollY < 580) {
                    view_title.setAlpha(0.58f);
                } else if (scrollY > 580 && scrollY < 590) {
                    view_title.setAlpha(0.59f);
                } else if (scrollY > 590 && scrollY < 600) {
                    view_title.setAlpha(0.6f);
                } else if (scrollY > 600 && scrollY < 610) {
                    view_title.setAlpha(0.61f);
                } else if (scrollY > 610 && scrollY < 620) {
                    view_title.setAlpha(0.62f);
                } else if (scrollY > 620 && scrollY < 630) {
                    view_title.setAlpha(0.63f);
                } else if (scrollY > 630 && scrollY < 640) {
                    view_title.setAlpha(0.64f);
                } else if (scrollY > 640 && scrollY < 650) {
                    view_title.setAlpha(0.65f);
                } else if (scrollY > 650 && scrollY < 660) {
                    view_title.setAlpha(0.66f);
                } else if (scrollY > 660 && scrollY < 670) {
                    view_title.setAlpha(0.67f);
                } else if (scrollY > 670 && scrollY < 680) {
                    view_title.setAlpha(0.68f);
                } else if (scrollY > 680 && scrollY < 690) {
                    view_title.setAlpha(0.69f);
                } else if (scrollY > 690 && scrollY < 700) {
                    view_title.setAlpha(0.7f);
                } else if (scrollY > 700 && scrollY < 710) {
                    view_title.setAlpha(0.71f);
                } else if (scrollY > 710 && scrollY < 720) {
                    view_title.setAlpha(0.72f);
                } else if (scrollY > 720 && scrollY < 730) {
                    view_title.setAlpha(0.73f);
                } else if (scrollY > 730 && scrollY < 740) {
                    view_title.setAlpha(0.74f);
                } else if (scrollY > 740 && scrollY < 750) {
                    view_title.setAlpha(0.75f);
                } else if (scrollY > 750 && scrollY < 760) {
                    view_title.setAlpha(0.76f);
                } else if (scrollY > 760 && scrollY < 770) {
                    view_title.setAlpha(0.77f);
                } else if (scrollY > 770 && scrollY < 780) {
                    view_title.setAlpha(0.78f);
                } else if (scrollY > 780 && scrollY < 790) {
                    view_title.setAlpha(0.79f);
                } else if (scrollY > 790 && scrollY < 800) {
                    view_title.setAlpha(0.8f);
                } else if (scrollY > 800) {
                    view_title.setAlpha(1);
                    imageLeft.setImageResource(R.mipmap.icon_back_all);
                    imageRight.setImageResource(R.mipmap.icon_title_right_more);
                    tv_title.setTextColor(getResources().getColor(R.color.tv333));
                }

                Log.e("fhxxx", "scrollX =" + scrollX + "\n scrollY=" + scrollY + "\n oldScrollX=" + oldScrollX + "\n oldScrollY =" + oldScrollY);
            }
        });
    }
}
