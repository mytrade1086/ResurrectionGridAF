package Rough;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class rough {
	private static  WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		   
		    driver = new ChromeDriver();
		    driver.get("https://classic.freecrm.com/");
		    driver.manage().window().setSize(new Dimension(1366, 728));
		    driver.findElement(By.name("username")).click();
		    driver.findElement(By.name("username")).sendKeys("batchautomation");
		    driver.findElement(By.name("password")).click();
		    driver.findElement(By.name("password")).sendKeys("Test@12345");
		    driver.findElement(By.cssSelector(".btn")).click();
		    
		    
		    
		    
		    By linkCalendar=By.xpath("//a[@title='Calendar']");
			By linkNewEvent=By.xpath("//a[@title='Calendar']//a[@title='New Event']");
			
			
			Actions act=new Actions(driver);
			driver.switchTo().frame("mainpanel");
			Thread.sleep(3000);
			
			act.moveToElement(driver.findElement(linkCalendar)).build().perform();;
		
			
		    driver.findElement(By.linkText("New Event")).click();
			
			
	}

}
