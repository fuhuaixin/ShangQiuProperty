package com.fhx.property.fragment;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.activity.mine.ReadLogMsgActivity;
import com.fhx.property.adapter.ReadLogAdapter;
import com.fhx.property.base.BaseFragment;
import com.fhx.property.bean.ReadLogBean;
import com.fhx.property.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

public class ReadLogFragment extends BaseFragment implements View.OnClickListener {
    private ImageView image_left, image_right;
    private TextView tv_title;
    private RecyclerView recycle_log;
    private ReadLogAdapter readLogAdapter;
    private List<ReadLogBean> readLogBeanList = new ArrayList<>();
    private List<String > imageList1 = new ArrayList<>();
    private List<String> imageList2 = new ArrayList<>();
    private List<String> imageList3 = new ArrayList<>();

    @Override
    public int setLayoutId() {
        return R.layout.fragment_read_log;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        image_right = view.findViewById(R.id.image_right);
        image_left = view.findViewById(R.id.image_left);
        tv_title = view.findViewById(R.id.tv_title);
        recycle_log = view.findViewById(R.id.recycle_log);
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        imageList1.clear();
        imageList3.clear();
        imageList2.clear();
        imageList1.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598609130061&di=8bfbe0334d906968b981179c6d9bc80d&imgtype=0&src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201303%2F20%2F211948bwc9oj2zwojo969o.jpg");
        imageList2.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598609130061&di=8bfbe0334d906968b981179c6d9bc80d&imgtype=0&src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201303%2F20%2F211948bwc9oj2zwojo969o.jpg");
        imageList2.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598606457627&di=ee3985a0b502e0cc67069f1f8641b721&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F8%2F511102f384245.jpg%3Fdown");

        imageList3.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598606457627&di=ee3985a0b502e0cc67069f1f8641b721&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F8%2F511102f384245.jpg%3Fdown");
        imageList3.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598609130061&di=8bfbe0334d906968b981179c6d9bc80d&imgtype=0&src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201303%2F20%2F211948bwc9oj2zwojo969o.jpg");
        imageList3.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598606457627&di=ee3985a0b502e0cc67069f1f8641b721&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F8%2F511102f384245.jpg%3Fdown");

//        imageList1.add(R.mipmap.ic_launcher);
//        imageList2.add(R.mipmap.ic_launcher);
//        imageList2.add(R.mipmap.ic_launcher);
//        imageList3.add(R.mipmap.ic_launcher);
//        imageList3.add(R.mipmap.ic_launcher);
//        imageList3.add(R.mipmap.ic_launcher);

        readLogBeanList.clear();
        readLogBeanList.add(new ReadLogBean("李明哲的日报1", "2020-08-16 16:54", "今日完成工作：修灯", null));
        readLogBeanList.add(new ReadLogBean("李明哲的日报2", "2020-08-16 16:54", "今日完成工作：修灯", imageList1));
        readLogBeanList.add(new ReadLogBean("李明哲的日报3", "2020-08-16 16:54", "今日完成工作：巡逻", imageList2));
        readLogBeanList.add(new ReadLogBean("李明哲的日报4", "2020-08-16 16:54", "今日完成工作：1.完成常规巡逻 2.完成管理部派发的临时任务", imageList3));
        readLogBeanList.add(new ReadLogBean("李明哲的日报5", "2020-08-16 16:54", "今日完成工作：1.完成常规巡逻 2.完成管理部派发的临时任务", null));

        readLogAdapter = new ReadLogAdapter(readLogBeanList);
        recycle_log.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle_log.setAdapter(readLogAdapter);


    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);
        image_right.setOnClickListener(this);
        image_left.setOnClickListener(this);

        readLogAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpTo(getActivity(), ReadLogMsgActivity.class);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_right:
                ShowMenu(getContext(), image_right);
                break;
            case R.id.image_left:
                getActivity().finish();
                getActivity().overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
        }
    }

    /**
     * 弹出窗
     */

    public void ShowMenu(Context context, View view) {
        PopupMenu popupMenu = new PopupMenu(context, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_read, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.all:
                        tv_title.setText("全部日志");
                        break;
                    case R.id.day:
                        tv_title.setText("日报");

                        break;
                    case R.id.week:
                        tv_title.setText("周报");

                        break;
                    case R.id.month:
                        tv_title.setText("月报");

                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }
}
