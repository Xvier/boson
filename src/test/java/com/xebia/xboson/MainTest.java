package com.xebia.xboson;

import java.io.IOException;
import org.junit.Test;

public class MainTest {

    @Test
    public void runMain() throws IOException {
        Main.main(new String[] { "src/test/resources/parsertest.html" });
    }
}
