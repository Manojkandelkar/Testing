package demotestng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeMethodAfterMethod {
	
	@BeforeTest
	public void browserOpen() {
		System.out.println("Opening Browser");
	}
	
  @Test(priority=1)
  public void verifyLoginToApp() {
	  System.out.println("Verified Successfully.....");
  }
  
  @Test(priority=2)
  public void urlEntered() {
	  System.out.println("App URL entered ..");
  }
  
  @BeforeMethod
  public void login() {
	  System.out.println("login successfully");
  }
  
  @AfterMethod
  public void logout() {
	  System.out.println("logged out");
  }
  
  
  @AfterTest
  public void closeBrowser() {
	  System.out.println("browser Closed..");
  }
  
  /**
   * @BeforeMethod/@AfterMethod ---> method will execute before and after every test case from start to end. BEFORE method will execute
   * before every TC and AfterMethod will execute after every TC 
   */
}
