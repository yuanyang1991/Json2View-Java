package com.yuanyang.mylibrary.parser;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.yuanyang.base.PropertyItem;
import com.yuanyang.base.PropertyType;
import com.yuanyang.mylibrary.Property;
import com.yuanyang.mylibrary.parser.internal.IdMapper;

import java.util.HashMap;
import java.util.Map;

public class RelativeLayoutPropertyBindHandler implements PropertyBindHandler {

    private static final Map<String, Integer> map = new HashMap<>();

    static {
        map.put(PropertyItem.LAYOUT_ABOVE, RelativeLayout.ABOVE);
        map.put(PropertyItem.LAYOUT_BELOW, RelativeLayout.BELOW);

        map.put(PropertyItem.LAYOUT_TO_START_OF, RelativeLayout.START_OF);
        map.put(PropertyItem.LAYOUT_TO_END_OF, RelativeLayout.END_OF);

        map.put(PropertyItem.LAYOUT_ALIGN_START, RelativeLayout.ALIGN_START);
        map.put(PropertyItem.LAYOUT_ALIGN_END, RelativeLayout.ALIGN_END);
        map.put(PropertyItem.LAYOUT_ALIGN_TOP, RelativeLayout.ALIGN_TOP);
        map.put(PropertyItem.LAYOUT_ALIGN_BOTTOM, RelativeLayout.ALIGN_BOTTOM);
        map.put(PropertyItem.LAYOUT_ALIGN_BASELINE, RelativeLayout.ALIGN_BASELINE);

        map.put(PropertyItem.LAYOUT_ALIGN_PARENT_START, RelativeLayout.ALIGN_PARENT_START);
        map.put(PropertyItem.LAYOUT_ALIGN_PARENT_END, RelativeLayout.ALIGN_PARENT_END);
        map.put(PropertyItem.LAYOUT_ALIGN_PARENT_TOP, RelativeLayout.ALIGN_PARENT_TOP);
        map.put(PropertyItem.LAYOUT_ALIGN_PARENT_BOTTOM, RelativeLayout.ALIGN_PARENT_BOTTOM);

        map.put(PropertyItem.LAYOUT_CENTER_IN_PARENT, RelativeLayout.CENTER_IN_PARENT);

        map.put(PropertyItem.LAYOUT_CENTER_HORIZONTAL, RelativeLayout.CENTER_HORIZONTAL);
        map.put(PropertyItem.LAYOUT_CENTER_VERTICAL, RelativeLayout.CENTER_VERTICAL);
    }

    @Override
    public void bind(View v, Property p, ViewGroup parent) throws Exception {
        Integer rule = map.get(p.property);
        if (rule != null) {
            ViewGroup.LayoutParams params = v.getLayoutParams();
            RelativeLayout.LayoutParams newParams = null;
            if (!(params instanceof RelativeLayout.LayoutParams)) {
                newParams = new RelativeLayout.LayoutParams(params);
                v.setLayoutParams(newParams);
            } else {
                newParams = (RelativeLayout.LayoutParams) params;
            }
            String value = p.value;
            String type = p.type;
            if (PropertyType.TYPE_BOOLEAN.equalsIgnoreCase(type)) {
                newParams.addRule(rule);
            } else {
                Integer id = IdMapper.getInstance().get(value);
                if (id != null) {
                    newParams.addRule(rule, id);
                }
            }
            v.setLayoutParams(newParams);
        }
    }
}
