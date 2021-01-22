package com.fhx.property.fragment;

import android.view.View;
import android.widget.ImageView;

import com.fhx.property.R;
import com.fhx.property.activity.TaskChoosePeopleActivity;
import com.fhx.property.activity.TaskFaultMsgActivity;
import com.fhx.property.base.BaseFragment;
import com.fhx.property.utils.CutToUtils;

public class TaskRedeployFragment extends BaseFragment {
    private ImageView image_add_people;
    @Override
    public int setLayoutId() {
        return R.layout.fragment_task_redeploy;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        image_add_people =view.findViewById(R.id.image_add_people);

    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);

    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);
        image_add_people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CutToUtils.getInstance().JumpToOne(getActivity(), TaskChoosePeopleActivity.class, TaskFaultMsgActivity.processId);
            }
        });
    }
}
