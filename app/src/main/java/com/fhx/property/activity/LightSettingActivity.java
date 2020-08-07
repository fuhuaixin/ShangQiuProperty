package com.fhx.property.activity;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.EquBroadBean;

/**
 * 灯光设置
 */
public class LightSettingActivity extends BaseActivity implements View.OnClickListener{

    private ImageView imageRight;
    private ImageView imageLeft;
    private TextView tvTitle;
    private EquBroadBean equBroadBean;


    @Override
    protected int initLayout() {
        return R.layout.activity_light_setting;
    }

    @Override
    protected void initView() {
        imageRight = (ImageView) findViewById(R.id.image_right);
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
    }

    @Override
    protected void initData() {
        equBroadBean = (EquBroadBean) getIntent().getSerializableExtra("bean");
        tvTitle.setText(equBroadBean.getTitle());
        imageRight.setVisibility(View.VISIBLE);
        imageRight.setImageResource(R.mipmap.icon_title_right_more);
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        imageRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.image_right:
                ShowMenu(imageRight);
                break;
        }
    }


    /**
     * 弹出窗
     */

    private void ShowMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(LightSettingActivity.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.record:
                        ToastShort("点击了record");
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }
}
