package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.widget.ImageView;

import com.yuanyang.base.PropertyItem;
import com.yuanyang.base.PropertyType;
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
            if (property.equals(PropertyItem.SRC)) {
                if (type.equals(PropertyType.TYPE_DRAWABLE_REF)) {
                    imageView.setImageResource(ResourceLoader.getDrawableId(imageView.getContext(), value));
                }
            } else if (property.equals(PropertyItem.SCALE_TYPE)) {
                if (type.equals(PropertyType.TYPE_STRING)) {
                    imageView.setScaleType(ImageView.ScaleType.valueOf(value));
                }
            }
        }
    }
}
