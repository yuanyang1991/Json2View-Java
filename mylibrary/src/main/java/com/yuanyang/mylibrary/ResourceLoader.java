package com.yuanyang.mylibrary;

import android.content.Context;

public class ResourceLoader {

    public static int getStringId(Context context, String name) {
        return context.getResources().getIdentifier(name, "string", context.getPackageName());
    }

    public static int getDrawableId(Context context, String name) {
        return context.getResources().getIdentifier(name, "drawable", context.getPackageName());
    }

}
