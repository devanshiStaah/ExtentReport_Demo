package ExtentReports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class diff_attributes {

	public static void main(String[] args) {
		ExtentReports extent = new ExtentReports();
		File file = new File("report1.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extent.attachReporter(sparkReporter);
		extent.createTest("Test 1").assignAuthor("Devanshi Kshirsagar").assignCategory("First").assignDevice("Chrome").pass("Test 1 is Passed");
		
		extent.createTest("Test 2").assignAuthor("Dityaa Kshirsagar").assignCategory("Second").assignDevice("Edge").pass("Test 2 is Passed");
		
		extent.createTest("Test 3").assignAuthor("Henisha Parmar").assignCategory("Third").assignDevice("Fierfox").pass("Test 3 is Passed");
		
		extent.flush();
	}

}
