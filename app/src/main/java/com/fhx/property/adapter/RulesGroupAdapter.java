package com.fhx.property.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.property.R;
import com.fhx.property.bean.RulesGroupBean;

import java.util.List;

public class RulesGroupAdapter extends BaseQuickAdapter<RulesGroupBean, BaseViewHolder> {
    public RulesGroupAdapter(@Nullable List<RulesGroupBean> data) {
        super(R.layout.adapter_rules_groups, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RulesGroupBean item) {
        helper.setText(R.id.tv_title, item.getRulesTitle())
                .setText(R.id.tv_time, "周" + item.getField_workdays().toString()
                        + "\n第一时段上下班时间： " + item.getPeriods().get(0).getStime() + " - " + item.getPeriods().get(0).getEtime()
                        +"\n第二时段上下班时间： "+item.getPeriods().get(1).getStime() + " - " + item.getPeriods().get(1).getEtime());

        if (item.isField_checkEarlyBefore() && item.isField_checkLateAfter()) {
            helper.setText(R.id.tv_tanxing, "允许迟到" + item.getField_lateafter() + "分钟\n" +
                    "允许提前走" + item.getField_earlybefore() + "分钟");
        } else if (item.isField_checkEarlyBefore() && !item.isField_checkLateAfter()) {
            helper.setText(R.id.tv_tanxing, "允许迟到" + item.getField_lateafter() + "分钟");
        } else if (!item.isField_checkEarlyBefore() && item.isField_checkLateAfter()) {
            helper.setText(R.id.tv_tanxing, "允许提前走" + item.getField_earlybefore() + "分钟");
        } else {
            helper.setText(R.id.tv_tanxing, "暂无");
        }
    }
}
