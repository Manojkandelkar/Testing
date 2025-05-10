package browseroperation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActitimeOpening {
	 public static void main(String[] args) {
	      String chromePath = System.getProperty("user.dir") + ".\\executables\\chromedriver.exe";
	      System.setProperty("webdriver.chrome.driver", chromePath);
	      WebDriver cdriver = new ChromeDriver();
	      cdriver.get("https://www.actitime.com/");
	      String actiTitle = cdriver.getTitle();
	      System.out.println("Title of acttime :" + actiTitle);
//	      System.out.println("Lenghth of Title :" + actiTitle.length());
//	      System.out.println("Page URL :" + cdriver.getCurrentUrl());
//	      if (actiTitle.equals("actiTIME - Time Tracking Software")) {
//	         System.out.println("page title is correct");
//	      } else {
//	         System.out.println("Title Not Found or Title get changed");
//	      }

	      cdriver.close();
	   }

}
