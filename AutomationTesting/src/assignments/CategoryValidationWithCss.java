package assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CategoryValidationWithCss {
	
	 public static void main(String[] args) {
	      System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.get("https://www.demoblaze.com/");
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	      List<WebElement> categories = driver.findElements(By.cssSelector(".list-group>a"));
	      System.out.println("Size of categories :" + categories.size());
	      List<String> li = new ArrayList();
	      li.add("CATEGORIES");
	      li.add("Phones");
	      li.add("Laptops");
	      li.add("Monitors");

	      for(int i = 0; i < categories.size(); ++i) {
	         WebElement option = (WebElement)categories.get(i);
	         System.out.println("Elements of list is :" + option.getText() + "************");
	         System.out.println(option.isDisplayed());
	         System.out.println(option.isEnabled());
	         System.out.println(option.getText().equals(li.get(i)));
	      }

	   }

}
