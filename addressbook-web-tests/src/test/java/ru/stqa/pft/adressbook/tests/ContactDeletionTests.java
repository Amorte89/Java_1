package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        if (! app.group().isThereAGroup()) {
            app.getContactHelper().createContact(new ContactData("test", "test1", "test3", "test4", "mr.", "testing", "addresstest123", "+111111111", "+22222222", "+33333333", "+44444444", "test@test.ts", "test@test1.ts", "test@test2.ts", "test.ru/ts", "11", "April", "1989", "14", "July", "2000", "address2", "123", "test123", "test1"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().submitContactDeletion();
        app.getContactHelper().acceptAlert();
        app.goTo().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
