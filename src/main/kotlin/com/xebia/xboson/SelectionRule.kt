package com.xebia.xboson

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

import java.util.Optional

interface SelectionRule {

    fun match(document: Document, element: Element): ParsedElement?
}
