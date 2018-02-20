package GenericLibrary;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import GlobalInitializer.GlobalVariable;

public class Report {

	
	public static GlobalVariable initializer = GlobalVariable.initialize();
	
	
	 public static ExtentTest startTest(String message)
     {
         return initializer.extent.startTest(message);
         
     }

     public static void passStatus(String message)
     {
         initializer.logger.log(LogStatus.PASS, message);
     }

     public static void failStatus(String message)
     {
    	 initializer.logger.log(LogStatus.PASS, message);
     }

     public static void info(String message)
     {
    	 initializer.logger.log(LogStatus.PASS, message);
     }


     public static void error(String message)
     {
    	 initializer.logger.log(LogStatus.PASS, message);
     }

     public static void skip(String message)
     {
    	 initializer.logger.log(LogStatus.PASS, message);
     }

     public static void warning(String message)
     {
    	 initializer.logger.log(LogStatus.PASS, message);
     }


     public static void endTest()
     {
         //return initializer.extent.StartTest(message);

         initializer.extent.endTest(initializer.logger);
     }


     public static void endReport()
     {
         //extent.EndTest(logger);
         try
         {
             initializer.extent.flush();
             initializer.extent.close();
         }
         catch (Exception ex)
         {
             //Console.WriteLine(ex.Message);
         }
     }


	
	
}
