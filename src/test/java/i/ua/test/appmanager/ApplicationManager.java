package i.ua.test.appmanager;

import i.ua.test.model.Email;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager extends EmailHelper{

    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        login("ittest2", "337774a");
    }

    public void login(String user, String password) {
        driver.get("https://www.i.ua/");
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys(user);
        driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
        driver.findElement(By.xpath("//p//input[@type='submit']")).click();
    }

    public void createEmail(Email email) {
        typeTo(email.getTo());
        typeSubject(email.getSubject());
        typeEmailText(email.getEmailText());
    }

    public void acceptAllert() {
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}
