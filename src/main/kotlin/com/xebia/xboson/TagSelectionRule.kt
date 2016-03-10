package com.xebia.xboson

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

import java.util.Optional

class TagSelectionRule : SelectionRule {
    override fun match(document: Document, element: Element): ParsedElement? {
        val tagName = element.tagName()
        val found = document.select(tagName)
        if (found.size == 1) {
            return ParsedElement(tagName, tagName)
        } else {
            return null
        }
    }
}
