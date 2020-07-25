package i.ua.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {

    private WebDriver driver;

    @BeforeTest
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        login("ittest2", "337774a");
    }

    private void login(String user, String password) {
        driver.get("https://www.i.ua/");
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys(user);
        driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
        driver.findElement(By.xpath("//p//input[@type='submit']")).click();
    }


    @Test
    public void userCanCreateEmail() {
        clickCreateMessage();
        createEmail(new Email("test@ukr.net", "test@ukr.net", "test@ukr.net"));
        saveInDrafts();
    }

    private void createEmail(Email email) {
        typeTo(email.getTo());
        typeSubject(email.getSubject());
        typeEmailText(email.getEmailText());
    }

    private void saveInDrafts() {
        driver.findElement(By.xpath("//p[@class='send_container']//input[@name='save_in_drafts']")).click();
    }

    private void typeEmailText(String emailText) {
        driver.findElement(By.xpath("//textarea[@id='text']")).sendKeys(emailText);
    }

    private void typeSubject(String subject) {
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(subject);
    }

    private void typeTo(String to) {
        driver.findElement(By.xpath("//textarea[@id='to']")).sendKeys(to);
    }

    private void clickCreateMessage() {
        driver.findElement(By.xpath("//p[@class='make_message']//a")).click();
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
