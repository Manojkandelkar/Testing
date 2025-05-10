package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.SeleniumUtilities;

public class RedbusValidation {
	
	  public static void main(String[] args) {
	      SeleniumUtilities s1 = new SeleniumUtilities();
	      WebDriver driver = s1.setup("chrome", "https://www.redbus.in/");
	      WebDriverWait wait = new WebDriverWait(driver, 25L);
	      driver.findElement(By.cssSelector("div[role='button']>*:first-child>div:nth-of-type(1)>div>input")).sendKeys(new CharSequence[]{"Pune"});
	      driver.findElement(By.cssSelector("div[role='button']>ul>li:first-child")).click();
	      driver.findElement(By.xpath("//input[@id='dest' and @tabindex='-1']")).sendKeys(new CharSequence[]{"Goa"});
	      WebElement destinationTab = driver.findElement(By.xpath("//div[@tabindex='2' and @role='button']/ul/li[1]/div/text[contains(text() ,'Goa')]"));
	      wait.until(ExpectedConditions.elementToBeClickable(destinationTab));
	      destinationTab.click();
	      driver.findElement(By.id("div#onwardCal")).click();
	   }

}
