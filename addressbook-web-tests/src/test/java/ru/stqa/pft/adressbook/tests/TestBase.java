package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.adressbook.appmanager.ApplicationHelper;
import org.openqa.selenium.remote.BrowserType;


public class TestBase {

    protected final ApplicationHelper app = new ApplicationHelper(BrowserType.CHROME);


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

}
