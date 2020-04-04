package mantis.tests;

import mantis.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;


public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws IOException {
        app.init();
        app.ftp().upload(new File("src/test/resources/config_inc.php"), "config/config_inc.php", "config/config_inc.php.bak");
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown() throws IOException {
        app.stop();
        app.ftp().restore("config/config_inc.php.bak", "config/config_inc.php");
    }

}