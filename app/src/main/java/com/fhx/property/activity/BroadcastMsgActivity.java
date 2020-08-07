package com.fhx.property.activity;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fhx.property.R;
import com.fhx.property.adapter.BroadMSgAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.BroadMsgBean;
import com.fhx.property.bean.EquBroadBean;
import com.fhx.property.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 音乐 广播详情
 */
public class BroadcastMsgActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageRight;
    private ImageView imageLeft;
    private ImageView image_swith;
    private TextView tvTitle;
    private TextView tv_broad_type;
    private TextView tv_broad_title;
    private TextView tv_add_temp;
    private EquBroadBean equBroadBean;
    private RecyclerView recycle_temporary;
    private BroadMSgAdapter broadMSgAdapter;
    private List<BroadMsgBean> beanList = new ArrayList<>();
    private List<String> repetitionList = new ArrayList<>();

    private int swith = 0;

    @Override
    protected int initLayout() {
        return R.layout.activity_broadcast_msg;
    }

    @Override
    protected void initView() {
        imageRight = (ImageView) findViewById(R.id.image_right);
        imageLeft = (ImageView) findViewById(R.id.image_left);
        image_swith = (ImageView) findViewById(R.id.image_swith);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_add_temp = (TextView) findViewById(R.id.tv_add_temp);
        tv_broad_type = (TextView) findViewById(R.id.tv_broad_type);
        tv_broad_title = (TextView) findViewById(R.id.tv_broad_title);
        recycle_temporary = (RecyclerView) findViewById(R.id.recycle_temporary);
    }

    @Override
    protected void initData() {
        equBroadBean = (EquBroadBean) getIntent().getSerializableExtra("bean");

        tvTitle.setText(equBroadBean.getTitle());

        imageRight.setVisibility(View.VISIBLE);
        imageRight.setImageResource(R.mipmap.icon_title_right_more);

        if (equBroadBean.getStatus() == 0) {
            image_swith.setImageResource(R.mipmap.icon_swith_unsel);
            swith = 0;
        } else {
            image_swith.setImageResource(R.mipmap.image_switch_sel);
            swith = 1;
        }

        tv_broad_type.setText(equBroadBean.getTitle() + "type");
        tv_broad_title.setText(equBroadBean.getMusic());

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
        recycle_temporary.setLayoutManager(new LinearLayoutManager(this));
        recycle_temporary.setAdapter(broadMSgAdapter);

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
                ShowMenu(BroadcastMsgActivity.this,imageRight);
                break;
            case R.id.tv_add_temp:
                CutToUtils.getInstance().JumpTo(BroadcastMsgActivity.this, BroadTempActivity.class);
                break;
        }
    }


}
