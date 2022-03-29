package com.yuanyang.mylibrary;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.yuanyang.mylibrary.parser.BindHandlerFactory;

import org.json.JSONArray;
import org.json.JSONObject;

public class PropertiesHelper {

    public static void applyProperties(View view, JSONArray properties, ViewGroup parent) throws Exception {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params == null) {
            params = generateDefaultLayoutParams(parent);
            view.setLayoutParams(params);
        }
        int len = properties.length();
        for (int i = 0; i < len; i++) {
            JSONObject jsonObject = properties.optJSONObject(i);
            String property = jsonObject.optString(Constants.PROPERTY_NAME);
            String value = jsonObject.optString(Constants.PROPERTY_VALUE);
            String type = jsonObject.optString(Constants.PROPERTY_TYPE);
            BindHandlerFactory.getPropertyParser(property).bind(view, new Property(property, type, value), parent);
        }
    }

    private static ViewGroup.LayoutParams generateDefaultLayoutParams(ViewGroup parent) {
        if (parent instanceof FrameLayout) {
            return new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        } else if (parent instanceof LinearLayout) {
            return new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        } else if (parent instanceof RelativeLayout) {
            return new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        } else {
            return new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

}
