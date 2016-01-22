package com.xebia.xboson;

import org.jsoup.nodes.Element;

/**
 * Created by xviuda on 22-01-16.
 */
public class ParsedElement {
    private final Element element;

    public ParsedElement(Element e) {
        this.element = e;
    }

    public String name() {
        return element.tagName() + "@name=" + element.attr("name");
    }
}
