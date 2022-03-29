package com.yuanyang.json2view_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
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
        View rootView = null;
        try {
            File jsonFile = copyFile(true);
            rootView = new Json2View(this, jsonFile).parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rootView != null) {
            setContentView(rootView);
        } else {
            TextView textView = new TextView(this);
            textView.setText("Error");
            textView.setTextSize(50, TypedValue.COMPLEX_UNIT_SP);
            textView.setGravity(Gravity.CENTER);
            setContentView(textView);
        }
    }

    private File copyFile(boolean forceUpdate) throws Exception {
        File file = new File(getDataDir(), "json");
        if (!file.exists()) {
            file.mkdirs();
        }
        File jsonFile = new File(file, "layout_main.json");

        if (!jsonFile.exists()) {
            jsonFile.createNewFile();
        }
        if (jsonFile.length() > 0 && !forceUpdate) {
            return jsonFile;
        }
        try {
            InputStream inputStream = getAssets().open("layout_main.json");
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(jsonFile));
            byte[] buffer = new byte[8 * 1024];
            int len = 0;
            len = bis.read(buffer);
            while (len != -1) {
                bos.write(buffer, 0, len);
                len = bis.read(buffer);
            }
            bis.close();
            bos.close();
            return jsonFile;
        } catch (IOException e) {
            return null;
        }
    }
}