package pageClasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.Base;
import resources.property;

public class Staff extends Base implements property  {


	public static WebElement element = null;
	static Logger log = Logger.getLogger(Staff.class);
	

	 
	/**
	 * Returns Add Employee button 
	 * @param driver
	 * @return
	 */
	public static WebElement addEmployeesButton (WebDriver driver) {
		element = driver.findElement(By.xpath("//button [contains(text(), 'Add Employees')]"));
		return element;
	}
	
	/**
	 * Returns First Name input
	 * @param driver
	 * @return
	 */
	public static WebElement firstNameInput (WebDriver driver, String firstName)  {
		element = driver.findElement(By.id("_asf1"));
		return element;
	}
	
	/**
	 * Returns Last Name input
	 * @param driver
	 * @return
	 */
	public static WebElement lastNameInput (WebDriver driver, String lastName) {
		element = driver.findElement(By.id("_asl1"));
		return element;
	}
	
	/**
	 * Returns Last Name input
	 * @param driver
	 * @return
	 */
	public static WebElement emailInput (WebDriver driver, String lastName) {
		element = driver.findElement(By.id("_ase1"));
		return element;
	}
	
	/**
	 * Returns Save Employee button
	 * @param driver
	 * @return
	 */
	public static WebElement saveEmployeeButton (WebDriver driver) {
		element = driver.findElement(By.id("_as_save_multiple"));
		return element;
	}
	
	/**
	 * Returns manager email 
	 * @param driver
	 * @return
	 */
	public static WebElement managerEmail (WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'"+BussinessUserId+"')]"));
		return element;
	}
	
	
	/**
	 * Returns employee email
	 * @param driver
	 * @return
	 */
	public static WebElement emailUserName (WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'"+useremailcheck+"')]"));
		return element;
	}
	
	
	//###############################//ACTIONS//######################

		public static void clickOnAddEmployeesButton (WebDriver driver) {
		element = addEmployeesButton(driver);
		element.click();
		}
			
		public static void insertFirstName (WebDriver driver, String firstName) {
		element = firstNameInput(driver, firstName);
		element.sendKeys(firstName);
		}
		
		public static void insertLastName (WebDriver driver, String lastName) {
			element = lastNameInput(driver, lastName);
			element.sendKeys(lastName);
			}
			
		public static void insertemail (WebDriver driver, String useremail) {
			element = emailInput(driver, useremail);
			element.sendKeys(useremail);
			}	
		
		
		public static void clickSaveEmployeeButton (WebDriver driver) {
			element = saveEmployeeButton(driver);
			element.click();
			}	
		
}
			
