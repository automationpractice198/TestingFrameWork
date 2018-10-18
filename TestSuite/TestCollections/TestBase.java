package TestCollections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Driver.DriverCollections;
import Utility.Utility;

public class TestBase extends DriverCollections{
	//Method to set up the browser as per config file
	public static void setUpBrowser(){
		try {
		DriverCollections.BrowserSelection(Utility.configValue("Driver"),Utility.configValue("NavURL"));
		}
		catch (Exception e) {
			throw new IllegalArgumentException("File doesnot exist");
		}
	}
	
	//Wait method to check the availibility of the element before returning the locator type
	public static By waitForElement(By element) {
		WebElement w =  new WebDriverWait(Browser,10).
				until(ExpectedConditions.presenceOfElementLocated(element));
		boolean found = w != null;
		if (found) {
			return element;
		}
		else throw new IllegalAccessError();
	}
	
	//Method which returns the locator By type.
	public static By getLocatorVal(String element){
		try {
			String locator = Utility.locatorValue(element);
			String LocatorType = locator.split(":")[0];
			String value = locator.split(":")[1];
			if(LocatorType.equalsIgnoreCase("id")) return waitForElement(By.id(value));
			else if (LocatorType.equalsIgnoreCase("name")) return waitForElement(By.name(value));
			else if (LocatorType.equalsIgnoreCase("className")) return waitForElement(By.className(value));
			else if ((LocatorType.equalsIgnoreCase("tagname"))) return waitForElement(By.tagName(value));
			else if ((LocatorType.equalsIgnoreCase("linktext"))) return waitForElement(By.linkText(value));
			else if (LocatorType.equalsIgnoreCase("partiallinktext")) return waitForElement(By.partialLinkText(value));
			else if ((LocatorType.equalsIgnoreCase("cssselector"))) return waitForElement(By.cssSelector(value));
			else if (LocatorType.equalsIgnoreCase("xpath")) return waitForElement(By.xpath(value));
			else throw new Exception("Locator type '" + LocatorType + "' not defined!!");
		}
		catch (Exception e) {
			throw new IllegalArgumentException("File doesnot exist");
		}
	}
	
}
