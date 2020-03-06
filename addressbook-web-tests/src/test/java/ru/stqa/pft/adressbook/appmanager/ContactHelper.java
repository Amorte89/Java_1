package ru.stqa.pft.adressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectContactModification(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void submitContactDeletion() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void acceptAlert() {
        wd.switchTo().alert().accept();
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void newContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress1());
        type(By.name("home"), contactData.getHomephone());
        type(By.name("mobile"), contactData.getMobilephone());
        type(By.name("work"), contactData.getWorkphone());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getEmail1());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("homepage"), contactData.getHomepage());
        click(By.name("bday"));
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
        click(By.name("bday"));
        click(By.name("bmonth"));
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBmonth());
        click(By.name("bmonth"));
        click(By.name("byear"));
        wd.findElement(By.name("byear")).sendKeys(contactData.getByear());
        click(By.name("aday"));
        new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getAday());
        click(By.name("aday"));
        click(By.name("amonth"));
        new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getAmouth());
        type(By.name("ayear"), contactData.getAyear());
        type(By.name("address2"), contactData.getAddress2());
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys(contactData.getPhone2());
        type(By.name("notes"), contactData.getNotes());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void createContact(ContactData contact, boolean b) {
        newContactCreation();
        fillContactForm(contact, b);
        submitContactCreation();
        returnToHomePage();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String name = element.findElement(By.xpath("td[3]")).getText();
            String lastname = element.findElement(By.xpath("td[2]")).getText();
            ContactData contact = new ContactData(id, name, null, lastname, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}

