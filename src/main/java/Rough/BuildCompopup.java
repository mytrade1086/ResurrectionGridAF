package Rough;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BuildCompopup {

	
	
	public static void main(String[] args) {
		 String url;
		 WebDriver driver;
		 url="https://www.build.com/";
		WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
		   driver.get(url);
		 
		 try {
			
			 if(driver.findElement(By.xpath("//input[@id='newsletterPopupEmail']")).isDisplayed()) {
				 driver.findElement(By.xpath("//input[@id='newsletterPopupEmail']")).sendKeys(Keys.ESCAPE);
				
			 }
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		   
		   
		   
		   
		   
	}
}
