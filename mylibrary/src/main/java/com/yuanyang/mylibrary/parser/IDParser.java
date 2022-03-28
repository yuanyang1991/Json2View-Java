package com.yuanyang.mylibrary.parser;

import android.view.View;

import com.yuanyang.mylibrary.Utils;

public class IDParser implements Parser {

    @Override
    public void parse(View v, String property, String value, String type) throws Exception {
        v.setId(Utils.string2Int(value));
    }
}
