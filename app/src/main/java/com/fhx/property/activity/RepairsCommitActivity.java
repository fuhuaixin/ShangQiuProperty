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
import com.fhx.property.adapter.ImageChooseAdapter;
import com.fhx.property.base.AppUrl;
import com.fhx.property.base.BaseActivity;
import com.fhx.property.bean.RepairTypeListBean;
import com.fhx.property.bean.RepairsMSgBean;
import com.fhx.property.bean.SuccessBean;
import com.fhx.property.bean.UpLoadImageBean;
import com.fhx.property.dialog.ListDialog;
import com.scrat.app.selectorlibrary.ImageSelector;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.body.UIProgressResponseCallBack;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;


/**
 * 维修表单提交
 */

public class RepairsCommitActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageLeft;
    private ImageView imageRight;
    private TextView tvTitle;
    private TextView tv_repair_type, tv_choose_time;
    private LinearLayout ll_choose_type, ll_choose_time;
    private RecyclerView recycle_image;
    private EditText et_content, et_name, et_number, et_floor;

    private ListDialog listDialog;//选择类型dialog
    private ListDialog chooseDialog; //选择图片dialog
    private List<String> mChooseList = new ArrayList<>();
    private List<String> mChooseIdList = new ArrayList<>(); //类型id  List
    private String chooseId; //选择的类型id
    private List<String> mChooseImageList = new ArrayList<>();
    private ImageChooseAdapter chooseImgAdapter;
    private List<String> imageList = new ArrayList<>(); //选择上传图片列表
    private List<String> UpImageList = new ArrayList<>(); //压缩上传图片列表
    private List<RepairTypeListBean.DataBean.RecordsBean> records; //报修类型list

    private static final int REQUEST_CODE_SELECT_IMG = 1;
    private static final int REQUEST_CAMERA = 2;
    private static final int MAX_SELECT_COUNT = 3;

    private Calendar c;//获取当前时间
    private String jumpOne = null;

    @Override
    protected int initLayout() {
        return R.layout.activity_repairs_commit;
    }

    @Override
    protected void initView() {
        imageLeft = (ImageView) findViewById(R.id.image_left);
        imageRight = (ImageView) findViewById(R.id.image_right);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tv_repair_type = (TextView) findViewById(R.id.tv_repair_type);
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
        jumpOne = getIntent().getStringExtra("jumpOne");
        c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        imageLeft.setImageResource(R.mipmap.icon_back_all_x);
        imageRight.setVisibility(View.VISIBLE);
        tvTitle.setText("我要报修");
        getRepairType();


        recycle_image.setLayoutManager(new GridLayoutManager(this, 3));
        chooseImgAdapter = new ImageChooseAdapter(this, imageList);
        recycle_image.setAdapter(chooseImgAdapter);


        mChooseImageList.add("相机");
        mChooseImageList.add("选择图片");
        chooseDialog = new ListDialog(RepairsCommitActivity.this, mChooseImageList, new ListDialog.LeaveMyDialogListener() {
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
                chooseDialog.dismiss();
            }
        });

        getMsg();
    }


    @Override
    protected void initListen() {
        imageLeft.setOnClickListener(this);
        imageRight.setOnClickListener(this);

        ll_choose_type.setOnClickListener(this);
        ll_choose_time.setOnClickListener(this);

        chooseImgAdapter.setClickListener(new ImageChooseAdapter.OnItemClickListener() {
            @Override
            public void onAdd(View view, int position) {
                chooseDialog.show();
            }

            @Override
            public void onDel(View view, int position) {
                imageList.remove(position);
                UpImageList.remove(position);
                chooseSize();
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

            case R.id.ll_choose_type:

                listDialog = new ListDialog(RepairsCommitActivity.this, mChooseList, new ListDialog.LeaveMyDialogListener() {
                    @Override
                    public void onClick(BaseQuickAdapter adapter, View view, int position) {
                        tv_repair_type.setText(mChooseList.get(position));
                        chooseId = mChooseIdList.get(position);
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
                        String mMonth = null;
                        String day = null;
                        if (month < 9) {
                            mMonth = "0" + (month + 1);
                        } else {
                            mMonth = String.valueOf((month + 1));
                        }
                        if (dayOfMonth < 10) {
                            day = "0" + dayOfMonth;
                        } else {
                            day = String.valueOf(dayOfMonth);
                        }
                        tv_choose_time.setText(year + "-" + mMonth + "-" + day);
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
          /*  imageList.add(file.getAbsolutePath());
            chooseSize();
            upImage(file);*/
            Luban(file);
            //在手机相册中显示刚拍摄的图片
            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri contentUri = Uri.fromFile(file);
            mediaScanIntent.setData(contentUri);
            sendBroadcast(mediaScanIntent);
        } else if (requestCode == REQUEST_CODE_SELECT_IMG) {
            showContent(data);
        }

    }

    private void chooseSize() {

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
                                mChooseIdList.add(records.get(i).getRepairTypeId());
                            }
                        }
                    }
                });
    }

    private void getMsg() {
        if (jumpOne != null && !jumpOne.equals("")) {
            EasyHttp.get(AppUrl.RepairDetail)
                    .params("id", jumpOne)
                    .execute(new SimpleCallBack<String>() {

                        @Override
                        public void onError(ApiException e) {

                        }

                        @Override
                        public void onSuccess(String s) {
                            RepairsMSgBean repairsMSgBean = JSON.parseObject(s, RepairsMSgBean.class);
                            if (repairsMSgBean.isSuccess()) {
                                RepairsMSgBean.DataBean.SelfBean self = repairsMSgBean.getData().getSelf();
                                et_content.setText(self.getContent());
                                tv_repair_type.setText(self.getRepairTypeName());
                                et_floor.setText(self.getNotes());
                                tv_choose_time.setText(self.getReserveTime());
                                et_name.setText(self.getCustomerName());
                                et_number.setText(self.getCustomerPhone());
                                chooseId = self.getRepairTypeId();
                                String imgs = self.getImgs();
                                if (imgs != null && !imgs.equals("")) {
                                    String[] split = imgs.split(",");
                                    for (int i = 0; i < split.length; i++) {
                                        imageList.add(split[i]);
                                        UpImageList.add(split[i]);
                                    }
                                }
                                chooseImgAdapter.notifyDataSetChanged();

                            } else {

                            }
                        }
                    });
        }
    }

    /**
     * 提交报修参数
     */

    private void commitRepair() {
        String images = "";
        if (UpImageList.size() > 0) {
            for (int i = 0; i < UpImageList.size(); i++) {
                switch (i) {
                    case 0:
                        images = UpImageList.get(0);
                        break;
                    case 1:
                        images = UpImageList.get(0) + "," + UpImageList.get(1);
                        break;
                    case 2:
                        images = UpImageList.get(0) + "," + UpImageList.get(1) + "," + UpImageList.get(2);

                        break;
                }
            }
        }

        if (!TextUtils.isEmpty(et_content.getText().toString()) && !TextUtils.isEmpty(tv_repair_type.getText().toString()) && !tv_repair_type.getText().toString().equals("请选择")
                && !TextUtils.isEmpty(et_floor.getText().toString()) && !et_floor.getText().toString().equals("请填写")
                && !TextUtils.isEmpty(tv_choose_time.getText().toString()) && !tv_choose_time.getText().toString().equals("请选择")) {
            String url;
            if (jumpOne != null && !jumpOne.equals("")) {
                url = AppUrl.RepairReSubmit;
            } else {
                url = AppUrl.RepairAdd;
            }
            EasyHttp.post(url)
                    .syncRequest(false)
//                    .upJson(jsonObject.toString())
                    .params("content", et_content.getText().toString())
                    .params("reserveTime", tv_choose_time.getText().toString())
                    .params("customerName", et_name.getText().toString())
                    .params("customerPhone", et_number.getText().toString())
                    .params("repairTypeName", tv_repair_type.getText().toString())
                    .params("repairTypeId", chooseId)
                    .params("notes", et_floor.getText().toString())
                    .params("customerId", mmkv.decodeString("userId"))
                    .params("originType", "0")
                    .params("imgs", images)
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
                        UpLoadImageBean bean = JSON.parseObject(s, UpLoadImageBean.class);
                        if (bean.isSuccess()) {
                            UpImageList.add(bean.getData().getUrl());
                        }
                    }
                });
    }


    /**
     * 鲁班图片压缩
     *
     * @param file
     */
    private void Luban(File file) {
        Luban.with(RepairsCommitActivity.this)
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
                        chooseSize();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("luban", e.getMessage());

                    }
                })
                .launch();
    }
}
