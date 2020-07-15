package testcases;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.Base;

public class SpiceJetAutomation extends Base {
	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeClass
	public void tearUp() {
		driver = initializeDriver();
	}

	@AfterClass
	public void teardown() {
		driver.close();
	}

	@Test(priority = 1)
	@Parameters("url")
	public void launchApplication(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 2)
	public void searchAndSelectFromCity() throws InterruptedException {
		driver.findElement(
				By.xpath("//input[@id='ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT']"))
				.click();
		Thread.sleep(1000);
		List<WebElement> fromCityList = driver
				.findElements(By.xpath("//table[@id='citydropdown']/tbody/tr[2]/td[2]/div[3]/div/div/ul/li/a"));
		for (int i = 0; i < fromCityList.size(); i++) {
			String cityName = fromCityList.get(i).getText();
			if (cityName.contains("Pune")) {
				fromCityList.get(i).click();
				break;
			}
		}
	}

	@Test(priority = 3)
	public void searchAndSelectToCity() {
		List<WebElement> fromCityList = driver
				.findElements(By.xpath("//table[@id='citydropdown']/tbody/tr[2]/td[2]/div[3]/div/div/ul/li/a"));
		for (int i = 0; i < fromCityList.size(); i++) {
			String cityName = fromCityList.get(i).getText();
			if (cityName.contains("Hyderabad")) {
				fromCityList.get(i).click();
				break;
			}
		}
	}

	@Test(priority = 4)
	public void departDate() {
		String month = driver.findElement(By.xpath(
				"//div[@class='ui-datepicker-group ui-datepicker-group-first'] //div[@class='ui-datepicker-title']/span[1]"))
				.getText();
		while (!month.contains("September")) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			month = driver.findElement(By.xpath(
					"//div[@class='ui-datepicker-group ui-datepicker-group-first'] //div[@class='ui-datepicker-title']/span[1]"))
					.getText();
		}
		List<WebElement> dateList = driver.findElements(By.xpath(
				"//div[@class='ui-datepicker-group ui-datepicker-group-first'] //table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']"));
		for (int i = 1; i <= dateList.size(); i++) {
			String date = dateList.get(i).getText();
			if (date.equalsIgnoreCase("12")) {
				dateList.get(i).click();
				break;
			}
		}
	}

	@Test(priority = 5)
	public void returnData() {
		driver.findElement(By.xpath("//div[@id='marketDate_2']//input[1]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String month = driver.findElement(By.xpath(
				"//div[@class='ui-datepicker-group ui-datepicker-group-first'] //div[@class='ui-datepicker-title']/span[1]"))
				.getText();
		while (!month.contains("September")) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			month = driver.findElement(By.xpath(
					"//div[@class='ui-datepicker-group ui-datepicker-group-first'] //div[@class='ui-datepicker-title']/span[1]"))
					.getText();
		}
		List<WebElement> dateList = driver.findElements(By.xpath(
				"//div[@class='ui-datepicker-group ui-datepicker-group-first'] //table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']"));
		for (int i = 1; i <= dateList.size(); i++) {
			String date = dateList.get(i).getText();
			if (date.equalsIgnoreCase("15")) {
				dateList.get(i).click();
				break;
			}
		}
	}

	@Test(priority = 6)
	public void selectPassenger() {
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement selectAdult = driver.findElement(By.xpath(
				"//select[@id='ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT']"));
		Select adult = new Select(selectAdult);
		adult.selectByValue("2");
		WebElement selectChild = driver.findElement(By.xpath(
				"//select[@id='ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_CHD']"));
		Select child = new Select(selectChild);
		child.selectByVisibleText("1");
	}

	@Test(priority = 7)
	public void selectCurrancy() {
		WebElement currancy = driver
				.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency"));
		Select selectCurrancy = new Select(currancy);
		selectCurrancy.selectByVisibleText("INR");
	}

	@Test(priority = 8)
	public void searchFlight() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@class='bookbtn']")).click();
	}
}