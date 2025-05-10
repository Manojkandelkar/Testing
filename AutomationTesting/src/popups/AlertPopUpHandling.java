package popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.SeleniumUtilities;

public class AlertPopUpHandling {
	  public static void main(String[] args) {
	      SeleniumUtilities s1 = new SeleniumUtilities();
	      WebDriver driver = s1.setup("chrome", "https://demoqa.com/alerts");
	      WebElement pageBody = driver.findElement(By.cssSelector("body"));
	      driver.findElement(By.cssSelector("div[id='javascriptAlertsWrapper']>div>div:last-child>button[id='alertButton']")).click();
	      driver.switchTo().alert().accept();
	   }

}
