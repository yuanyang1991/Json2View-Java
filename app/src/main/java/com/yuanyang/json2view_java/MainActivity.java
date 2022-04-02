package com.yuanyang.json2view_java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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


    public void toHummer(View view) {
        startActivity(new Intent(this, HummerPlaygroundActivity.class));
    }
}