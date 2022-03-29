package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.view.ViewGroup;

import com.yuanyang.mylibrary.Property;

import java.lang.reflect.Method;

public class GravityPropertyBindHandler implements PropertyBindHandler {


    @Override
    public void bind(View v, Property p, ViewGroup parent) throws Exception {
        Class clz = v.getClass();
        Method m = clz.getMethod("setGravity", Integer.TYPE);
        m.invoke(v, GravityUtils.gravityStringToInt(p.value));
    }
}
