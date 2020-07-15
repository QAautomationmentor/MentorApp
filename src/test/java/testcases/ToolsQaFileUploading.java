package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utilities.Base;

public class ToolsQaFileUploading extends Base {
	public WebDriver driver;
	JavascriptExecutor js;
	public WebDriverWait wait;

	@BeforeClass
	public void tearUp() {
		driver = initializeDriver();
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test(priority = 1)
	public void openApplication() throws Exception {
		driver.get("http://demoqa.com/automation-practice-form");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 2)
	public void uploadFile(){
		WebElement upload = driver.findElement(By.id("uploadPicture"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", upload);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Actions act=new Actions(driver);
		act.moveToElement(upload).sendKeys("D:\\desktop_Items\\cropath.PNG");
	}
}
