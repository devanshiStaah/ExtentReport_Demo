package Tasks;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DownloadFile {

    public static void main(String[] args) {
        String path = "/home/staah/Documents/eclipse_projects/Reports_Demo/Screenshots";

        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("browser.download.folderList", 2);
        options.addPreference("browser.download.dir", path);
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");

        // Set the Firefox WebDriver with the specified options
        WebDriver driver = new FirefoxDriver(options);

        driver.get("http://omayo.blogspot.com/p/page7.html");
        driver.findElement(By.xpath("//a[text()='ZIP file']")).click();
    }
}