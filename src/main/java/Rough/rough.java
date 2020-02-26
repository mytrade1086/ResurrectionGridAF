package Rough;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class rough {
	private static  WebDriver driver;
	public static void main(String[] args) {
		   
		    driver = new ChromeDriver();
		    driver.get("https://classic.freecrm.com/");
		    driver.manage().window().setSize(new Dimension(1366, 728));
		    driver.findElement(By.name("username")).click();
		    driver.findElement(By.name("username")).sendKeys("batchautomation");
		    driver.findElement(By.name("password")).click();
		    driver.findElement(By.name("password")).sendKeys("Test@12345");
		    driver.findElement(By.cssSelector(".btn")).click();
	}

}
