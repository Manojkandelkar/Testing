package keyboardoperations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilities.SeleniumUtilities;

public class LoginValidationKeyboard {
	
	 public static void main(String[] args) {
	      SeleniumUtilities s1 = new SeleniumUtilities();
	      WebDriver driver = s1.setup("chrome", "https://online.actitime.com/pboss/login.do");
	      driver.findElement(By.id("username")).sendKeys(new CharSequence[]{"bpk26222@gmail.com", Keys.TAB});
	      driver.findElement(By.name("pwd")).sendKeys(new CharSequence[]{"Test@123", Keys.ENTER});
	      driver.close();
	   }

}
