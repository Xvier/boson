package com.xebia.xboson

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class NameSelectionRule : SelectionRule {
    override fun match(document: Document, element: Element): ParsedElement? {
        val tagName = element.tagName()
        val name = element.attr("name")
        if ("" == name) {
            return null;
        }
        val cssQuery = String.format("%s[name=%s]", tagName, name)
        val found = document.select(cssQuery)
        if (found.size == 1) {
            return ParsedElement(name, cssQuery)
        } else {
            return null
        }
    }
}
