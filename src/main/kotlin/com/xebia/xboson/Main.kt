package com.xebia.xboson

import org.jsoup.Jsoup
import java.io.File

object Main {

//    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        if (args.size == 0) {
            usage()
        } else {
            for (arg in args) {
                val file = File(arg)

                if (!file.exists()) {
                    System.err.println("File not found: " + file.path)
                }

                val parsedDocument = parseDocument(file)
                parsedDocument.elements.forEach { element ->
                    // TODO: this is a placeholder for file generation.
                    println(String.format("%s = %s", element.identifier, element.selector))
                }
            }
        }
    }

    fun usage() {
        System.err.println("Usage: java com.xebia.xboson.Main <file..>")
        System.err.println("\tfile: is a of list HTML files.")
    }

//    @Throws(IOException::class)
    private fun parseDocument(input: File): ParsedDocument {
        val doc = Jsoup.parse(input, "UTF-8")
        return ParsedDocument(doc)
    }
}
