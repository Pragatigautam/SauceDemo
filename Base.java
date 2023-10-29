package SauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//i am trying to set base class with before and after method for https://www.saucedemo.com/ 
public class Base{
public static WebDriver driver;
@BeforeMethod
public void setUp() {
	driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	//utility = new Utility(driver);
}
@AfterMethod
public void tearDown() {
	driver.close();
}
}
