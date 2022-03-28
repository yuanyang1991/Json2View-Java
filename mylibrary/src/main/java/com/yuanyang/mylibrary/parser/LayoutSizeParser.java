package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.view.ViewGroup;

import com.yuanyang.mylibrary.Utils;

public class LayoutSizeParser implements Parser {
    @Override
    public void parse(View v, String property, String value, String type) throws Exception {
        ViewGroup.LayoutParams p = v.getLayoutParams();
        if (property.equals(Parser.LAYOUT_WIDTH)) {
            if (value.equals("match_parent")) {
                p.width = ViewGroup.LayoutParams.MATCH_PARENT;
            } else if (value.equals("wrap_content")) {
                p.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            } else {
                p.width = (int) Utils.convertDimenToPixel(v.getContext(), value);
            }
        } else if (property.equals(Parser.LAYOUT_HEIGHT)) {
            if (value.equals("match_parent")) {
                p.height = ViewGroup.LayoutParams.MATCH_PARENT;
            } else if (value.equals("wrap_content")) {
                p.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            } else {
                p.height = (int) Utils.convertDimenToPixel(v.getContext(), value);
            }
        }
        v.setLayoutParams(p);
    }
}
