package browseroperation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumUtilities;

public class HandlingCalender {
	public static void main(String[] args) {
	      SeleniumUtilities s1 = new SeleniumUtilities();
	      WebDriver driver = s1.setup("chrome", "https://www.makemytrip.com/");
	      driver.findElement(By.cssSelector("span[data-cy='closeModal']")).click();
	      driver.findElement(By.cssSelector("label[for='departure']>span.lbl_input.appendBottom10")).click();
	      driver.findElement(By.cssSelector("div.DayPicker-Months>*:last-child>.DayPicker-Body>*:nth-of-type(2)>*:nth-of-type(3)>div>p")).click();
	      driver.close();
	   }

}
