package com.fhx.property.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.activity.mine.LeaveMsgActivity;
import com.fhx.property.activity.mine.MakeCardMsgActivity;
import com.fhx.property.adapter.ExamineAdapter;
import com.fhx.property.base.BaseFragment;
import com.fhx.property.bean.ExamineBean;
import com.fhx.property.utils.CutToUtils;
import com.lljjcoder.style.citylist.Toast.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class ExamineFragment extends BaseFragment {
    private LinearLayout ll_empty;
    private TextView tv_msg;
    private RecyclerView recycle_examine;
    private ExamineAdapter examineAdapter;
    private List<ExamineBean> examineBeanList =new ArrayList<>();
    private int  type;

    public ExamineFragment(int type) {
        this.type = type;
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_examine;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        ll_empty =view.findViewById(R.id.ll_empty);
        tv_msg =view.findViewById(R.id.tv_msg);
        recycle_examine =view.findViewById(R.id.recycle_examine);
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        examineBeanList.add(new ExamineBean(1,"黄三发起的请假","2020.10.1","事假","2020.10.4","2020.10.5",0));
        examineBeanList.add(new ExamineBean(1,"黄三发起的请假","2020.10.2","病假","2020.10.4","2020.10.5",1));
        examineBeanList.add(new ExamineBean(1,"黄三发起的请假","2020.10.3","婚假","2020.10.4","2020.10.5",2));
        examineBeanList.add(new ExamineBean(2,"黄三发起的补卡","2020.10.4","2020.10.2 12:00",0));
        examineBeanList.add(new ExamineBean(2,"黄三发起的补卡","2020.10.5","2020.10.2 12:00",1));
        examineBeanList.add(new ExamineBean(2,"黄三发起的补卡","2020.10.6","2020.10.2 12:00",2));
        examineAdapter =new ExamineAdapter(examineBeanList,type);
        recycle_examine.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle_examine.setAdapter(examineAdapter);

        if (examineBeanList.size()>0){
            ll_empty.setVisibility(View.GONE);
        }else {
            ll_empty.setVisibility(View.VISIBLE);

            if (type==1){
                tv_msg.setText("你还没有发起过审批");
            }else if (type==2){
                tv_msg.setText("你还没有处理过审批");
            }

        }
    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);
        examineAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                int itemType = examineBeanList.get(position).getItemType();
                switch (type){
                    case 1:
                        if (itemType==1){
                            CutToUtils.getInstance().JumpToTwo(getActivity(), LeaveMsgActivity.class,1,examineBeanList.get(position).getProgress());
                        }else {
                            CutToUtils.getInstance().JumpToTwo(getActivity(), MakeCardMsgActivity.class,1,examineBeanList.get(position).getProgress());
                        }
                        break;
                    case 2:
                        if (itemType==1){
                            CutToUtils.getInstance().JumpToTwo(getActivity(), LeaveMsgActivity.class,2,examineBeanList.get(position).getProgress());
                        }else {
                            CutToUtils.getInstance().JumpToTwo(getActivity(), MakeCardMsgActivity.class,2,examineBeanList.get(position).getProgress());
                        }
                        break;
                }
               /* switch (view.getId()){
                    case R.id.ll_leave_item:
                        ToastUtils.showShortToast(getContext(),type+"点击了leave的"+position);
                        break;
                    case R.id.ll_card_item:
                        ToastUtils.showShortToast(getContext(),type+"点击了card的"+position);
                        break;
                }*/
            }
        });
    }
}
