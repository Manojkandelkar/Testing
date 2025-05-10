package assignments;


import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GsmArenaPhoneValidation {
	 public static void main(String[] args) {
	      System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
	      driver.get("https://www.gsmarena.com/");
	      String actualTitle = driver.getTitle();
	      String expectedTitle = "GSMArena.com - mobile phone reviews, news, specifications and more...";
	      if (actualTitle.equals(expectedTitle)) {
	         System.out.println("Title matched successfully");
	      } else {
	         System.out.println("Title not found or Not matched");
	      }

	      List<WebElement> totalPhones = driver.findElements(By.cssSelector(".brandmenu-v2.light.l-box.clearfix>ul>li>a"));
	      System.out.println("Size of phones :" + totalPhones.size());

	      WebElement nextButton;
	      for(int i = 0; i < totalPhones.size(); ++i) {
	         nextButton = (WebElement)totalPhones.get(i);
	         System.out.println(nextButton.isDisplayed());
	         System.out.println(nextButton.isEnabled());
	         String nameOfPhones = nextButton.getText();
	         System.out.println("Phone brand is : " + nameOfPhones);
	         if (nameOfPhones.equals("SAMSUNG")) {
	            nextButton.click();
	            break;
	         }
	      }

	      while(true) {
	         List<WebElement> samsungList = driver.findElements(By.cssSelector(".makers>ul>li>a>strong>span"));
	         Iterator var10 = samsungList.iterator();

	         while(var10.hasNext()) {
	            nextButton = (WebElement)var10.next();
	            System.out.println("Samsung Model :" + nextButton.getText());
	         }

	         try {
	            nextButton = driver.findElement(By.cssSelector(".nav-pages>a:last-child"));
	            nextButton.click();
	            WebDriverWait wait = new WebDriverWait(driver, 10L);
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".makers>ul>li>a>strong>span")));
	         } catch (NoSuchElementException var8) {
	            System.out.println("No more pages.");
	            return;
	         }

	         driver.close();
	      }
	 }

}
