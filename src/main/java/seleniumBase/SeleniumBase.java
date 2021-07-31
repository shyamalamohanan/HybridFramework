package seleniumBase;


import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import design.Browser;
import design.Elements;

public class SeleniumBase implements Elements , Browser{
	public WebDriver driver;
	public Properties prop,wOProp; 
	public WebDriverWait wait; 
	
	public void clearAndType(WebElement ele, String data) {
		ele.clear();
		ele.sendKeys(data);
	}

	public void clearTypeAndPressEnter(WebElement ele, String data) {
		ele.clear();
		ele.sendKeys(data,Keys.ENTER);
	}
	
	public void enter(WebElement ele) {
		ele.sendKeys(Keys.ENTER);
	}
	public void click(WebElement ele) {
		ele.click();
	}
	
	public String getText(WebElement ele) {
		String actual = ele.getText();
		return actual;
	}

	public WebElement locateWebElement(String locatorType, String value) {
		switch(locatorType.toLowerCase()) {
		case "id": return driver.findElement(By.id(value));
		case "name": return driver.findElement(By.name(value));
		case "classname":return driver.findElement(By.className(value));
		case "linktext" : return driver.findElement(By.linkText(value));
		case "partiallinktext":return driver.findElement(By.partialLinkText(value));
		case "xpath":return driver.findElement(By.xpath(value));
		}
		return null;
	}
	
	

}
