package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.view.ViewGroup;

import com.yuanyang.mylibrary.Utils;

public class LayoutSizeParser implements Parser {

    private static final String LAYOUT_MATCH_PARENT = "match_parent";
    private static final String LAYOUT_WRAP_CONTENT = "wrap_content";

    @Override
    public void parse(View v, String property, String value, String type) throws Exception {
        ViewGroup.LayoutParams p = v.getLayoutParams();
        if (property.equals(Parser.LAYOUT_WIDTH)) {
            if (value.equals(LAYOUT_MATCH_PARENT)) {
                p.width = ViewGroup.LayoutParams.MATCH_PARENT;
            } else if (value.equals(LAYOUT_WRAP_CONTENT)) {
                p.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            } else {
                p.width = (int) Utils.convertDimenToPixel(v.getContext(), value);
            }
        } else if (property.equals(Parser.LAYOUT_HEIGHT)) {
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
