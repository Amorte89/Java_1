package ru.stqa.pft.adressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.adressbook.appmanager.ApplicationHelper;


public class TestBase {

    protected static final ApplicationHelper app = new ApplicationHelper(BrowserType.CHROME);


    @BeforeSuite//(alwaysRun = true)
    public void setUp() {
        app.init();
    }

    @AfterSuite//(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

}
