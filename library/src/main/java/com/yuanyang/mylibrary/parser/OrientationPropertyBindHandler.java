package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yuanyang.mylibrary.Property;

public class OrientationPropertyBindHandler implements PropertyBindHandler {

    private static final String HORIZONTAL = "horizontal";
    private static final String VERTICAL = "vertical";

    @Override
    public void bind(View v, Property p, ViewGroup parent) throws Exception {
        String value = p.value;
        if (v instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) v;
            if (value.equalsIgnoreCase(HORIZONTAL)) {
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            } else if (value.equalsIgnoreCase(VERTICAL)) {
                linearLayout.setOrientation(LinearLayout.VERTICAL);
            }
        }
    }
}
