package com.yuanyang.mylibrary;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import com.yuanyang.mylibrary.click.ClickHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.lang.ref.WeakReference;

public class Json2View {

    private final WeakReference<Activity> mAtyRef;
    private final File f;
    private ClickHandler clickHandler;

    public Json2View(Activity aty, File f) {
        this.mAtyRef = new WeakReference<>(aty);
        this.f = f;
    }

    public void bindClickHandler(ClickHandler clickHandler) {
        this.clickHandler = clickHandler;
    }

    public View parse() throws Exception {
        String json = new StringReader(f).readString();
        JSONObject jsonObject = new JSONObject(json);
        return parseInner(jsonObject, null);
    }

    private View parseInner(JSONObject jsonObject, ViewGroup parent) throws Exception {
        String widgetStr = jsonObject.optString(Constants.WIDGET_NAME);
        View view = ViewFactory.getView(getAttachedActivity(), widgetStr);
        JSONArray properties = jsonObject.optJSONArray(Constants.PROPERTIES_NAME);
        PropertiesHelper.applyProperties(view, properties, parent);
        JSONArray children = jsonObject.optJSONArray(Constants.CHILDREN_NAME);
        if (children != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childLength = children.length();
            for (int i = 0; i < childLength; i++) {
                View child = parseInner(children.optJSONObject(i), viewGroup);
                viewGroup.addView(child);
            }
        }
        return view;
    }

    public Activity getAttachedActivity() {
        return mAtyRef.get();
    }
}
