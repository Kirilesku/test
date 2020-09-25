package features;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.*;
import pageClasses.*;
import resources.*;



public class AddNewEmployeeScenario extends Base  implements property {
	
static Logger log = Logger.getLogger(AddNewEmployeeScenario.class);


ExtentReports report;
ExtentTest test;
		

    @BeforeMethod
    
    public void setup() throws Exception {

    	driver.get(Url);
    	login(BussinessUserId, BussinessPassword);
    	
	}
	
        @Test
        
		public void addnewemployee() throws Exception {
    	
    	report = ExtentFactory.getInstance();	
		test = report.startTest("Add new employee Scenario");
		
		test.log(LogStatus.INFO, "starting App...");
		
		Dashboard.clickOnStaff(driver);
		
		//Assert business email is presented
		
		WebDriverWait waitpage = new WebDriverWait(driver, 10);
		waitpage.until(ExpectedConditions.visibilityOf(Staff.managerEmail(driver)));
		test.log(LogStatus.INFO, "Manager is pressented in table");
				
		//Click on Staff menu item 
		Staff.clickOnAddEmployeesButton(driver);

		//Fill the form and click on save button 
		Staff.insertFirstName(driver, firstName);
		Staff.insertLastName(driver, lastName);
		Staff.insertemail(driver, useremail);
		Staff.clickSaveEmployeeButton(driver);
		
		
		//Assert status notification
		WebDriverWait waitStatus = new WebDriverWait(driver, 60);
		waitStatus.until(ExpectedConditions.visibilityOfElementLocated(By.id("_status")));
		
		//Navigate back on Staff page 
		Dashboard.clickOnStaff(driver);
		
		
		//Assert employee is added to empoyees table 
				
		WebDriverWait waitpages = new WebDriverWait(driver, 10);
		waitpages.until(ExpectedConditions.visibilityOf(Staff.emailUserName(driver)));
		test.log(LogStatus.INFO, "Employee is pressented in table");
		
}
			 

		   @AfterMethod

		   public void tearDown(ITestResult testResult) throws Exception {
				if (testResult.getStatus() == ITestResult.FAILURE) {
					String path = Screenshots.takeScreenshot(driver, testResult.getName());
					String imagePath = test.addScreenCapture(path);
					test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
				}
			
			
			driver.quit();
			report.endTest(test);
			report.flush();
			
		   
		   }
}

