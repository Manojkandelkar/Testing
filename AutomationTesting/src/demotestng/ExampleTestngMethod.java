package demotestng;

import org.testng.annotations.Test;

public class ExampleTestngMethod {
  @Test(invocationCount =4)
  /**
   * If you want to run method multiple times without using for loop then use "invocationCount" 
   * It will allow you to run method multiple times 
   */
  public void runMethodThroughInvocation() {
	  System.out.println("Hi, This is Manoj");
  }
}
