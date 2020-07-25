package i.ua.test;

import org.testng.annotations.Test;

public class CreateDraftTest extends TestBase {


    @Test
    public void userCanCreateDraft() {
        clickCreateMessage();
        createEmail(new Email("test@ukr.net", "test@ukr.net", "test@ukr.net"));
        saveInDrafts();
    }

}
