package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utilities.Base;

public class TestIEBrowser extends Base {
	public WebDriver driver;

	@BeforeClass
	public void tearUp() {
		driver = initializeIEDriver();
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test(priority = 1)
	public void openApplication() {
		driver.manage().window().maximize();
		driver.get("http://www.google.co.in");
	}

	@Test(priority = 2)
	public void printMessage() {
		System.out.println("IE Title : " + driver.getTitle());
	}
}
