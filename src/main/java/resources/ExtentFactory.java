package resources;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.relevantcodes.extentreports.ExtentReports;


 public class ExtentFactory {
	public static ExtentReports getInstance() {
		
		//report name for every day 
		SimpleDateFormat formater = new SimpleDateFormat("ddMMyyyy");
		Date reportDate = new Date();
		String reportName = formater.format(reportDate);
		
		ExtentReports extent;
		String Path =".\\report\\"+reportName+".html";
		extent = new ExtentReports(Path, false);
		extent
	     .addSystemInfo("Selenium Version", "2.52")
	     .addSystemInfo("Platform", "Window");

		return extent;
	}
}