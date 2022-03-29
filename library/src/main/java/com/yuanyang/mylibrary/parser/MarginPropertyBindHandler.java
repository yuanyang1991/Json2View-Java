package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.view.ViewGroup;

import com.yuanyang.mylibrary.Utils;

public class MarginPropertyBindHandler implements PropertyBindHandler {

    @Override
    public void parse(View v, String property, String value, String type) throws Exception {
        ViewGroup.LayoutParams p = v.getLayoutParams();
        int margin = (int) Utils.convertDimenToPixel(v.getContext(), value);
        if (p instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) p;
            int marginStart = marginLayoutParams.getMarginStart();
            int marginEnd = marginLayoutParams.getMarginEnd();
            int marginTop = marginLayoutParams.topMargin;
            int marginBottom = marginLayoutParams.bottomMargin;

            if (property.equals(PropertyBindHandler.MARGIN)) {
                marginStart = marginEnd = marginTop = marginBottom = margin;
            } else if (property.equals(PropertyBindHandler.MARGIN_START)) {
                marginStart = margin;
            } else if (property.equals(PropertyBindHandler.MARGIN_END)) {
                marginEnd = margin;
            } else if (property.equals(PropertyBindHandler.MARGIN_TOP)) {
                marginTop = margin;
            } else if (property.equals(PropertyBindHandler.MARGIN_BOTTOM)) {
                marginBottom = margin;
            }

            marginLayoutParams.leftMargin = marginStart;
            marginLayoutParams.rightMargin = marginEnd;
            marginLayoutParams.topMargin = marginTop;
            marginLayoutParams.bottomMargin = marginBottom;
            marginLayoutParams.setMarginStart(marginStart);
            marginLayoutParams.setMarginEnd(marginEnd);

            v.setLayoutParams(marginLayoutParams);
        }
    }
}
