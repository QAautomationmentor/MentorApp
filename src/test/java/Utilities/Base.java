package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.io.FileHandler;

public class Base {
	public static Properties property;

	public static WebDriver initializeChromeDriver() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		option.addArguments("start-maximized");
		option.setAcceptInsecureCerts(true);
		property = new Properties();
		InputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\Utilities\\data.propeties");
			property.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ChromeDriver(option);
	}

	public static WebDriver initializeIEDriver() {
		System.setProperty("webdriver.edge.driver",
				System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\msedgedriver.exe");
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--disable-notifications");
//		option.addArguments("start-maximized");
		option.setAcceptInsecureCerts(true);
		property = new Properties();
		InputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\Utilities\\data.propeties");
			property.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new EdgeDriver(option);
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
