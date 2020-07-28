package i.ua.test.tests;

import i.ua.test.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeTest
    public void setupTest() throws IOException {
        app.init();
    }

    @AfterTest
    public void teardown() {
        app.stop();
    }

}
