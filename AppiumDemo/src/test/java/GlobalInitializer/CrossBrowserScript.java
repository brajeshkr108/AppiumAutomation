package GlobalInitializer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;


public class CrossBrowserScript {

	public WebDriver driver;

	public WebDriver getWebDriverInstance(String browserName, String downloadFilepath)
	// public WebDriver getWebDriverInstance(String browserName)
	{
		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "./src/main/resources/drivers/internetexplorer.exe");
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
			Reporter.log("Browser Launched Successfully", true);

		}
		return driver;
	}

}
