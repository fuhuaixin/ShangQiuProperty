package com.fhx.property.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.MainActivity;
import com.fhx.property.R;
import com.fhx.property.activity.WebActivity;
import com.fhx.property.activity.mine.ChangeDetailsActivity;
import com.fhx.property.activity.mine.ChangePasswordActivity;
import com.fhx.property.activity.mine.FeedbackActivity;
import com.fhx.property.activity.mine.WorkDiaryActivity;
import com.fhx.property.adapter.MineOAAdapter;
import com.fhx.property.base.BaseFragment;
import com.fhx.property.bean.MineOABean;
import com.fhx.property.utils.CommonDialog;
import com.fhx.property.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的fragment
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {

    private RecyclerView recycle_oa;
    private MineOAAdapter mineOAAdapter;

    private List<MineOABean> mineOABeanList = new ArrayList<>();
    private LinearLayout ll_change_password, ll_feedback,ll_about_us;
    private TextView tv_logout;
    private View view_help;
    private RelativeLayout rl_change_msg;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        recycle_oa = view.findViewById(R.id.recycle_oa);
        ll_change_password = view.findViewById(R.id.ll_change_password);
        ll_feedback = view.findViewById(R.id.ll_feedback);
        ll_about_us = view.findViewById(R.id.ll_about_us);
        tv_logout = view.findViewById(R.id.tv_logout);
        view_help = view.findViewById(R.id.view_help);
        rl_change_msg = view.findViewById(R.id.rl_change_msg);
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        mineOABeanList.clear();
        mineOABeanList.add(new MineOABean(R.mipmap.icon_mine_clock, "打卡", 0));
        mineOABeanList.add(new MineOABean(R.mipmap.icon_mine_leave, "请假", 0));
        mineOABeanList.add(new MineOABean(R.mipmap.icon_mine_log, "日志", 0));
        mineOABeanList.add(new MineOABean(R.mipmap.icon_mine_examine, "审批", 1));
        mineOABeanList.add(new MineOABean(R.mipmap.icon_mine_mk_card, "补卡", 0));
        mineOABeanList.add(new MineOABean(R.mipmap.icon_mine_salary, "薪资", 0));


        recycle_oa.setLayoutManager(new GridLayoutManager(getContext(), 5));
        mineOAAdapter = new MineOAAdapter(mineOABeanList);
        recycle_oa.setAdapter(mineOAAdapter);
    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);
        ll_change_password.setOnClickListener(this);
        ll_feedback.setOnClickListener(this);
        ll_about_us.setOnClickListener(this);
        view_help.setOnClickListener(this);
        rl_change_msg.setOnClickListener(this);

        tv_logout.setOnClickListener(this);
        mineOAAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (mineOABeanList.get(position).getTitle()){
                    case "日志":
                        CutToUtils.getInstance().JumpTo(getActivity(), WorkDiaryActivity.class);
                        break;
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_change_password://修改密码
                CutToUtils.getInstance().JumpTo(getActivity(), ChangePasswordActivity.class);
                break;
            case R.id.ll_feedback://投诉反馈
                CutToUtils.getInstance().JumpTo(getActivity(), FeedbackActivity.class);
                break;
            case R.id.ll_about_us://关于我们
                CutToUtils.getInstance().JumpToTwo(getActivity(), WebActivity.class,"关于我们","https://www.baidu.com/");
                break;
            case R.id.view_help://帮助中心
                CutToUtils.getInstance().JumpToTwo(getActivity(), WebActivity.class,"帮助中心","https://weibo.com/");
                break;
            case R.id.tv_logout://登出
                initDialog();
                break;
            case R.id.rl_change_msg://登出
               CutToUtils.getInstance().JumpTo(getActivity(), ChangeDetailsActivity.class);
                break;
        }
    }


    /**
     * 单双按钮弹窗
     */
    private void initDialog() {
        final CommonDialog dialog = new CommonDialog(getActivity());
        dialog.setMessage("确定退出？确定将直接退出程序")
                .setImageResId(-1)
                .setTitle("系统提示")
                .setSingle(false).setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
            @Override
            public void onPositiveClick() {
                dialog.dismiss();
                getActivity().finish();
            }

            @Override
            public void onNegtiveClick() {
                dialog.dismiss();
                Toast.makeText(getContext(),"取消",Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}
