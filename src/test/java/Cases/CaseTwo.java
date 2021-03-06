package Cases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;

public class CaseTwo {
	
	
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
	public void tearDown() throws InterruptedException {
	b.tearDown();
	}
	

	@Test
	public void caseFive() {
		Assert.assertEquals(true, true);
	}
	
	@Test
	public void caseSix() {
		Assert.assertEquals(true, false);
	}
	
	@Test
	public void caseSeven() {
		Assert.assertEquals(true, true);
	}

	@Test(invocationCount=3)
	public void caseEight() {	
		Assert.assertEquals(true, false);
	}


}
