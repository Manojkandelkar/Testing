package browseroperation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandlingDemo {
	public static void main(String[] args) {
	      System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	      driver.get("https://demo.automationtesting.in/Register.html");
	      WebElement dropDown = driver.findElement(By.id("Skills"));
	      Select skillSelect = new Select(dropDown);
	      System.out.println("is multiple selection allowed :" + skillSelect.isMultiple());
	      System.out.println("Printing first selected option :" + skillSelect.getFirstSelectedOption().getText());
	      List<WebElement> optionCount = skillSelect.getOptions();

	      for(int i = 0; i < optionCount.size(); ++i) {
	         System.out.println("options in dropdown :" + ((WebElement)optionCount.get(i)).getText());
	      }

	      skillSelect.selectByIndex(10);
	      skillSelect.selectByValue("Art Design");
	      skillSelect.selectByVisibleText("C++");
	      driver.close();
	   }

}
