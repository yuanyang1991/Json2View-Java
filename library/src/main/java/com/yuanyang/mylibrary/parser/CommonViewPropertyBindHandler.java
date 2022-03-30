package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.view.ViewGroup;

import com.yuanyang.base.PropertyItem;
import com.yuanyang.base.PropertyType;
import com.yuanyang.mylibrary.GlobalOnClickListener;
import com.yuanyang.mylibrary.Property;
import com.yuanyang.mylibrary.R;
import com.yuanyang.mylibrary.ResourceIdFinder;
import com.yuanyang.mylibrary.Utils;
import com.yuanyang.mylibrary.parser.internal.IdMapper;

public class CommonViewPropertyBindHandler implements PropertyBindHandler {

    @Override
    public void bind(View v, Property p, ViewGroup parent) throws Exception {
        String property = p.property;
        String value = p.value;
        String type = p.type;
        if (property.equals(PropertyItem.BACKGROUND)) {
            applyBackground(v, property, value, type);
        } else if (property.equals(PropertyItem.ID)) {
            int id = IdMapper.getInstance().nextId();
            v.setId(id);
            IdMapper.getInstance().put(value, id);
        } else if (property.startsWith(PropertyBindHandlerFactory.KEY_MARGIN)) {
            applyMargin(v, property, value, type);
        } else if (property.startsWith(PropertyBindHandlerFactory.KEY_PADDING)) {
            applyPadding(v, property, value, type);
        } else if (property.equals(PropertyItem.VISIBILITY)) {
            v.setVisibility(VisibilityUtils.stringToVisibility(value));
        } else if (property.equals(PropertyItem.ONCLICK)) {
            v.setTag(R.id.tag_key_onclick, value);
            v.setOnClickListener(GlobalOnClickListener.INSTANCE);
        }
    }

    private void applyPadding(View v, String property, String value, String type) {
        int padding = (int) Utils.convertDimenToPixel(v.getContext(), value);
        int paddingStart = v.getPaddingStart();
        int paddingEnd = v.getPaddingEnd();
        int paddingTop = v.getPaddingTop();
        int paddingBottom = v.getPaddingBottom();
        if (PropertyItem.PADDING.equals(property)) {
            paddingStart = paddingEnd = paddingTop = paddingBottom = padding;
        } else if (PropertyItem.PADDING_START.equals(property)) {
            paddingStart = padding;
        } else if (PropertyItem.PADDING_END.equals(property)) {
            paddingEnd = padding;
        } else if (PropertyItem.PADDING_TOP.equals(property)) {
            paddingTop = padding;
        } else if (PropertyItem.PADDING_BOTTOM.equals(property)) {
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

            if (property.equals(PropertyItem.MARGIN)) {
                marginStart = marginEnd = marginTop = marginBottom = margin;
            } else if (property.equals(PropertyItem.MARGIN_START)) {
                marginStart = margin;
            } else if (property.equals(PropertyItem.MARGIN_END)) {
                marginEnd = margin;
            } else if (property.equals(PropertyItem.MARGIN_TOP)) {
                marginTop = margin;
            } else if (property.equals(PropertyItem.MARGIN_BOTTOM)) {
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
            case PropertyType.TYPE_COLOR:
                v.setBackgroundColor(Utils.string2Color(value));
                break;
            case PropertyType.TYPE_DRAWABLE_REF:
                v.setBackgroundResource(ResourceIdFinder.getDrawableId(v.getContext(), value));
                break;
            case PropertyType.TYPE_COLOR_REF:
                v.setBackgroundResource(ResourceIdFinder.getColorId(v.getContext(), value));
                break;
        }
    }
}
