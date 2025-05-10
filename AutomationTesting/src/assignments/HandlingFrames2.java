package assignments;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingFrames2 {
	
	public static void main(String[] args) {
	      System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(25L, TimeUnit.SECONDS);
	      driver.get("https://jqueryui.com/sortable/");
	      WebElement frame = driver.findElement(By.cssSelector(".demo-frame"));
	      driver.switchTo().frame(frame);
	      Actions act = new Actions(driver);
	      List<WebElement> list = driver.findElements(By.cssSelector("ul#sortable>li>span"));
	      list.size();

	      for(int i = 0; i < list.size(); ++i) {
	         for(int j = i + 1; j < list.size(); ++j) {
	            WebElement listNumber = (WebElement)list.get(i);
	            WebElement items = (WebElement)list.get(i + 1);
	            act.dragAndDrop(items, listNumber).perform();
	            driver.findElements(By.cssSelector("ul#sortable>li>span"));
	         }
	      }

	      driver.close();
	   }

}
