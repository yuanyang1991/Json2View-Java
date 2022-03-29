package com.yuanyang.mylibrary;

import android.content.Context;

public class ResourceLoader {

    private static final String RES_TYPE_STRING = "string";
    private static final String RES_TYPE_DRAWABLE = "drawable";

    public static int getStringId(Context context, String name) {
        return context.getResources().getIdentifier(name, RES_TYPE_STRING, context.getPackageName());
    }

    public static int getDrawableId(Context context, String name) {
        return context.getResources().getIdentifier(name, RES_TYPE_DRAWABLE, context.getPackageName());
    }

}
