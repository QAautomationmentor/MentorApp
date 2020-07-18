package testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.Base;

public class firebaseApp extends Base {
	public WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void tearUp() {
		driver = initializeChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test(priority = 1)
	@Parameters("url")
	public void openApplication(String url) {
		driver.get(url);
	}

	@Test(priority = 2)
	@Parameters({ "username", "password" })
	public void loginToApplication(String username, String password) {
		driver.findElement(By.id("email_field")).sendKeys(username);
		driver.findElement(By.id("password_field")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]")).click();
	}

	@Test(priority = 3)
	public void registerStudent() {
		driver.findElement(By.id("name")).sendKeys("Aadi");
		driver.findElement(By.id("lname")).sendKeys("Singh");
		driver.findElement(By.id("postaladdress")).sendKeys("xyz street");
		driver.findElement(By.id("personaladdress")).sendKeys("home street");
		driver.findElement(By.xpath("//input[@value='male']")).click();
		WebElement city = driver.findElement(By.id("city"));
		Select selectCity = new Select(city);
		selectCity.selectByVisibleText("MUMBAI");
		WebElement course = driver.findElement(By.id("course"));
		Select selectCourse = new Select(course);
		selectCourse.selectByValue("mca");
		WebElement district = driver.findElement(By.id("district"));
		Select selectDistrict = new Select(district);
		selectDistrict.selectByVisibleText("MUMBAI");
		WebElement state = driver.findElement(By.id("state"));
		Select selectState = new Select(state);
		selectState.selectByVisibleText("GOA");
		driver.findElement(By.id("pincode")).sendKeys("411057");
		driver.findElement(By.id("emailid")).sendKeys("admin123@gmail.com");
		driver.findElement(By.className("bootbutton")).click();
	}

	@Test(priority = 4)
	@Parameters("file")
	public void uploadFile(String file) {
		driver.findElement(By.linkText("File Upload")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='logo']"))).sendKeys(file);
	}
}
