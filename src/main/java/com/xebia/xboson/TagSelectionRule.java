package com.xebia.xboson;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Optional;

/**
 * Created by xviuda on 22-01-16.
 */
public class TagSelectionRule implements SelectionRule {
    @Override
    public Optional<ParsedElement> match(Document doc, Element element) {
        String tagName = element.tagName();
        Elements found = doc.select(tagName);
        if (found.size() == 1) {
            return Optional.of(new ParsedElement(tagName, tagName));
        }else {
            return Optional.empty();
        }
    }
}
