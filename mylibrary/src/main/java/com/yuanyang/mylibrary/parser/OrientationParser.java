package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.widget.LinearLayout;

public class OrientationParser implements Parser {

    private static final String HORIZONTAL = "horizontal";
    private static final String VERTICAL = "vertical";

    @Override
    public void parse(View v, String property, String value, String type) throws Exception {
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
