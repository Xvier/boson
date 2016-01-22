package com.xebia.xboson;

import java.util.Optional;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class IdSelectionRule implements SelectionRule {
    @Override
    public Optional<ParsedElement> match(Document document, Element element) {
        String id = element.id();
        if ("".equals(id)) {
            return Optional.empty();
        }
        String cssQuery = String.format("#%s", id);
        Elements found = document.select(cssQuery);
        if (found.size() == 1) {
            return Optional.of(new ParsedElement(id, cssQuery));
        }else {
            return Optional.empty();
        }
    }
}
