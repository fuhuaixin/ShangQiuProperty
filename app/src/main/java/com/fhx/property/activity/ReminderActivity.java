package com.fhx.property.activity;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.ReminderListAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.ReminderListBean;
import com.fhx.property.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 催缴列表
 */
public class ReminderActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageLeft,imageRight;
    private TextView tvTitle;
    private RecyclerView recycle_reminder;

    private ReminderListAdapter adapter;

    private List<ReminderListBean> mList = new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_reminder;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        imageRight = (ImageView) findViewById(R.id.image_right);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recycle_reminder = (RecyclerView) findViewById(R.id.recycle_reminder);
    }

    @Override
    protected void initData() {
        tvTitle.setText("费用催缴");
        imageRight.setVisibility(View.VISIBLE);
        imageRight.setImageResource(R.mipmap.icon_title_right_more);
        for (int i = 0; i < 5; i++) {
            if (i%2==0){
                mList.add(new ReminderListBean("标题"+i,"￥"+2000+i,"房号：room"+i,0));
            }else {
                mList.add(new ReminderListBean("标题"+i,"￥"+2000+i,"房号：room"+i,1));
            }
        }
        adapter =new ReminderListAdapter(mList);

        recycle_reminder.setLayoutManager(new LinearLayoutManager(this));
        recycle_reminder.setAdapter(adapter);

    }

    @Override
    protected void initListen() {
        imageRight.setOnClickListener(this);
        imageLeft.setOnClickListener(this);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.ll_item:
                        CutToUtils.getInstance().JumpTo(ReminderActivity.this,ReminderMsgActivity.class);
                        break;
                    case R.id.tv_pay:
                        if (mList.get(position).getIsPay()==0){
                            ToastShort("催缴");
                        }
                        break;
                }
            }
        });
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
        PopupMenu popupMenu = new PopupMenu(ReminderActivity.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_reminder, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.reminder:
                        ToastShort("点击了reminder");
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }
}
