package com.fhx.property.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fhx.property.R;
import com.fhx.property.adapter.RepairsMsgImageAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.RepairsCommitBean;
import com.fhx.property.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 报修详情
 */
public class RepairsMsgActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvTitle;
    private ImageView imageLeft;

    private TextView tv_ing;
    private TextView tv_finish;
    private TextView tv_msg;
    private ImageView image_ing;
    private ImageView image_finish;
    private View view_ing;
    private View view_finish;
    private LinearLayout ll_evaluate;
    private LinearLayout ll_no_evaluate;
    private LinearLayout ll_revocation;
    private LinearLayout ll_repairs_man;
    private RecyclerView recycle_image;


    private RepairsMsgImageAdapter imageAdapter;
    private List<String> imageList = new ArrayList<>();
    private RepairsCommitBean repairsCommitBean;

    @Override
    protected int initLayout() {
        return R.layout.activity_repairs_msg;
    }

    @Override
    protected void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_ing = (TextView) findViewById(R.id.tv_ing);
        tv_msg = (TextView) findViewById(R.id.tv_msg);
        tv_finish = (TextView) findViewById(R.id.tv_finish);
        imageLeft = (ImageView) findViewById(R.id.image_left);
        image_ing = (ImageView) findViewById(R.id.image_ing);
        image_finish = (ImageView) findViewById(R.id.image_finish);
        view_ing = findViewById(R.id.view_ing);
        view_finish = findViewById(R.id.view_finish);
        ll_evaluate = (LinearLayout) findViewById(R.id.ll_evaluate);
        ll_no_evaluate = (LinearLayout) findViewById(R.id.ll_no_evaluate);
        ll_revocation = (LinearLayout) findViewById(R.id.ll_revocation);
        ll_repairs_man = (LinearLayout) findViewById(R.id.ll_repairs_man);
        recycle_image = (RecyclerView) findViewById(R.id.recycle_image);
    }

    @Override
    protected void initData() {
        tvTitle.setText("报修详情");

        repairsCommitBean = (RepairsCommitBean) getIntent().getSerializableExtra("bean");
        Log.e("fhxx",repairsCommitBean.getMsg()+repairsCommitBean.getType());

        Status(repairsCommitBean.getStatus());
        tv_msg.setText(repairsCommitBean.getMsg());
        imageList.add("https://iknow-pic.cdn.bcebos.com/fcfaaf51f3deb48f12d46640f21f3a292cf578eb?x-bce-process=image/resize,m_lfit,w_600,h_800,limit_1");
        imageList.add("https://iknow-pic.cdn.bcebos.com/7af40ad162d9f2d3659ee371abec8a136227cca5?x-bce-process=image/resize,m_lfit,w_600,h_800,limit_1");
        imageList.add("https://iknow-pic.cdn.bcebos.com/7af40ad162d9f2d3659ee371abec8a136227cca5?x-bce-process=image/resize,m_lfit,w_600,h_800,limit_1");
        imageAdapter =new RepairsMsgImageAdapter(imageList);
        recycle_image.setLayoutManager(new GridLayoutManager(this,3));
        recycle_image.setAdapter(imageAdapter);

    }

    @Override
    protected void initListen() {

        imageLeft.setOnClickListener(this);
        ll_no_evaluate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation,R.anim.activity_out_to_animation);
                break;
            case R.id.ll_no_evaluate:
                CutToUtils.getInstance().JumpToBean(RepairsMsgActivity.this,RepairsMsgEvaActivity.class,repairsCommitBean);
                break;
        }
    }

    /**
     * 状态的判断
     * @param i
     */
    private void Status(int i){
        switch (i){
            case 1:
                ll_revocation.setVisibility(View.VISIBLE);
                tv_ing.setTextColor(getResources().getColor(R.color.tvaaa));
                tv_finish.setTextColor(getResources().getColor(R.color.tvaaa));
                image_ing.setImageResource(R.mipmap.icon_repairs_msg_ing);
                image_finish.setImageResource(R.mipmap.icon_repairs_finish);
                view_ing.setBackgroundResource(R.color.tvaaa);
                view_finish.setBackgroundResource(R.color.tvaaa);
                ll_evaluate.setVisibility(View.GONE);
                break;
            case 2:
                tv_ing.setTextColor(getResources().getColor(R.color.col_repairs_blue));
                tv_finish.setTextColor(getResources().getColor(R.color.tvaaa));
                image_ing.setImageResource(R.mipmap.icon_repairs_msg_ing_sel);
                image_finish.setImageResource(R.mipmap.icon_repairs_finish);
                view_ing.setBackgroundResource(R.color.col_repairs_blue);
                view_finish.setBackgroundResource(R.color.tvaaa);
                ll_evaluate.setVisibility(View.GONE);
                ll_repairs_man.setVisibility(View.VISIBLE);
                break;
            case 3:
                ll_no_evaluate.setVisibility(View.VISIBLE);
                ll_repairs_man.setVisibility(View.VISIBLE);
                tv_ing.setTextColor(getResources().getColor(R.color.col_repairs_blue));
                tv_finish.setTextColor(getResources().getColor(R.color.col_repairs_blue));
                image_ing.setImageResource(R.mipmap.icon_repairs_msg_ing_sel);
                image_finish.setImageResource(R.mipmap.icon_repairs_finish_sel);
                view_ing.setBackgroundResource(R.color.col_repairs_blue);
                view_finish.setBackgroundResource(R.color.col_repairs_blue);
                break;
            case 4:
                ll_evaluate.setVisibility(View.VISIBLE);
                ll_repairs_man.setVisibility(View.VISIBLE);
                tv_ing.setTextColor(getResources().getColor(R.color.col_repairs_blue));
                tv_finish.setTextColor(getResources().getColor(R.color.col_repairs_blue));
                image_ing.setImageResource(R.mipmap.icon_repairs_msg_ing_sel);
                image_finish.setImageResource(R.mipmap.icon_repairs_finish_sel);
                view_ing.setBackgroundResource(R.color.col_repairs_blue);
                view_finish.setBackgroundResource(R.color.col_repairs_blue);
                break;
        }
    }

}
