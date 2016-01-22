package com.xebia.xboson;

import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

    public static void main(String... args) throws IOException {
        if (args.length == 0) {
            usage();
        } else {
            for (String arg: args) {
                File file = new File(arg);

                // TODO: exists check

                ParsedDocument parsedDocument = parseDocument(file);
                for (ParsedElement element : parsedDocument.getElements()) {
                    // TODO: this is a placeholder for file generation.
                    System.out.println(String.format("%s = %s", element.getIdentifier(), element.getSelector()));
                }
            }
        }
    }

    public static void usage() {
        System.out.println("Usage: java com.xebia.xboson.Main <file..>");
        System.out.println("\tfile: is a list HTML files.");
    }

    private static ParsedDocument parseDocument(File input) throws IOException {
        Document doc = Jsoup.parse(input, "UTF-8");
        return new ParsedDocument(doc);
    }


}
