package com.apillay.simpleflashlight;

import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String FLASH_TAG = "FLASH";
    private  Camera camera;
    private boolean isFlashOn;
    private boolean hasFlash;
    android.hardware.Camera.Parameters param;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleButton flashSwitch = (ToggleButton) findViewById(R.id.flash_switch);
        if (getCamera() && hasFlash) {
            flashSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    turnOnOffFlash(compoundButton.isChecked());
                }
            });
        }
        else {
            flashSwitch.setEnabled(false);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (camera != null) {
            camera.release();
            camera = null;
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        turnOnOffFlash(false);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getCamera();
    }

    private Boolean getCamera() {
        List<String> flashModes;
        Boolean hayCamera = true;
        if (camera == null) {
            try {
                camera = Camera.open();
                param = camera.getParameters();
                flashModes = param.getSupportedFlashModes();
                hasFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
                if ((flashModes == null && hasFlash) || !hasFlash) {
                    Toast.makeText(this, R.string.nohay_flash, Toast.LENGTH_SHORT).show();
                    hasFlash = false;
                }
            }
            catch (Exception e) {
                Log.e(FLASH_TAG, e.getMessage());
                hayCamera = false;
            }
        }
        return hayCamera;
    }

    private void turnOnOffFlash(boolean isOff) {
            if (camera != null && param != null) {
                param = camera.getParameters();
                if (isOff) {
                    param.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    Log.v(FLASH_TAG, "Flash prendido");
                }
                else {
                    param.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    Log.v(FLASH_TAG, "Flash apagado");
                }
                camera.setParameters(param);
                camera.startPreview();
                isFlashOn = !isOff;
            }
    }
}
