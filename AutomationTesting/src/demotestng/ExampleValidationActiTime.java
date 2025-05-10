package demotestng;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.SeleniumUtilities;

public class ExampleValidationActiTime {
  @Test
  public void loginLogoffActitimeApp() {
	  
	  SeleniumUtilities s1 = new SeleniumUtilities();
	  WebDriver driver = s1.setup("chrome", "https://www.actitime.com/");
	  System.out.println("Title of Page :" +driver.getTitle());
	  
	  //Validation using TestNG
	 // Assert.assertEquals(driver.getTitle(), "actiTIME - Time Tracking Software for Cost-Effective Projects");
	  
	  //if you want to display any message along with failure test then
	  Assert.assertEquals(driver.getTitle(), "actiTIME - Time Tracking Software for Cost-Effective Projects", "Eithrt title got changed OR Not found");
  }
}
