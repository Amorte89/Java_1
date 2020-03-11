package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    private ApplicationHelper applicationHelper;

    public NavigationHelper(WebDriver wd, ApplicationHelper applicationHelper) {
        super(wd);
        this.applicationHelper = applicationHelper;
    }

    public void homePage() {
        click(By.xpath("//*[text()='home']"));
    }

    public void groupPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
      click(By.linkText("groups"));
    }
}
