package com.xebia.xboson;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Modifier;
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
    public void shouldConvertADocument() throws IOException {

        ParsedDocument doc = parseDocument(new File("src/test/resources/parsertest.html"));
        List<ParsedElement> elements = doc.getElements();
        assertThat(elements.size(), is(1));
        assertThat(elements.get(0).getSelector(), is("input[name=testname]"));

        TypeSpec helloWorld = TypeSpec.classBuilder("FirstPage")
                .addModifiers(Modifier.PUBLIC)
                .addMethod(createElement(elements.get(0).getIdentifier(), elements.get(0).getSelector()))
                .build();

        JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
                .build();

        javaFile.writeTo(System.out);


    }

    @Test
    public void shouldConvertADocumentWithTwoFields() throws IOException {

        ParsedDocument doc = parseDocument(new File("src/test/resources/twoInputFields.html"));
        List<ParsedElement> elements = doc.getElements();
        assertThat(elements.size(), is(2));
        assertThat(elements.get(0).getSelector(), is("input[name=foo]"));

        TypeSpec.Builder classBuilder = TypeSpec.classBuilder("FirstPage2")
                .addModifiers(Modifier.PUBLIC);

        for (ParsedElement element : elements) {
            classBuilder.addMethod(createElement(element.getIdentifier(), element.getSelector()));
        }
        TypeSpec helloWorld = classBuilder.build();

        JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
                .build();

        javaFile.writeTo(System.out);


    }


    @Test
    public void convertTags() throws IOException {

        ParsedDocument doc = parseDocument(new File("src/test/resources/supportedFields.html"));
        List<ParsedElement> elements = doc.getElements();

        assertThat(elements.size(), is(4));

        TypeSpec.Builder classBuilder = TypeSpec.classBuilder("FirstPage3")
                .addModifiers(Modifier.PUBLIC);

        for (ParsedElement element : elements) {
            classBuilder.addMethod(createElement(element.getIdentifier(), element.getSelector()));
        }
        TypeSpec helloWorld = classBuilder.build();

        JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
                .build();

        javaFile.writeTo(System.out);

    }



    private static MethodSpec createElement(String name, String selector) {
        return MethodSpec.methodBuilder(name)
                .addModifiers(Modifier.PUBLIC,Modifier.STATIC)
                .returns(WebElement.class)
                .addStatement("return driver.findElement(By.cssSelector(\""+selector+"\")")
                .build();
    }

    private ParsedDocument parseDocument(File input) throws IOException {
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
        return new ParsedDocument(doc);
    }

}
