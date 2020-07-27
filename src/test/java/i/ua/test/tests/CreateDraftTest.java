package i.ua.test.tests;

import i.ua.test.model.Email;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateDraftTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validEmails(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"test@ukr.net", "test@ukr.net", "test@ukr.net"});
        list.add(new Object[]{"test2@ukr.net", "test2@ukr.net", "test2@ukr.net"});
        list.add(new Object[]{"test3@ukr.net", "test3@ukr.net", "test3@ukr.net"});
        return list.iterator();
    }


    @Test(dataProvider = "validEmails")
    public void userCanCreateDraft(Email email) {
        app.getEmailHelper().clickCreateMessage();
        app.getEmailHelper().createEmail(new Email(email.getTo(), email.getSubject(), email.getEmailText()));
        app.getEmailHelper().clickSaveInDrafts();
    }

}
