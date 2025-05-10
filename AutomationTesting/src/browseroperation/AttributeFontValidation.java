package browseroperation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.SeleniumUtilities;

public class AttributeFontValidation {
	 public static void main(String[] args) {
	      SeleniumUtilities s1 = new SeleniumUtilities();
	      WebDriver driver = s1.setup("chrome", "https://demo.vtiger.com/vtigercrm/index.php");
	      WebElement signInButton = driver.findElement(By.cssSelector("#loginFormDiv .button.buttonBlue"));
	      System.out.println("Font Size -" + signInButton.getCssValue("font-size"));
	      System.out.println("color -" + signInButton.getCssValue("color"));
	      System.out.println("background -" + signInButton.getCssValue("background"));
	      driver.quit();
	   }

}
