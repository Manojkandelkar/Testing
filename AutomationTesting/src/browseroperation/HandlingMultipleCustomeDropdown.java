package browseroperation;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingMultipleCustomeDropdown {
	 public static void main(String[] args) {
	      System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	      driver.get("https://thompsonsj.com/bootstrap-select-dropdown/");
	      WebDriverWait wait = new WebDriverWait(driver, 20L);
	      WebElement dropdown = driver.findElement(By.id("bsd1-button"));
	      wait.until(ExpectedConditions.elementToBeClickable(dropdown));
	      dropdown.click();
	      List<WebElement> options = driver.findElements(By.cssSelector(".dropdown-menu.dropdown-menu-right.show>div>a"));
	      System.out.println("option count: " + options.size());

	      for(int i = 0; i < options.size(); ++i) {
	         System.out.println(((WebElement)options.get(i)).getText());
	      }

	      ((WebElement)options.get(2)).click();
	      driver.close();
	   }

}
