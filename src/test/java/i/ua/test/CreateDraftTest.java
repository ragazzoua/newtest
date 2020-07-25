package i.ua.test;

import org.testng.annotations.Test;

public class CreateDraftTest extends TestBase {


    @Test
    public void userCanCreateDraft() {
        app.clickCreateMessage();
        app.createEmail(new Email("test@ukr.net", "test@ukr.net", "test@ukr.net"));
        app.saveInDrafts();
    }

}
