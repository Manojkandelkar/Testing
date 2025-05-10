package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumUtilities {

	public WebDriver setup(String browserName, String appUrl) {
		WebDriver driver = null;
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		((WebDriver)driver).manage().window().maximize();
		((WebDriver)driver).manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		((WebDriver)driver).get(appUrl);
		return (WebDriver)driver;
	}

}
