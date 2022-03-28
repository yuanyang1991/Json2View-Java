package com.yuanyang.mylibrary;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

public class StringReader {

    private final static int BUFFER_SIZE = 4 * 1024;

    private final File f;

    public StringReader(File f) {
        this.f = f;
    }

    public String readString() throws Exception {
        Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        StringWriter stringWriter = new StringWriter();
        copy(reader, stringWriter);
        return stringWriter.toString();
    }

    private void copy(Reader reader, StringWriter stringWriter) throws Exception {
        int length = 0;
        char[] buffer = new char[BUFFER_SIZE];
        length = reader.read(buffer);
        while (length != -1) {
            stringWriter.write(buffer, 0, length);
            length = reader.read(buffer);
        }
    }
}
