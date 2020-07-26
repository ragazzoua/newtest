package i.ua.test.appmanager;

import i.ua.test.model.Email;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager extends EmailHelper{
    private WebDriver driver;

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

    public void saveInDrafts() {
        driver.findElement(By.xpath("//p[@class='send_container']//input[@name='save_in_drafts']")).click();
    }

    public void typeEmailText(String emailText) {
        driver.findElement(By.xpath("//textarea[@id='text']")).sendKeys(emailText);
    }

    public void typeSubject(String subject) {
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(subject);
    }

    public void typeTo(String to) {
        driver.findElement(By.xpath("//textarea[@id='to']")).sendKeys(to);
    }

    public void clickCreateMessage() {
        driver.findElement(By.xpath("//p[@class='make_message']//a")).click();
    }

    public void clickDraft() {
        driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[2]/div[1]/div[2]/div[3]/ul/li[3]/a")).click();
    }

    public void selectDraft(int index) {
        driver.findElements(By.xpath("//input[@type='checkbox']")).get(index).click();
    }

    public void clickDeleteDraft() {
        driver.findElement(By.xpath("//div[@id='fieldset1']//span[@class='button l_r del']")).click();
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
