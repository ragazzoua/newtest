package i.ua.test.tests;

import i.ua.test.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeTest
    public void setupTest() {
        app.init();
    }

    @AfterTest
    public void teardown() {
        app.stop();
    }

}
