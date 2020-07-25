package i.ua.test;

import org.testng.annotations.Test;

public class DeleteDraftTest extends TestBase {

    @Test
    public void userCanDeleteDraft(){
        app.clickDraft();
        app.selectDraft(2);
        app.clickDeleteDraft();
        app.acceptAllert();
    }
}
