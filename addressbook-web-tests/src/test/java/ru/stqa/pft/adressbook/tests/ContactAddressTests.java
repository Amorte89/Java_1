package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.getContactHelper().all().size() == 0) {
            app.getContactHelper().create(new ContactData()
                    .withFirstName("test1").withLastName("test2").withAddress1("testAddress").withBday("1").withBmonth("April").withByear("1990").withAday("1").wihtAmonth("January").withAyear("2000").withAddress2("test").withNotes("test").withGroup("test1"), true);
        }
    }

    @Test
    public void testContactAddress() {
        ContactData contact = app.getContactHelper().all().iterator().next();
        ContactData contactInfoFromEditForm = app.getContactHelper().infoFromEditForm(contact);
        assertThat(contact.getAddress1(), equalTo((contactInfoFromEditForm.getAddress1())));
    }
}
