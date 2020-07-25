package i.ua.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private WebDriver driver;

    protected void init() {
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

    protected void createEmail(Email email) {
        typeTo(email.getTo());
        typeSubject(email.getSubject());
        typeEmailText(email.getEmailText());
    }

    protected void saveInDrafts() {
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

    protected void clickCreateMessage() {
        driver.findElement(By.xpath("//p[@class='make_message']//a")).click();
    }

    protected void clickDraft() {
        driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[2]/div[1]/div[2]/div[3]/ul/li[3]/a")).click();
    }

    protected void selectDraft(int index) {
        driver.findElements(By.xpath("//input[@type='checkbox']")).get(index).click();
    }

    protected void clickDeleteDraft() {
        driver.findElement(By.xpath("//div[@id='fieldset1']//span[@class='button l_r del']")).click();
    }

    protected void acceptAllert() {
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

    }

    protected void stop() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}
