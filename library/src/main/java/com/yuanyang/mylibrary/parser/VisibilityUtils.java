package com.yuanyang.mylibrary.parser;

import android.view.View;

public class VisibilityUtils {

    public static int stringToVisibility(String value) {
        if (value.equals("visible")) {
            return View.VISIBLE;
        } else if (value.equals("invisible")) {
            return View.INVISIBLE;
        } else {
            return View.GONE;
        }
    }
}
