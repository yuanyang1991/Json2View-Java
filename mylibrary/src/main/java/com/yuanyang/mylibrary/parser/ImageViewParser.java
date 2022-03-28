package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.widget.ImageView;

import com.yuanyang.mylibrary.Constants;
import com.yuanyang.mylibrary.ResourceLoader;

public class ImageViewParser implements Parser {

    @Override
    public void parse(View v, String property, String value, String type) throws Exception {
        if (v instanceof ImageView) {
            ImageView imageView = (ImageView) v;
            if (property.equals(Parser.SRC)) {
                if (type.equals(Constants.TYPE_REF)) {
                    imageView.setImageResource(ResourceLoader.getDrawableId(imageView.getContext(), value));
                }
            } else if (property.equals(Parser.SCALE_TYPE)) {
                if (type.equals(Constants.TYPE_STRING)) {
                    imageView.setScaleType(ImageView.ScaleType.valueOf(value));
                }
            }
        }
    }
}
