package com.yuanyang.mylibrary;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.lang.ref.WeakReference;

public class Json2View {

    private final WeakReference<Activity> mAtyRef;
    private final File f;

    public Json2View(Activity aty, File f) {
        this.mAtyRef = new WeakReference<>(aty);
        this.f = f;
    }

    public View parse() throws Exception {
        String json = new StringReader(f).readString();
        JSONObject jsonObject = new JSONObject(json);
        return parseInner(jsonObject);
    }

    private View parseInner(JSONObject jsonObject) throws Exception {
        String widgetStr = jsonObject.optString(Constants.WIDGET_NAME);
        View view = ViewFactory.getView(getAttachedActivity(), widgetStr);
        JSONArray properties = jsonObject.optJSONArray(Constants.PROPERTIES_NAME);
        PropertiesHelper.applyProperties(view, properties);
        JSONArray children = jsonObject.optJSONArray(Constants.CHILDREN_NAME);
        if (children != null) {
            ViewGroup parent = (ViewGroup) view;
            int childLength = children.length();
            for (int i = 0; i < childLength; i++) {
                View child = parseInner(children.optJSONObject(i));
                parent.addView(child);
            }
        }
        return view;
    }

    public Activity getAttachedActivity() {
        return mAtyRef.get();
    }
}
