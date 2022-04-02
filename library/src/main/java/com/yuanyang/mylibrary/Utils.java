package com.yuanyang.mylibrary;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.ViewGroup;

public class Utils {

    public static int string2Int(String str) throws Exception {
        return Integer.parseInt(str);
    }

    public static boolean string2Boolean(String str) throws Exception {
        return Boolean.parseBoolean(str);
    }

    public static int string2Color(String color) {
        if (color.startsWith("0x")) {
            return (int) Long.parseLong(color.substring(2), 16);
        }
        return Color.parseColor(color);
    }

    public static int dp2px(final Context context, final float dpValue) {
        if (context == null) {
            return -1;
        }
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static float sp2px(float sp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, Resources.getSystem().getDisplayMetrics());
    }

    public static int deviceWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static float convertDimenToPixel(Context context, String dimen) {
        if (dimen.endsWith("dp"))
            return dp2px(context, Float.parseFloat(dimen.substring(0, dimen.length() - 2)));
        else if (dimen.endsWith("sp"))
            return sp2px(Float.parseFloat(dimen.substring(0, dimen.length() - 2)));
        else if (dimen.endsWith("px"))
            return Integer.parseInt(dimen.substring(0, dimen.length() - 2));
        else if (dimen.endsWith("%"))
            return (int) (Float.parseFloat(dimen.substring(0, dimen.length() - 1)) / 100f * deviceWidth());
        else if (dimen.equalsIgnoreCase("match_parent"))
            return ViewGroup.LayoutParams.MATCH_PARENT;
        else if (dimen.equalsIgnoreCase("wrap_content"))
            return ViewGroup.LayoutParams.WRAP_CONTENT;
        else
            return Integer.parseInt(dimen);
    }
}
