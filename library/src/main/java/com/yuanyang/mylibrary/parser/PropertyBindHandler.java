package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.view.ViewGroup;

import com.yuanyang.mylibrary.Property;

public interface PropertyBindHandler {

    void bind(View v, Property p, ViewGroup parent) throws Exception;


}
