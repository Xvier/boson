package com.xebia.xboson;

import com.squareup.javapoet.TypeSpec;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by xviuda on 22-01-16.
 */
public class ConvertTest {

    @Test
    public void shouldParseADocument() throws IOException {
        ParsedDocument doc = parseDocument(new File("src/test/resources/parsertest.html"));
        List<ParsedElement> elements = doc.getElements();


       // TypeSpec helloWorld = TypeSpec.classBuilder("FirstPage").

        assertThat(elements.size(), is(1));
        assertThat(elements.get(0).getSelector(), is("input[name=testname]"));
    }


    private ParsedDocument parseDocument(File input) throws IOException {
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
        return new ParsedDocument(doc);
    }

}
