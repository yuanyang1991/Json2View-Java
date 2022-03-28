package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yuanyang.mylibrary.Utils;

public class LayoutWeightParser implements Parser {
    @Override
    public void parse(View v, String property, String value, String type) throws Exception {
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
