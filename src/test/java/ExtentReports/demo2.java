package ExtentReports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class demo2 { // Corrected class name
    public static void main(String[] args) {

        ExtentReports extentreports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report1.html");
        extentreports.attachReporter(sparkReporter);

        extentreports.createTest("Test1").log(Status.PASS, "<b>Passs</b>").log(Status.INFO, "<i>Passs</i>")
                .log(Status.INFO, "<u>Passs</u>").log(Status.WARNING, "Passs").log(Status.PASS, "Passs")
                .log(Status.INFO, "Passs");

        String xmldata = "<menu id=\"file\" value=\"File\">\n" + "  <popup>\n"
                + "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\n"
                + "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\n"
                + "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\n" + "  </popup>\n" + "</menu>";

        String jsonData = "{\"menu\": {\n" + "  \"id\": \"file\",\n" + "  \"value\": \"File\",\n"
                + "  \"popup\": {\n" + "    \"menuitem\": [\n"
                + "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n"
                + "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n"
                + "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" + "    ]\n" + "  }\n" + "}}";

        extentreports.createTest("Test2").log(Status.INFO, MarkupHelper.createCodeBlock(xmldata, CodeLanguage.XML));
        extentreports.createTest("Test3").log(Status.INFO, MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));
        extentreports.flush();

    }
}