package browseroperation;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidationActitime {
	  public static void main(String[] args) throws InterruptedException {
	      System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	      driver.get("https://online.actitime.com/pboss/login.do");
	      WebElement usernameField = driver.findElement(By.id("username"));
	      System.out.println("username field displaying :" + usernameField.isDisplayed());
	      System.out.println("username field is editable :" + usernameField.isEnabled());
	      String actualAttribute = usernameField.getAttribute("placeholder");
	      System.out.println("comparing attributes :" + actualAttribute.equals("Username"));
	      usernameField.sendKeys(new CharSequence[]{"bpk26222@gmail.com"});
	      WebElement passwordField = driver.findElement(By.name("pwd"));
	      System.out.println("is displaying or not :" + passwordField.isDisplayed());
	      System.out.println("is enabled or not :" + passwordField.isEnabled());
	      passwordField.sendKeys(new CharSequence[]{"Test@123"});
	      WebElement checkBox = driver.findElement(By.id("keepLoggedInCheckBox"));
	      System.out.println("is displaying :" + checkBox.isDisplayed());
	      System.out.println("is enabled :" + checkBox.isEnabled());
	      System.out.println("is selected :" + checkBox.isSelected());
	      checkBox.click();
	      System.out.println("is selected :" + checkBox.isSelected());
	      checkBox.click();
	      WebElement logiBtn = driver.findElement(By.id("loginButton"));
	      System.out.println("ids displaying :" + logiBtn.isDisplayed());
	      System.out.println("is enabled :" + logiBtn.isEnabled());
	      logiBtn.click();
	      WebElement logoutBtn = driver.findElement(By.id("logoutLink"));
	      logoutBtn.click();
	      Thread.sleep(2000L);
	      driver.navigate().to("https://www.amazon.in/");
	      Thread.sleep(2000L);
	      driver.navigate().back();
	      Thread.sleep(2000L);
	      driver.navigate().forward();
	      Thread.sleep(2000L);
	      driver.navigate().refresh();
	      Thread.sleep(2000L);
	      driver.close();
	   }

}
