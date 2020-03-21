package ru.stqa.pft.adressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.adressbook.appmanager.ApplicationHelper;

import java.io.IOException;


public class TestBase {

    protected static final ApplicationHelper app = new ApplicationHelper(System.getProperty("browser", BrowserType.CHROME));


    @BeforeSuite
    public void setUp() throws IOException {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
