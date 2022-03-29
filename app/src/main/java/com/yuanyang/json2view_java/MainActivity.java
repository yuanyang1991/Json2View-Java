package com.yuanyang.json2view_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuanyang.mylibrary.Json2View;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toPlayground(View view) {
        startActivity(new Intent(this, PlaygroundActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!PermissionUtils.hasAllFilesManagePermissionInner()) {
            PermissionUtils.requestAllFilesManagePermission(this);
        }
    }


}