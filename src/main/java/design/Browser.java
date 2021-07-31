package design;

import org.openqa.selenium.WebElement;

public interface Browser {

	
	public WebElement locateWebElement (String locatorType, String value );
}
