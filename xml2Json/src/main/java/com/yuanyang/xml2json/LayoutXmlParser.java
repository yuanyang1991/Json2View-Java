package com.yuanyang.xml2json;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class LayoutXmlParser extends DefaultHandler {

    private final File xmlFile;
    private final SAXParser saxParser;
    private Node root;
    private final Stack<Node> stack;

    public LayoutXmlParser(File xmlFile) throws Exception {
        this.xmlFile = xmlFile;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setValidating(false);
        this.saxParser = factory.newSAXParser();
        stack = new Stack<>();
    }

    public Node parse() throws IOException, SAXException {
        saxParser.parse(xmlFile, this);
        return root;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        List<Node.Property> propertyList = parseProperty(attributes);
        Node temp = new Node(localName, propertyList);
        if (stack.size() == 0) {
            root = temp;
        } else {
            Node parent = stack.peek();
            parent.addChild(temp);
        }
        stack.push(temp);
    }

    private List<Node.Property> parseProperty(Attributes attributes) {
        int len = attributes.getLength();
        List<Node.Property> result = new ArrayList<>();
        String key = null;
        String value = null;
        for (int i = 0; i < len; i++) {
            key = attributes.getQName(i);
            value = attributes.getValue(i);
            result.add(new Node.Property(key, value));
        }
        return result;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (stack.size() > 0) {
            stack.pop();
        }
    }
}
