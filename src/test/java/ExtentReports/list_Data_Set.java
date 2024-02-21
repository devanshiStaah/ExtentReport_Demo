package ExtentReports;

import java.util.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class list_Data_Set {

	public static void main(String[] args) {
		
		 	ExtentReports extentreports = new ExtentReports();
	        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report2.html");
	        extentreports.attachReporter(sparkReporter);
	        
	        List<String> listdata = new ArrayList<>();
	        listdata.add("A");
	        listdata.add("B");
	        listdata.add("C");
	
	        Map<Integer, String> mapData = new HashMap<>();
	        mapData.put(1, "Devanshi");
	        mapData.put(2, "Henisha");
	
	        Set<Integer> keys = mapData.keySet();

	        extentreports.createTest("Set1").log(Status.INFO, MarkupHelper.createOrderedList(listdata)).log(Status.INFO, MarkupHelper.createUnorderedList(listdata));             
	        extentreports.createTest("Set2").log(Status.INFO, MarkupHelper.createOrderedList(mapData)).log(Status.INFO, MarkupHelper.createUnorderedList(mapData));       
	        extentreports.createTest("Set3").log(Status.INFO, MarkupHelper.createOrderedList(keys)).log(Status.INFO, MarkupHelper.createUnorderedList(keys));       
	        
	        
	        extentreports.createTest("Test2").log(Status.INFO, "Not Highlighted").log(Status.INFO, MarkupHelper.createLabel("Highlighted", ExtentColor.GREEN));
	        
	        //exception
	        try {
	        	int i = 5/0;
	        }catch(Exception e) {
	        	extentreports.createTest("Exception1").fail(e);
	        	
	        }
	        
	        Throwable t = new RuntimeException("This is runtime exception.");
	        extentreports.createTest("Exception2").pass(t);
	        
	        extentreports.flush();

	}

}
