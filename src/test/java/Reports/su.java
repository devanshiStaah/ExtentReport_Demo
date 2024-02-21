package Reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class su {
    @Test
    public void Login() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Staah\\Desktop\\New folder\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver();
        driver.get("https://stayinn.suissu.com/config/login.php");
        driver.findElement(By.xpath("//*[@id=\"login-username\"]")).sendKeys("trushant69@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"login-password\"]")).sendKeys("Staah@11");
        driver.findElement(By.xpath("//*[@class=\"btn btn-primary\"]")).click();
        

    }
}
