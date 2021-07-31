package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseMethods;

public class HomePage extends BaseMethods {
	public HomePage(WebDriver driver, Properties wOProp, Properties prop, WebDriverWait wait) {
		this.driver = driver;
		this.wOProp = wOProp;
		this.wait = wait;
	}

	public HomePage clickToggleButton() {
	//	WebElement eleToggleButton = driver.findElement(By.xpath(wOProp.getProperty("HomePage.eleToggleButton.Xpath")));
		WebElement eleToggleButton = locateWebElement("xpath", wOProp.getProperty("HomePage.eleToggleButton.Xpath"));
		wait.until(ExpectedConditions.visibilityOf(eleToggleButton));
		click(eleToggleButton);
		return this;
	}

	public HomePage clickViewAllOption() {
		//WebElement eleViewAll = driver.findElement(By.xpath(wOProp.getProperty("HomePage.eleViewAll.Xpath")));
		WebElement eleViewAll = locateWebElement("xpath", wOProp.getProperty("HomePage.eleViewAll.Xpath"));
		wait.until(ExpectedConditions.visibilityOf(eleViewAll));
		click(eleViewAll);
		return this;
	}

	public PriceBooksPage clickOnPriceBooks() throws InterruptedException {
		//WebElement elePriceBooks = driver.findElement(By.xpath(wOProp.getProperty("HomePage.eleApp.Xpath")));
		WebElement elePriceBooks = locateWebElement("xpath", wOProp.getProperty("HomePage.eleApp.Xpath"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", elePriceBooks);
		click(elePriceBooks);
		Thread.sleep(3000);
		return new PriceBooksPage(driver,wOProp,wait);
	}
}
