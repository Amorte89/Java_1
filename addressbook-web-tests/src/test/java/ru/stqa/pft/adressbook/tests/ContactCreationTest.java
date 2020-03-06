package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();

        //ContactData contact = new ContactData ("test", "test1", "test3", "test4", "mr.", "testing", "addresstest123", "+111111111", "+22222222", "+33333333", "+44444444", "test@test.ts", "test@test1.ts", "test@test2.ts", "test.ru/ts", "11", "April", "1989", "14", "July", "2000", "address2", "123", "test123", "test1");
        ContactData contact = new ContactData ("test", null, "test3", null, null, null, null, null, null, null, null, null, null, null, null, "-", "-", "-", "-", "-", "-", null, "123123", null, "test1");
        app.getContactHelper().createContact(contact, true);

        List<ContactData> after = app.getContactHelper().getContactList();

        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super  ContactData> byId = (g1, g2) -> Integer.compare(g1. getId(), g2. getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
