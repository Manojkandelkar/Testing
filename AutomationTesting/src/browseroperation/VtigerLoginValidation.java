package browseroperation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VtigerLoginValidation {
	
	  public static void main(String[] args) {
	      System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
	      driver.get("https://demo.vtiger.com/vtigercrm/index.php");
	      System.out.println("Title of Page :" +driver.getTitle());
	      WebElement usernameField = driver.findElement(By.id("username"));
	      usernameField.clear();
	      usernameField.sendKeys(new CharSequence[]{"admin"});
	      WebElement passwordInpuutField = driver.findElement(By.id("password"));
	      passwordInpuutField.clear();
	      passwordInpuutField.sendKeys(new CharSequence[]{"admin"});
	      WebElement signInButton = driver.findElement(By.cssSelector(".button.buttonBlue"));
	      signInButton.click();
	   }

}
