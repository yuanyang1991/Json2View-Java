package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.widget.TextView;

import com.yuanyang.mylibrary.Constants;
import com.yuanyang.mylibrary.ResourceLoader;
import com.yuanyang.mylibrary.Utils;

public class TextViewParser implements Parser {


    @Override
    public void parse(View v, String property, String value, String type) throws Exception {
        if (v instanceof TextView) {
            TextView textView = (TextView) v;
            switch (property) {
                case Parser.TEXT_SIZE:
                    textView.setTextSize(Utils.convertDimenToPixel(v.getContext(), value));
                    break;
                case Parser.FONT_FAMILY:

                    break;
                case Parser.TEXT:
                    applyText(value, type, textView);
                    break;
                case Parser.TEXT_COLOR:
                    applyTextColor(value, type, textView);
                    break;
                case Parser.TEXT_STYLE:
                    textView.setTypeface(null, Utils.string2Int(value));
                    break;
                case Parser.LINES:
                    textView.setLines(Utils.string2Int(value));
                    break;
                case Parser.SINGLE_LINE:
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
