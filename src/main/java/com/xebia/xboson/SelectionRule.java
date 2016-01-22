package com.xebia.xboson;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Optional;

/**
 * Created by xviuda on 22-01-16.
 */
public interface SelectionRule {

    Optional<ParsedElement> match(Document doc, Element element);
}
