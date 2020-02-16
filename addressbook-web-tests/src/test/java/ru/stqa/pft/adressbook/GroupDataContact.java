package ru.stqa.pft.adressbook;

public class GroupDataContact {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String title;
    private final String company;
    private final String address1;
    private final String homephone;
    private final String mobilephone;
    private final String workphone;
    private final String fax;
    private final String email1;
    private final String email2;
    private final String email3;
    private final String homepage;
    private final String bday;
    private final String bmonth;
    private final String byear;
    private final String aday;
    private final String amouth;
    private final String ayear;
    private final String address2;
    private final String phone2;
    private final String notes;

    public GroupDataContact(String firstname, String middlename, String lastname, String nickname, String title, String company, String address1, String homephone, String mobilephone, String workphone, String fax, String email1, String email2, String email3, String homepage, String bday, String bmonth, String byear, String aday, String amouth, String ayear, String address2, String phone2, String notes) {
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
}
