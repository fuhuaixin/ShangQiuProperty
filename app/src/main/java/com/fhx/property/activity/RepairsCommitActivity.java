package com.fhx.property.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.property.R;
import com.fhx.property.adapter.ChooseImgAdapter;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.RepairTypeListBean;
import com.fhx.property.bean.SuccessBean;
import com.fhx.property.utils.ListDialog;
import com.scrat.app.selectorlibrary.ImageSelector;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.body.UIProgressResponseCallBack;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;


/**
 * 维修表单提交
 */

public class RepairsCommitActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageLeft;
    private ImageView imageRight;
    private ImageView image_add;
    private TextView tvTitle;
    private TextView tv_type, tv_choose_time;
    private LinearLayout ll_choose_type, ll_choose_time;
    private RecyclerView recycle_image;
    private EditText et_content, et_name, et_number, et_floor;
    private ListDialog listDialog;
    private List<String> mChooseList = new ArrayList<>();
    private List<String> mChooseImageList = new ArrayList<>();
    private ChooseImgAdapter chooseImgAdapter;
    private List<String> imageList = new ArrayList<>();

    private List<RepairTypeListBean.DataBean.RecordsBean> records; //报修类型list

    private static final int REQUEST_CODE_SELECT_IMG = 1;
    private static final int REQUEST_CAMERA = 2;
    private static final int MAX_SELECT_COUNT = 3;

    private Calendar c;//获取当前时间

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
        tv_choose_time = (TextView) findViewById(R.id.tv_choose_time);
        ll_choose_type = (LinearLayout) findViewById(R.id.ll_choose_type);
        ll_choose_time = (LinearLayout) findViewById(R.id.ll_choose_time);
        recycle_image = (RecyclerView) findViewById(R.id.recycle_image);
        et_content = (EditText) findViewById(R.id.et_content);
        et_name = (EditText) findViewById(R.id.et_name);
        et_number = (EditText) findViewById(R.id.et_number);
        et_floor = (EditText) findViewById(R.id.et_floor);

    }

    @Override
    protected void initData() {

        c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        imageLeft.setImageResource(R.mipmap.icon_back_all_x);
        imageRight.setVisibility(View.VISIBLE);
        tvTitle.setText("我要报修");

        chooseImgAdapter = new ChooseImgAdapter(imageList);
        chooseSize();
        recycle_image.setAdapter(chooseImgAdapter);

        getRepairType();

    }

    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        imageRight.setOnClickListener(this);
        image_add.setOnClickListener(this);
        ll_choose_type.setOnClickListener(this);
        ll_choose_time.setOnClickListener(this);

        chooseImgAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
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
        switch (v.getId()) {
            case R.id.image_right:

                commitRepair();
                break;

            case R.id.image_left:
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);

                break;
            case R.id.image_add:
                mChooseImageList.clear();
                mChooseImageList.add("相机");
                mChooseImageList.add("选择图片");
                listDialog = new ListDialog(RepairsCommitActivity.this, mChooseImageList, new ListDialog.LeaveMyDialogListener() {
                    @Override
                    public void onClick(BaseQuickAdapter adapter, View view, int position) {
                        switch (position) {
                            case 0:
                                useCamera();
                                break;
                            case 1:
                                ImageSelector.show(RepairsCommitActivity.this, REQUEST_CODE_SELECT_IMG, MAX_SELECT_COUNT - imageList.size());

                                break;
                        }
                        listDialog.dismiss();
                    }
                });
                listDialog.show();
                break;
            case R.id.ll_choose_type:

                listDialog = new ListDialog(RepairsCommitActivity.this, mChooseList, new ListDialog.LeaveMyDialogListener() {
                    @Override
                    public void onClick(BaseQuickAdapter adapter, View view, int position) {
                        tv_type.setText(mChooseList.get(position));
//                        ToastShort(records.get(position).getRepairTypeId());
                        listDialog.dismiss();
                    }
                });
                listDialog.show();
                break;
            case R.id.ll_choose_time:

                int year = c.get(Calendar.YEAR);
                int mouth = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(RepairsCommitActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        ToastShort(year+"--"+month+"--"+dayOfMonth);
                        tv_choose_time.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                }, year, mouth, day).show();
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {
            Log.e("TAG", "拍照---------" + FileProvider.getUriForFile(this, "com.fhx.property.provider", file));
            Log.e("TAG", "拍照---------" + file);
//            imageView.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
            imageList.add(file.getAbsolutePath());
            chooseSize();
            upImage(file);
            //在手机相册中显示刚拍摄的图片
            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri contentUri = Uri.fromFile(file);
            mediaScanIntent.setData(contentUri);
            sendBroadcast(mediaScanIntent);
        } else if (requestCode == REQUEST_CODE_SELECT_IMG) {
            showContent(data);
            chooseSize();
            return;
        }

    }

    private void chooseSize() {
        if (imageList.size() < 3) {
            image_add.setVisibility(View.VISIBLE);
        } else {
            image_add.setVisibility(View.GONE);
        }
        if (imageList.size() > 0) {
            recycle_image.setLayoutManager(new GridLayoutManager(RepairsCommitActivity.this, imageList.size()));
        }
        chooseImgAdapter.notifyDataSetChanged();
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
        Uri uri = FileProvider.getUriForFile(this, "com.fhx.property.provider", file);
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
        File file = new File(paths.get(0));
        Log.e("fhxx", "选择图片" + file);
        upImage(file);
        if (paths.isEmpty()) {
            for (int i = 0; i < paths.size(); i++) {
                imageList.add(paths.get(i));
            }
//            tv_mes.setText(paths.toString());
            return;
        }

        for (int i = 0; i < paths.size(); i++) {
            imageList.add(paths.get(i));
        }
    }

    /**
     * 获取报修类型
     */
    private void getRepairType() {
        EasyHttp.get(AppUrl.RepairTypeList)
                .syncRequest(false)
                .params("pageNum", "1")
                .params("pageSize", "50")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        RepairTypeListBean repairTypeListBean = JSON.parseObject(s, RepairTypeListBean.class);
                        if (repairTypeListBean.isSuccess()) {
                            records = repairTypeListBean.getData().getRecords();
                            for (int i = 0; i < records.size(); i++) {
                                mChooseList.add(records.get(i).getRepairTypeName());
                            }
                        }
                    }
                });
    }

    /**
     * 提交报修参数
     */

    private void commitRepair() {

        if (!TextUtils.isEmpty(et_content.getText().toString()) && !TextUtils.isEmpty(tv_type.getText().toString()) && !tv_type.getText().toString().equals("请选择")
                && !TextUtils.isEmpty(et_floor.getText().toString()) && !et_floor.getText().toString().equals("请填写")
                && !TextUtils.isEmpty(tv_choose_time.getText().toString()) && !tv_choose_time.getText().toString().equals("请选择")) {
           /* HashMap<String, String> params = new HashMap<>();
            params.put("content", et_content.getText().toString());
            params.put("reserveTime", tv_choose_time.getText().toString());//预约时间
            params.put("customerName", et_name.getText().toString());
            params.put("customerPhone", et_number.getText().toString());
            params.put("repairTypeName", tv_type.getText().toString());//维修类型
            params.put("notes", et_floor.getText().toString());//报修地址
            params.put("customerId", mmkv.decodeString("userId"));//提交用户id
            JSONObject jsonObject = new JSONObject(params);*/
            EasyHttp.post(AppUrl.RepairAdd)
                    .syncRequest(false)
//                    .upJson(jsonObject.toString())
                    .params("content", et_content.getText().toString())
                    .params("reserveTime", tv_choose_time.getText().toString())
                    .params("customerName", et_name.getText().toString())
                    .params("customerPhone", et_number.getText().toString())
                    .params("repairTypeName", tv_type.getText().toString())
                    .params("notes", et_floor.getText().toString())
                    .params("customerId", mmkv.decodeString("userId"))
                    .params("originType", "0")
                    .execute(new SimpleCallBack<String>() {
                        @Override
                        public void onError(ApiException e) {
                            Log.e("error", e.getMessage());
                        }

                        @Override
                        public void onSuccess(String s) {
                            SuccessBean repairsAddBean = JSON.parseObject(s, SuccessBean.class);
                            if (repairsAddBean.isSuccess()) {
                                ToastShort("提交成功");
                                finish();
                                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                            } else {
                                ToastShort(repairsAddBean.getMsg());
                            }
                        }
                    });
        } else {
            ToastShort("请填写必填项");
        }


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
                    ToastShort("上传成功");
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
                        SuccessBean successBean = JSON.parseObject(s, SuccessBean.class);

                    }
                });
    }

}
