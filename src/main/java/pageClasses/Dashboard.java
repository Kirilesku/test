package pageClasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.property;


public class Dashboard implements property  {

	public static WebElement element = null;
	static Logger log = Logger.getLogger(Dashboard.class);
	
	/**
	 * Returns the Staff menu item
	 * @param driver
	 * @return
	 */
	
	//Staff
	
	public static WebElement staffPrimeNav (WebDriver driver) {
		element = driver.findElement(By.id("sn_staff"));
		return element;
	}
	

	/**
	 * Returns the Avatar
	 * @param driver
	 * @return
	 */

	
	public static WebElement avatar(WebDriver driver) {
		element = driver.findElement(By.id("tr_avatar"));
		return element;
	}
	
		

	/**
	 * Returns Sign out
	 * @param driver
	 * @return
	 */

	
	public static WebElement signout (WebDriver driver) {
		element = driver.findElement(By.linkText("Sign Ot"));
		return element;
	}
	
	//###############################//ACTIONS//######################
	
	/*
	 * clicks on Staff menu item 
	 * @param driver
	 */

		public static void clickOnStaff (WebDriver driver) {
		element = staffPrimeNav(driver);
		element.click();
		}
		
		/**
		 * Click on Avatar
		 * @param driver
		 */
		
		public static void clickOnAvatar (WebDriver driver) {
			element = avatar(driver);
			element.click();
		}
		
		/**
		 * Click on Sign Out 
		 * @param driver
		 */
		
		public static void clickSignOut (WebDriver driver) {
			element = signout(driver);
			element.click();
		}
		
}
			
