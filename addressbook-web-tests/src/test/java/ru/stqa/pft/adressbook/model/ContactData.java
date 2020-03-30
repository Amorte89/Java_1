package ru.stqa.pft.adressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "addressbook")

public class ContactData {

    @Id
    private int id = Integer.MAX_VALUE;

    @Expose
    @Column(name = "firstname")
    private String firstname;

    @Expose
    @Column(name = "middlename")
    private String middlename;

    @Expose
    @Column(name = "lastname")
    private String lastname;

    @Expose
    @Column(name = "nickname")
    private String nickname;

    @Expose
    @Column(name = "title")
    private String title;

    @Expose
    @Column(name = "company")
    private String company;

    @Expose
    @Column(name = "address")
    @Type(type = "text")
    private String address1;

    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private String homephone;

    @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    private String mobilephone;

    @Expose
    @Column(name = "work")
    @Type(type = "text")
    private String workphone;

    @Expose
    @Column(name = "fax")
    @Type(type = "text")
    private String fax;

    @Expose
    @Column(name = "email")
    @Type(type = "text")
    private String email;

    @Expose
    @Column(name = "email2")
    @Type(type = "text")
    private String email2;

    @Expose
    @Column(name = "email3")
    @Type(type = "text")
    private String email3;

    @Expose
    @Column(name = "homepage")
    @Type(type = "text")
    private String homepage;

    @Expose
    @Column(name = "bday", columnDefinition = "TINYINT")
    private String bday;

    @Expose
    @Column(name = "bmonth", columnDefinition = "VARCHAR")
    private String bmonth;

    @Expose
    @Column(name = "byear", columnDefinition = "VARCHAR")
    private String byear;

    @Expose
    @Column(name = "aday", columnDefinition = "TINYINT")
    private String aday;

    @Expose
    @Column(name = "amonth", columnDefinition = "VARCHAR")
    private String amonth;

    @Expose
    @Column(name = "ayear", columnDefinition = "VARCHAR")
    private String ayear;

    @Expose
    @Column(name = "address2")
    @Type(type = "text")
    private String address2;

    @Expose
    @Column(name = "notes")
    @Type(type = "text")
    private String notes;

    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<>();


    @Transient
    private String allPhones;

    @Transient
    private String allEmails;


    public File getPhoto() {
        return (this.photo == null || this.photo.equals("")) ? null : new File(photo);
    }

    public String getAllEmails() {
        return allEmails;
    }

    public int getId() {
        return id;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public Groups getGroups() {
        return new Groups(groups);
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withFirstName(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastName(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withMiddleName(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactData withNickName(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public ContactData withHomePhone(String homephone) {
        this.homephone = homephone;
        return this;
    }

    public ContactData withMobilePhone(String mobilephone) {
        this.mobilephone = mobilephone;
        return this;
    }

    public ContactData withWorkPhone(String workphone) {
        this.workphone = workphone;
        return this;
    }

    public ContactData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public ContactData withEmail1(String email1) {
        this.email = email1;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    public ContactData withBday(String bday) {
        this.bday = bday;
        return this;
    }

    public ContactData withBmonth(String bmonth) {
        this.bmonth = bmonth;
        return this;
    }

    public ContactData withByear(String byear) {
        this.byear = byear;
        return this;
    }

    public ContactData withAday(String aday) {
        this.aday = aday;
        return this;
    }

    public ContactData wihtAmonth(String amouth) {
        this.amonth = amouth;
        return this;
    }

    public ContactData withAyear(String ayear) {
        this.ayear = ayear;
        return this;
    }

    public ContactData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public ContactData withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public ContactData inGroup (GroupData group) {
        groups.add(group);
        return this;
    }


    public String getFirstName() {
        return firstname;
    }

    public String getMiddleName() {
        return middlename;
    }

    public String getLastName() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress1() {
        return address1;
    }

    public String getHomePhone() {
        return homephone;
    }

    public String getMobilePhone() {
        return mobilephone;
    }

    public String getWorkPhone() {
        return workphone;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    public String getAday() {
        return aday;
    }

    public String getAmonth() {
        return amonth;
    }

    public String getAyear() {
        return ayear;
    }

    public String getAddress2() {
        return address2;
    }

    public String getNotes() {
        return notes;
    }


    public ContactData withValuesToDbFormat() {
        this.photo = nullToEmpty(this.photo);
        return
                withFirstName(nullToEmpty(this.firstname))
                        .withMiddleName(nullToEmpty(this.middlename))
                        .withLastName(nullToEmpty(this.lastname))
                        .withNickName(nullToEmpty(this.nickname))
                        .withTitle(nullToEmpty(this.title))
                        .withCompany(nullToEmpty(this.company))
                        .withAddress1(nullToEmpty(this.address1))
                        .withHomePhone(nullToEmpty(this.homephone))
                        .withMobilePhone(nullToEmpty(this.mobilephone))
                        .withWorkPhone(nullToEmpty(this.workphone))
                        .withFax(nullToEmpty(this.fax))
                        .withEmail1(nullToEmpty(this.email))
                        .withEmail2(nullToEmpty(this.email2))
                        .withEmail3(nullToEmpty(this.email3))
                        .withBday(nullToZero(this.bday))
                        .withBmonth(nullToDash(this.bmonth))
                        .withByear(nullToEmpty(this.byear))
                        .withAday(nullToZero(this.aday))
                        .wihtAmonth(nullToDash(this.amonth))
                        .withAyear(nullToEmpty(this.ayear))
                        .withHomepage(nullToEmpty(this.homepage))
                        .withAddress2(nullToEmpty(this.address2))
                        .withNotes(nullToEmpty(this.notes));

    }

    public String nullToEmpty(String s) {
        if (s == null) {
            return "";
        }
        return s;
    }

    public String nullToZero(String s) {
        if (s == null) {
            return "0";
        }
        return s;
    }

    public String nullToDash(String s) {
        if (s == null) {
            return "-";
        }
        return s;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(middlename, that.middlename) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(nickname, that.nickname) &&
                Objects.equals(title, that.title) &&
                Objects.equals(company, that.company) &&
                Objects.equals(address1, that.address1) &&
                Objects.equals(homephone, that.homephone) &&
                Objects.equals(mobilephone, that.mobilephone) &&
                Objects.equals(workphone, that.workphone) &&
                Objects.equals(fax, that.fax) &&
                Objects.equals(email, that.email) &&
                Objects.equals(email2, that.email2) &&
                Objects.equals(email3, that.email3) &&
                Objects.equals(homepage, that.homepage) &&
                Objects.equals(bday, that.bday) &&
                Objects.equals(bmonth, that.bmonth) &&
                Objects.equals(byear, that.byear) &&
                Objects.equals(aday, that.aday) &&
                Objects.equals(amonth, that.amonth) &&
                Objects.equals(ayear, that.ayear) &&
                Objects.equals(address2, that.address2) &&
                Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, middlename, lastname, nickname, title, company, address1, homephone, mobilephone, workphone, fax, email, email2, email3, homepage, bday, bmonth, byear, aday, amonth, ayear, address2, notes);
    }
}
