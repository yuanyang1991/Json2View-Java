package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yuanyang.mylibrary.Property;
import com.yuanyang.mylibrary.Utils;

public class LayoutWeightPropertyBindHandler implements PropertyBindHandler {
    @Override
    public void parse(View v, Property pro) throws Exception {
        String value = pro.value;
        ViewGroup.LayoutParams p = v.getLayoutParams();
        if (p instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) p).weight = Utils.string2Int(value);
        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(p);
            layoutParams.weight = Utils.string2Int(value);
            p = layoutParams;
            v.setLayoutParams(p);
        }
    }
}
