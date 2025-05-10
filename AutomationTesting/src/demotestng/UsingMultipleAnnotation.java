package demotestng;

import org.testng.annotations.Test;

public class UsingMultipleAnnotation {
  @Test(dependsOnMethods="logout", enabled =true)
  public void signIn() {
	  System.out.println("this is signIn");
  }
  @Test(enabled = true, priority =2)
  public void composeMail() {
	  System.out.println("this is compose");
  }
  @Test(priority=1, enabled =true)
  public void logout() {
	  System.out.println("this is Logout");
	  int i = 10/2 ;
  }
}
