package i.ua.test.tests;

import i.ua.test.appmanager.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeTest
    public void setupTest() {
        app.init();
    }

    @AfterTest
    public void teardown() {
        app.stop();
    }

}
