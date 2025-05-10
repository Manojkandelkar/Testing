package keyboardoperations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginValidationKeyboard2 {
	
	 public static void main(String[] args) {
	      System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.get("https://demo.automationtesting.in/Register.html");
	      WebElement firstNameField = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
	      firstNameField.sendKeys(new CharSequence[]{"admin", Keys.chord(new CharSequence[]{Keys.CONTROL, "a"})});
	      firstNameField.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.CONTROL, "c"})});
	      WebElement lastNameField = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
	      lastNameField.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.CONTROL, "v"})});
	   }

}
