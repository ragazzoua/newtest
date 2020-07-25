package i.ua.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

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
        createMessage();
        typeTo();
        typeSubject();
        typeEmailText();
        saveInDrafts();
    }

    private void saveInDrafts() {
        driver.findElement(By.xpath("//p[@class='send_container']//input[@name='save_in_drafts']")).click();
    }

    private void typeEmailText() {
        driver.findElement(By.xpath("//textarea[@id='text']")).sendKeys("test@ukr.net");
    }

    private void typeSubject() {
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("test@ukr.net");
    }

    private void typeTo() {
        driver.findElement(By.xpath("//textarea[@id='to']")).sendKeys("test@ukr.net");
    }

    private void createMessage() {
        driver.findElement(By.xpath("//p[@class='make_message']//a")).click();
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
