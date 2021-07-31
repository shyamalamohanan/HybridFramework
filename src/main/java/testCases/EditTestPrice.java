package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseMethods;
import pages.LoginPage;

public class EditTestPrice extends BaseMethods {
	@BeforeTest
	public void setSheetName() {
		testName = "EditTestPrice";
		testDesc = "Edit the description of the Book";
		testAuth = "Shyamala";
		testCategory = "Regression";
		fileName = "EditCamp";
		sheetName = "Sheet1";
	}


	@Test()
	public void verifyEditTestPriceFuntionality() throws InterruptedException {

		new LoginPage(driver,wOProp,prop,wait)
		.enterUserName()
		.enterPassword()
		.clickLoginButton()
		.clickToggleButton()
		.clickViewAllOption()
		.clickOnPriceBooks()
		.searchPriceBook("TC001")
		.clickOnDropDown()
		.clickOnEdit()
		.enterDescription("newDescription")
		.clickOnSave()
		.verifyNewDescription("newDescription");

	}
}

