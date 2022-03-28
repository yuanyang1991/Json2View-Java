package com.yuanyang.mylibrary.parser;

import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;

import com.yuanyang.mylibrary.Utils;

public class OrientationParser implements Parser {

    @Override
    public void parse(View v, String property, String value, String type) throws Exception {
        if (v instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) v;
            if (value.equalsIgnoreCase("horizontal")) {
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            } else if (value.equalsIgnoreCase("vertical")) {
                linearLayout.setOrientation(LinearLayout.VERTICAL);
            }
        }
    }
}
