package Cases;

import java.io.IOException;
import java.util.Properties;

import org.jsoup.Connection.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import Login.Login;
import Utility.JavaScriptUtil;
import homePage.homePage;

public class CaseOne {

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
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		b.tearDown();
	}

	@Test()
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
		Assert.assertEquals(hm.gettitle(), "CRMPRO");
		hm.switchToFrame();
		hm.movetoElementCalender();
		hm.clickNewEvent();

	}
//	@Test
//	public void caseOne() {
//		Assert.assertEquals(true, true);
//	}
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
