package com.fhx.property.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.activity.mine.MakeCardMsgActivity;
import com.fhx.property.adapter.CardListAdapter;
import com.fhx.property.base.BaseFragment;
import com.fhx.property.bean.ExamineBean;
import com.fhx.property.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

public class CardListFragment extends BaseFragment {

    private RecyclerView recycle_list;

    private CardListAdapter cardListAdapter;
    private List<ExamineBean> cardList = new ArrayList<>();

    @Override
    public int setLayoutId() {
        return R.layout.fragment_card_list;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        recycle_list = view.findViewById(R.id.recycle_list);
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        cardList.add(new ExamineBean(2, "黄三发起的补卡", "2020.10.4", "2020.10.2 12:00", 0));
        cardList.add(new ExamineBean(2, "黄三发起的补卡", "2020.10.5", "2020.10.2 12:00", 1));
        cardList.add(new ExamineBean(2, "黄三发起的补卡", "2020.10.6", "2020.10.2 12:00", 2));
        cardListAdapter = new CardListAdapter(cardList);
        recycle_list.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle_list.setAdapter(cardListAdapter);

    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);
        cardListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                CutToUtils.getInstance().JumpTo(getActivity(), MakeCardMsgActivity.class);
                CutToUtils.getInstance().JumpToTwo(getActivity(), MakeCardMsgActivity.class, 1, cardList.get(position).getProgress());
            }
        });
    }
}
