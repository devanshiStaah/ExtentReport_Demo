package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class basicReports {

	public static void main(String[] args) {
		
		ExtentReports extentreports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report.html");
		extentreports.attachReporter(sparkReporter);
		
		ExtentTest test1 = extentreports.createTest("T1");
		test1.pass("This is Test1. passed");
		
		ExtentTest test2 = extentreports.createTest("T2");
		test1.fail("This is Test2.Failed");
		
		extentreports.createTest("T3").skip("T3 skipped");
		
		ExtentTest test4 = extentreports.createTest("T4");
		test1.log(Status.INFO,"This is Test2.info");
		
		ExtentTest test5 = extentreports.createTest("T5");
		test1.log(Status.WARNING,"This is Test2.info");
		
		extentreports.flush();

	}

}
