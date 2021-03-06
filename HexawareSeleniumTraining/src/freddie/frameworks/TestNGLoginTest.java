package freddie.frameworks;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import freddie.utilities.DriverFactory;
import freddie.utilities.GlobalSettings;

public class TestNGLoginTest {
  
	private WebDriver driver;
	private String email = "rachel.simmons2@testemail.com";
	private String password = "password2";

	@BeforeMethod
	public void setUp() throws Exception {
		// Initialize the Driver
		driver = DriverFactory.start("chrome");
		driver.get(GlobalSettings.AMSWebURL);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		// Close the Driver
		driver.quit();
	}

	@Test
	public void loginTest() {
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("SDET"), "Page Title Error");
		
		// Implement the UI test steps		
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(email);
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
		driver.findElement(By.id("MainContent_btnLogin")).click();
		
		// Assert a correct login
		try {
			String message = driver.findElement(By.id("conf_message")).getText();
		} catch (NoSuchElementException e) {
			Assert.fail("COULD NOT FIND THE CONFIRMATION MESSAGE WEB ELEMENT");
		}
	}
	
}
