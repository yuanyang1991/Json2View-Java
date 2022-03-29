package com.yuanyang.mylibrary;

import android.content.Context;
import android.view.View;

public class ViewFactory {

    private static final String ANDROID_WIDGET_PREFIX = "android.widget.";

    public static View getView(Context context, String widgetStr) throws Exception {
        if ("View".equals(widgetStr)) {
            widgetStr = "android.view.View";
        } else if (!widgetStr.contains(".")) {
            widgetStr = ANDROID_WIDGET_PREFIX + widgetStr;
        }
        Class clz = Class.forName(widgetStr);
        return (View) clz.getConstructor(Context.class).newInstance(context);
    }
}
