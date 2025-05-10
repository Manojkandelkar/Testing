package browseroperation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenericWayToOpen {
	 public static void main(String[] args) {
	      String geckoDriverPath = System.getProperty("user.dir") + ".\\executables\\geckodriver.exe";
	      String chromeDriverPath = System.getProperty("user.dir") + ".\\executables\\chromedriver.exe";
	      openBrowser(geckoDriverPath, "Firefox");
	      openBrowser(chromeDriverPath, "chrome");
	   }

	   static void openBrowser(String driverPath, String browserName) {
	      if (browserName.equalsIgnoreCase("chrome")) {
	         System.setProperty("webdriver.chrome.driver", driverPath);
	         new ChromeDriver();
	      } else if (browserName.equalsIgnoreCase("Firefox")) {
	         System.setProperty("webdriver.gecko.driver", driverPath);
	         new FirefoxDriver();
	      }

	   }

}
