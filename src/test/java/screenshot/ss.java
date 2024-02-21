package screenshot;

import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;

public class ss extends BaseClass {
	static WebDriver driver = new FirefoxDriver();
	public void getss() throws IOException {
		Date currentdate = new Date();
		String ssfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		File ssfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ssfile, new File(".//screenshots//" + ssfilename + ".png"));
	}

}
