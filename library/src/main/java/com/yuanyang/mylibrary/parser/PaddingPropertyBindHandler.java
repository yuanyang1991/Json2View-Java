package com.yuanyang.mylibrary.parser;

import android.view.View;

import com.yuanyang.mylibrary.Utils;

public class PaddingPropertyBindHandler implements PropertyBindHandler {

    @Override
    public void parse(View v, String property, String value, String type) throws Exception {
        int padding = (int) Utils.convertDimenToPixel(v.getContext(), value);
        int paddingStart = v.getPaddingStart();
        int paddingEnd = v.getPaddingEnd();
        int paddingTop = v.getPaddingTop();
        int paddingBottom = v.getPaddingBottom();
        if (PropertyBindHandler.PADDING.equals(property)) {
            paddingStart = paddingEnd = paddingTop = paddingBottom = padding;
        } else if (PropertyBindHandler.PADDING_START.equals(property)) {
            paddingStart = padding;
        } else if (PropertyBindHandler.PADDING_END.equals(property)) {
            paddingEnd = padding;
        } else if (PropertyBindHandler.PADDING_TOP.equals(property)) {
            paddingTop = padding;
        } else if (PropertyBindHandler.PADDING_BOTTOM.equals(property)) {
            paddingBottom = padding;
        }
        v.setPadding(paddingStart, paddingTop, paddingEnd, paddingBottom);
    }
}
