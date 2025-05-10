package keyboardoperations;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginValidationKeyboard3 {
	
	 public static void main(String[] args) throws InterruptedException {
	      System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	      driver.get("https://www.cashify.in/");
	      WebElement bodyOfPage = driver.findElement(By.cssSelector("body"));
	      bodyOfPage.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.CONTROL, Keys.END})});
	      Thread.sleep(5000L);
	      bodyOfPage.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.CONTROL, Keys.HOME})});
	      Thread.sleep(5000L);
	      bodyOfPage.sendKeys(new CharSequence[]{Keys.F5});
	   }

}
