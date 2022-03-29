package com.yuanyang.json2view_java;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;

import java.lang.reflect.Method;

public class PermissionUtils {

    public static void requestAllFilesManagePermission(Context context) {
        if (Build.VERSION.SDK_INT > 29 || "R".equals(Build.VERSION.CODENAME)) {
            try {
                Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION"); // Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION
                intent.setData(Uri.parse("package:" + context.getPackageName()));
                context.startActivity(intent);
            } catch (Throwable throwable) {

            }
        }
    }

    public static boolean hasAllFilesManagePermissionInner() {
        Class clz = Environment.class;
        try {
            Method m = clz.getMethod("isExternalStorageManager");
            return (boolean) m.invoke(null);
        } catch (Throwable e) {
            // ignore
        }
        return false;
    }
}
