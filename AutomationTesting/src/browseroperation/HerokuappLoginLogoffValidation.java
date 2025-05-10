package browseroperation;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HerokuappLoginLogoffValidation {
	  public static void main(String[] args) {
	      System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
	      driver.get("https://the-internet.herokuapp.com/login");
	      driver.findElement(By.id("username")).sendKeys(new CharSequence[]{"tomsmith"});
	      driver.findElement(By.id("password")).sendKeys(new CharSequence[]{"SuperSecretPassword!"});
	      driver.findElement(By.cssSelector("i.fa.fa-2x.fa-sign-in")).click();
	      driver.findElement(By.cssSelector("i.icon-2x.icon-signout")).click();
	      driver.close();
	   }

}
