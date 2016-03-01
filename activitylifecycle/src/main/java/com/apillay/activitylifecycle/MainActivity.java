package com.apillay.activitylifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "ANIL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView)findViewById(R.id.hello);
        tv.setText(R.string.start);
        Log.i(TAG, "On Create");
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
