package com.yuanyang.xml2json;

import java.io.File;

public class MyClass {

    public static void main(String[] args) {
        File xmlFile = new File("D:\\demo\\Json2ViewJava\\app\\src\\main\\res\\layout\\playground2.xml");
        File jsonFile = new File("D:\\demo\\playground\\playground.json");
        try {
            new Xml2Json(xmlFile, jsonFile).startConvert();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}