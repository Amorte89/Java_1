import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

public class ShoppingCartTest {
  private WebDriver driver;

  @BeforeClass
  public void setUp() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testShoppingCart() {
    driver.get("https://www.amazon.com/");
    driver.findElement(By.id("twotabsearchtextbox")).click();
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("play playstation 4 pro");
    driver.findElement(By.xpath("//input[@value='Go']")).click();
    driver.findElement(By.xpath("//img[@alt='PlayStation 4 Pro 1TB Console']")).click();
    String p1 = driver.findElement(By.xpath("//*[@id=\"priceblock_ourprice\"]")).getText();
    int price1 = Integer.parseInt(p1.replaceAll("[\\D]", ""));
    driver.findElement(By.id("add-to-cart-button")).click();
    driver.findElement(By.id("twotabsearchtextbox")).click();
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("xbox one s");
    driver.findElement(By.xpath("//input[@value='Go']")).click();
    driver.findElement(By.xpath("//img[@alt='Xbox One S 1TB All-Digital Edition Console (Disc-Free Gaming)']")).click();
    String p2 = driver.findElement(By.xpath("//*[@id=\"priceblock_ourprice\"]")).getText();
    int price2 = Integer.parseInt(p2.replaceAll("[\\D]", ""));
    driver.findElement(By.id("add-to-cart-button")).click();
    driver.findElement(By.id("nav-cart-count")).click();
    String p3 = driver.findElement(By.xpath("//*[@id=\"sc-subtotal-amount-activecart\"]/span")).getText();
    int price3 = Integer.parseInt(p3.replaceAll("[\\D]", ""));
    assertThat(price3, equalTo(price1 + price2));
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }
}
