package com.fhx.property.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.activity.TaskFaultMsgActivity;
import com.fhx.property.adapter.ImageChooseAdapter;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseFragment;
import com.fhx.property.bean.SuccessBean;
import com.fhx.property.bean.UpLoadImageBean;
import com.fhx.property.dialog.ListDialog;
import com.fhx.property.utils.ActivityControl;
import com.lljjcoder.style.citylist.Toast.ToastUtils;
import com.scrat.app.selectorlibrary.ImageSelector;
import com.scrat.app.selectorlibrary.activity.ImageSelectorActivity;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.body.UIProgressResponseCallBack;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;


public class TaskDealFragment extends BaseFragment implements View.OnClickListener {

    private RecyclerView recycle_image_add;
    private TextView tv_to_repairs;
    private EditText et_content;

    private ImageChooseAdapter imageChooseAdapter;
    private ListDialog chooseDialog;
    private List<String> chooseList = new ArrayList<>();

    private static final int REQUEST_CODE_SELECT_IMG = 1;
    private static final int REQUEST_CAMERA = 2;
    private static final int MAX_SELECT_COUNT = 3;
    private List<String> imageList = new ArrayList<>(); //选择上传图片列表
    private List<String> UpImageList = new ArrayList<>(); //上传图片列表
    private String upImages="";


    @Override
    public int setLayoutId() {
        return R.layout.framgent_task_deal;
    }

    @Override
    public void findViewById(View view) {
        super.findViewById(view);
        recycle_image_add = view.findViewById(R.id.recycle_image_add);
        tv_to_repairs = view.findViewById(R.id.tv_to_repairs);
        et_content = view.findViewById(R.id.et_content);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("fhxx", requestCode + "---------" + resultCode);
        if (requestCode == REQUEST_CAMERA && resultCode == -1) {
            Log.e("TAG", "拍照---------" + FileProvider.getUriForFile(getContext(), "com.fhx.property.provider", file));
            Log.e("TAG", "拍照---------" + file);
//            imageView.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
          /*  imageList.add(file.getAbsolutePath());
            chooseSize();
            upImage(file);*/
            Luban(file);
        } else if (requestCode == REQUEST_CODE_SELECT_IMG) {
            showContent(data);
        }
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        chooseList.add("拍照");
        chooseList.add("图片选择");
        recycle_image_add.setLayoutManager(new GridLayoutManager(getContext(), 3));
        imageChooseAdapter = new ImageChooseAdapter(getContext(), imageList);
        recycle_image_add.setAdapter(imageChooseAdapter);
        chooseDialog = new ListDialog(getContext(), chooseList, new ListDialog.LeaveMyDialogListener() {
            @Override
            public void onClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        useCamera();
                        break;
                    case 1:
                        Intent i = new Intent(getContext(), ImageSelectorActivity.class);
                        i.putExtra("max", MAX_SELECT_COUNT - imageList.size());
                        startActivityForResult(i, REQUEST_CODE_SELECT_IMG);
                        break;
                }
                chooseDialog.dismiss();
            }
        });
    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);
        tv_to_repairs.setOnClickListener(this);
        imageChooseAdapter.setClickListener(new ImageChooseAdapter.OnItemClickListener() {
            @Override
            public void onAdd(View view, int position) {
                chooseDialog.show();
            }

            @Override
            public void onDel(View view, int position) {
                imageList.remove(position);
                UpImageList.remove(position);
                imageChooseAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_to_repairs:
                for (int i = 0; i < UpImageList.size(); i++) {
                    if (i==0){
                        upImages =UpImageList.get(i);
                    }else {
                        upImages =upImages+","+UpImageList.get(i);
                    }
                }
                Log.e("upImages",upImages);
                if (TextUtils.isEmpty(et_content.getText())){
                    ToastUtils.showShortToast(getContext(),"请填写处理结果");
                    return;
                }
                if (upImages.equals("")){
                    ToastUtils.showShortToast(getContext(),"请选择图片");
                    return;
                }
                switch (TaskFaultMsgActivity.type){
                    case "0": //报修
                        repair();
                        break;
                    case "1": //投诉
                        ComplainModifyRepairInfo();
                        break;
                }
                break;
        }
    }

    /**
     * 初始化相机相关权限
     * 适配6.0+手机的运行时权限
     */
    private File file;

    private void useCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/images/" + System.currentTimeMillis() + ".jpg");
        file.getParentFile().mkdirs();
        //改变Uri com.fhx.property.provider注意和xml中的一致
        Uri uri = FileProvider.getUriForFile(getContext(), "com.fhx.property.provider", file);
        //添加权限
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    /**
     * 选择图片
     *
     * @param data
     */
    private void showContent(Intent data) {
        List<String> paths = ImageSelector.getImagePaths(data);

        if (paths.isEmpty()) {
            for (int i = 0; i < paths.size(); i++) {
                imageList.add(paths.get(i));
            }
            return;
        }

        for (int i = 0; i < paths.size(); i++) {
            File file = new File(paths.get(i));
            Luban(file);
        }
    }


    /**
     * 鲁班图片压缩
     *
     * @param file
     */
    private void Luban(File file) {
        Luban.with(getContext())
                .load(file)
                .ignoreBy(100)
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {
                        Log.e("luban", "onStart");
                    }

                    @Override
                    public void onSuccess(File file) {
                        Log.e("luban", file.getAbsolutePath());
                        upImage(file);
                        imageList.add(file.getAbsolutePath());
                        imageChooseAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("luban", e.getMessage());

                    }
                })
                .launch();
    }

    private void commitTask() {
//        Log.e("fhxx",processId+"\n"+assignOperation+"\n"+executor);
        EasyHttp.get(AppUrl.OrderTransfer)
                .headers("Admin-Token",mmkv.decodeString("token"))
                .params("processId", TaskFaultMsgActivity.processId)
                .params("assignOperation", "commitTask")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());

                    }

                    @Override
                    public void onSuccess(String s) {
                        SuccessBean successBean = JSON.parseObject(s, SuccessBean.class);
                        if (successBean.isSuccess()){
                            ToastUtils.showShortToast(getContext(),"提交成功");
                            getActivity().finish();
                        }
                    }
                });
    }

    private void repair(){
        EasyHttp.get(AppUrl.RepairModifyRepairInfo)
                .params("processId",TaskFaultMsgActivity.processId)
                .params("images",upImages)
                .params("content",et_content.getText().toString())
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        SuccessBean successBean = JSON.parseObject(s, SuccessBean.class);
                        if (successBean.isSuccess()){
                            commitTask();
                        }
                    }
                });
    }

    private void ComplainModifyRepairInfo(){
        EasyHttp.get(AppUrl.ComplainModifyRepairInfo)
                .params("processId",TaskFaultMsgActivity.processId)
                .params("images",upImages)
                .params("content",et_content.getText().toString())
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        SuccessBean successBean = JSON.parseObject(s, SuccessBean.class);
                        if (successBean.isSuccess()){
                            commitTask();
                        }
                    }
                });
    }


    /**
     * 图片上传
     */
    private void upImage(File file) {
        UIProgressResponseCallBack uiProgressResponseCallBack = new UIProgressResponseCallBack() {
            @Override
            public void onUIResponseProgress(long bytesRead, long contentLength, boolean done) {
                int progress = (int) (bytesRead * 100 / contentLength);
                Log.e("fhxx", "上传" + progress);
                if (done) {
                    ToastUtils.showShortToast(getContext(),"上传成功");
                }
            }
        };
        EasyHttp.post(AppUrl.ImageUpLoad)
                .syncRequest(false)
                .timeStamp(true)
                .params("file", file, uiProgressResponseCallBack)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("imageError", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        UpLoadImageBean bean = JSON.parseObject(s, UpLoadImageBean.class);
                        if (bean.isSuccess()) {
                            UpImageList.add(bean.getData().getUrl());
                        }
                    }
                });
    }


}
