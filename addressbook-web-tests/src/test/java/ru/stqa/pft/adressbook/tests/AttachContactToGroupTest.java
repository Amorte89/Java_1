package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AttachContactToGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.getNavigationHelper().groupPage();
            app.getGroupHelper().create(new GroupData().withName("test 1").withHeader("test 2").withFooter("test 3"));
        }
        if (app.db().contacts().size() == 0) {
            app.getContactHelper().create(new ContactData().withFirstName("test1").withLastName("test2")
                    .withBday("1").withBmonth("April").withByear("1990").withAday("1").wihtAmonth("January")
                    .withAyear("2000").withAddress2("test").withNotes("test"), true);
        }
    }

    @Test
    public void attachContactToGroup() {
        Groups groups  = app.db().groups();
        Contacts contacts = app.db().contacts();

        ContactData contactBefore = null;
        ContactData contactAfter = null;
        GroupData selectedGroup = null;

        for (ContactData contact : contacts) {
            Groups linkedGroup = contact.getGroups();
            if (linkedGroup.size() != groups.size()) {
                groups.removeAll(linkedGroup);
                selectedGroup = groups.iterator().next();
                contactBefore = contact;
                break;
            }
        }

        if (selectedGroup == null) {
            ContactData contact = new ContactData().withFirstName("test1").withLastName("test2")
                    .withBday("1").withBmonth("April").withByear("1990").withAday("1").wihtAmonth("January")
                    .withAyear("2000").withAddress2("test").withNotes("test");
            app.getContactHelper().create(contact, true);
            Contacts newContact = app.db().contacts();
            contact.withId(newContact.stream().mapToInt((g) -> (g).getId()).max().getAsInt());
            contactBefore = contact;
            selectedGroup = groups.iterator().next();
        }
        app.getContactHelper().attachContactToGroup(contactBefore, selectedGroup);

        Contacts allContacts = app.db().contacts();
        for (ContactData selectedContact : allContacts){
            if (selectedContact.getId() == contactBefore.getId()){
                contactAfter = selectedContact;
            }
        }

        assertThat(contactAfter.getGroups(), equalTo(contactBefore.getGroups().withAdded(selectedGroup)));
    }
}
