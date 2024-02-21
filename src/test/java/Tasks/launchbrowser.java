package Tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class launchbrowser {
	public static WebDriver driver = null;
	static String browserName = "chrome";

	@BeforeSuite
	public void launchbrowser() {
	if (browserName.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	} else if (browserName.equalsIgnoreCase("fierfox")) {
		driver = new FirefoxDriver();
	} else if (browserName.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	} else {
		System.out.println("Provide Specific Browser name");
	}
	}

	@AfterSuite
	public void closebrowser() {
		driver.close();
		driver.quit();
	}
}
