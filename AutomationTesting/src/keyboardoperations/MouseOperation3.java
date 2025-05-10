package keyboardoperations;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.SeleniumUtilities;

public class MouseOperation3 {

	public static void main(String[] args) throws InterruptedException {
	      SeleniumUtilities s1 = new SeleniumUtilities();
	      WebDriver driver = s1.setup("chrome", "https://www.globalsqa.com/demo-site/draganddrop/");
	      WebElement frame = driver.findElement(By.cssSelector(".demo-frame.lazyloaded"));
	      driver.switchTo().frame(frame);
	      Actions act = new Actions(driver);
	      List<WebElement> sourceElement = driver.findElements(By.cssSelector("#gallery>li"));
	      WebElement targetlocation = driver.findElement(By.xpath("//div/h4/span[text()='Trash']"));
	      act.dragAndDrop((WebElement)sourceElement.get(0), targetlocation).build().perform();
	      Thread.sleep(2000L);
	      act.dragAndDrop((WebElement)sourceElement.get(1), targetlocation).build().perform();
	      Thread.sleep(2000L);
	      act.dragAndDrop((WebElement)sourceElement.get(2), targetlocation).build().perform();
	      Thread.sleep(2000L);
	      act.dragAndDrop((WebElement)sourceElement.get(3), targetlocation).build().perform();
	   }
}
