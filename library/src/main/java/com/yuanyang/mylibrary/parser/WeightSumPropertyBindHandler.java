package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yuanyang.mylibrary.Property;
import com.yuanyang.mylibrary.Utils;

public class WeightSumPropertyBindHandler implements PropertyBindHandler {
    @Override
    public void bind(View v, Property p, ViewGroup parent) throws Exception {
        String value = p.value;
        if (v instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) v;
            linearLayout.setWeightSum(Utils.string2Int(value));
        }
    }
}
