package com.xebia.xboson;

import org.jsoup.nodes.Element;

public class ParsedElement {
    private final String identifier;
    private final String selector;

    public ParsedElement(String identifier, String selector) {

        this.identifier = identifier;
        this.selector = selector;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getSelector() {
        return selector;
    }
}
