package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import seleniumBase.SeleniumBase;

public class BaseMethods extends SeleniumBase{

	public String fileName;
	public String sheetName;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName, testDesc, testAuth, testCategory;


	@BeforeMethod
	public void startApplication() throws IOException {
		FileInputStream configFile = new FileInputStream("./repository/config.properties");
		prop = new Properties();
		prop.load(configFile);
		FileInputStream wOfile = new FileInputStream("./repository/webObjectRepository.properties");
		wOProp = new Properties();
		wOProp.load(wOfile);

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");

		wait = new WebDriverWait(driver,Duration.ofSeconds(60));
	}

	@AfterMethod
	public void closeApplication() {
		driver.close();
	}

	@BeforeSuite
	public void startReport() {
		reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@DataProvider(name = "fetchData")
	public String[][] sendData() throws IOException {
		return utils.ReadExcel.readExcelData(fileName,sheetName);
	}

	@AfterSuite
	public void stopReport() {
		extent.flush();
	}

	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName,testDesc);
		test.assignAuthor(testAuth);
		test.assignCategory(testCategory);
		//test.pass(testCategory);
	}
	
	public void reportStep(String msg,String status) {
		if(status.equalsIgnoreCase("Pass")) {
			test.pass(msg);
		}
		else if(status.equalsIgnoreCase("Fail")) {
			test.fail(msg);
		}
	}
}
