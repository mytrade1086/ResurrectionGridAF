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
import org.testng.annotations.Test;

import Base.Base;

public class MyListerner extends Base implements ITestListener{
	//WebDriver driver;
	
@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test has Stared: "+result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test has passed: "+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test has FAILED: "+result.getName());
		
		//ITestContext context = result.getTestContext();
		//WebDriver driver = (WebDriver)context.getAttribute("driver");
	    String method=result.getMethod().getMethodName();
		try {
			takeScreenShot(method,driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}        
	}




	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test has been SKIPPED: "+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// ""
		
	}

	@Override
	public void onStart(ITestContext context) {
	
		
	}

	@Override
	public void onFinish(ITestContext context) {
	
		
	}
}
