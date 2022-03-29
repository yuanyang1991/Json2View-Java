package com.yuanyang.json2view_java;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import androidx.annotation.Nullable;

import com.yuanyang.mylibrary.Json2View;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PlaygroundActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
            throw new IllegalStateException("inflate view error");
        }
    }

    private File copyFile(boolean forceUpdate) throws Exception {
        File file = new File(getDataDir(), "json");
        if (!file.exists()) {
            file.mkdirs();
        }
        File jsonFile = new File(file, "playground.json");

        if (!jsonFile.exists()) {
            jsonFile.createNewFile();
        }
        if (jsonFile.length() > 0 && !forceUpdate) {
            return jsonFile;
        }
        try {
            File root = Environment.getExternalStorageDirectory();
            File playground = new File(root, "playground");
            File fromFile = new File(playground, "playground.json");
            InputStream inputStream = new FileInputStream(fromFile);
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
