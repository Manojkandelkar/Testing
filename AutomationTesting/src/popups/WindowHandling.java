package popups;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.SeleniumUtilities;

public class WindowHandling {
	
	public static void main(String[] args) {
	      SeleniumUtilities s1 = new SeleniumUtilities();
	      WebDriver driver = s1.setup("chrome", "https://dictionary.cambridge.org/");
	      String homePageID = driver.getWindowHandle();
	      System.out.println("Homepage ID :" + homePageID);
	      System.out.println("Title Of The Current Page :" + driver.getTitle());
	      System.out.println("Current URL of the Page :" + driver.getCurrentUrl());
	      driver.findElement(By.cssSelector("li>a[title='Likes']")).click();
	      Set<String> allWindow = driver.getWindowHandles();
	      System.out.println("All Window ID's :" + allWindow);
	      allWindow.remove(homePageID);
	      System.out.println("After removing Parent Window ID:" + allWindow);
	      Iterator<String> itr = allWindow.iterator();
	      String childWindow = (String)itr.next();
	      driver.switchTo().window(childWindow);
	      System.out.println("Title of the Page :" + driver.getTitle());
	      System.out.println("URL of New Window :" + driver.getCurrentUrl());
	      driver.close();
	      driver.switchTo().window(homePageID);
	      driver.quit();
	   }

}
