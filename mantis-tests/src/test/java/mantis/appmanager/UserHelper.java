package mantis.appmanager;

import org.openqa.selenium.By;

public class UserHelper extends HelperBase {

    public UserHelper(ApplicationManager app) {
        super(app);
    }

    public void selectUser(int id) {
        wd.findElement(By.cssSelector(String.format("a[href = 'manage_user_edit_page.php?user_id=%s']", id))).click();
    }

    public void resetPassword() {
        wd.findElement(By.cssSelector("input[value='Reset Password']")).click();
    }
}
