package i.ua.test.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    protected WebDriver driver;
    private Navigationhelper navigationhelper;
    private EmailHelper emailHelper;
    private SessionHelper sessionHelper;

    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        emailHelper = new EmailHelper(driver);
        navigationhelper = new Navigationhelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login("ittest2", "337774a");
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    public EmailHelper getEmailHelper() {
        return emailHelper;
    }

    public Navigationhelper getNavigationhelper() {
        return navigationhelper;
    }
}
