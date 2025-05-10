package demotestng;

import org.testng.annotations.Test;

public class ExampleTestngMethod2 {
	@Test (enabled=true)
	public void demo() {
		System.out.println("This is demo");
	}
	@Test (enabled=false)
	public void demo2() {
		System.out.println("this is demo2");
	}
	@Test (enabled=false)
	public void demo3() {
		System.out.println("This is demo3");
	}
	/**
	 * By default for each @Test enabled will set as enabled=true
	 * enabled= true ---. consider for execution
	 * enabled = false ----> don't consider for execution
	 */
}
