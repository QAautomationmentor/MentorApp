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
		driver = initializeDriver();
	}

	@AfterClass
	public void teardown() {
		driver.close();
	}

	@Test(priority = 1)
	public void openApplication() {
		driver.get("https://accounts.google.com/signin/v2");
	}

	@Test(priority = 2)
	public void login() {
		System.out.println("login is done");
	}
}
