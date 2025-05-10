package keyboardoperations;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.SeleniumUtilities;

public class MouseOperations1 {
	
	 public static void main(String[] args) {
	      SeleniumUtilities s1 = new SeleniumUtilities();
	      WebDriver driver = s1.setup("chrome", "https://demo.automationtesting.in/Register.html");
	      WebElement firstNameField = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
	      firstNameField.sendKeys(new CharSequence[]{"admin"});
	      Actions act = new Actions(driver);
	      act.moveToElement(firstNameField).doubleClick().keyDown(Keys.CONTROL).sendKeys(new CharSequence[]{"c"}).keyUp(Keys.CONTROL).build().perform();
	      WebElement lastNameField = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
	      act.moveToElement(lastNameField).click().keyDown(Keys.CONTROL).sendKeys(new CharSequence[]{"v"}).keyUp(Keys.CONTROL).build().perform();
	   }

}
