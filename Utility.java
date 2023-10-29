package SauceDemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility extends Base {
	private WebDriver driver;
	// finding elements
	By usernameLocator = By.id("user-name");
	By passwordLocator = By.id("password");
	By loginLocator = By.id("login-button");
	By errorstateLocator = By.tagName("h3");
	By inventoryObj = By.id("item_4_img_link");

	// writting constructor
	// WebDriver is a property of Utility
	
	
	public Utility(WebDriver driver) {
		this.driver = driver;
	}
	//creating method for username
	public void usernameLocator(String un) {
		driver.findElement(usernameLocator).sendKeys(un);
	}
	//creating method for password
	public void passwordLocator(String pwd) {
		driver.findElement(passwordLocator).sendKeys(pwd);
	}
	
	
	//creating method for login
		public void loginLocator() {
			driver.findElement(loginLocator).click();
		}

	public void logIn(String un, String pwd) {
		
		usernameLocator(un);
		passwordLocator(pwd);
		loginLocator();
		
		

	}
	public void inventoryObj1() {
		
	}
	
	public boolean errorState() {
		return driver.findElement(errorstateLocator).isDisplayed();
	}
	
	public void loginWithoutPassword(String un) {
		usernameLocator(un);
		loginLocator();
	}
	
	public void loginWithoutUsername(String pwd) {
		passwordLocator(pwd);
		loginLocator();
	}
	
	
	public void fillForm() {
		usernameLocator("standard_user");
		passwordLocator("secret_sauce");
		loginLocator();
	}
	
	public void captureScreenshot(String testName) {
		System.out.println(driver);
		if(driver!=null) {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destination = ".//screenshot//"+testName+".png";
			 try {
	             FileUtils.copyFile(source, new File(destination));
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
		}
	}
	

}
