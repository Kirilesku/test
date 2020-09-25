package resources;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import pageClasses.*;
import pageClasses.Landing;


public class Base implements property {

		ExtentReports report;
		ExtentTest test;

		//Unique user
		final static Date date= new Date(); 
		final static long uniquser = date.getTime();
	    final static long user = uniquser;
		
		//user email 
	    public static String useremail= "testingp278+"+user+"@gmail.com";	
			
	    //user email 
	    public static String useremailcheck= "testingp278+"+user;
			
		//user name 
		public final String username = "testingp278"+user+"T"; 

		//First name
		protected final String firstName = user+"f";
		
		//Last name
		protected final String lastName = user+"l";
			    
		
		final String welcomeEmail = "Hi "+username ;  
		
		
		public WebDriver driver;
	
		public String Url;
	
		 
		 @BeforeTest(alwaysRun = true)
		 @Parameters("env") 
		 public void  setupEnv (String env) throws Exception {
			 
				//Check the parameter passed from TestNG 
				if(env.equalsIgnoreCase("staging")){
		
					 Url = "https://staging.humanity.com/app/";
			
				}else if (env.equalsIgnoreCase("develop")){
		 
					Url = "https://develop.humanity.com/app/";
				}else if (env.equalsIgnoreCase("prod")){
					 
					Url = "https://humanity.com/app/";
				}
				else{
					//If no browser passed throw exception
					throw new Exception("enviroment is not correct");
				}

		}
		 
		
		 @BeforeMethod(alwaysRun = true)
		 @Parameters("browser")
		 public void setup(String browser) throws Exception {
			 
		 //Check the parameter passed from TestNG 
			
	   	if(browser.equalsIgnoreCase("firefox")){
		
		System.setProperty("webdriver.gecko.driver", ".\\src\\main\\java\\executables\\geckodriver.exe");
		driver = new FirefoxDriver();
			
		}
		
		else if(browser.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\java\\executables\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}
	
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		

		// Maximize the browser's window
		driver.manage().window().maximize();
	
	    //Resize current window to the set dimension **************
		//driver.manage().window().setSize(new Dimension(1800, 1080));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		 }
		  
		
		//Login method 
		public void login(String userId, String password) throws Exception {
			Landing.fillEmailOnLoginModal(driver, userId);
			Landing.fillPassOnLoginModal(driver, password);
			Landing.clickOnLoginButton(driver);
		
		}
		
		//Logout 
		public void logout() throws Exception {
		
		Dashboard.clickOnAvatar(driver);
		Dashboard.clickSignOut(driver);

}

	   @AfterMethod
	  
		   public void tearDown(ITestResult testResult) throws Exception {
				if (testResult.getStatus() == ITestResult.FAILURE) {
					String path = Screenshots.takeScreenshot(driver, testResult.getName());
					String imagePath = test.addScreenCapture(path);
					test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
				}
				report.endTest(test);
				report.flush();   

}
	   

}

	   
