package browseroperation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrialTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String path = System.getProperty(".\\executables\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.eclipse.org/downloads/packages/release/2018-09/r");

	}

}
