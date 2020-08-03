package i.ua.test.tests;

import i.ua.test.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

@Listeners(MyTestListener.class)
public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeTest
    public void setupTest(ITestContext context) throws IOException {
        app.init();
        context.setAttribute("app", app);
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart(Method method) {
        logger.info("Start test " + method.getName());
    }

    @AfterMethod
    public void logTestStop(Method method) {
        logger.info("Finished test " + method.getName());
    }

}
