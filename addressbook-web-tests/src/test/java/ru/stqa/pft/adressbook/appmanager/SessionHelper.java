package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

    private ApplicationHelper applicationHelper;

    public SessionHelper(WebDriver wd, ApplicationHelper applicationHelper) {
        super(wd);
        this.applicationHelper = applicationHelper;
    }

    public void login(String username, String password) {
        type(By.name("user"), username);
        type(By.name("pass"), password);
        click(By.xpath("//form[@name='LoginForm']/input[3]"));
    }
}
