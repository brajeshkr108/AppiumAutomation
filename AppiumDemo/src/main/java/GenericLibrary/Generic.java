package GenericLibrary;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import GlobalInitializer.GlobalVariable;

public class Generic {
	
	public static GlobalVariable initializer = GlobalVariable.initialize();	

		public static String getPropertyValue(String propKey) 
		{
		   Properties config = null;
			try {
				config = new Properties();
				FileInputStream ip = new FileInputStream("./src/main/resources/Resources/config.properties");

				config.load(ip);
			} catch (Exception e) {
			}

			return config.getProperty(propKey);
		}

	
		//-----------------------------------------------------------------------------------------------
		//Method : takeScreenShot
		//Description : This method is used to capture the screen shot 


		/*public static String takeScreenShotPath(){

			String projectDirectory = System.getProperty("user.dir");

			//String scrPath=".\\src\\main\\resources\\Screenshots\\"+"screenshot_"+System.currentTimeMillis()+".jpg";
			String screenshotPath=Generic.getPropertyValue("ScreenshotPath")+"\\screenshot_"+System.currentTimeMillis()+".jpg";

			try {
				Robot rob=new Robot();
				Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
				Rectangle screenRect=new Rectangle(d);
				BufferedImage img=rob.createScreenCapture(screenRect);

				ImageIO.write(img, "jpg", new File(screenshotPath));

			} catch (Exception e) {
				e.printStackTrace();

			//return current+(screenshotPath.replaceFirst(".", ""));
		}
			//String s=projectDirectory+screenshotPath;
			return projectDirectory+screenshotPath;
			
			//String s=initializer.screenShotFilename;
			
			//return initializer.screenShotFilename;
			
			
	
}*/
		
		
	
		/*public static void takeScreenShot() {
			
			String projectDirectory = System.getProperty("user.dir");
			
			String screenshotPath=Generic.getPropertyValue("ScreenshotPath");

			DateFormat dateFormat;
			
			
			  // Set folder name to store screenshots.
			  String destDir = "screenshots";
			  //String destDir = screenshotPath;
			
			  // Capture screenshot.
			  File scrFile = ((TakesScreenshot) initializer.driver).getScreenshotAs(OutputType.FILE);
			  // Set date format to set It as screenshot file name.
			  dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
			  // Create folder under project with name "screenshots" provided to destDir.
			  new File(destDir).mkdirs();
			  // Set file name using current date time.
			  String destFile = dateFormat.format(new Date()) + ".png";

			  try {
			   // Copy paste file at destination folder location
			   FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
			 }
		*/
		
		
		

		public static void takeScreenShot() throws IOException {
		
			//SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
			//Date date=new Date();
			initializer.screenShotFilename=System.getProperty("user.dir")+"//src//main//resources//Screenshots//"+"screenshot_"+System.currentTimeMillis()+".png";
			String screenPath=initializer.screenShotFilename;
			//initializer.fileName = sdf.format(date);
			//String screenShotFilename=System.getProperty("user.dir")+"//src//main//resources//Screenshots//"+fileName+".png";
		
			File des = ((TakesScreenshot) initializer.driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(des, new File(System.getProperty("user.dir")+"//src//main//resources//Screenshots//"+fileName+".png"));
			
			FileUtils.copyFile(des, new File(screenPath));
			
			System.out.println("Screenshot captured");
			
		
		}	
		
		
}
