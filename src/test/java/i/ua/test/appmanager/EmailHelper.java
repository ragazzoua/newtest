package i.ua.test.appmanager;

import i.ua.test.model.Email;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailHelper {
    private WebDriver driver;

    public EmailHelper(WebDriver driver) {
        this.driver = driver;
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

    public void selectDraft(int index) {
        driver.findElements(By.xpath("//input[@type='checkbox']")).get(index).click();
    }

    public void clickDeleteDraft() {
        driver.findElement(By.xpath("//div[@id='fieldset1']//span[@class='button l_r del']")).click();
    }

    public void createEmail(Email email) {
        typeTo(email.getTo());
        typeSubject(email.getSubject());
        typeEmailText(email.getEmailText());
    }
}
