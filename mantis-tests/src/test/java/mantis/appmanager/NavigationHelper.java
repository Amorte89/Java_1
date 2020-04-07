package mantis.appmanager;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager app) {
        super(app);
    }

    public void manageUsers() {
        click(By.cssSelector(".fa-gears"));
        click(By.linkText("Manage Users"));
    }
}
