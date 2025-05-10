package assignments;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.SeleniumUtilities;

public class ActitimeCreateTaskValidation {
	
	 public static void main(String[] args) {
	      SeleniumUtilities s1 = new SeleniumUtilities();
	      WebDriver driver = s1.setup("chrome", "https://online.actitime.com/pboss/login.do");
	      driver.findElement(By.id("username")).sendKeys(new CharSequence[]{"bpk26222@gmail.com"});
	      driver.findElement(By.name("pwd")).sendKeys(new CharSequence[]{"Test@123"});
	      driver.findElement(By.id("loginButton")).click();
	      driver.findElement(By.cssSelector(".content.tasks>div:last-child")).click();
	      driver.findElement(By.cssSelector(".addNewButton>div:nth-of-type(2)")).click();
	      driver.findElement(By.cssSelector(".dropdownContainer.addNewMenu>div:nth-of-type(3)")).click();
	      WebDriverWait wait = new WebDriverWait(driver, 20L);
	      driver.findElement(By.cssSelector(".customerProjectSelectorPlaceholder>div>table>tbody>tr:nth-of-type(1)>td:first-child>div>div>div:first-child>div:nth-of-type(3)")).click();
	      driver.findElement(By.cssSelector(".customerSelector>div>div:last-child>div>div>div>div:nth-of-type(4)")).click();
	      WebElement creatingNewTask = driver.findElement(By.cssSelector(".projectSelector>div>div>div:nth-of-type(3)"));
	      creatingNewTask.click();
	      driver.findElement(By.cssSelector(".projectSelector>div>div:last-child>div>div>div>div:nth-of-type(5)")).click();
	      WebElement taskNameInput = driver.findElement(By.cssSelector(".taskTableContainer>table>tbody>tr>td:nth-of-type(1)>input[placeholder='Enter task name']"));
	      taskNameInput.sendKeys(new CharSequence[]{"SeleniumTesting"});
	      wait.until(ExpectedConditions.elementToBeClickable(taskNameInput));
	      driver.findElement(By.cssSelector(".taskTableContainer>table>tbody>tr:first-child>td:nth-of-type(4)>div>table>tbody>tr>td:nth-of-type(2)>em>button")).click();
	      driver.findElement(By.cssSelector(".x-date-picker>table>tbody>tr:nth-of-type(2)>td>table>tbody>tr:nth-of-type(2)>td:nth-of-type(4)")).click();
	      WebElement workSelection = driver.findElement(By.cssSelector("div.contentWrapper>div.innerContent>div:nth-of-type(3)>div>div:first-child>table>tbody>tr:first-child>td:nth-of-type(5)>div:last-child>div"));
	      workSelection.click();
	      wait.until(ExpectedConditions.elementToBeClickable(workSelection));
	      driver.findElement(By.cssSelector("tbody>tr:first-child>td:nth-of-type(5)>div:first-child>div>div:last-child>div>div:first-child>div>div:nth-of-type(5)")).click();
	      driver.findElement(By.cssSelector("#createTasksPopup_content>div.scrollableContainer>div.contentWrapper>div.innerContent>div:nth-of-type(3)>div>div:first-child>table>tbody>tr:first-child>td:nth-of-type(6)>label>span:last-child")).click();
	      driver.findElement(By.cssSelector(".commitButtonPlaceHolder>div>div:first-child")).click();
	      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".taskRowsTableContainer>table>tbody>tr>td:nth-of-type(3)>div>div>div:first-child>div:last-child")));
	      List<WebElement> tableTaskContent = driver.findElements(By.cssSelector(".taskRowsTableContainer>table>tbody>tr>td:nth-of-type(3)>div>div>div:first-child>div:last-child"));
	      wait.until(ExpectedConditions.visibilityOfAllElements(tableTaskContent));
	      boolean taskFound = false;

	      for(int i = 0; i < tableTaskContent.size(); ++i) {
	         wait.until(ExpectedConditions.visibilityOf((WebElement)tableTaskContent.get(i)));
	         System.out.println("Count in table :" + ((WebElement)tableTaskContent.get(i)).getText());
	         if (((WebElement)tableTaskContent.get(i)).getText().equals("SeleniumTesting")) {
	            System.out.println("********Task Is Present And Added Successfully********");
	            taskFound = true;
	            break;
	         }
	      }

	      if (taskFound) {
	         List<WebElement> deleteTaskContainer = driver.findElements(By.cssSelector(".tasksTable>div:first-child>div>div>div:first-child>div:first-child>div:nth-of-type(1)>div:last-child>table>tbody div.checkbox.inactive"));
	         deleteTaskContainer.size();

	         WebElement confirmDeleteButton;
	         for(int i = 0; i < tableTaskContent.size(); ++i) {
	            confirmDeleteButton = (WebElement)tableTaskContent.get(i);
	            String listOfTask = confirmDeleteButton.getText();
	            System.out.println("Task List :" + listOfTask);
	            if (listOfTask.equals("SeleniumTesting")) {
	               System.out.println("**********" + deleteTaskContainer.get(i));
	               wait.until(ExpectedConditions.elementToBeClickable((WebElement)deleteTaskContainer.get(i)));
	               ((WebElement)deleteTaskContainer.get(i)).click();
	               break;
	            }
	         }

	         WebElement deleteButton = driver.findElement(By.cssSelector(".bulkOperationsPanel>div:nth-of-type(6)"));
	         wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
	         deleteButton.click();
	         confirmDeleteButton = driver.findElement(By.cssSelector(".dialogWithPointerWrapper.deleteDialog>div:first-child>div:first-child>div>div:nth-of-type(5)>div:first-child>div>span"));
	         wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton));
	         confirmDeleteButton.click();
	         System.out.println("**************Task Deleted Successfully***********");
	      } else {
	         System.out.println("Task not found, cannot delete.");
	      }

	   }

}
