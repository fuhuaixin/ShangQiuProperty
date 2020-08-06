package com.fhx.property.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.ChooseImgAdapter;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.utils.CameraAndChooseDialog;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * 维修表单提交
 */

public class RepairsCommitActivity extends BaseActivity implements View.OnClickListener{

    private ImageView imageLeft;
    private ImageView imageRight;
    private ImageView image_add;
    private TextView tvTitle;
    private TextView tv_type;
    private LinearLayout ll_choose_type;
    private RecyclerView recycle_image;
    private CameraAndChooseDialog cameraAndChooseDialog;
    private List<String> mChooseList = new ArrayList<>();
    private List<String> mChooseImageList = new ArrayList<>();
    private ChooseImgAdapter chooseImgAdapter;
    private List<String> imageList =new ArrayList<>();


    private static final int REQUEST_CODE_SELECT_IMG = 1;
    private static final int REQUEST_CAMERA = 2;
    private static final int MAX_SELECT_COUNT = 3;

    @Override
    protected int initLayout() {
        return R.layout.activity_repairs_commit;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        imageRight = (ImageView) findViewById(R.id.image_right);
        image_add = (ImageView) findViewById(R.id.image_add);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_type = (TextView) findViewById(R.id.tv_type);
        ll_choose_type = (LinearLayout) findViewById(R.id.ll_choose_type);
        recycle_image= (RecyclerView) findViewById(R.id.recycle_image);

    }

    @Override
    protected void initData() {
        imageLeft.setImageResource(R.mipmap.icon_back_all_x);
        imageRight.setVisibility(View.VISIBLE);
        tvTitle.setText("我要报修");

//        imageList.add("https://iknow-pic.cdn.bcebos.com/fcfaaf51f3deb48f12d46640f21f3a292cf578eb?x-bce-process=image/resize,m_lfit,w_600,h_800,limit_1");
//        imageList.add("https://iknow-pic.cdn.bcebos.com/7af40ad162d9f2d3659ee371abec8a136227cca5?x-bce-process=image/resize,m_lfit,w_600,h_800,limit_1");
//        imageList.add("https://iknow-pic.cdn.bcebos.com/7af40ad162d9f2d3659ee371abec8a136227cca5?x-bce-process=image/resize,m_lfit,w_600,h_800,limit_1");
        Log.e("fhxx",imageList.size()+" ----- ");


        chooseImgAdapter =new ChooseImgAdapter(imageList);
        chooseSize();
        recycle_image.setAdapter(chooseImgAdapter);

        for (int i = 0; i <10; i++) {
            mChooseList.add("类型"+i);
        }


    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        imageRight.setOnClickListener(this);
        image_add.setOnClickListener(this);
        ll_choose_type.setOnClickListener(this);

        chooseImgAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.image_del:
                        imageList.remove(position);
                        chooseSize();
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_right:
                ToastShort("提交并执行退出动画");

                break;

            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);

                break;
            case R.id.image_add:
                mChooseImageList.clear();
                mChooseImageList.add("相机");
                mChooseImageList.add("选择图片");
                cameraAndChooseDialog = new CameraAndChooseDialog(RepairsCommitActivity.this, mChooseImageList, new CameraAndChooseDialog.LeaveMyDialogListener() {
                    @Override
                    public void onClick(BaseQuickAdapter adapter, View view, int position) {
                        switch (position){
                            case 0:

                                break;
                        }
                        cameraAndChooseDialog.dismiss();
                    }
                });
                cameraAndChooseDialog.show();
                break;
            case R.id.ll_choose_type:

                cameraAndChooseDialog = new CameraAndChooseDialog(RepairsCommitActivity.this, mChooseList, new CameraAndChooseDialog.LeaveMyDialogListener() {
                    @Override
                    public void onClick(BaseQuickAdapter adapter, View view, int position) {
                        tv_type.setText(mChooseList.get(position));
                        cameraAndChooseDialog.dismiss();
                    }
                });
                cameraAndChooseDialog.show();
                break;

        }
    }

    private void chooseSize(){
        if (imageList.size()<3){
            image_add.setVisibility(View.VISIBLE);
        }else {
            image_add.setVisibility(View.GONE);
        }
        if (imageList.size()>0){
            recycle_image.setLayoutManager(new GridLayoutManager(RepairsCommitActivity.this,imageList.size()));
        }
        chooseImgAdapter.notifyDataSetChanged();
    }




}
