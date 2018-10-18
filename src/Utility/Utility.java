package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import Driver.DriverCollections;

public class Utility extends DriverCollections {
	
	//Method to get the configuration of test driver
	public static String configValue(String key) throws Exception {
		String propertyValue;
		Properties prop = new Properties();
		InputStream FIS = new FileInputStream("/Users/arunaarali/eclipse-workspace/Automation_GitHub/src/Config/TestConfig.properties");
		prop.load(FIS);
		propertyValue = prop.getProperty(key);
		return propertyValue;
	}
	
	//Method to get webElement locator value
	public static String locatorValue(String key) throws Exception {
		String locatorValue;
		Properties prop = new Properties();
		InputStream FIS = new FileInputStream("/Users/arunaarali/eclipse-workspace/Automation_GitHub/src/Config/WebElement.properties");
		prop.load(FIS);
		locatorValue = prop.getProperty(key);
		return locatorValue;
	}
	
	//Method to capture the screenshot
	public static void TakeScreenShot(ITestResult result) throws Exception {
		File file = ((TakesScreenshot)Browser).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File("/Users/arunaarali/Desktop/mahesh/ScreenShots/"+result.getName()+".jpg"));
		
	}
}
