package com.apillay.wallpaper;

import android.app.WallpaperManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("mi Menu Contual");
        AdapterView.AdapterContextMenuInfo cmi = (AdapterView.AdapterContextMenuInfo)menuInfo;
        menu.add(1, cmi.position, 0, "Set as Wallpaper");
        menu.add(2, cmi.position, 0, "View Image");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        GridView g = (GridView)findViewById(R.id.GridView1);
        Integer resourceId = (Integer)g.getItemAtPosition(item.getItemId());
        switch (item.getGroupId()) {
            case 1: {
                final WallpaperManager wpm = WallpaperManager.getInstance(getApplicationContext());
                try {
                    wpm.setResource(resourceId);
                    Toast.makeText(getApplicationContext(), "Wallpaper changed",Toast.LENGTH_LONG).show();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 2: {
                Intent i = new Intent(MainActivity.this, ImagePreview.class);
                i.putExtra("id", resourceId);
                startActivity(i);
                break;
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView mGrid = (GridView)findViewById(R.id.GridView1);
        mGrid.setAdapter(new ImageAdapter(this));
        registerForContextMenu(mGrid);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about : {
                Intent i = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(i);
                break;
            }
            case R.id.exit : {
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
