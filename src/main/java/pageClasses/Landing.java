package pageClasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.property;

public class Landing implements property {
	
	public static WebElement element = null;
	static Logger log = Logger.getLogger(Landing.class);
	
	/**
	 * Find all relevant fields on the Landing page
	 * @param driver
	 */
	
	
	public static WebElement loginEmailInput (WebDriver driver) {
		element = driver.findElement(By.id("email"));
		log.info("headerLoginButton element found");
		return element;
	}
	
	/**
	 * Returns the Login password input
	 * @param driver
	 * @return
	 */
	
	public static WebElement loginPassInput(WebDriver driver) {
		element = driver.findElement(By.id("password"));
		log.info("loginEmailInput element found");
		return element;
	}

	
	/**
	 * Returns the Login button
	 * @param driver
	 * @return
	 */
	
	public static WebElement mainLoginButton(WebDriver driver) {
		element = driver.findElement(By.name("login"));
		return element;
	}
	


	
	
	//###############################//ACTIONS//######################
	
	/**
	 * Click on mainLogin button
	 * @param driver
	 */
	
	public static void clickOnLoginButton (WebDriver driver) {
		element = mainLoginButton(driver);
		element.click();
	}
	
	

	/**
	 * Fill user email
	 * @param driver
	 * @param origin
	 */
	public static void fillEmailOnLoginModal(WebDriver driver, String userloginemail) throws Exception {
		element = loginEmailInput(driver);
		element.sendKeys(userloginemail);
		Thread.sleep(2000);
		element.sendKeys(Keys.TAB);
		log.info("Entered user login name as " + userloginemail);
	}


	/**
	 * Fill user pass 
	 * @param driver
	 * @param origin
	 */
	public static void fillPassOnLoginModal(WebDriver driver, String userloginpass ) throws Exception {
		element = loginPassInput(driver);
		element.sendKeys(userloginpass);
		Thread.sleep(2000);
		element.sendKeys(Keys.TAB);
		log.info("Enter user password as " + userloginpass);
	}


	
	
	

	
}	
	
	

