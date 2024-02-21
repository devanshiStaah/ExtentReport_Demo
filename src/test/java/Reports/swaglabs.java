package Reports;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Tasks.launchbrowser;

public class swaglabs extends launchbrowser {
	
	@Test
	public void login() {
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}
	
	@Test(dependsOnMethods = { "login" })
	public void addTocart() {
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
	}
	
	@Test(dependsOnMethods = { "addTocart" })
	public void goTocart() {
		driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
	}
	
	@Test(dependsOnMethods = { "goTocart" })
	public void removeTocart() {
		driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
	}
	
	@Test(dependsOnMethods = { "removeTocart" })
	public void checkout() {
		driver.findElement(By.id("checkout")).click();
		
	}
	@Test(dependsOnMethods = { "checkout" })
	public void placeOrder() {
		driver.findElement(By.id("first-name")).sendKeys("Devanshi");
		driver.findElement(By.id("last-name")).sendKeys("Kshirsagar");
		driver.findElement(By.id("postal-code")).sendKeys("395023");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		driver.findElement(By.id("back-to-products")).click();
	}
}
