package i.ua.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{
    private WebDriver driver;

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String password) {
        driver.get("https://www.i.ua/");
        type(user, "//input[@name='login']");
        type(password, "//input[@name='pass']");
        click("//p//input[@type='submit']");
    }
}
