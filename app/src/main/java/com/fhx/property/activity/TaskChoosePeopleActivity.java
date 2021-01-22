package com.fhx.property.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.TaskChooseEmpAdapter;
import com.fhx.property.adapter.TaskChoosePeopleAdapter;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.DepartmentBean;
import com.fhx.property.bean.SuccessBean;
import com.fhx.property.utils.ActivityControl;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务转派 或者 指派
 */
public class TaskChoosePeopleActivity extends BaseActivity implements View.OnClickListener {

    private ImageView image_left;
    private ImageView image_right;
    private TextView tv_title;
    private RecyclerView recycle_child;
    private RecyclerView recycle_emp;

    private TaskChoosePeopleAdapter childAdapter;
    private TaskChooseEmpAdapter empAdapter;
    private List<DepartmentBean.DataBean.ChildDeptBean> childDeptBeanList = new ArrayList<>(); //上面
    private List<DepartmentBean.DataBean.DeptEmployeeBean> employeeBeanList = new ArrayList<>(); //下面
    private String deptId, processId;

    private String assignOperation;  //选中的人
    private String executor; //选中人的id

    @Override
    protected int initLayout() {
        return R.layout.activity_task_choose_people;
    }

    @Override
    protected void initView() {
        image_left = (ImageView) findViewById(R.id.image_left);
        image_right = (ImageView) findViewById(R.id.image_right);
        tv_title = (TextView) findViewById(R.id.tv_title);
        recycle_child = (RecyclerView) findViewById(R.id.recycle_child);
        recycle_emp = (RecyclerView) findViewById(R.id.recycle_emp);

    }

    @Override
    protected void initData() {
        deptId = mmkv.decodeString("deptId");
        processId = getIntent().getStringExtra("jumpOne");
        image_left.setImageResource(R.mipmap.icon_back_all_x);
        image_right.setVisibility(View.VISIBLE);
        tv_title.setText("工单指派");
        ActivityControl.getInstance().add(TaskChoosePeopleActivity.this);

        childAdapter = new TaskChoosePeopleAdapter(childDeptBeanList);
        recycle_child.setLayoutManager(new LinearLayoutManager(this));
        recycle_child.setAdapter(childAdapter);


        empAdapter = new TaskChooseEmpAdapter(employeeBeanList);
        recycle_emp.setLayoutManager(new LinearLayoutManager(this));
        recycle_emp.setAdapter(empAdapter);

        String userType = mmkv.decodeString("userType");
        String[] split = userType.split(",");
        boolean kf =false;
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("KF_EMP_003")){
                kf=true;
                break;
            }else {
                kf =false;
            }
        }

        if (kf){
            getDept("");
        }else {
            getDept(deptId);
        }
    }

    @Override
    protected void initListen() {
        image_left.setOnClickListener(this);
        image_right.setOnClickListener(this);
        childAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.image_unsel:
                        for (int i = 0; i < childDeptBeanList.size(); i++) {
                            childDeptBeanList.get(i).setChoose(0);
                        }
                        for (int i = 0; i < employeeBeanList.size(); i++) {
                            employeeBeanList.get(i).setChoose(0);
                        }
                        childDeptBeanList.get(position).setChoose(1);
                        if (childDeptBeanList.get(position).getDeptType().equals("1")) {
                            assignOperation = "toManager";
                        } else {
                            assignOperation = "toHeader";
                        }
                        executor = childDeptBeanList.get(position).getDeptId();
                        childAdapter.notifyDataSetChanged();
                        empAdapter.notifyDataSetChanged();
                        break;
                    case R.id.image_right:
                    case R.id.tv_name:
                        getDept(childDeptBeanList.get(position).getDeptId());
                        break;
                }
            }
        });
        empAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.image_check:
                        for (int i = 0; i < childDeptBeanList.size(); i++) {
                            childDeptBeanList.get(i).setChoose(0);
                        }
                        for (int i = 0; i < employeeBeanList.size(); i++) {
                            employeeBeanList.get(i).setChoose(0);
                        }
                        assignOperation = "toEmployee";
                        executor = employeeBeanList.get(position).getEmployeeId();
                        employeeBeanList.get(position).setChoose(1);
                        childAdapter.notifyDataSetChanged();
                        empAdapter.notifyDataSetChanged();
                        break;
                }
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

            case R.id.image_right:
                commit();
                break;
        }
    }


    private void getDept(String dept) {
        EasyHttp.get(AppUrl.Department)
                .params("parentDeptId", dept)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        childDeptBeanList.clear();
                        employeeBeanList.clear();
                        DepartmentBean departmentBean = JSON.parseObject(s, DepartmentBean.class);
                        if (departmentBean.isSuccess()) {
                            if (departmentBean.getData() != null) {
                                if (departmentBean.getData().getChildDept()!=null&&departmentBean.getData().getChildDept().size()>0){
                                    childDeptBeanList.addAll(departmentBean.getData().getChildDept());

                                }
                                if (departmentBean.getData().getDeptEmployee()!=null&&departmentBean.getData().getDeptEmployee().size()>0){
                                    employeeBeanList.addAll(departmentBean.getData().getDeptEmployee());
                                }
                            }
                            childAdapter.notifyDataSetChanged();
                            empAdapter.notifyDataSetChanged();
                        } else {
                            ToastShort(departmentBean.getMsg());
                        }
                    }
                });
    }

    /**
     * 提交
     * processId   列表id
     * assignOperation  操作
     * executor 处理人
     */
    private void commit() {
        Log.e("fhxx",processId+"\n"+assignOperation+"\n"+executor);
        EasyHttp.get(AppUrl.OrderTransfer)
                .headers("Admin-Token",mmkv.decodeString("token"))
                .params("processId", processId)
                .params("assignOperation", assignOperation)
                .params("executor", executor)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());

                    }

                    @Override
                    public void onSuccess(String s) {
                        SuccessBean successBean = JSON.parseObject(s, SuccessBean.class);
                        if (successBean.isSuccess()){
                            ToastShort("提交成功");
                            ActivityControl.getInstance().closeAll();
                        }
                    }
                });
    }

}
