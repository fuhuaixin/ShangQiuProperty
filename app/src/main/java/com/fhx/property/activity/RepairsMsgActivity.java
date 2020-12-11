package com.fhx.property.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.fhx.property.R;
import com.fhx.property.adapter.RepairsMsgImageAdapter;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.EvaMsgBean;
import com.fhx.property.bean.RepairsCommitBean;
import com.fhx.property.bean.RepairsMSgBean;
import com.fhx.property.bean.SuccessBean;
import com.fhx.property.utils.CutToUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

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
    private TextView tv_evaluate,tv_repair_name,tv_repair_phone,tv_reserve_time;
    private ImageView image_ing;
    private ImageView image_finish;
    private View view_ing;
    private View view_finish;
    private LinearLayout ll_evaluate;
    private LinearLayout ll_no_evaluate;
    private LinearLayout ll_revocation;
    private LinearLayout ll_repairs_man;
    private RecyclerView recycle_image;
    private RatingBar ratingBar_finish;
    private TextView tv_eva_finish;


    private RepairsMsgImageAdapter imageAdapter;
    private List<String> imageList = new ArrayList<>();
    private String repairId;
    private RepairsMSgBean.DataBean data;
    @Override
    protected int initLayout() {
        return R.layout.activity_repairs_msg;
    }

    @Override
    protected void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_ing = (TextView) findViewById(R.id.tv_ing);
        tv_msg = (TextView) findViewById(R.id.tv_msg);
        tv_repair_name = (TextView) findViewById(R.id.tv_repair_name);
        tv_repair_phone = (TextView) findViewById(R.id.tv_repair_phone);
        tv_reserve_time = (TextView) findViewById(R.id.tv_reserve_time);
        tv_evaluate = (TextView) findViewById(R.id.tv_evaluate);
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
        ratingBar_finish = (RatingBar) findViewById(R.id.ratingBar_finish);
        tv_eva_finish = (TextView) findViewById(R.id.tv_eva_finish);
    }

    @Override
    protected void onResume() {
        super.onResume();
        repairId = getIntent().getStringExtra("jumpOne");


        imageAdapter = new RepairsMsgImageAdapter(imageList);
        recycle_image.setLayoutManager(new GridLayoutManager(this, 3));
        recycle_image.setAdapter(imageAdapter);

        getDetails();

    }

    @Override
    protected void initData() {
        tvTitle.setText("报修详情");

    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        ll_no_evaluate.setOnClickListener(this);
        tv_evaluate.setOnClickListener(this);
        ll_revocation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.ll_no_evaluate:
                break;
            case R.id.tv_evaluate:
                if (data.getSelf().getCustomerId() != null && data.getSelf().getCustomerId().equals(mmkv.decodeString("userId"))) {
                    CutToUtils.getInstance().JumpToOne(RepairsMsgActivity.this, RepairsMsgEvaActivity.class, data.getSelf().getRepairId());
                } else {
                    ToastShort("只可评价自己发起的报修");
                }
                break;
            case R.id.ll_revocation: //撤回
                cancle(data.getSelf().getRepairId());
                break;
        }
    }

    /**
     * 状态的判断
     *
     * @param i
     */
    private void Status(String i) {
        switch (i) {
            case "1":
                if (data.getSelf().getCustomerId().equals(mmkv.decodeString("userId"))) {
                    ll_revocation.setVisibility(View.VISIBLE);
                }
                tv_ing.setTextColor(getResources().getColor(R.color.tvaaa));
                tv_finish.setTextColor(getResources().getColor(R.color.tvaaa));
                image_ing.setImageResource(R.mipmap.icon_repairs_msg_ing);
                image_finish.setImageResource(R.mipmap.icon_repairs_finish);
                view_ing.setBackgroundResource(R.color.tvaaa);
                view_finish.setBackgroundResource(R.color.tvaaa);
                ll_evaluate.setVisibility(View.GONE);
                break;
            case "2":
            case "3":
                tv_ing.setTextColor(getResources().getColor(R.color.col_repairs_blue));
                tv_finish.setTextColor(getResources().getColor(R.color.tvaaa));
                image_ing.setImageResource(R.mipmap.icon_repairs_msg_ing_sel);
                image_finish.setImageResource(R.mipmap.icon_repairs_finish);
                view_ing.setBackgroundResource(R.color.col_repairs_blue);
                view_finish.setBackgroundResource(R.color.tvaaa);
                ll_evaluate.setVisibility(View.GONE);
                ll_repairs_man.setVisibility(View.VISIBLE);
                break;
            case "0":
                tv_ing.setTextColor(getResources().getColor(R.color.col_repairs_blue));
                tv_finish.setTextColor(getResources().getColor(R.color.col_repairs_blue));
                tv_finish.setText("已撤回");
                image_ing.setImageResource(R.mipmap.icon_repairs_msg_ing_sel);
                image_finish.setImageResource(R.mipmap.icon_repairs_finish_sel);
                view_ing.setBackgroundResource(R.color.col_repairs_blue);
                view_finish.setBackgroundResource(R.color.col_repairs_blue);
                break;
            case "4":
                ll_no_evaluate.setVisibility(View.VISIBLE);
                ll_repairs_man.setVisibility(View.VISIBLE);
                tv_ing.setTextColor(getResources().getColor(R.color.col_repairs_blue));
                tv_finish.setTextColor(getResources().getColor(R.color.col_repairs_blue));
                image_ing.setImageResource(R.mipmap.icon_repairs_msg_ing_sel);
                image_finish.setImageResource(R.mipmap.icon_repairs_finish_sel);
                view_ing.setBackgroundResource(R.color.col_repairs_blue);
                view_finish.setBackgroundResource(R.color.col_repairs_blue);
                break;
            case "5":
                ll_evaluate.setVisibility(View.VISIBLE);
                ll_repairs_man.setVisibility(View.VISIBLE);
                ll_no_evaluate.setVisibility(View.GONE);
                tv_ing.setTextColor(getResources().getColor(R.color.col_repairs_blue));
                tv_finish.setTextColor(getResources().getColor(R.color.col_repairs_blue));
                image_ing.setImageResource(R.mipmap.icon_repairs_msg_ing_sel);
                image_finish.setImageResource(R.mipmap.icon_repairs_finish_sel);
                view_ing.setBackgroundResource(R.color.col_repairs_blue);
                view_finish.setBackgroundResource(R.color.col_repairs_blue);
                getEvaMsg(data.getSelf().getRepairId());
                break;
        }
    }

    /**
     * 根据id查询详情
     */


    private void getDetails(){
        EasyHttp.get(AppUrl.RepairDetail)
                .params("id",repairId)
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        RepairsMSgBean repairsMSgBean = JSON.parseObject(s, RepairsMSgBean.class);
                        if (repairsMSgBean.isSuccess()){
                            data = repairsMSgBean.getData();
                            Status(data.getSelf().getStatus());
                            tv_msg.setText(data.getSelf().getContent());
                            tv_repair_name.setText(data.getSelf().getCustomerName());
                            tv_repair_phone.setText(data.getSelf().getCustomerPhone());
                            tv_reserve_time.setText(data.getSelf().getReserveTime());
                            String imgs = data.getSelf().getImgs();
                            if (imgs!=null&&!imgs.equals("")){
                                String[] split = imgs.split(",");
                                for (int i = 0; i < split.length; i++) {
                                    imageList.add(split[i]);
                                }
                            }
                            imageAdapter.notifyDataSetChanged();

                        }else {

                        }
                    }
                });
    }

    /**
     * 撤回报修
     */
    private void cancle(String id) {
        EasyHttp.put(AppUrl.RepairCancel)
                .syncRequest(false)
                .params("repairId", id)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        SuccessBean successBean = JSON.parseObject(s, SuccessBean.class);
                        if (successBean.isSuccess()) {
                            ToastShort("撤回成功");
                            finish();
                            overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                        } else {
                            ToastShort(successBean.getMsg());
                        }
                    }
                });
    }

    /**
     * 查询评价详情
     */
    private void getEvaMsg(String id) {
        EasyHttp.get(AppUrl.EvaluteGet)
                .syncRequest(false)
                .params("id", id)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        EvaMsgBean evaMsgBean = JSON.parseObject(s, EvaMsgBean.class);
                        if (evaMsgBean.isSuccess()) {
                            if (evaMsgBean.getData()==null){
                                return;
                            }
                            ratingBar_finish.setRating(evaMsgBean.getData().getRateScore());
                            tv_eva_finish.setText(evaMsgBean.getData().getContent());
                        }
                    }
                });
    }
}
