package com.yuanyang.xml2json;

import com.google.gson.Gson;

import java.io.File;
import java.io.PrintWriter;

public class Xml2Json {

    private final File xmlFile;
    private final File jsonFile;

    public Xml2Json(File xmlFile, File jsonFile) {
        this.xmlFile = xmlFile;
        this.jsonFile = jsonFile;
    }

    public void startConvert() throws Exception {
        Node node = new LayoutXmlParser(xmlFile).parse();
        String json = new Gson().toJson(node);
        PrintWriter printWriter = new PrintWriter(jsonFile);
        printWriter.write(json);
        printWriter.flush();
        printWriter.close();
    }
}
