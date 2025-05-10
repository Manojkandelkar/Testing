package browseroperation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookOpening {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		if(driver.getTitle().equals("Facebook – log in or sign up")) {
			System.out.println("Title Matched Successfully");
			System.out.println(driver.getTitle());
		}else {
			System.out.println("Title might be changed or not matched");
		}
		driver.close();

	}

}
