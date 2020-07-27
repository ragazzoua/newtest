package i.ua.test.appmanager;

import org.openqa.selenium.WebDriver;

public class Navigationhelper extends HelperBase{


    public Navigationhelper(WebDriver driver) {
        super(driver);
    }

    public void clickDraft() {
        click("/html/body/div[2]/div[6]/div[2]/div[1]/div[2]/div[3]/ul/li[3]/a");
    }
}
