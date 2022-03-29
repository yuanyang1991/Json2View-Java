package com.yuanyang.xml2json;

import com.yuanyang.base.PropertyItem;
import com.yuanyang.base.PropertyType;

public class Helper {

    public static Property createPropertyItem(String propertyName, String propertyValue) {
        String type = null;
        String value = propertyValue;
        switch (propertyName) {
            case PropertyItem.ID:
            case PropertyItem.LAYOUT_ABOVE:
            case PropertyItem.LAYOUT_ALIGN_BASELINE:
            case PropertyItem.LAYOUT_ALIGN_BOTTOM:
            case PropertyItem.LAYOUT_ALIGN_END:
            case PropertyItem.LAYOUT_ALIGN_START:
            case PropertyItem.LAYOUT_ALIGN_TOP:
            case PropertyItem.LAYOUT_BELOW:
            case PropertyItem.LAYOUT_TO_END_OF:
            case PropertyItem.LAYOUT_TO_START_OF:
                type = PropertyType.TYPE_ID_REF;
                value = getRefValue(propertyValue);
                break;
            case PropertyItem.BACKGROUND:
            case PropertyItem.TEXT_COLOR:
                if (value.startsWith("@color")) {
                    type = PropertyType.TYPE_COLOR_REF;
                    value = getRefValue(propertyValue);
                } else {
                    type = PropertyType.TYPE_COLOR;
                }
                break;
            case PropertyItem.LAYOUT_WIDTH:
            case PropertyItem.LAYOUT_HEIGHT:
            case PropertyItem.PADDING_START:
            case PropertyItem.PADDING_END:
            case PropertyItem.PADDING_TOP:
            case PropertyItem.PADDING_BOTTOM:
            case PropertyItem.PADDING:
            case PropertyItem.TEXT_SIZE:
            case PropertyItem.MARGIN_START:
            case PropertyItem.MARGIN_END:
            case PropertyItem.MARGIN_TOP:
            case PropertyItem.MARGIN_BOTTOM:
            case PropertyItem.MARGIN:
            case PropertyItem.MIN_WIDTH:
            case PropertyItem.MIN_HEIGHT:
                type = PropertyType.TYPE_DIMEN;
                break;
            case PropertyItem.LAYOUT_CENTER_HORIZONTAL:
            case PropertyItem.LAYOUT_CENTER_IN_PARENT:
            case PropertyItem.LAYOUT_CENTER_VERTICAL:
            case PropertyItem.LAYOUT_ALIGN_PARENT_BOTTOM:
            case PropertyItem.LAYOUT_ALIGN_PARENT_END:
            case PropertyItem.LAYOUT_ALIGN_PARENT_START:
            case PropertyItem.LAYOUT_ALIGN_PARENT_TOP:
                type = PropertyType.TYPE_BOOLEAN;
                break;
            case PropertyItem.LAYOUT_WEIGHT:
                type = PropertyType.TYPE_FLOAT;
                break;
            case PropertyItem.SCALE_TYPE:
                value = splitCamelCase(propertyValue).replaceAll(" ", "_");
                break;
            case PropertyItem.TEXT:
                if (value.startsWith("@string/")) {
                    type = PropertyType.TYPE_STRING_REF;
                    value = getRefValue(propertyValue);
                } else {
                    type = PropertyType.TYPE_STRING;
                }
                break;
            case PropertyItem.SRC:
                if (value.startsWith("@drawable")) {
                    type = PropertyType.TYPE_DRAWABLE_REF;
                    value = getRefValue(propertyValue);
                } else if (value.startsWith("@color")) {
                    type = PropertyType.TYPE_COLOR_REF;
                    value = getRefValue(propertyValue);
                } else {
                    type = PropertyType.TYPE_COLOR;
                }
                break;
            case PropertyItem.VISIBILITY:
                type = PropertyType.TYPE_STRING;
                break;
        }
        return new Property(propertyName, type, value);
    }

    static String getRefValue(String origin) {
        return origin.split("/")[1];
    }

    static String splitCamelCase(String s) {
        return s.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
    }
}
