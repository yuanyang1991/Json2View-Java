package com.yuanyang.mylibrary.parser;

import java.util.HashMap;

public class BindHandlerFactory {

    public static final String KEY_PADDING = "padding";
    public static final String KEY_MARGIN = "margin";

    private static final HashMap<String, PropertyBindHandler> CACHED_PARSER = new HashMap<>();

    public static PropertyBindHandler getPropertyParser(String property) {
        String key = getParserKey(property);
        if (CACHED_PARSER.containsKey(key)) {
            return CACHED_PARSER.get(key);
        } else {
            PropertyBindHandler propertyPropertyBindHandler = getPropertyParserInner(key);
            CACHED_PARSER.put(key, propertyPropertyBindHandler);
            return propertyPropertyBindHandler;
        }
    }

    private static PropertyBindHandler getPropertyParserInner(String key) {
        switch (key) {
            case PropertyBindHandler.LAYOUT_WIDTH:
            case PropertyBindHandler.LAYOUT_HEIGHT:
                return new LayoutSizePropertyBindHandler();
            case PropertyBindHandler.LAYOUT_WEIGHT:
                return new LayoutWeightPropertyBindHandler();
            case PropertyBindHandler.WEIGHT_SUM:
                return new WeightSumPropertyBindHandler();
            case PropertyBindHandler.ORIENTATION:
                return new OrientationPropertyBindHandler();
            case PropertyBindHandler.LAYOUT_GRAVITY:
                return new LayoutGravityPropertyBindHandler();
            case PropertyBindHandler.LAYOUT_TO_START_OF:
            case PropertyBindHandler.LAYOUT_TO_END_OF:
                return new RelativeLayoutPropertyPropertyBindHandler();
            case PropertyBindHandler.TEXT_COLOR:
            case PropertyBindHandler.TEXT_SIZE:
            case PropertyBindHandler.TYPEFACE:
            case PropertyBindHandler.TEXT_STYLE:
            case PropertyBindHandler.TEXT:
            case PropertyBindHandler.FONT_FAMILY:
                return new TextViewPropertyBindHandler();
            case PropertyBindHandler.SRC:
            case PropertyBindHandler.SCALE_TYPE:
                return new ImageViewPropertyBindHandler();
            case PropertyBindHandler.BACKGROUND:
            case PropertyBindHandler.ID:
            case KEY_PADDING:
            case KEY_MARGIN:
                return new CommonViewPropertyBindHandler();
            default:
                return new EmptyPropertyBindHandler();
        }
    }

    private static String getParserKey(String property) {
        if (property.startsWith(KEY_PADDING)) {
            return KEY_PADDING;
        } else if (property.startsWith(KEY_MARGIN)) {
            return KEY_MARGIN;
        } else {
            return property;
        }
    }
}
