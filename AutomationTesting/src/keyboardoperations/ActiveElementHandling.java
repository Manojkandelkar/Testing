package keyboardoperations;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.SeleniumUtilities;

public class ActiveElementHandling {
	
	  public static void main(String[] args) {
	      SeleniumUtilities s1 = new SeleniumUtilities();
	      WebDriver driver = s1.setup("chrome", "https://online.actitime.com/pboss/login.do");
	      WebElement activeObjectElement = driver.switchTo().activeElement();
	      String activeObjectPlaceholder = activeObjectElement.getAttribute("placeholder");
	      String expectedObject = "Username";
	      if (activeObjectPlaceholder.equals(expectedObject)) {
	         System.out.println("Cursor Validation at active element is Successful");
	      } else {
	         System.out.println("Cursor Validation Unsuccessful");
	      }
	      driver.close();

	   }

}
