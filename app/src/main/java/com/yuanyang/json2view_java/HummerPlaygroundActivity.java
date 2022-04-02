package com.yuanyang.json2view_java;

import com.didi.hummer.HummerActivity;

public class HummerPlaygroundActivity extends HummerActivity {


    @Override
    protected void renderHummer() {
        super.renderHummer();
        hmRender.renderWithFile("/sdcard/playground/helloworld.js");
    }
}
