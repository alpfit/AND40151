package com.apillay.wallpaper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class ImagePreview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_preview);
        Intent i = getIntent();
        Integer imgRes = i.getExtras().getInt("id");
        ImageView imageView = (ImageView) findViewById((R.id.full_image_view));
        imageView.setImageResource(imgRes);


    }
}
