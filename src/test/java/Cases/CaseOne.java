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

public class CaseOne {
    
	Base b;
	Properties prop;
	WebDriver driver;

	@BeforeMethod
	public void init() throws IOException {
        b=new Base();
		prop = b.initProp();
		driver = b.setUp(prop);
	}

	@AfterMethod
	public void tearDown() {
	b.tearDown();
	}
	

	@Test
	public void caseOne() {
		Assert.assertEquals(true, true);
	}
	
	@Test
	public void caseTwo() {
		Assert.assertEquals(true, false);
	}
	
	@Test
	public void caseThree() {
		Assert.assertEquals(true, true);
	}

	@Test
	public void caseFour() {	
		Assert.assertEquals(true, false);
	}

}
