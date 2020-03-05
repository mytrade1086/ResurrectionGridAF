package Listerners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentTest;
import Base.Base;

public class MyListerner extends Base implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		logger = extent.createTest(result.getName());
		System.out.println("Test has Stared: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test has passed: " + result.getName());
		logger.log(Status.PASS, "Test has passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test has FAILED: " + result.getName());

		logger.log(Status.FAIL, "Test has FAILED: " + result.getName());
		// ITestContext context = result.getTestContext();
		// WebDriver driver = (WebDriver)context.getAttribute("driver");
		String method = result.getMethod().getMethodName();
		try {
			takeScreenShot(method, driver);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test has been SKIPPED: " + result.getName());
		logger.log(Status.SKIP, "Test has been skipped: " + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("test started Icontext");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("test finished");
		extent.flush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@AfterTest
	public void afterTest() {
		extent.flush();

	}
}
