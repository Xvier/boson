package com.xebia.xboson;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Optional;

/**
 * Created by xviuda on 22-01-16.
 */
public class NameSelectionRule implements SelectionRule {
    @Override
    public Optional<ParsedElement> match(Document doc, Element element) {
        String tagName = element.tagName();
        String name = element.attr("name");
        if (name == null) {
            return Optional.empty();
        }
        String cssQuery = String.format("%s[name=%s]", tagName, name);
        Elements found = doc.select(cssQuery);
        if (found.size() == 1) {
            return Optional.of(new ParsedElement(name, cssQuery));
        }else {
            return Optional.empty();
        }
    }
}
