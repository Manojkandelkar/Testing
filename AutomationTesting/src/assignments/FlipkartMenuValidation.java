package assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartMenuValidation {
	
	 public static void main(String[] args) {
	      System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.manage().timeouts().implicitlyWait(25L, TimeUnit.SECONDS);
	      driver.get("https://www.flipkart.com/");

	      try {
	         WebElement closeButton = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
	         closeButton.click();
	      } catch (Exception var8) {
	         System.out.println("Login popup did not appear.");
	      }

	      String actualTitle = driver.getTitle();
	      String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	      if (actualTitle.equals(expectedTitle)) {
	         System.out.println("Home page Title Mateched Successfully");
	      } else {
	         System.out.println("Title changed or Title not Found");
	      }

	      List<WebElement> categories = driver.findElements(By.cssSelector("._3sdu8W.emupdz > a, ._3sdu8W.emupdz > div"));
	      System.out.println(categories.size());

	      for(int i = 0; i < categories.size(); ++i) {
	         WebElement option = (WebElement)categories.get(i);
	         String names = option.getText();
	         System.out.println("Categories In Flipkart *******" + names + "*********");
	         System.out.println(option.isDisplayed());
	         System.out.println(option.isEnabled());
	      }

	      driver.close();
	   }

}
