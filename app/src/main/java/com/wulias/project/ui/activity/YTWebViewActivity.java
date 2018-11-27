package com.wulias.project.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.wulias.project.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YTWebViewActivity extends AppCompatActivity {
    @BindView(R.id.web_view)
    public WebView web_view;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ytweb_view);
        ButterKnife.bind(this);
        url = getIntent().getStringExtra("url");
        WebSettings webSettings = web_view.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        web_view.addJavascriptInterface(new JSInterface(mContext), "terminal");
        web_view.setWebChromeClient(new WebChromeClient());
        web_view.loadUrl("https://dev.utimecn.cn/utime-web-WeChat/readsecond/goReadSecondPage?user_phone=13684987372&sp_id=152&request_id=92408fa1-039d-2311-8074-913e27f099ac");
    }
}
