package com.xebia.xboson;

import java.io.IOException;
import org.junit.Test;

public class MainTest {

    @Test
    public void runMain() throws IOException {
        Main.main("src/test/resources/parsertest.html");
    }
}
