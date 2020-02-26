package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getContactHelper().createContact(new ContactData("test", "test1", "test3", "test4", "mr.", "testing", "addresstest123", "+111111111", "+22222222", "+33333333", "+44444444", "test@test.ts", "test@test1.ts", "test@test2.ts", "test.ru/ts", "11", "April", "1989", "14", "July", "2000", "address2", "123", "test123", "test1"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().submitContactDeletion();
        app.getContactHelper().acceptAlert();
    }
}
