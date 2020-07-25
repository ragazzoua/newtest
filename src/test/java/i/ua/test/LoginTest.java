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
        login();
    }

    private void login() {
        driver.get("https://www.i.ua/");
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("ittest2");
        driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("337774a");
        driver.findElement(By.xpath("//p//input[@type='submit']")).click();
    }


    @Test
    public void userCanCreateEmail() {
        driver.findElement(By.xpath("//p[@class='make_message']//a")).click();
        driver.findElement(By.xpath("//textarea[@id='to']")).sendKeys("test@ukr.net");
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("test@ukr.net");
        driver.findElement(By.xpath("//textarea[@id='text']")).sendKeys("test@ukr.net");
        driver.findElement(By.xpath("//p[@class='send_container']//input[@name='save_in_drafts']")).click();
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
