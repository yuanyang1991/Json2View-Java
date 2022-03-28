package com.yuanyang.mylibrary.parser;

import java.util.HashMap;

public class PropertyParserFactory {

    private static final String KEY_PADDING = "padding";
    private static final String KEY_MARGIN = "margin";

    private static final HashMap<String, Parser> CACHED_PARSER = new HashMap<>();

    public static Parser getPropertyParser(String property) {
        String key = getParserKey(property);
        if (CACHED_PARSER.containsKey(key)) {
            return CACHED_PARSER.get(key);
        } else {
            Parser propertyParser = getPropertyParserInner(key);
            CACHED_PARSER.put(key, propertyParser);
            return propertyParser;
        }
    }

    private static Parser getPropertyParserInner(String key) {
        switch (key) {
            case KEY_PADDING:
                return new PaddingParser();
            case KEY_MARGIN:
                return new MarginParser();
            case Parser.LAYOUT_WIDTH:
            case Parser.LAYOUT_HEIGHT:
                return new LayoutSizeParser();
            case Parser.LAYOUT_WEIGHT:
                return new LayoutWeightParser();
            case Parser.WEIGHT_SUM:
                return new WeightSumParser();
            case Parser.ORIENTATION:
                return new OrientationParser();
            case Parser.LAYOUT_GRAVITY:
                return new LayoutGravityParser();
            case Parser.LAYOUT_TO_START_OF:
            case Parser.LAYOUT_TO_END_OF:
                return new RelativeLayoutPropertyParser();
            case Parser.TEXT_COLOR:
            case Parser.TEXT_SIZE:
            case Parser.TYPEFACE:
            case Parser.TEXT_STYLE:
            case Parser.TEXT:
            case Parser.FONT_FAMILY:
                return new TextViewParser();
            case Parser.SRC:
            case Parser.SCALE_TYPE:
                return new ImageViewParser();
            case Parser.BACKGROUND:
                return new CommonViewParser();
            default:
                return new EmptyParser();
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
