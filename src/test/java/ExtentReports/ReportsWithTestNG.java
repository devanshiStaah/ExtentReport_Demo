package ExtentReports;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import screenshot.ss;

public class ReportsWithTestNG extends ss{

	ExtentSparkReporter htmlreporter;
	ExtentReports extent;
	static WebDriver driver = null;

	@BeforeSuite
	public void setup() {

		htmlreporter = new ExtentSparkReporter("ExtentReport3.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);

	}

	@AfterSuite
	public void flush() {
		extent.flush();

	}
	
	@BeforeTest
	public void launchbrowser() {
		driver = new FirefoxDriver();
	}
	
	@AfterTest
	public void closebrowser() {
		driver.close();
	}
	

	@Test
	public void Test() throws IOException {
		ExtentTest test = extent.createTest("MyFirstTest", "Demo of First ExtentReports");		
		driver.get("https://www.saucedemo.com/");
		test.log(Status.INFO,"Navigate to website");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		test.pass("Entering username");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		test.pass("Entering Password");
		driver.findElement(By.id("login-button")).click();
		test.pass("Button clicked");
		test.info("Driver close");
	}
	@Test
	public void Test2() throws IOException {
		ExtentTest test1 = extent.createTest("MyFirstTest", "Demo of First ExtentReports");		
		driver.get("https://www.saucedemo.com/");
		test1.log(Status.INFO,"Navigate to website");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		test1.pass("Entering username");
		driver.findElement(By.id("password")).sendKeys("secwwret_sauce");
		Assert.fail("Entering Wrong Password");
		getss();
		//test1.fail("Entering Wrong Password", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test1.addScreenCaptureFromPath("screenshot.png");
		driver.findElement(By.id("login-button")).click();
		test1.pass("Button clicked");
		test1.info("Driver close");
	}
}
