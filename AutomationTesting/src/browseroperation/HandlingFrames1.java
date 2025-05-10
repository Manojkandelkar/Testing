package browseroperation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingFrames1 {
	 public static void main(String[] args) {
	      System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(25L, TimeUnit.SECONDS);
	      driver.get("https://jqueryui.com/droppable/");
	      WebElement frame = driver.findElement(By.cssSelector(".demo-frame"));
	      driver.switchTo().frame(frame);
	      Actions act = new Actions(driver);
	      WebElement source = driver.findElement(By.id("draggable"));
	      WebElement dest = driver.findElement(By.id("droppable"));
	      act.dragAndDrop(source, dest).build().perform();
	      driver.switchTo().defaultContent();
	      driver.findElement(By.xpath("//h2/a[contains(text(),'jQuery UI')]")).click();
	      driver.close();
	   }

}
