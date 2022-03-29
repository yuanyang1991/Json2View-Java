package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.view.ViewGroup;

import com.yuanyang.mylibrary.Property;
import com.yuanyang.mylibrary.Utils;

public class LayoutSizePropertyBindHandler implements PropertyBindHandler {

    private static final String LAYOUT_MATCH_PARENT = "match_parent";
    private static final String LAYOUT_WRAP_CONTENT = "wrap_content";

    @Override
    public void parse(View v, Property pro) throws Exception {
        String property = pro.property;
        String value = pro.value;
        String type = pro.type;
        ViewGroup.LayoutParams p = v.getLayoutParams();
        if (property.equals(PropertyBindHandler.LAYOUT_WIDTH)) {
            if (value.equals(LAYOUT_MATCH_PARENT)) {
                p.width = ViewGroup.LayoutParams.MATCH_PARENT;
            } else if (value.equals(LAYOUT_WRAP_CONTENT)) {
                p.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            } else {
                p.width = (int) Utils.convertDimenToPixel(v.getContext(), value);
            }
        } else if (property.equals(PropertyBindHandler.LAYOUT_HEIGHT)) {
            if (value.equals(LAYOUT_MATCH_PARENT)) {
                p.height = ViewGroup.LayoutParams.MATCH_PARENT;
            } else if (value.equals(LAYOUT_WRAP_CONTENT)) {
                p.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            } else {
                p.height = (int) Utils.convertDimenToPixel(v.getContext(), value);
            }
        }
        v.setLayoutParams(p);
    }
}
