package com.fhx.property.activity.mine;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.AbnormalAdapter;
import com.fhx.property.adapter.MonthChooseAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.AbnormalBean;
import com.fhx.property.bean.ChooseBean;
import com.fhx.property.utils.TitleDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * 考勤统计
 */
public class RecordCheckActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageLeft;
    private TextView tv_abnormal;
    private RecyclerView recycle_month;
    private MonthChooseAdapter chooseAdapter;
    private List<ChooseBean> chooseBeanList =new ArrayList<>();
    private TitleDialog titleDialog;

    @Override
    protected int initLayout() {
        return R.layout.activity_record_check;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        recycle_month = (RecyclerView) findViewById(R.id.recycle_month);
        tv_abnormal = (TextView) findViewById(R.id.tv_abnormal);
    }

    @Override
    protected void initData() {
        chooseBeanList.add(new ChooseBean("一月",0));
        chooseBeanList.add(new ChooseBean("二月",0));
        chooseBeanList.add(new ChooseBean("三月",0));
        chooseBeanList.add(new ChooseBean("四月",0));
        chooseBeanList.add(new ChooseBean("五月",0));
        chooseBeanList.add(new ChooseBean("六月",0));
        chooseBeanList.add(new ChooseBean("七月",0));
        chooseBeanList.add(new ChooseBean("八月",0));
        chooseBeanList.add(new ChooseBean("九月",0));
        chooseBeanList.add(new ChooseBean("十月",0));
        chooseBeanList.add(new ChooseBean("十一月",0));
        chooseBeanList.add(new ChooseBean("十二月",1));

        chooseAdapter =new MonthChooseAdapter(chooseBeanList);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycle_month.setLayoutManager(layout);
        recycle_month.setAdapter(chooseAdapter);
        for (int i = 0; i < chooseBeanList.size(); i++) {
            if (chooseBeanList.get(i).getIsChoose()==1){
                Log.e("fhxx","选中了"+i);
                recycle_month.scrollToPosition(i);
            }
        }
    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        tv_abnormal.setOnClickListener(this);


        chooseAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                for (int i = 0; i < chooseBeanList.size(); i++) {
                    chooseBeanList.get(i).setIsChoose(0);
                }
                chooseBeanList.get(position).setIsChoose(1);
                chooseAdapter.notifyDataSetChanged();
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
            case R.id.tv_abnormal:
                ShowDialog();
                break;
        }
    }

    private AbnormalAdapter abnormalAdapter;
    private List<AbnormalBean> abnormalBeans =new ArrayList<>();
    private void ShowDialog(){
        titleDialog = new TitleDialog(RecordCheckActivity.this, R.layout.dialog_abnormal);
        titleDialog.show();
        ImageView image_close = titleDialog.findViewById(R.id.image_close);
        RecyclerView recycle_record = titleDialog.findViewById(R.id.recycle_record);

        abnormalBeans.add(new AbnormalBean("缺卡","2020-08-12 09:00"));
        abnormalBeans.add(new AbnormalBean("早退","2020-08-12 09:00"));
        abnormalBeans.add(new AbnormalBean("外勤","2020-08-12 09:00"));
        abnormalAdapter =new AbnormalAdapter(abnormalBeans);
        recycle_record.setLayoutManager(new LinearLayoutManager(this));
        recycle_record.setAdapter(abnormalAdapter);
        image_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleDialog.dismiss();
            }
        });
    }

}
