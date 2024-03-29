package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utilities.Base;

public class EmailAutomation extends Base {
	public WebDriver driver;

	@BeforeClass
	public void tearUp() {
		driver = initializeChromeDriver();
	}

	@AfterClass
	public void teardown() {
		driver.close();
	}

	@Test(priority = 1)
	public void openApplication() {
		String url = property.getProperty("url");
		driver.get(url);
	}

	@Test(priority = 2)
	public void login() {
		System.out.println("login is done");
	}
}
