package com.yuanyang.xml2json;

import java.io.File;

public class MyClass {

    public static void main(String[] args) {
        File xmlFile = new File("D:\\demo\\Json2ViewJava\\app\\src\\main\\res\\layout\\activity_main.xml");
        File jsonFile = null;
        try {
            Node node = new LayoutXmlParser(xmlFile).parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}