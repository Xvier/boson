package com.xebia.xboson;

import org.jsoup.nodes.Document;
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
        return elements.stream().map(ParsedElement::new).collect(Collectors.toList());
    }
}
