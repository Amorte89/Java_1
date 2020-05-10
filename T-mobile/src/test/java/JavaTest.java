import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class JavaTest {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        // this time test is waiting loading before drop error
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void testJavaSiteLoading() {
        String mount = "Mountain Pictures";
        String beach = "Beach Pictures";
        String bird = "Bird Pictures";
        String food = "Food Pictures";
        String mountIm = "Mountain Images";
        String beachIm = "Beaches Images";


        driver.get("https://yog9.github.io/SnapShot/#/SnapScout/search/mountain");
        driver.findElement(By.linkText("Mountain")).click();
        String p1 = driver.findElement(By.xpath("//*[@id=\"root\"]//h2")).getText();
        assertThat(mount, equalTo(p1));
        driver.findElement(By.linkText("Beaches")).click();
        String p2 = driver.findElement(By.xpath("//*[@id=\"root\"]//h2")).getText();
        assertThat(beach, equalTo(p2));
        driver.findElement(By.linkText("Birds")).click();
        String p3 = driver.findElement(By.xpath("//*[@id=\"root\"]//h2")).getText();
        assertThat(bird, equalTo(p3));
        driver.findElement(By.linkText("Food")).click();
        String p4 = driver.findElement(By.xpath("//*[@id=\"root\"]//h2")).getText();
        assertThat(food, equalTo(p4));
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("mountain");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String p5 = driver.findElement(By.xpath("//*[@id=\"root\"]//h2")).getText();
        assertThat(mountIm, equalTo(p5));
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("beaches");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String p6 = driver.findElement(By.xpath("//*[@id=\"root\"]//h2")).getText();
        assertThat(beachIm, equalTo(p6));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown()  {
        driver.quit();
    }
}

