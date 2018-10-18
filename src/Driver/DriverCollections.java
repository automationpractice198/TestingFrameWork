package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverCollections {
	public static WebDriver Browser;
	public static void BrowserSelection(String BrowserType, String NavURL) {
		switch (BrowserType) {
		case "Chrome":
			Browser = new ChromeDriver();
			Browser.navigate().to(NavURL);
			Browser.manage().window().maximize();
			break;
		case "Mozilla":
			Browser = new FirefoxDriver();
			Browser.navigate().to(NavURL);
			Browser.manage().window().maximize();
			break;
		}
	}
}
