package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.yuanyang.mylibrary.Property;

public class LayoutGravityPropertyBindHandler implements PropertyBindHandler {

    @Override
    public void parse(View v, Property p) throws Exception {
        ViewParent viewParent = v.getParent();
        ViewGroup.LayoutParams params = v.getLayoutParams();
        if (viewParent instanceof LinearLayout) {
            LinearLayout.LayoutParams newParams = null;
            if (params instanceof LinearLayout.LayoutParams) {
                newParams = (LinearLayout.LayoutParams) params;
            } else {
                newParams = new LinearLayout.LayoutParams(params);
            }
            newParams.gravity = GravityUtils.gravityStringToInt(p.property);
            v.setLayoutParams(newParams);
        } else if (viewParent instanceof FrameLayout) {
            FrameLayout.LayoutParams newParams = null;
            if (params instanceof FrameLayout.LayoutParams) {
                newParams = (FrameLayout.LayoutParams) params;
            } else {
                newParams = new FrameLayout.LayoutParams(params);
            }
            newParams.gravity = GravityUtils.gravityStringToInt(p.property);
            v.setLayoutParams(newParams);
        }
    }
}
