package Tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Task2 extends launchbrowser {
		
		@Test
		public void verify() {
			driver.get("https://www.saucedemo.com/");
			String expect = "Swag     Labs";
			String actual = driver.getTitle();
			Assert.assertEquals(actual,expect);
		}
		
		@AfterMethod
		public void ss(ITestResult result) throws IOException {
			if(ITestResult.FAILURE==result.getStatus()) {
				Date currentdate = new Date();
				String ssfilename = "Failure_" + currentdate.toString().replace(" ", "-").replace(":", "-");
				File ssfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(ssfile, new File(".//screenshots//" + ssfilename + ".png"));
			}
		}
		
		@Test
		public void alert() throws InterruptedException {
			driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
			driver.manage().window().maximize();	
			WebElement element = driver.findElement(By.xpath("//*[@id='iframeResult']"));
			driver.switchTo().frame(element);
			driver.findElement(By.xpath("/html/body/button")).click();	
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
		}
		
		@Test
		public void readwrite() throws IOException {
			Properties properties = new Properties();
			FileInputStream input = new FileInputStream("/home/staah/Documents/eclipse_projects/Reports_Demo/src/test/resources/Properties/userdata.properties");
			properties.load(input);
			System.out.println(properties.getProperty("name"));
			System.out.println(properties.getProperty("age"));
			System.out.println(properties.getProperty("Surname"));
			
			FileOutputStream output = new FileOutputStream("/home/staah/Documents/eclipse_projects/Reports_Demo/src/test/resources/Properties/userdata.properties");
			properties.setProperty("age", "Kshirsagar");
			properties.store(output, "Stored Successfully");
					
		}
		
		@Test
		public void downloadfile() {
			driver.get("https://demo.automationtesting.in/FileDownload.html");
			driver.findElement(By.xpath("//a[@type='button']")).click();
		}
}
