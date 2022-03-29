package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.yuanyang.mylibrary.Property;

public class LayoutGravityPropertyBindHandler implements PropertyBindHandler {

    @Override
    public void bind(View v, Property p, ViewGroup parent) throws Exception {
        ViewGroup.LayoutParams params = v.getLayoutParams();
        if (parent instanceof LinearLayout) {
            LinearLayout.LayoutParams newParams = null;
            if (params instanceof LinearLayout.LayoutParams) {
                newParams = (LinearLayout.LayoutParams) params;
            } else {
                newParams = new LinearLayout.LayoutParams(params);
            }
            newParams.gravity = GravityUtils.gravityStringToInt(p.value);
            v.setLayoutParams(newParams);
        } else if (parent instanceof FrameLayout) {
            FrameLayout.LayoutParams newParams = null;
            if (params instanceof FrameLayout.LayoutParams) {
                newParams = (FrameLayout.LayoutParams) params;
            } else {
                newParams = new FrameLayout.LayoutParams(params);
            }
            newParams.gravity = GravityUtils.gravityStringToInt(p.value);
            v.setLayoutParams(newParams);
        }
    }
}
