package com.yuanyang.mylibrary.parser;

import android.view.View;

import com.yuanyang.mylibrary.Constants;
import com.yuanyang.mylibrary.ResourceLoader;
import com.yuanyang.mylibrary.Utils;

public class CommonViewParser implements Parser {


    @Override
    public void parse(View v, String property, String value, String type) throws Exception {
        if (property.equals(Parser.BACKGROUND)) {
            applyBackground(v, property, value, type);
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
