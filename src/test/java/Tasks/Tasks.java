package Tasks;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Tasks extends launchbrowser{
	
	@Test
	public void verifytitle() {
		driver.get("https://www.saucedemo.com/");
		String expect = "Swag Labs";
		String actual = driver.getTitle();
		if(actual.equalsIgnoreCase(expect)) {
			System.out.println("Matched");
		}else {
			System.out.println("Not Matched");
		}
	}
	
	//form
	@Test
	public void form() {
		driver.get("https://qavalidation.com/demo-form/");
		driver.findElement(By.id("g4072-fullname")).sendKeys("Miti");
		driver.findElement(By.id("g4072-email")).sendKeys("Miti@gamil.com");
		driver.findElement(By.id("g4072-phonenumber")).sendKeys("9632587410");
		driver.findElement(By.xpath("//input[@value=\"5\"]")).click();
		WebElement gender = driver.findElement(By.id("g4072-gender-button"));
		gender.click();
		driver.findElement(By.xpath("//div[@id='ui-id-2']")).click();
		driver.findElement(By.xpath("(//input[@name='g4072-skills[]'])[2]")).click();		
		driver.findElement(By.xpath("(//input[@name='g4072-skills[]'])[4]")).click();
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", ele);
	}
	
	@Test
	public void Autosuggestion() throws InterruptedException {
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[text()='From']")).click();
		Actions action = new Actions(driver);
		WebElement txtbox=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		txtbox.sendKeys("su");
		Thread.sleep(2000);
		txtbox.sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		txtbox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
	@Test
	public void fileupload() {
		driver.get("https://the-internet.herokuapp.com/upload");
		driver.findElement(By.xpath("//*[@id='file-upload']")).sendKeys("/home/staah/Documents/eclipse_projects/Reports_Demo/Screenshots/demo.jpg");
	}
	
	@Test
	public void dragdrop() {
		driver.get("https://jqueryui.com/droppable/");
		WebElement frame = driver.findElement(By.xpath("//*[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).perform();
	}
	
	@Test
	public void mousehover() {
		driver.get("https://www.ebay.com/");
		WebElement ele = driver.findElement(By.xpath("(//a[text()='Electronics'])[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}
	
	public void waits() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Mattresses']"))).click();
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).withMessage("Custom msg").ignoring(NoSuchElementException.class);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Mattresses']"))).click();
	}
	
	@Test
	public void ss() throws IOException {
		driver.get("file:///home/staah/Documents/eclipse_projects/Reports_Demo/report2.html#");
		getss();
	}
	
	public void getss() throws IOException {
		Date currentdate = new Date();
		String ssfilename = "Devanshi_" + currentdate.toString().replace(" ", "-").replace(":", "-");
		File ssfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ssfile, new File(".//screenshots//" + ssfilename + ".png"));
	}
	

	
	

}
