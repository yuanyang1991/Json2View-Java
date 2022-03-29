package com.yuanyang.mylibrary.parser;

import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.yuanyang.base.PropertyItem;
import com.yuanyang.base.PropertyType;
import com.yuanyang.mylibrary.Constants;
import com.yuanyang.mylibrary.Property;
import com.yuanyang.mylibrary.ResourceLoader;
import com.yuanyang.mylibrary.Utils;

public class TextViewPropertyBindHandler implements PropertyBindHandler {


    @Override
    public void parse(View v, Property p) throws Exception {
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
                    textView.setTypeface(null, Utils.string2Int(value));
                    break;
                case PropertyItem.LINES:
                    textView.setLines(Utils.string2Int(value));
                    break;
                case PropertyItem.SINGLE_LINE:
                    textView.setSingleLine(Utils.string2Boolean(value));
                    break;
            }
        }
    }

    private void applyTextColor(String value, String type, TextView textView) throws Exception {
        switch (type) {
            case PropertyType.TYPE_COLOR:
                textView.setTextColor(Utils.string2Color(value));
                break;
            case PropertyType.TYPE_COLOR_REF:
                textView.setTextColor(ResourceLoader.getColorId(textView.getContext(), value));
        }

    }

    private void applyText(String value, String type, TextView textView) {
        if (PropertyType.TYPE_STRING.equals(type)) {
            textView.setText(value);
        } else if (PropertyType.TYPE_STRING_REF.equals(type)) {
            int resId = ResourceLoader.getStringId(textView.getContext(), value);
            textView.setText(resId);
        }
    }
}
