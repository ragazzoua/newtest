package i.ua.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    protected void type(String text, String locator) {
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }

    protected void click(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }
}
