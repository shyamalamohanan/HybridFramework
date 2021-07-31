package design;

import org.openqa.selenium.WebElement;

public interface Elements {

	public void clearAndType(WebElement ele, String data);
	
	public void clearTypeAndPressEnter(WebElement ele, String data);
	
	public void enter(WebElement ele);
	
	public void click(WebElement ele);
	
	public String getText(WebElement ele);
}
