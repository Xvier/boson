package com.xebia.xboson;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Optional;

public interface SelectionRule {

    Optional<ParsedElement> match(Document document, Element element);
}
