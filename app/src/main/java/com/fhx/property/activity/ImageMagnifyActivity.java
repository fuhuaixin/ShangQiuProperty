package com.fhx.property.activity;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片放大
 */
public class ImageMagnifyActivity extends BaseActivity {
    private ViewPager viewpager;
    private TextView tv_size;
    private ImageView image_left;

    private ArrayList<String> imageLists;
    private int position;
    //定义一个View的数组
    private List<ImageView> imageViews=new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_image_magnify;
    }

    @Override
    protected void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tv_size = (TextView) findViewById(R.id.tv_size);
        image_left = (ImageView) findViewById(R.id.image_left);
    }

    @Override
    protected void initData() {
        imageLists = getIntent().getStringArrayListExtra("imageList");
        position =getIntent().getIntExtra("position",0);
        Log.e("fhxx",imageLists.toString()+" \n "+position);

        tv_size.setText((position+1)+"/"+imageLists.size());
        for (int i = 0; i < imageLists.size(); i++) {
            ImageView imageView = new ImageView(this);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(this).load(imageLists.get(i)).into(imageView);
            imageViews.add(imageView);
        }

        setViewpagerAdapter();
    }

    @Override
    protected void initListen() {
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tv_size.setText((position+1)+"/"+imageLists.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        image_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
            }
        });
    }

    private void setViewpagerAdapter(){
        viewpager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageViews.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view==object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ImageView imageView = imageViews.get(position);
                container.addView(imageView);
                return imageView;

            }
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                View v=imageViews.get(position);
                //前一张图片划过后删除该View
                container.removeView(v);
            }
        });
        viewpager.setCurrentItem(position);
    }
}
