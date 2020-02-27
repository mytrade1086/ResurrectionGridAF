package Cases;

import java.io.IOException;
import java.util.Properties;

import org.jsoup.Connection.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.Base;
import Login.Login;
import Utility.JavaScriptUtil;
import homePage.homePage;

public class CaseOne extends Base {

	Base b;
	Properties prop;
	WebDriver driver;
	Login log;
	homePage hm;
	
	@BeforeMethod
	public void init() throws IOException {
		b = new Base();
		prop = b.initProp();
		driver = b.setUp(prop);
		log = new Login();
	}
	
	@AfterMethod
	public void tearDowntest() throws InterruptedException {
		Thread.sleep(4000);
		tearDown();
		//b.ExtenttearDown();
		b.logger.info("dummy");
	}

	//@Test()
	public void Login() {
		log.enterUsername("batchautomation");
		log.enterPassword("Test@12345");
		hm = log.clickLogin();
		Assert.assertEquals(hm.gettitle(), "CRMPRO");

	}

	
	
	@Test
	public void clickNewEvent() {
		log.enterUsername("batchautomation");
		log.enterPassword("Test@12345");
		hm = log.clickLogin();
		//Assert.assertEquals(hm.gettitle().contains("CRMPRO"), "CRMPRO");
		hm.switchToFrame();
		hm.movetoElementCalender();
		hm.clickNewEvent();

	}
	@Test
	public void caseOne() {
		Assert.assertEquals(true, true);
	}
//	
//	@Test
//	public void caseTwo() {
//		Assert.assertEquals(true, false);
//	}
//	
//	@Test
//	public void caseThree() {
//		Assert.assertEquals(true, true);
//	}
//
//	@Test
//	public void caseFour() {	
//		Assert.assertEquals(true, false);
//	}

}
