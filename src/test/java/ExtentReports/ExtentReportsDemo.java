package ExtentReports;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	
	 static WebDriver driver = null;
	
	public static void main(String[] args) throws IOException {
		
		ExtentSparkReporter htmlreporter = new ExtentSparkReporter("ExtentReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		
		ExtentTest test = extent.createTest("MyFirstTest", "Demo of First ExtentReports");
		driver = new FirefoxDriver();
		driver.get("https://www.saucedemo.com/");
		test.log(Status.INFO,"Navigate to website");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		test.info("Entering username");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		test.info("Entering Password");
		driver.findElement(By.id("login-button")).click();
		test.info("Button clicked");
		test.info("Driver close");
		
		
		
		ExtentTest test1 = extent.createTest("MyFirstTest1", "Demo1 of First ExtentReports");
		driver = new FirefoxDriver();
		driver.get("https://www.saucedemo.com/");
		test1.log(Status.INFO,"Navigate to website");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		test1.info("Entering username");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		test1.fail("details").addScreenCaptureFromPath("screenshot.png");
		driver.findElement(By.id("login-button")).click();
		test1.pass("Button clicked");
		test1.pass("Driver close");
		//driver.close();
		//driver.quit();
		extent.flush();
	}

}
