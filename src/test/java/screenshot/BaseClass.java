package screenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public static WebDriver driver;

	@BeforeSuite
	public void launchbrowser() {
		driver = new FirefoxDriver();
	}

	@AfterSuite
	public void closebrowser() {
		driver.close();
	}
}
