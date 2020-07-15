package Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

@Listeners
public class MyTestListener implements ITestListener {
	ExtentReports extent;
	ExtentTest test;

	// making test object as thread safe
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().pass("successfully passed");
	}

	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		WebDriver driver;
		Object instace = result.getInstance();
		@SuppressWarnings("rawtypes")
		Class testClass = result.getTestClass().getRealClass();

		try {
			driver = (WebDriver) testClass.getDeclaredField("driver").get(instace);
			extentTest.get().addScreenCaptureFromPath(
					Base.captureScreenshot(result.getMethod().getMethodName(), driver),
					result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		extent = ExtentReportNG.extentReportGenerator();
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
