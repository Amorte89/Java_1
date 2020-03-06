package ru.stqa.pft.adressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String nickname;
    private String title;
    private String company;
    private String address1;
    private String homephone;
    private String mobilephone;
    private String workphone;
    private String fax;
    private String email1;
    private String email2;
    private String email3;
    private String homepage;
    private String bday;
    private String bmonth;
    private String byear;
    private String aday;
    private String amouth;
    private String ayear;
    private String address2;
    private String phone2;
    private String notes;
    private String group;


    public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String company, String address1, String homephone, String mobilephone, String workphone, String fax, String email1, String email2, String email3, String homepage, String bday, String bmonth, String byear, String aday, String amouth, String ayear, String address2, String phone2, String notes, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address1 = address1;
        this.homephone = homephone;
        this.mobilephone = mobilephone;
        this.workphone = workphone;
        this.fax = fax;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.aday = aday;
        this.amouth = amouth;
        this.ayear = ayear;
        this.address2 = address2;
        this.phone2 = phone2;
        this.notes = notes;
        this.group = group;
    }

    public ContactData(int id, String firstname, String middlename, String lastname, String nickname, String title, String company, String address1, String homephone, String mobilephone, String workphone, String fax, String email1, String email2, String email3, String homepage, String bday, String bmonth, String byear, String aday, String amouth, String ayear, String address2, String phone2, String notes, String group) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address1 = address1;
        this.homephone = homephone;
        this.mobilephone = mobilephone;
        this.workphone = workphone;
        this.fax = fax;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.aday = aday;
        this.amouth = amouth;
        this.ayear = ayear;
        this.address2 = address2;
        this.phone2 = phone2;
        this.notes = notes;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
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

    public String getHomephone() {
        return homephone;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public String getWorkphone() {
        return workphone;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail1() {
        return email1;
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

    public String getAmouth() {
        return amouth;
    }

    public String getAyear() {
        return ayear;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getNotes() {
        return notes;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }
}
