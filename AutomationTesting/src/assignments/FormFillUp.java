package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.SeleniumUtilities;

public class FormFillUp {
	
	 public static void main(String[] args) {
	      SeleniumUtilities s1 = new SeleniumUtilities();
	      WebDriver driver = s1.setup("chrome", "https://demo.automationtesting.in/Register.html");
	      WebElement firstNameField = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
	      firstNameField.sendKeys(new CharSequence[]{"admin", Keys.TAB});
	      Actions act = new Actions(driver);
	      act.sendKeys(new CharSequence[]{"admin", Keys.TAB}).perform();
	      act.sendKeys(new CharSequence[]{"Akurdi,Pune", Keys.TAB}).perform();
	      act.sendKeys(new CharSequence[]{"abd123@gmail.com", Keys.TAB}).perform();
	      act.sendKeys(new CharSequence[]{"9876543210", Keys.TAB}).perform();
	      act.sendKeys(new CharSequence[]{Keys.SPACE, Keys.TAB}).perform();
	      act.sendKeys(new CharSequence[]{Keys.SPACE, Keys.TAB, Keys.SPACE, Keys.TAB, Keys.SPACE}).perform();
	      WebElement skillOptionsSelect = driver.findElement(By.id("Skills"));
	      Select skills = new Select(skillOptionsSelect);
	      skills.selectByIndex(6);
	      WebElement bodyOfPage = driver.findElement(By.cssSelector("body"));
	      bodyOfPage.sendKeys(new CharSequence[]{Keys.PAGE_DOWN});
	      act.sendKeys(skillOptionsSelect, new CharSequence[]{Keys.ENTER, Keys.TAB}).perform();
	      act.sendKeys(new CharSequence[]{Keys.TAB});
	      act.sendKeys(new CharSequence[]{Keys.ENTER, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB}).perform();
	      act.sendKeys(new CharSequence[]{Keys.ENTER, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB}).perform();
	      act.sendKeys(new CharSequence[]{Keys.ENTER, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB}).perform();
	      act.sendKeys(new CharSequence[]{"java@123", Keys.TAB}).perform();
	      act.sendKeys(new CharSequence[]{"java@123", Keys.TAB}).perform();
	      WebElement countryOptionsSelect = driver.findElement(By.id("country"));
	      Select countries = new Select(countryOptionsSelect);
	      countries.selectByIndex(6);
	      act.sendKeys(countryOptionsSelect, new CharSequence[]{Keys.ENTER, Keys.TAB, Keys.TAB}).perform();
	      driver.close();
	   }

}
