package com.fhx.property.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.NotifyListAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.NotifyListBean;
import com.fhx.property.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 通知列表
 */
public class NotifyListActivity extends BaseActivity {

    private ImageView imageLeft;
    private TextView tvTitle;
    private EditText etSearch;
    private RecyclerView recycleNotify;

    private NotifyListAdapter adapter;
    private List<NotifyListBean> mList =new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.activity_reminder;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        etSearch = (EditText) findViewById(R.id.et_search);
        recycleNotify = (RecyclerView) findViewById(R.id.recycle_reminder);
    }

    @Override
    protected void initData() {
        tvTitle.setText("通知公告");
        etSearch.setHint("搜索公告标题及内容");

        recycleNotify.setLayoutManager(new LinearLayoutManager(this));
        for (int i = 0; i < 7; i++) {
            mList.add(new NotifyListBean("标题"+i,"msg"+i,"时间"+i,"部门"));
        }
        adapter = new NotifyListAdapter(mList);
        recycleNotify.setAdapter(adapter);

    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
            }
        });

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpToTwo(NotifyListActivity.this, WebActivity.class,"公告详情","https://www.baidu.com/");
        }
        });
    }
}
