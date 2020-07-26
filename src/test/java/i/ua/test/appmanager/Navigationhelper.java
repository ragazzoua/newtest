package i.ua.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigationhelper {


    private WebDriver driver;

    public Navigationhelper(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDraft() {
        driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[2]/div[1]/div[2]/div[3]/ul/li[3]/a")).click();
    }
}
