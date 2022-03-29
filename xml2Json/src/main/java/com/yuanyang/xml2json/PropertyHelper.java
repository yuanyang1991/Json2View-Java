package com.yuanyang.xml2json;

public class PropertyHelper {

    public static Property createPropertyItem(String propertyName, String propertyValue) {
        String upperCase = propertyName.toUpperCase();
        String type = null;
        String value = propertyValue;
        switch (upperCase) {
            case "ID":
            case "LAYOUT_ABOVE":
            case "LAYOUT_ALIGNBASELINE":
            case "LAYOUT_ALIGNBOTTOM":
            case "LAYOUT_ALIGNEND":
            case "LAYOUT_ALIGNLEFT":
            case "LAYOUT_ALIGNRIGHT":
            case "LAYOUT_ALIGNSTART":
            case "LAYOUT_ALIGNTOP":
            case "LAYOUT_BELOW":
            case "LAYOUT_TOENDOF":
            case "LAYOUT_TOLEFTOF":
            case "LAYOUT_TORIGHTOF":
            case "LAYOUT_TOSTARTOF":
                type = "ref";
                try {
                    value = propertyValue.split("/")[1];
                } catch (Exception e) {
                }
                break;
            case "BACKGROUND":
            case "TEXTCOLOR":
                type = "color";
                break;
            case "LAYOUT_WIDTH":
            case "LAYOUT_HEIGHT":
            case "PADDING_LEFT":
            case "PADDING_RIGHT":
            case "PADDING_TOP":
            case "PADDING_BOTTOM":
            case "PADDING":
            case "TEXTSIZE":
            case "LAYOUT_MARGINLEFT":
            case "LAYOUT_MARGINRIGHT":
            case "LAYOUT_MARGINTOP":
            case "LAYOUT_MARGINBOTTOM":
            case "LAYOUT_MARGIN":
            case "MINWIDTH":
            case "MINHEIGHT":
                type = "dimen";
                break;
            case "LAYOUT_ALIGNWITHPARENTIFMISSING":
            case "LAYOUT_CENTERHORIZONTAL":
            case "LAYOUT_CENTERINPARENT":
            case "LAYOUT_CENTERVERTICAL":
            case "LAYOUT_ALIGNPARENTBOTTOM":
            case "LAYOUT_ALIGNPARENTEND":
            case "LAYOUT_ALIGNPARENTLEFT":
            case "LAYOUT_ALIGNPARENTRIGHT":
            case "LAYOUT_ALIGNPARENTSTART":
            case "LAYOUT_ALIGNPARENTTOP":
                type = "BOOLEAN";
                break;
            case "LAYOUT_WEIGHT":
                type = "float";
                break;
            case "SCALETYPE":
                value = splitCamelCase(propertyValue).replaceAll(" ", "_");
                break;
        }
        return new Property(propertyName, type, value);
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
