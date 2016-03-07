package com.apillay.wallpaper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        WebView wv = (WebView)findViewById(R.id.webView1);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("http://www.androidatc.com/pages-2/About-Us");
    }
}
