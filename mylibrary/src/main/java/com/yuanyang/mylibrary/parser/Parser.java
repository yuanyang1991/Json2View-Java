package com.yuanyang.mylibrary.parser;

import android.view.View;

public interface Parser {

    String ID = "id";

    String LAYOUT_WIDTH = "layout_width";
    String LAYOUT_HEIGHT = "layout_height";
    String BACKGROUND = "background";

    // padding
    String PADDING_START = "padding_start";
    String PADDING_END = "padding_end";
    String PADDING_TOP = "padding_top";
    String PADDING_BOTTOM = "padding_bottom";
    String PADDING = "padding";

    // margins
    String MARGIN = "margin";
    String MARGIN_START = "margin_start";
    String MARGIN_END = "margin_end";
    String MARGIN_TOP = "margin_top";
    String MARGIN_BOTTOM = "margin_bottom";

    // linearlayout
    String LAYOUT_WEIGHT = "layout_weight";
    String WEIGHT_SUM = "weightSum";
    String ORIENTATION = "orientation";
    String LAYOUT_GRAVITY = "layout_gravity";

    // relativelayout
    String LAYOUT_TO_START_OF = "layout_toStartOf";
    String LAYOUT_TO_END_OF = "layout_toEndOf";
    String LAYOUT_ALIGN_PARENT_TOP = "layout_alignParentTop";
    String LAYOUT_ALIGN_PARENT_START = "layout_alignParentStart";
    String LAYOUT_ALIGN_PARENT_RIGHT = "layout_alignParentRight";
    String LAYOUT_ALIGN_PARENT_END = "layout_alignParentEnd";

    // textview
    String TEXT_SIZE = "textSize";
    String FONT_FAMILY = "fontFamily";
    String TYPEFACE = "typeface";
    String TEXT_STYLE = "textStyle";
    String TEXT_COLOR = "textColor";
    String TEXT = "text";
    String LINES = "lines";
    String SINGLE_LINE = "singleLine";

    // imageview
    String SRC = "src";
    String SCALE_TYPE = "scaleType";


    String VISIBILITY = "visibility";

    void parse(View v, String property, String value, String type) throws Exception;


}
