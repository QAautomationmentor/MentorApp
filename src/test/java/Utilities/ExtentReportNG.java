package Utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {
	// ExtentReports , ExtentSparkReporter
	public static ExtentReports extent;

	public static ExtentReports extentReportGenerator() {
		File filePath = new File("D:\\reports\\extent_report.html");
		ExtentSparkReporter reporter = new ExtentSparkReporter(filePath);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Tester", "Aditya Sisodiya");
		extent.attachReporter(reporter);
		return extent;
	}

}
