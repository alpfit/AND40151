package com.apillay.activitylifecycle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "ANIL";
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.hello);
        tv.setText(R.string.start);
        Log.i(TAG, "On Create");

        responderIntent();
    }

    private void responderIntent() {
        Intent intent = getIntent();
        WebView wv;
        String mDatos;
        Uri datos;
        if (intent != null && intent.getAction().compareTo(Intent.ACTION_VIEW) == 0) {
            datos = intent.getData();
            mDatos = datos.toString();
            Toast.makeText(MainActivity.this, mDatos, Toast.LENGTH_LONG).show();
            tv.setText(mDatos);
            wv = (WebView)findViewById(R.id.webView1);
            wv.loadUrl(mDatos);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "On Restart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "On Resume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, getString(R.string.start));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "On Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "On Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "On Pause");
    }
}
