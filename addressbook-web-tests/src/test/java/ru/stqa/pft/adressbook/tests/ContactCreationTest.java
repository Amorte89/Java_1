package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @Test ()
    public void testContactCreation() {
        Contacts before = app.getContactHelper().all();
        ContactData contact = new ContactData()
                .withFirstName("test1").withLastName("test2").withHomePhone("+123123123").withMobilePhone("+(123)123123").withWorkPhone("123-123-123").withBday("1").withBmonth("April").withByear("1990").withAday("1").withAmouth("January").withAyear("2000").withAddress2("test").withNotes("test").withGroup("test1");
        app.getContactHelper().create(contact, true);
        Contacts after = app.getContactHelper().all();
        Assert.assertEquals(after.size(), before.size() + 1);
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
