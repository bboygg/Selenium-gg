import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Date;


public class TestBase {

   private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
   private static final long TIMESTAMP = new Date().getTime();
   private Advice.Local local;
   protected WebDriverWait wait;
   private String environment;


   public WebDriver getDriver() {
      return driver.get();
   }



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
