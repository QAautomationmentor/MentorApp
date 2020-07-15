package Utilities;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
public class Base {

	public static WebDriver initializeDriver() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		option.addArguments("start-maximized");
		option.setAcceptInsecureCerts(true);
		return new ChromeDriver(option);
	}

	public static String captureScreenshot(String screenshotName, WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destination = new File(
				System.getProperty("user.dir") + "\\src\\test\\java\\reports\\" + screenshotName + ".png");
		try {
			FileHandler.copy(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destination.getAbsolutePath();
	}
}
