package keyboardoperations;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOperations2 {
	
	 public static void main(String[] args) throws InterruptedException {
	      System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(25L, TimeUnit.SECONDS);
	      driver.get("https://www.globalsqa.com/");
	      List<WebElement> hoverOptions = driver.findElements(By.xpath("//div[@class='menu-custom-main-menu-container']/ul/li/a"));
	      Actions act = new Actions(driver);
	      mouseHoverWithCords(act, (WebElement)hoverOptions.get(2));
	      driver.close();
	   }

	   static void mouseHover(Actions act, List<WebElement> hoverOptions) throws InterruptedException {
	      for(int i = 0; i < hoverOptions.size(); ++i) {
	         WebElement menuOptions = (WebElement)hoverOptions.get(i);
	         act.moveToElement(menuOptions).perform();
	         Thread.sleep(2000L);
	      }

	   }

	   static void mouseHoverWithCords(Actions act, WebElement menuOptions) throws InterruptedException {
	      System.out.println("Option name is :" + menuOptions.getText());
	      act.moveToElement(menuOptions, 100, 0).perform();
	      Thread.sleep(2000L);
	   }

}
