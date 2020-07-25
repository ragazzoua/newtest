package i.ua.test;

import org.testng.annotations.Test;

public class DeleteDraftTest extends TestBase {

    @Test
    public void userCanDeleteDraft(){
        clickDraft();
        selectDraft(2);
        clickDeleteDraft();
        acceptAllert();
    }
}
