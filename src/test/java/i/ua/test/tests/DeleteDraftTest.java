package i.ua.test.tests;

import org.testng.annotations.Test;

public class DeleteDraftTest extends TestBase {

    @Test
    public void userCanDeleteDraft(){
        app.getNavigationhelper().clickDraft();
        app.getEmailHelper().selectDraft(2);
        app.getEmailHelper().clickDeleteDraft();
        app.getEmailHelper().acceptAllert();
    }
}
