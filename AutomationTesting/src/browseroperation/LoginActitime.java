package browseroperation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginActitime {
	 public static void main(String[] args) {
	      System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
	      driver.get("https://www.saucedemo.com/");
	      String actualTitleOfPage = driver.getTitle();
	      String expectedTitleOfPage = "Swag Labs";
	      if (actualTitleOfPage.equals(expectedTitleOfPage)) {
	         System.out.println("page title matched ");
	      } else {
	         System.out.println("Page not found or Page title is changed");
	      }

	      WebElement usernameInputField = driver.findElement(By.id("user-name"));
	      usernameInputField.sendKeys(new CharSequence[]{"standard_user"});
	      WebElement passwordInputField = driver.findElement(By.id("password"));
	      passwordInputField.sendKeys(new CharSequence[]{"secret_sauce"});
	      WebElement loginButton = driver.findElement(By.id("login-button"));
	      loginButton.click();
	      driver.findElement(By.cssSelector(".bm-burger-button>button")).click();
	      driver.findElement(By.cssSelector("nav.bm-item-list>a:nth-of-type(3)")).click();
	      driver.close();
	   }

}
