package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseMethods;

public class PriceBooksPage extends BaseMethods {

	public PriceBooksPage(WebDriver driver, Properties wOProp,  WebDriverWait wait) {
		this.driver = driver;
		this.wOProp = wOProp;
		this.wait = wait;
	}

	public PriceBooksPage searchPriceBook(String bookName) throws InterruptedException {
		//	WebElement eleSearchBook = driver.findElement(By.xpath("//input[@placeholder='Search this list...']"));
		WebElement eleSearchBook = locateWebElement("xpath", wOProp.getProperty("PriceBooksPage.eleSearchBook.Xpath"));
		clearTypeAndPressEnter(eleSearchBook, bookName);
		enter(eleSearchBook);
		Thread.sleep(3000);
		return this;
	}


	public PriceBooksPage clickOnDropDown() throws InterruptedException {
		WebElement eleDropDownButton = locateWebElement("xpath", wOProp.getProperty("PriceBooksPage.eleDropDownButton.Xpath"));
		wait.until(ExpectedConditions.visibilityOf(eleDropDownButton));
		click(eleDropDownButton);
		Thread.sleep(2000);
		return this;
	}


	public PriceBooksPage clickOnEdit() {
		WebElement eleEdit = locateWebElement("xpath", wOProp.getProperty("PriceBooksPage.eleEdit.Xpath"));
		wait.until(ExpectedConditions.visibilityOf(eleEdit));
		click(eleEdit);
		return this;
	}
	
	public PriceBooksPage enterDescription(String newDescription) throws InterruptedException {
		WebElement eleDescription = locateWebElement("xpath", wOProp.getProperty("PriceBooksPage.eleDescription.Xpath"));
		wait.until(ExpectedConditions.visibilityOf(eleDescription));
		clearAndType(eleDescription,newDescription);
		Thread.sleep(2000);
		return this;
	}

	public PriceBooksPage clickOnSave() {
		WebElement eleSave = locateWebElement("xpath", wOProp.getProperty("PriceBooksPage.eleSave.Xpath"));
		wait.until(ExpectedConditions.visibilityOf(eleSave));
		click(eleSave);
		return this;
	}

	public PriceBooksPage verifyNewDescription(String expectDesciption) {
		WebElement eleNewDescription = locateWebElement("xpath", wOProp.getProperty("PriceBooksPage.eleNewDescription.Xpath"));
		wait.until(ExpectedConditions.visibilityOf(eleNewDescription));
		String actualDescription = getText(eleNewDescription);
		Assert.assertEquals(actualDescription, expectDesciption, "The new descrition is not saved");
		return this;
	}

	
}
