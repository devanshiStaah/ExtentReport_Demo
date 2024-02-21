package ExtentReports;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestsClass {
	@Test
	public void Test1() {
		System.out.println("This is Test 1");
		AssertJUnit.assertTrue(true);
	}
	@Test
	public void Test2() {
		System.out.println("This is Test 2");
		AssertJUnit.assertTrue(false);
	}
	@Test
	public void Test3() {
		System.out.println("This is Test 3");
		AssertJUnit.assertTrue(false);
	}
	@Test
	public void Test4() {
		System.out.println("This is Test 4");
		AssertJUnit.assertTrue(true);
	}
	@Test
	public void Test5() {
		System.out.println("This is Test 5");
		throw new SkipException("This method is skipped.");
	}
	
}
