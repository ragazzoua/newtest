package i.ua.test.appmanager;

import i.ua.test.model.Email;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailHelper extends HelperBase {

    public EmailHelper(WebDriver driver) {
        super(driver);
    }

    public void clickSaveInDrafts() {
        click("//p[@class='send_container']//input[@name='save_in_drafts']");
    }

    public void clickCreateMessage() {
        click("//p[@class='make_message']//a");
    }

    public void selectDraft(int index) {
        driver.findElements(By.xpath("//input[@type='checkbox']")).get(index).click();
    }

    public void clickDeleteDraft() {
        click("//div[@id='fieldset1']//span[@class='button l_r del']");
    }

    public void createEmail(Email email) {
        type(email.getTo(), "//textarea[@id='to']");
        type(email.getSubject(), "//input[@name='subject']");
        type(email.getEmailText(), "//textarea[@id='text']");
    }
}
