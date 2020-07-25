package i.ua.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase extends ApplicationManager {

    @BeforeTest
    public void setupTest() {
        init();
    }

    @AfterTest
    public void teardown() {
        stop();
    }

}
