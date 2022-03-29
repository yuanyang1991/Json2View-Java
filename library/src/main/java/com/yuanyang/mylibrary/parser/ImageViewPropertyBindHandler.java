package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.widget.ImageView;

import com.yuanyang.mylibrary.Constants;
import com.yuanyang.mylibrary.Property;
import com.yuanyang.mylibrary.ResourceLoader;

public class ImageViewPropertyBindHandler implements PropertyBindHandler {

    @Override
    public void parse(View v, Property p) throws Exception {
        String property = p.property;
        String value = p.value;
        String type = p.type;
        if (v instanceof ImageView) {
            ImageView imageView = (ImageView) v;
            if (property.equals(PropertyBindHandler.SRC)) {
                if (type.equals(Constants.TYPE_REF)) {
                    imageView.setImageResource(ResourceLoader.getDrawableId(imageView.getContext(), value));
                }
            } else if (property.equals(PropertyBindHandler.SCALE_TYPE)) {
                if (type.equals(Constants.TYPE_STRING)) {
                    imageView.setScaleType(ImageView.ScaleType.valueOf(value));
                }
            }
        }
    }
}
