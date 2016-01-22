package com.xebia.xboson;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by xviuda on 22-01-16.
 */
public class ParsedDocument {
    private List<SelectionRule> selectionRules = new ArrayList<>();
    private final Document doc;

    public ParsedDocument(Document doc) {
        this.doc = doc;
        selectionRules.add(new TagSelectionRule());
        selectionRules.add(new NameSelectionRule());
    }


    public List<ParsedElement> getElements() {
        Elements elements = doc.getElementsByTag("input");


        // Apply rules to make elements unique

        return elements.stream().map(this::match).filter(e -> e != null).collect(Collectors.toList());
    }

    ParsedElement match(Element e) {
        for (SelectionRule rule : selectionRules) {
            Optional<ParsedElement> m = rule.match(doc, e);
            if (m.isPresent()) {
                return m.get();
            }
        }
        return null;
    }
}
