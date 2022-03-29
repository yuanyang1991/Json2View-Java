package com.yuanyang.mylibrary.parser;

import android.view.Gravity;

public class GravityUtils {

    public static int gravityStringToInt(String gravity) {
        switch (gravity.toUpperCase()) {
            case "TOP":
                return Gravity.TOP;
            case "BOTTOM":
                return Gravity.BOTTOM;
            case "LEFT":
                return Gravity.LEFT;
            case "RIGHT":
                return Gravity.RIGHT;
            case "START":
                return Gravity.START;
            case "END":
                return Gravity.END;
            case "CENTER_VERTICAL":
                return Gravity.CENTER_VERTICAL;
            case "FILL_VERTICAL":
                return Gravity.FILL_VERTICAL;
            case "CENTER_HORIZONTAL":
                return Gravity.CENTER_HORIZONTAL;
            case "FILL_HORIZONTAL":
                return Gravity.FILL_HORIZONTAL;
            case "CENTER":
                return Gravity.CENTER;
            case "FILL":
                return Gravity.FILL;
            default:
                return Gravity.NO_GRAVITY;
        }
    }
}
