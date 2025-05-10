package demotestng;

import org.testng.annotations.Test;

public class ExampleTestngMethod1 {
  
  /**
   * Here We are using "priority". And according to priority we can run method as per our requirement. such as if we want login as 1st priority 
   * and sendmail as 2nd priority then we can set priority and run accordingly
   */
	@Test (priority =1)
  public void login() {
		System.out.println("This is login Method");
  }
	@Test (priority=3)
	public void sendMail() {
		System.out.println("This is Send mail Method");
	}
	
	@Test (priority =2)
		public void logout() {
			System.out.println("This is logout method");
		}
	
}
