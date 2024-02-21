package ExtentReports;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class listenerClass implements ITestListener {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	public static WebDriver driver= new FirefoxDriver();
	
	public void configureReport() {
		htmlReporter = new ExtentSparkReporter("ExtentReportsDemo.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		reports.setSystemInfo("Created By : ", "Devanshi Kshirsagar");
		reports.setSystemInfo("OS : ", "Linux");
		reports.setSystemInfo("Browser : ", "Fierfox ");
		
		htmlReporter.config().setDocumentTitle("ExtentReorts using Listener.");
		htmlReporter.config().setReportName("Test Reports Demo");
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Method Started : " + result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Method Finished : " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Pass Test case is : " + result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
	    System.out.println("Test Failed : " + result.getName());
	    test = reports.createTest(result.getName());
	    test.log(Status.FAIL, MarkupHelper.createLabel("Failed Test case is : " + result.getName(), ExtentColor.RED));
	    // = "Failed to capture screenshot."; // Default value

	    try {
	    	String sspath = getss(result.getName());
	    	 test.addScreenCaptureFromPath(sspath, "Test case is Failed.");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped : " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Skipped Test case is : " + result.getName(), ExtentColor.ORANGE));
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		configureReport();
		System.out.println("On Start Method is Invoked..");
	}	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Finish Method is Invoked..");
		reports.flush();
	}
	
	private String getss(String testName) throws IOException {
		Date currentdate = new Date();
		String ssfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		File ssfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String sspath = ".//screenshots//"+ssfilename+".png";
		FileUtils.copyFile(ssfile, new File(sspath));
		return sspath;
	}
}
