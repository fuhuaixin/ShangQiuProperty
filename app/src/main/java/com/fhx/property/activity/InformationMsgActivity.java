package com.fhx.property.activity;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fhx.property.R;
import com.fhx.property.adapter.BroadMSgAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.BroadMsgBean;
import com.fhx.property.bean.InformationBean;
import com.fhx.property.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 信息发布设备管理
 */
public class InformationMsgActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageRight;
    private ImageView imageLeft;
    private TextView tvTitle;
    private TextView tv_add_temp;
    private ImageView image_swith;
    private RecyclerView recycle_information;

    private InformationBean informationBean;
    private BroadMSgAdapter broadMSgAdapter;
    private List<BroadMsgBean> beanList = new ArrayList<>();
    private List<String> repetitionList = new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_information_msg;
    }

    @Override
    protected void initView() {
        imageRight = (ImageView) findViewById(R.id.image_right);
        imageLeft = (ImageView) findViewById(R.id.image_left);
        image_swith = (ImageView) findViewById(R.id.image_swith);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_add_temp = (TextView) findViewById(R.id.tv_add_temp);
        recycle_information = (RecyclerView) findViewById(R.id.recycle_information);
    }

    @Override
    protected void initData() {
        informationBean = (InformationBean) getIntent().getSerializableExtra("bean");
        tvTitle.setText(informationBean.getTitle());
        if (informationBean.getStatus() == 0) {
            image_swith.setImageResource(R.mipmap.icon_swith_unsel);
        } else {
            image_swith.setImageResource(R.mipmap.image_switch_sel);
        }
        repetitionList.add("不重复");
        beanList.add(new BroadMsgBean(0, "类型1", "播放内容1.mp3", "7:00", "8:00", repetitionList));
        repetitionList.clear();
        repetitionList.add("周二");
        repetitionList.add("周三");
        beanList.add(new BroadMsgBean(1, "类型2", "播放内容2.mp3", "7:00", "8:00", repetitionList));
        repetitionList.clear();
        repetitionList.add("周二");
        repetitionList.add("周三");
        repetitionList.add("周四");
        beanList.add(new BroadMsgBean(0, "类型3", "播放内容3.mp3", "7:00", "8:00", repetitionList));


        broadMSgAdapter = new BroadMSgAdapter(beanList);
        recycle_information.setLayoutManager(new LinearLayoutManager(this));
        recycle_information.setAdapter(broadMSgAdapter);
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        imageRight.setOnClickListener(this);
        tv_add_temp.setOnClickListener(this);
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
            case R.id.tv_add_temp:
                CutToUtils.getInstance().JumpTo(InformationMsgActivity.this, InformationTempActivity.class);
                break;
        }
    }


    /**
     * 弹出窗
     */

    private void ShowMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(InformationMsgActivity.this, view);
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
