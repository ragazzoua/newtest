package i.ua.test.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    protected WebDriver driver;
    private Navigationhelper navigationhelper;
    private EmailHelper emailHelper;
    private SessionHelper sessionHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.CHROME)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
