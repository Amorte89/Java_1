package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getGroupHelper().selectContact();
        app.getGroupHelper().submitContactDeletion();
        app.getGroupHelper().acceptAlert();
    }
}
