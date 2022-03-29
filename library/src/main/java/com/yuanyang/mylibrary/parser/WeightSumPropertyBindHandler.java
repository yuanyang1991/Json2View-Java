package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.widget.LinearLayout;

import com.yuanyang.mylibrary.Utils;

public class WeightSumPropertyBindHandler implements PropertyBindHandler {
    @Override
    public void parse(View v, String property, String value, String type) throws Exception {
        if (v instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) v;
            linearLayout.setWeightSum(Utils.string2Int(value));
        }
    }
}
