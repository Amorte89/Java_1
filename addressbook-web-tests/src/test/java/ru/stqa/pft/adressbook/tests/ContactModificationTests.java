package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getContactHelper().createContact(new ContactData("test", "test1", "test3", "test4", "mr.", "testing", "addresstest123", "+111111111", "+22222222", "+33333333", "+44444444", "test@test.ts", "test@test1.ts", "test@test2.ts", "test.ru/ts", "11", "April", "1989", "14", "July", "2000", "address2", "123", "test123", "test1"), true);
        }

        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContactModification(before.size() - 1);
        ContactData contact = new ContactData (before.get(before.size() - 1).getId(),"test", null, "test3", null, null, null, null, null, null, null, null, null, null, null, null, "-", "-", "-", "-", "-", "-", null, "123123", null, "test1");
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super  ContactData> byId = (g1, g2) -> Integer.compare(g1. getId(), g2. getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
