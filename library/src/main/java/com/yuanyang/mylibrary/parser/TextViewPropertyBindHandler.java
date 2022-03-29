package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.widget.TextView;

import com.yuanyang.mylibrary.Constants;
import com.yuanyang.mylibrary.ResourceLoader;
import com.yuanyang.mylibrary.Utils;

public class TextViewPropertyBindHandler implements PropertyBindHandler {


    @Override
    public void parse(View v, String property, String value, String type) throws Exception {
        if (v instanceof TextView) {
            TextView textView = (TextView) v;
            switch (property) {
                case PropertyBindHandler.TEXT_SIZE:
                    textView.setTextSize(Utils.convertDimenToPixel(v.getContext(), value));
                    break;
                case PropertyBindHandler.FONT_FAMILY:

                    break;
                case PropertyBindHandler.TEXT:
                    applyText(value, type, textView);
                    break;
                case PropertyBindHandler.TEXT_COLOR:
                    applyTextColor(value, type, textView);
                    break;
                case PropertyBindHandler.TEXT_STYLE:
                    textView.setTypeface(null, Utils.string2Int(value));
                    break;
                case PropertyBindHandler.LINES:
                    textView.setLines(Utils.string2Int(value));
                    break;
                case PropertyBindHandler.SINGLE_LINE:
                    textView.setSingleLine(Utils.string2Boolean(value));
                    break;
            }
        }
    }

    private void applyTextColor(String value, String type, TextView textView) throws Exception {
        textView.setTextColor(Utils.string2Color(value));
    }

    private void applyText(String value, String type, TextView textView) {
        if (Constants.TYPE_STRING.equals(type)) {
            textView.setText(value);
        } else if (Constants.TYPE_REF.equals(type)) {
            int resId = ResourceLoader.getStringId(textView.getContext(), value);
            textView.setText(resId);
        }
    }
}
