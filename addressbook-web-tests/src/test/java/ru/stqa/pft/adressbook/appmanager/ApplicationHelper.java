package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationHelper {

    protected WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private String browser;

    public ApplicationHelper(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (this.browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (this.browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (this.browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook");
        this.groupHelper = new GroupHelper(wd, this);
        this.contactHelper = new ContactHelper(wd, this);
        this.navigationHelper = new NavigationHelper(wd, this);
        this.sessionHelper = new SessionHelper(wd, this);
        this.sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return this.groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return this.navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return this.contactHelper;
    }
}
