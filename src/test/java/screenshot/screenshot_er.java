package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class screenshot_er {
	public static WebDriver driver;
	public static void main(String[] args) {
		
		ExtentReports extentreports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report3.html");
        extentreports.attachReporter(sparkReporter);
        
      
        driver= new FirefoxDriver();
        driver.get("file:///home/staah/Documents/eclipse_projects/Reports_Demo/report2.html#");
        String base64 = capturess();
        String path = capturess("demo.jpg");
        
        extentreports.createTest("Test1", "Test 1 Decsription")
        .info("This is Test1")
        .addScreenCaptureFromBase64String(base64);
        
        extentreports.createTest("Test2", "Test 2Decsription")
        .info("This is Test2")
        .addScreenCaptureFromPath(path);
        
        extentreports.createTest("Test3", "Test 3 Decsription")
        .info("This is Test3")
        .addScreenCaptureFromBase64String(base64,"Test 3");
        
        extentreports.createTest("Test4", "Test 4 Decsription")
        .info("This is Test4")
        .addScreenCaptureFromPath(path,"Test 4");
        
        extentreports.createTest("Test5", "Test 5 Decsription")
        .info("This is Test5")
        .fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
        
        extentreports.createTest("Test6", "Test 6 Decsription")
        .info("This is Test6")
        .fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        
        extentreports.createTest("Test7", "Test 7 Decsription")
        .info("This is Test7")
        .fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"Test 7").build());
        
        extentreports.createTest("Test8", "Test 8 Decsription")
        .info("This is Test8")
        .fail(MediaEntityBuilder.createScreenCaptureFromPath(path, "Test8").build());
        
        
        Throwable t = new RuntimeException("This is runtime exception.");
        extentreports.createTest("Test9", "Test 9 Decsription")
        .info("This is Test9")
        .fail(t, MediaEntityBuilder.createScreenCaptureFromPath(path, "Test9").build());
        
        extentreports.createTest("Test10", "Test 10 Decsription")
        .info("This is Test10")
        .fail(t, MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "Test10").build());
        
        
        extentreports.flush();	
        driver.close();
	}
	
	public static String capturess(String filename) {
		TakesScreenshot takess = (TakesScreenshot) driver;
		File source = takess.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/"+filename);
		try {
			FileUtils.copyFile(source, dest);
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot Saved Successfully..");
		return dest.getAbsolutePath();
	}
	public static String capturess() {
		TakesScreenshot takess = (TakesScreenshot) driver;
		String source = takess.getScreenshotAs(OutputType.BASE64);
		System.out.println("Screenshot Saved Successfully..");
		return source;
	}

}
