package demotestng;

import org.testng.annotations.Test;

public class Example1 {
  @Test
  public void demoMethod1() {
	  System.out.println("Hi,This DemoMethod1 Here....");
	  displayShow();
  }
  @Test 
  public void demoMethod2() {
	  System.out.println("Hi, This is DemoMethod2 here....");
	  displayShow();
  }
  
  void displayShow() {
	  System.out.println("Hi,This is Deisplay Method Here...");
  }
}
