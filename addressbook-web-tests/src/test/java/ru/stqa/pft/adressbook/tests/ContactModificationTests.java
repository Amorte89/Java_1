package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.getContactHelper().create(new ContactData().withFirstName("test1").withLastName("test2")
                    .withBday("1").withBmonth("April").withByear("1990").withAday("1").wihtAmonth("January")
                    .withAyear("2000").withAddress2("test").withNotes("test").withGroup("test 1"), true);
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.db().contacts();
        File photo = new File("src/test/resources/1.png");
        ContactData modifyContact = before.iterator().next();
        ContactData contact = new ContactData ()
                .withId(modifyContact.getId()).withFirstName("test1").withLastName("test2").withBday("1").withBmonth("April")
                .withByear("1990").withAday("1").wihtAmonth("January").withAyear("2000").withAddress2("test").withNotes("test")
                .withGroup("test 1").withPhoto(photo);
        app.getContactHelper().modify(contact, false);
        Contacts after = app.db().contacts();
        Assert.assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));
    }
}
