package com.yuanyang.mylibrary;

import android.view.View;

import com.yuanyang.mylibrary.click.ClickHandler;

public class GlobalOnClickListener implements View.OnClickListener {

    private GlobalOnClickListener() {
    }

    public static final GlobalOnClickListener INSTANCE = new GlobalOnClickListener();

    @Override
    public void onClick(View v) {
        String method = (String) v.getTag(R.id.tag_key_onclick);
        String data = (String) v.getTag();
        ClickHandler.getInstance().handleClick(v, method, data);
    }
}
