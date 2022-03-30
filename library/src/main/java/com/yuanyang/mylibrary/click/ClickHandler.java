package com.yuanyang.mylibrary.click;

import android.view.View;

import java.util.HashMap;
import java.util.Map;

public class ClickHandler {

    private Map<String, Click> map = new HashMap<>();

    private static ClickHandler instance;

    public static ClickHandler getInstance() {
        if (instance == null) {
            instance = new ClickHandler();
        }
        return instance;
    }

    public void registerClick(String action, Click click) {
        map.put(action, click);
    }

    public void unRegister(String action) {
        map.remove(action);
    }

    public void handleClick(View view, String method, String data) {
        Click click = map.get(method);
        if (click == null) {
            return;
        }
        click.onClick(view, data);
    }


}
