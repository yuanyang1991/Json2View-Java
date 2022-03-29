package com.yuanyang.mylibrary.parser;

import com.yuanyang.base.PropertyItem;

import java.util.HashMap;

public class BindHandlerFactory {

    public static final String KEY_PADDING = "padding";
    public static final String KEY_MARGIN = "layout_margin";
    public static final String KEY_SIZE = "KEY_SIZE";
    public static final String KEY_LAYOUT_WEIGHT = "KEY_LAYOUT_WEIGHT";
    public static final String KEY_WEIGHT_SUM = "KEY_WEIGHT_SUM";
    public static final String KEY_ORIENTATION = "KEY_ORIENTATION";
    public static final String KEY_LAYOUT_GRAVITY = "KEY_LAYOUT_GRAVITY";
    public static final String KEY_TEXTVIEW = "KEY_TEXTVIEW";
    public static final String KEY_IMAGEVIEW = "KEY_IMAGEVIEW";
    public static final String KEY_COMMON = "KEY_COMMON";
    public static final String KEY_GRAVITY = "GRAVITY";
    public static final String KEY_RELATIVELAYOUT = "KEY_RELATIVELAYOUT";
    public static final String KEY_NULL = "KEY_NULL";


    private static final HashMap<String, PropertyBindHandler> CACHED_PARSER = new HashMap<>();

    public static PropertyBindHandler getPropertyParser(String property) {
        String key = getHandlerKey(property);
        if (CACHED_PARSER.containsKey(key)) {
            return CACHED_PARSER.get(key);
        } else {
            PropertyBindHandler propertyPropertyItem = getPropertyParserInner(key);
            CACHED_PARSER.put(key, propertyPropertyItem);
            return propertyPropertyItem;
        }
    }

    private static PropertyBindHandler getPropertyParserInner(String key) {
        switch (key) {
            case KEY_SIZE:
                return new LayoutSizePropertyBindHandler();
            case KEY_LAYOUT_WEIGHT:
                return new LayoutWeightPropertyBindHandler();
            case KEY_WEIGHT_SUM:
                return new WeightSumPropertyBindHandler();
            case KEY_ORIENTATION:
                return new OrientationPropertyBindHandler();
            case KEY_LAYOUT_GRAVITY:
                return new LayoutGravityPropertyBindHandler();
            case KEY_TEXTVIEW:
                return new TextViewPropertyBindHandler();
            case KEY_IMAGEVIEW:
                return new ImageViewPropertyBindHandler();
            case KEY_COMMON:
                return new CommonViewPropertyBindHandler();
            case KEY_GRAVITY:
                return new GravityPropertyBindHandler();
            case KEY_RELATIVELAYOUT:
                return new RelativeLayoutPropertyBindHandler();
            default:
                return new EmptyPropertyBindHandler();
        }
    }

    private static String getHandlerKey(String property) {
        switch (property) {
            case PropertyItem.LAYOUT_WIDTH:
            case PropertyItem.LAYOUT_HEIGHT:
                return KEY_SIZE;
            case PropertyItem.LAYOUT_WEIGHT:
                return KEY_LAYOUT_WEIGHT;
            case PropertyItem.WEIGHT_SUM:
                return KEY_WEIGHT_SUM;
            case PropertyItem.ORIENTATION:
                return KEY_ORIENTATION;
            case PropertyItem.LAYOUT_GRAVITY:
                return KEY_LAYOUT_GRAVITY;
            case PropertyItem.TEXT_COLOR:
            case PropertyItem.TEXT_SIZE:
            case PropertyItem.TYPEFACE:
            case PropertyItem.TEXT_STYLE:
            case PropertyItem.TEXT:
            case PropertyItem.FONT_FAMILY:
            case PropertyItem.DRAWABLE_BOTTOM:
            case PropertyItem.DRAWABLE_TOP:
            case PropertyItem.DRAWABLE_START:
            case PropertyItem.DRAWABLE_END:
            case PropertyItem.DRAWABLE_PADDING:
                return KEY_TEXTVIEW;
            case PropertyItem.SRC:
            case PropertyItem.SCALE_TYPE:
                return KEY_IMAGEVIEW;
            case PropertyItem.BACKGROUND:
            case PropertyItem.ID:
            case PropertyItem.PADDING:
            case PropertyItem.PADDING_START:
            case PropertyItem.PADDING_END:
            case PropertyItem.PADDING_TOP:
            case PropertyItem.PADDING_BOTTOM:
            case PropertyItem.MARGIN:
            case PropertyItem.MARGIN_START:
            case PropertyItem.MARGIN_END:
            case PropertyItem.MARGIN_TOP:
            case PropertyItem.MARGIN_BOTTOM:
            case PropertyItem.VISIBILITY:
                return KEY_COMMON;
            case PropertyItem.GRAVITY:
                return KEY_GRAVITY;
            case PropertyItem.LAYOUT_ABOVE:
            case PropertyItem.LAYOUT_BELOW:
            case PropertyItem.LAYOUT_TO_START_OF:
            case PropertyItem.LAYOUT_TO_END_OF:
            case PropertyItem.LAYOUT_ALIGN_START:
            case PropertyItem.LAYOUT_ALIGN_END:
            case PropertyItem.LAYOUT_ALIGN_TOP:
            case PropertyItem.LAYOUT_ALIGN_BOTTOM:
            case PropertyItem.LAYOUT_ALIGN_BASELINE:
            case PropertyItem.LAYOUT_ALIGN_PARENT_TOP:
            case PropertyItem.LAYOUT_ALIGN_PARENT_START:
            case PropertyItem.LAYOUT_ALIGN_PARENT_BOTTOM:
            case PropertyItem.LAYOUT_ALIGN_PARENT_END:
            case PropertyItem.LAYOUT_CENTER_IN_PARENT:
            case PropertyItem.LAYOUT_CENTER_HORIZONTAL:
            case PropertyItem.LAYOUT_CENTER_VERTICAL:
                return KEY_RELATIVELAYOUT;
            default:
                return KEY_NULL;
        }
    }
}
