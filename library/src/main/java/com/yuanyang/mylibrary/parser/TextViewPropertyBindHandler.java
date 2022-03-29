package com.yuanyang.mylibrary.parser;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuanyang.base.PropertyItem;
import com.yuanyang.base.PropertyType;
import com.yuanyang.mylibrary.Property;
import com.yuanyang.mylibrary.ResourceIdFinder;
import com.yuanyang.mylibrary.Utils;

public class TextViewPropertyBindHandler implements PropertyBindHandler {


    @Override
    public void bind(View v, Property p, ViewGroup parent) throws Exception {
        String property = p.property;
        String value = p.value;
        String type = p.type;
        if (v instanceof TextView) {
            TextView textView = (TextView) v;
            switch (property) {
                case PropertyItem.TEXT_SIZE:
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, Utils.convertDimenToPixel(v.getContext(), value));
                    break;
                case PropertyItem.FONT_FAMILY:

                    break;
                case PropertyItem.TEXT:
                    applyText(value, type, textView);
                    break;
                case PropertyItem.TEXT_COLOR:
                    applyTextColor(value, type, textView);
                    break;
                case PropertyItem.TEXT_STYLE:
                    textView.setTypeface(null, parseTextStyle(value));
                    break;
                case PropertyItem.LINES:
                    textView.setLines(Utils.string2Int(value));
                    break;
                case PropertyItem.SINGLE_LINE:
                    textView.setSingleLine(Utils.string2Boolean(value));
                    break;
                case PropertyItem.DRAWABLE_BOTTOM:
                    applyDrawable(textView, PropertyItem.DRAWABLE_BOTTOM, value);
                    break;
                case PropertyItem.DRAWABLE_TOP:
                    applyDrawable(textView, PropertyItem.DRAWABLE_TOP, value);
                    break;
                case PropertyItem.DRAWABLE_START:
                    applyDrawable(textView, PropertyItem.DRAWABLE_START, value);
                    break;
                case PropertyItem.DRAWABLE_END:
                    applyDrawable(textView, PropertyItem.DRAWABLE_END, value);
                    break;
                case PropertyItem.DRAWABLE_PADDING:
                    textView.setCompoundDrawablePadding((int) Utils.convertDimenToPixel(v.getContext(), value));
                    break;
            }
        }
    }

    private void applyDrawable(TextView textView, String property, String value) {
        int drawableRes = ResourceIdFinder.getDrawableId(textView.getContext(), value);
        Drawable drawable = textView.getContext().getResources().getDrawable(drawableRes);
        Drawable[] drawables = textView.getCompoundDrawables();
        switch (property) {
            case PropertyItem.DRAWABLE_START:
                drawables[0] = drawable;
                break;
            case PropertyItem.DRAWABLE_END:
                drawables[2] = drawable;
                break;
            case PropertyItem.DRAWABLE_TOP:
                drawables[1] = drawable;
                break;
            case PropertyItem.DRAWABLE_BOTTOM:
                drawables[3] = drawable;
                break;
        }
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawables[0], drawables[1], drawables[2], drawables[3]);
    }

    private int parseTextStyle(String value) {
        switch (value) {
            case "italic":
                return Typeface.ITALIC;
            case "bold_italic":
                return Typeface.BOLD_ITALIC;
            case "bold":
                return Typeface.BOLD;
            default:
                return Typeface.NORMAL;


        }
    }

    private void applyTextColor(String value, String type, TextView textView) throws Exception {
        switch (type) {
            case PropertyType.TYPE_COLOR:
                textView.setTextColor(Utils.string2Color(value));
                break;
            case PropertyType.TYPE_COLOR_REF:
                int colorId = ResourceIdFinder.getColorId(textView.getContext(), value);
                textView.setTextColor(textView.getContext().getResources().getColor(colorId));
        }

    }

    private void applyText(String value, String type, TextView textView) {
        if (PropertyType.TYPE_STRING.equals(type)) {
            textView.setText(value);
        } else if (PropertyType.TYPE_STRING_REF.equals(type)) {
            int resId = ResourceIdFinder.getStringId(textView.getContext(), value);
            textView.setText(resId);
        }
    }
}
