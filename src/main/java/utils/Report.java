package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Report {

	public static void main(String[] args) {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		//to view the histroy of execution 
		//reporter.setAppendExisting(true);
		ExtentReports extent = new ExtentReports();

		extent.attachReporter(reporter);
		
		ExtentTest testcase1 = extent.createTest("EditTestPrice","Edit the description of the Book");
		testcase1.assignAuthor("Shyamala");
		testcase1.assignCategory("Regression Test");
		testcase1.pass("Description edited successfuly");
		extent.flush();
		
	}
}
