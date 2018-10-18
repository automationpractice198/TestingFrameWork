package TestCollections;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import TestCollections.TestBase;

public class TestSuite_Regression extends TestBase {	
	@BeforeSuite
	public void BeforeExecution() {
		TestBase.setUpBrowser();
	}
	
	@Test(priority=1,groups="Regression")
	public void TrivagoSearch() throws Exception {
		try {
			if (Browser.getTitle().equals("trivago.com - Compare hotel prices worldwide")){ 
			Browser.findElement(getLocatorVal("searchBox")).sendKeys("Chicago");
			Browser.findElement(getLocatorVal("searchButton")).click();
			List<WebElement> checkInDate = Browser.findElement(getLocatorVal("checkInDatesAvailable")).findElements(getLocatorVal("calendarDate"));
			checkInDate.get(22).click();
			List<WebElement> checkOutDate = Browser.findElement(getLocatorVal("checkInDatesAvailable")).findElements(getLocatorVal("calendarDate"));
			checkOutDate.get(26).click();
			List<WebElement> roomType = Browser.findElements(getLocatorVal("roomType"));
			roomType.get(0).click();
			Assert.assertEquals("Able to search the hotels for the given location", "Able to search the hotels for the given location");
			}
			else {
				Assert.assertEquals("User is not in Trivago home page", "User should be on trivago.com page");
			}	
		} catch (Exception e) {
			Assert.assertEquals("unable to search the hotels for the given location", "Able to search the hotels for the given location");
		}
	}
	
	@Test (priority=2,groups="Regression")
	public static void  printHotelNames(){
		try {
			Thread.sleep(5000);//forcefully adding sleep to get all the elements loaded on the page.
		List<WebElement> hotelName = Browser.findElement(By.className("container_itemlist")).findElement(By.id("js_item_list_section")).findElements(By.className("item__details"));//Without using the getLocatorVal method
		int counter=0;
		for(WebElement e:hotelName) {
			System.out.println("Hotel #"+(++counter));
			System.out.println(e.getText());
			System.out.println("*******************************");
		}
		Assert.assertEquals("Here are the list of hotels for the city you are looking for", "Here are the list of hotels for the city you are looking for");
		}
		catch (Exception e) {
			Assert.assertEquals("unable to find the hotel", "Here are the list of hotels for the city you are looking for");
		}
	}
	
	@AfterSuite
	public void afterExecution() {
		Browser.manage().deleteAllCookies();
		Browser.close();
	}
}
