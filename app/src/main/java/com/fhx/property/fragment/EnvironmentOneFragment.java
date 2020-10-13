package com.fhx.property.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.fhx.property.R;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseFragment;
import com.fhx.property.bean.EnvironmentListBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.CallBackProxy;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.List;

public class EnvironmentOneFragment extends BaseFragment {
    private ImageView image_shape_one, image_shape_two, image_shape_three;
    private TextView tv_top_title, tv_tem, tv_hum, tv_pm, tv_co, tv_co2;
    private int type;
    private List<EnvironmentListBean.DataBean> data;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_environment;
    }

    public EnvironmentOneFragment(int type) {
        this.type = type;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        tv_top_title = view.findViewById(R.id.tv_top_title);
        image_shape_one = view.findViewById(R.id.image_shape_one);
        image_shape_two = view.findViewById(R.id.image_shape_two);
        image_shape_three = view.findViewById(R.id.image_shape_three);
        tv_tem = view.findViewById(R.id.tv_tem);
        tv_hum = view.findViewById(R.id.tv_hum);
        tv_pm = view.findViewById(R.id.tv_pm);
        tv_co = view.findViewById(R.id.tv_co);
        tv_co2 = view.findViewById(R.id.tv_co2);
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        Http();

    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);

    }

    private void Http() {
        EasyHttp.get(AppUrl.EnvList)
                .syncRequest(false)
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        EnvironmentListBean environmentListBean = JSON.parseObject(s, EnvironmentListBean.class);
                        if (environmentListBean.isSuccess()) {
                            data = environmentListBean.getData();
                            switch (type) {
                                case 1:

                                    EnvironmentListBean.DataBean dataBean1 = data.get(0);
                                    tv_top_title.setText(dataBean1.getDevicename());
                                    tv_hum.setText(dataBean1.getDataDim());
                                    tv_pm.setText(dataBean1.getDataPm25());
                                    tv_co.setText(dataBean1.getDataCo1());
                                    tv_co2.setText(dataBean1.getDataCo2());
                                    tv_tem.setText(dataBean1.getDataTemp());

                                    image_shape_one.setImageResource(R.drawable.shape_oval_blue);
                                    image_shape_two.setImageResource(R.drawable.shape_oval_gray);
                                    image_shape_three.setImageResource(R.drawable.shape_oval_gray);
                                    break;
                                case 2:
                                    EnvironmentListBean.DataBean dataBean2 = data.get(1);

                                    tv_top_title.setText(dataBean2.getDevicename());
                                    tv_hum.setText(dataBean2.getDataDim());
                                    tv_pm.setText(dataBean2.getDataPm25());
                                    tv_co.setText(dataBean2.getDataCo1());
                                    tv_co2.setText(dataBean2.getDataCo2());
                                    tv_tem.setText(dataBean2.getDataTemp());

                                    image_shape_one.setImageResource(R.drawable.shape_oval_gray);
                                    image_shape_two.setImageResource(R.drawable.shape_oval_blue);
                                    image_shape_three.setImageResource(R.drawable.shape_oval_gray);
                                    break;
                                case 3:
                                    EnvironmentListBean.DataBean dataBean3 = data.get(2);
                                    tv_top_title.setText(dataBean3.getDevicename());
                                    tv_hum.setText(dataBean3.getDataDim());
                                    tv_pm.setText(dataBean3.getDataPm25());
                                    tv_co.setText(dataBean3.getDataCo1());
                                    tv_co2.setText(dataBean3.getDataCo2());
                                    tv_tem.setText(dataBean3.getDataTemp());

                                    image_shape_one.setImageResource(R.drawable.shape_oval_gray);
                                    image_shape_two.setImageResource(R.drawable.shape_oval_gray);
                                    image_shape_three.setImageResource(R.drawable.shape_oval_blue);
                                    break;
                            }

                        }
                    }
                });

    }

}
