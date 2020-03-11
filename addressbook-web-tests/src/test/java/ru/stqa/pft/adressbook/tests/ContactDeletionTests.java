package ru.stqa.pft.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

public class ContactDeletionTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        if (app.getContactHelper().all().size() == 0) {
            app.getContactHelper().create(new ContactData().withFirstName("test1").withLastName("test2").withBday("1").withBmonth("April").withByear("1990").withAday("1").withAmouth("January").withAyear("2000").withAddress2("test").withPhone2("123").withNotes("test").withGroup("test1"), true);
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.getContactHelper().all();
        ContactData deletedContact = before.iterator().next();
        app.getContactHelper().delete(deletedContact);
        Contacts after = app.getContactHelper().all();
        Assert.assertEquals(after.size(), before.size() - 1);
        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(deletedContact)));
    }
}
