package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.view.ViewGroup;

import com.yuanyang.mylibrary.Constants;
import com.yuanyang.mylibrary.Property;
import com.yuanyang.mylibrary.ResourceLoader;
import com.yuanyang.mylibrary.Utils;
import com.yuanyang.mylibrary.parser.internal.IdMapper;

public class CommonViewPropertyBindHandler implements PropertyBindHandler {


    @Override
    public void parse(View v, Property p) throws Exception {
        String property = p.property;
        String value = p.value;
        String type = p.type;
        if (property.equals(BACKGROUND)) {
            applyBackground(v, property, value, type);
        } else if (property.equals(ID)) {
            int id = IdMapper.getInstance().nextId();
            v.setId(id);
            IdMapper.getInstance().put(value, id);
        } else if (property.startsWith(BindHandlerFactory.KEY_MARGIN)) {
            applyMargin(v, property, value, type);
        } else if (property.startsWith(BindHandlerFactory.KEY_PADDING)) {
            applyPadding(v, property, value, type);
        }
    }

    private void applyPadding(View v, String property, String value, String type) {
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

    private void applyMargin(View v, String property, String value, String type) {
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

    private void applyBackground(View v, String property, String value, String type) {
        switch (type) {
            case Constants.TYPE_COLOR:
                v.setBackgroundColor(Utils.string2Color(value));
                break;
            case Constants.TYPE_REF:
                v.setBackgroundResource(ResourceLoader.getDrawableId(v.getContext(), value));
                break;
            case Constants.TYPE_DRAWABLE:

                break;
        }
    }
}
