package i.ua.test;

import org.testng.annotations.Test;

public class CreateEmailTest extends TestBase {


    @Test
    public void userCanCreateEmail() {
        clickCreateMessage();
        createEmail(new Email("test@ukr.net", "test@ukr.net", "test@ukr.net"));
        saveInDrafts();
    }

}
