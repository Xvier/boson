package com.xebia.xboson

import java.util.Optional
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class IdSelectionRule : SelectionRule {
    override fun match(document: Document, element: Element): ParsedElement? {
        val id = element.id()
        if ("" == id) {
            return null
        }
        val cssQuery = String.format("#%s", id)
        val found = document.select(cssQuery)
        if (found.size == 1) {
            return ParsedElement(id, cssQuery)
        } else {
            return null
        }
    }
}
