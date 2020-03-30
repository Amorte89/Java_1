package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveContactFromGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.getNavigationHelper().groupPage();
            app.getGroupHelper().create(new GroupData().withName("test 1").withHeader("test 2").withFooter("test 3"));
        }
        if (app.db().contacts().size() == 0) {
            Groups groups = app.db().groups();
            app.getContactHelper().create(new ContactData().withFirstName("test1").withLastName("test2")
                    .withBday("1").withBmonth("April").withByear("1990").withAday("1").wihtAmonth("January")
                    .withAyear("2000").withAddress2("test").withNotes("test").inGroup(groups.iterator().next()), true);
        }
    }

    @Test
    public void removeContactFromGroup() {
        ContactData contactBefore;
        ContactData contactAfter = null;
        GroupData selectedGroup = null;

        Groups groups = app.db().groups();
        Contacts contacts = app.db().contacts();
        app.getNavigationHelper().homePage();
        contactBefore = contacts.iterator().next();

        if (contactBefore.getGroups().size() == 0){
            selectedGroup = groups.iterator().next();
            app.getContactHelper().attachContactToGroup(contactBefore, selectedGroup);
        }

        for (ContactData selectedContact : contacts){
            Groups linkedGroup = selectedContact.getGroups();
            if (linkedGroup.size() > 0){
                contactBefore = selectedContact;
                selectedGroup = selectedContact.getGroups().iterator().next();
                break;
            }
        }

        app.getContactHelper().contactInGroup(selectedGroup);
        app.getContactHelper().selectContactById(contactBefore.getId());
        app.getContactHelper().removeContactFromGroup();

        Contacts allContacts = app.db().contacts();
        for (ContactData selectedContact : allContacts){
            if (selectedContact.getId() == contactBefore.getId()){
                contactAfter = selectedContact;
            }
        }

        assertThat(contactAfter.getGroups(), equalTo(contactBefore.getGroups().without(selectedGroup)));
    }
}
