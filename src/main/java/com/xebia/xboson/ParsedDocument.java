package com.xebia.xboson;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xviuda on 22-01-16.
 */
public class ParsedDocument {
    private final Document doc;

    public ParsedDocument(Document doc) {
        this.doc = doc;
    }


    public List<ParsedElement> getElements() {
        Elements elements = doc.getElementsByTag("input");


        // Apply rules to make elements unique

        return elements.stream().map(e -> new ParsedElement(identifier(e), selector(e))).collect(Collectors.toList());
    }

    private String selector(Element e) {
        return null;
    }

    private String identifier(Element e) {
        return null;
    }
}
