package com.yuanyang.mylibrary;

import android.view.View;
import android.view.ViewGroup;

import com.yuanyang.mylibrary.parser.PropertyParserFactory;

import org.json.JSONArray;
import org.json.JSONObject;

public class PropertiesHelper {

    public static void applyProperties(View view, JSONArray properties) throws Exception {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params == null) {
            params = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(params);
        }
        int len = properties.length();
        for (int i = 0; i < len; i++) {
            JSONObject jsonObject = properties.optJSONObject(i);
            String property = jsonObject.optString(Constants.PROPERTY_NAME);
            String value = jsonObject.optString(Constants.PROPERTY_VALUE);
            String type = jsonObject.optString(Constants.PROPERTY_TYPE);
            PropertyParserFactory.getPropertyParser(property).parse(view, property, value, type);
        }
    }

}
