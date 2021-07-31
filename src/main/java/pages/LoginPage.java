package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseMethods;

public class LoginPage extends BaseMethods {

	public LoginPage(WebDriver driver, Properties wOProp, Properties prop, WebDriverWait wait  ) {
		this.driver = driver;
		this.wOProp = wOProp;
		this.prop = prop;
		this.wait = wait;
		
	}
		
	public LoginPage enterUserName() {
		
		try {
			WebElement eleUserName = locateWebElement("xpath", wOProp.getProperty("LoginPage.eleUserName.Xpath"));
			clearAndType(eleUserName,prop.getProperty("userName"));
			reportStep("UserName entered successfully","pass");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("UserName not entered successfully","fail");
		}
		return this;
	}
	

	public LoginPage enterPassword() {
		try {
			WebElement eleUserPassword = locateWebElement("xpath",wOProp.getProperty("LoginPage.elePassword.Xpath"));
			clearAndType(eleUserPassword, prop.getProperty("password"));
			reportStep("Password entered successfully", "pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("Password not entered successfully", "fail");
		}
		return this;
	}
	
	public HomePage clickLoginButton() {
		WebElement eleLoginButton = locateWebElement("xpath",wOProp.getProperty("LoginPage.eleLoginButton.Xpath"));	
		click(eleLoginButton);
		return new HomePage(driver,wOProp, prop, wait);
	}


}
