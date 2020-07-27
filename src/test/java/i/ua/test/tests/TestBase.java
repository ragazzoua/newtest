package i.ua.test.tests;

import i.ua.test.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.IE);

    @BeforeTest
    public void setupTest() {
        app.init();
    }

    @AfterTest
    public void teardown() {
        app.stop();
    }

}
