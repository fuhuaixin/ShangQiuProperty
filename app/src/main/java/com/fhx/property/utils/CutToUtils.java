package com.fhx.property.utils;

import android.app.Activity;
import android.content.Intent;

import com.fhx.property.R;
import com.fhx.property.base.BaseBean;


/**
 * 跳转
 */
public class CutToUtils {

    private static final CutToUtils instance = new CutToUtils();

    public static CutToUtils getInstance() {
        return instance;
    }

    public void JumpTo(Activity context, Class<? extends Activity> activity) {
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.activity_in_from_anim, R.anim.activity_in_to_anim);
    }

    public void JumpToBean(Activity context, Class<? extends Activity> activity, BaseBean bean) {
        Intent intent = new Intent(context, activity);
        intent.putExtra("bean", bean);
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.activity_in_from_anim, R.anim.activity_in_to_anim);

    }


}
