package i.ua.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailHelper {
    protected WebDriver driver;

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

    public void clickDraft() {
        driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[2]/div[1]/div[2]/div[3]/ul/li[3]/a")).click();
    }

    public void selectDraft(int index) {
        driver.findElements(By.xpath("//input[@type='checkbox']")).get(index).click();
    }

    public void clickDeleteDraft() {
        driver.findElement(By.xpath("//div[@id='fieldset1']//span[@class='button l_r del']")).click();
    }

    public void clickCreateMessage() {
        driver.findElement(By.xpath("//p[@class='make_message']//a")).click();
    }
}
