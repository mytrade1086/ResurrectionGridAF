package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public Properties prop;
	public ITestContext context;
	
	 static public ExtentHtmlReporter reporter;
	 static public ExtentReports extent;
	 static public com.aventstack.extentreports.ExtentTest logger;
//		
@BeforeSuite
	public void ExtentSet() {
		reporter=new ExtentHtmlReporter("H:\\eclipseWin10\\com.ResurrectionGridAF\\src\\main\\java\\Reports\\Extent.html");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
	  }
	
	public WebDriver setUp(Properties prop) throws MalformedURLException {
		String runmode = prop.getProperty("runmode");
		String browser = prop.getProperty("browser");

		if (runmode.contains("local")) {
			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(prop.getProperty("appurl"));
				break;
				

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(prop.getProperty("appurl"));
				break;

			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				driver.get(prop.getProperty("appurl"));
				break;
			}
			
		//	return driver;
		}

		else if (runmode.contains("remote")) {

			String nodeUrl = "http://192.168.0.10:5556/wd/hub/";
			switch (browser) {
			case "chrome":
				// Define desired capabilities
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.WINDOWS);
				// Chrome option
				ChromeOptions options = new ChromeOptions();
				options.merge(cap);
				// options.setHeadless(true);
				driver = new RemoteWebDriver(new URL(nodeUrl), options);
				driver.get(prop.getProperty("appurl"));
				break;

//CORRECT  CODE FOR REMOTE
			case "firefox":
				// WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(prop.getProperty("appurl"));
				break;

			case "ie":
				// WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				driver.get(prop.getProperty("appurl"));
				break;

				
			}
			
		}

		System.out.println("driver from else if");
	    return driver;
	}

	public Properties initProp() throws IOException {
		FileInputStream fis = new FileInputStream(
				"H:\\eclipseWin10\\com.ResurrectionGridAF\\src\\main\\java\\config\\config");
		prop = new Properties();
		prop.load(fis);
		return prop;
	}

	public void tearDown() throws InterruptedException {
		if (driver != null) {
			driver.quit();

			System.out.println("quiting driver");
		}
	}

	public static String ScreenShot() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String datestamp = sdf.format(new Date());
		System.out.println(datestamp);
		return datestamp;
	}

	public void takeScreenShot(String method, WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String name = method + "_" + ScreenShot().replace(":", "_");
		String filename = "H:\\eclipseWin10\\com.ResurrectionGridAF\\src\\main\\java\\Reports\\" + name + ".png";
		// System.out.println(filename);
		FileUtils.copyFile(src, new File(filename));

	}

}
