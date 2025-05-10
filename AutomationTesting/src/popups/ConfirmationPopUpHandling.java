package popups;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.SeleniumUtilities;

public class ConfirmationPopUpHandling {

	 public static void main(String[] args) {
	      SeleniumUtilities s1 = new SeleniumUtilities();
	      WebDriver driver = s1.setup("chrome", "https://demoqa.com/alerts");
	      WebElement pageBody = driver.findElement(By.cssSelector("body"));
	      pageBody.sendKeys(new CharSequence[]{Keys.PAGE_DOWN});
	      driver.findElement(By.cssSelector("div[id='javascriptAlertsWrapper']>div:nth-of-type(3)>div:last-child>button")).click();
	      driver.switchTo().alert().dismiss();
	      driver.close();
	   }
}
