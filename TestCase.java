package SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestCase{
	private WebDriver driver;
	
	private Utility utility;
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		//creating object of Utility
		utility = new Utility(driver);
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}


	@Test
	public void loginTest() {
		
//		utility.usernameLocator("standard_user");
//		utility.passwordLocator("secret_sauce");
//		utility.loginLocator();
		utility.fillForm();
	}
	@Test
	public boolean verifyInventoryPage() {
		utility.fillForm();
		//utility.inventoryObj
		WebElement inv = driver.findElement(By.id("item_4_img_link"));
		return inv.isDisplayed();
	}
	
	@Test
	public void loginWithoutUsername() {
		utility.passwordLocator("secret_sauce");
		utility.loginLocator();
		Assert.assertTrue(utility.errorState());
		utility.captureScreenshot("loginWithoutUsername");
	}
	
	
	

}
