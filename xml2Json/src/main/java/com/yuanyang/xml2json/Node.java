package com.yuanyang.xml2json;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String widget;
    private List<Property> properties;
    private List<Node> children;

    public Node(String widget, List<Property> properties) {
        this.widget = widget; 
        this.properties = properties;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public String getWidget() {
        return widget;
    }

    public void setWidget(String widget) {
        this.widget = widget;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public void addChild(Node node) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(node);
    }
}
