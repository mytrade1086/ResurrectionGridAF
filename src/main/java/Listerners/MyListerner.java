package Listerners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

import Base.Base;

public class MyListerner extends Base implements ITestListener{
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
	  //  Base.ScreenShot();
	    try {	
	    	String method=result.getMethod().getMethodName();
			takeScreenShot(method ,driver);
		} catch (IOException e) {
			System.out.println("Error in method call : takeScreenShot");
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
