package test;

import base.Base;
import globalResource.GLOBALSTATIC;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestClass extends Base {
    @Test
        public void setup() throws IOException, InterruptedException {
            launchBrowser();
    }
    @Test
        public void testTearDown()throws IOException, InterruptedException {
        GLOBALSTATIC.driver.close();

    }

}




