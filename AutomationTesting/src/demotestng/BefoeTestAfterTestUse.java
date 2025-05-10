package demotestng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BefoeTestAfterTestUse {
  @BeforeTest
  public void browserOpen() {
	  System.out.println("browser opened succesfully and url entered ");
  }
  @AfterTest
  public void browserclosed() {
	 System.out.println("browser closed succssfully"); 
  }
  
  @Test(priority = 2)
  public void loginCheck() {
	  System.out.println("logged in successfully");
  }
  
  @Test(priority =1)
  public void addProduct() {
	  System.out.println("product Added....");
  }
  
  @Test(priority = 3)
  public void logoutCheck() {
	  System.out.println("logged Out......!!");
  }
  
  /**
   * @BeforeTest/@AfterTest ---> behalf of all the @test method executed only once either in the starting or at the end 
   */
}
