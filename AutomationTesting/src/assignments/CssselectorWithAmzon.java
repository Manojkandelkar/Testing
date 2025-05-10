package assignments;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssselectorWithAmzon {
	
	public static void main(String[] args) {
	      System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(25L, TimeUnit.SECONDS);
	      driver.get("https://www.amazon.in/");
	      List<WebElement> optionprint = driver.findElements(By.cssSelector("div#nav-xshop>a"));
	      System.out.println("Size of options :" + optionprint.size());

	      for(int i = 0; i < optionprint.size(); ++i) {
	         WebElement option = (WebElement)optionprint.get(i);
	         String name = option.getText();
	         System.out.println("Option name :" + name);
	         if (name.equals("Amazon Pay")) {
	            option.click();
	            break;
	         }

	         System.out.println("amazon pay not matched");
	      }

	      driver.close();
	   }

}
