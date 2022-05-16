import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


import java.time.Duration;


public class firstTest {

   public WebDriver driver;

   @Test
   public void eightComponents() {
      WebDriverManager.chromedriver().setup();

      ChromeDriver driver = new ChromeDriver();

      driver.get("https://google.com");

      String title = driver.getTitle();
      Assert.assertEquals("Google", title);

      driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

      WebElement searchBox = driver.findElement(By.name("q"));
      WebElement searchButton = driver.findElement(By.name("btnK"));

      searchBox.sendKeys("Selenium");
      searchButton.click();

      searchBox = driver.findElement(By.name("q"));
      String value = searchBox.getAttribute("value");
      Assert.assertEquals("Selenium", value);

      driver.quit();
   }

}
