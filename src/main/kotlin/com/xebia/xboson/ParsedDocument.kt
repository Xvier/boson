package com.xebia.xboson

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

import java.util.ArrayList
import java.util.Optional
import java.util.stream.Collectors

class ParsedDocument(private val doc: Document) {
    private val selectionRules = listOf(
        NameSelectionRule(),
        TagSelectionRule(),
        IdSelectionRule()
    )

    // Apply rules to make elements unique
    val elements: List<ParsedElement>
        get() {
            val elements = doc.select("input, button, a, textarea")

//            return elements.map { e -> match(e) } .filterNotNull();
            return elements.asSequence().map { e -> match(e) } .filterNotNull().toList();
        }

    private fun match(e: Element): ParsedElement? {
        return selectionRules.asSequence().map { rule -> rule.match(doc, e) } .filterNotNull().firstOrNull()
//        for (rule in selectionRules) {
//            val m = rule.match(doc, e)
//            if (m != null) {
//                return m
//            }
//        }
//        return null
    }

}
