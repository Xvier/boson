package com.xebia.xboson;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Optional;

public class TagSelectionRule implements SelectionRule {
    @Override
    public Optional<ParsedElement> match(Document document, Element element) {
        String tagName = element.tagName();
        Elements found = document.select(tagName);
        if (found.size() == 1) {
            return Optional.of(new ParsedElement(tagName, tagName));
        }else {
            return Optional.empty();
        }
    }
}
