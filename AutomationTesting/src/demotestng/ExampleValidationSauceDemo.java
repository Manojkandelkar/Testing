package demotestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.SeleniumUtilities;

public class ExampleValidationSauceDemo {
  @Test
  public void validationLoginLogout() {
	  SeleniumUtilities s1 = new SeleniumUtilities();
	  WebDriver driver = s1.setup("chrome", "https://www.saucedemo.com/v1/");
	  
	  Assert.assertEquals(driver.getTitle(), "Swag Labs");
	  
	  WebElement usernameField = driver.findElement(By.id("user-name"));
	  Assert.assertTrue(usernameField.isDisplayed());
	  Assert.assertTrue(usernameField.isEnabled());
	  Assert.assertEquals(usernameField.getAttribute("placeholder"), "Username", "Username is not matched to placeholder");
	  usernameField.sendKeys("standard_user");
	  
	  WebElement pwdField = driver.findElement(By.id("password"));
	  Assert.assertTrue(pwdField.isDisplayed());
	  Assert.assertTrue(pwdField.isEnabled());
	  Assert.assertEquals(pwdField.getAttribute("placeholder"), "Password", "Password field changed placeholder or Not found");
	  pwdField.sendKeys("secret_sauce");
	  
      WebElement loginButton = driver.findElement(By.id("login-button"));
      Assert.assertTrue(loginButton.isDisplayed());
      loginButton.click();
      driver.close();

      
	  
  }
}
