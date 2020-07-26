package i.ua.test.appmanager;

import i.ua.test.model.Email;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private final EmailHelper emailHelper = new EmailHelper();

    public void init() {
        WebDriverManager.chromedriver().setup();
        emailHelper.driver = new ChromeDriver();
        emailHelper.driver.manage().window().maximize();
        emailHelper.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        login("ittest2", "337774a");
    }

    public void login(String user, String password) {
        emailHelper.driver.get("https://www.i.ua/");
        emailHelper.driver.findElement(By.xpath("//input[@name='login']")).sendKeys(user);
        emailHelper.driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
        emailHelper.driver.findElement(By.xpath("//p//input[@type='submit']")).click();
    }

    public void createEmail(Email email) {
        emailHelper.typeTo(email.getTo());
        emailHelper.typeSubject(email.getSubject());
        emailHelper.typeEmailText(email.getEmailText());
    }

    public void acceptAllert() {
        try {
            emailHelper.driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

    }

    public void stop() {
        if (emailHelper.driver != null) {
            emailHelper.driver.quit();
        }
        emailHelper.driver = null;
    }

    public EmailHelper getEmailHelper() {
        return emailHelper;
    }
}
