package i.ua.test.tests;

import i.ua.test.model.Email;
import org.testng.annotations.Test;

public class CreateDraftTest extends TestBase {


    @Test
    public void userCanCreateDraft() {
        app.getEmailHelper().clickCreateMessage();
        app.createEmail(new Email("test@ukr.net", "test@ukr.net", "test@ukr.net"));
        app.getEmailHelper().saveInDrafts();
    }

}
