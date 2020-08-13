package com.fhx.property.activity;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.property.R;
import com.fhx.property.base.BaseActivity;

/**
 * web通用页
 */
public class WebActivity extends BaseActivity {
    private TextView tvTitle;
    private ImageView imageLeft;
    private WebView webView;

    private String title,url;
    private WebSettings settings;

    @Override
    protected int initLayout() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        imageLeft = (ImageView) findViewById(R.id.image_left);
        webView = (WebView) findViewById(R.id.webview);
        title =getIntent().getStringExtra("jumpOne");
        url =getIntent().getStringExtra("jumpTwo");
    }

    @Override
    protected void initData() {
        tvTitle.setText(title);
        settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
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
    }
}
