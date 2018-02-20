package GlobalInitializer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import GlobalInitializer.GlobalVariable;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import GenericLibrary.Generic;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BrowserInitializer {
	
	public static GlobalVariable initializer = GlobalVariable.initialize();	
	String workingDirectory = System.getProperty("user.dir");
	String extent_path = workingDirectory + Generic.getPropertyValue("ExtentReportPath") + "TestRunReport_"+ System.currentTimeMillis() + ".html";
	
	@BeforeClass
	public void launchApp() throws InterruptedException, MalformedURLException {

		// Create object of DesiredCapabilities class and specify android platform
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		
		// capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");

		// set the capability to execute our test in Android Platform

		capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);

		// we need to define platform name

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Generic.getPropertyValue("PlatformName"));

		// Set the device name as well (you can give any name)

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Generic.getPropertyValue("DeviceName"));

		// set the android version as well

		capabilities.setCapability(MobileCapabilityType.VERSION, Generic.getPropertyValue("Version"));

		capabilities.setCapability("apppackage", Generic.getPropertyValue("Apppackage"));

		capabilities.setCapability("appactivity", Generic.getPropertyValue("Appactivity"));

		//String apkFilePath = System.getProperty("user.dir") + "/Apk/selendroid-test-app.apk";
		String apkFilePath = System.getProperty("user.dir") + "/Apk/"+Generic.getPropertyValue("APKFile");
		
		capabilities.setCapability("app", apkFilePath);

		//initializer.driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		initializer.driver = new AndroidDriver(new URL(Generic.getPropertyValue("URL")), capabilities);
		
		initializer.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//extent = new ExtentReports(extent_path, true);
		
		initializer.extent = new ExtentReports(extent_path, true);

		// driver = new AndroidDriver(url, capabilities);

		Thread.sleep(5000);

	}

	@AfterClass
	public void closeBrowser() {
		initializer.extent.close();
		initializer.driver.close();

	}

	@AfterSuite
	public void executionResultFile() throws IOException {
		// File srcHtmlPath=new
		// File(GenericFunctions.getPropertyValue("newExtentReportPath"));
		// File destHtmlPath=new
		// File(GenericFunctions.getPropertyValue("ExtentReportBackUpPath")+"BackUp"+System.currentTimeMillis()+".html");
		// FileOperations.copyHtmlFile(srcHtmlPath,destHtmlPath);

		/*
		 * File srcHtmlPath1=new File(GenericFunctions.getPropertyValue(
		 * "E:\\ITG_SeleniumWorkspace\\target\\surefire-reports\\testng-failed.xml"));
		 * File destHtmlPath1=new File(GenericFunctions.getPropertyValue(
		 * "E:\\ITG_SeleniumWorkspace\\src\\main\\resources\\"+"BackUp"+System.currentTimeMillis()+"
		 * .xml")); FileOperations.copyHtmlFile(srcHtmlPath1,destHtmlPath1);
		 */
		// FileOperations.copyHtmlFile("E:\\ITG_SeleniumWorkspace\\target\\surefire-reports\\testng-failed.xml",
		// "E:\\ITG_SeleniumWorkspace\\src\\main\\"+System.currentTimeMillis()+".xml");

	}

}
