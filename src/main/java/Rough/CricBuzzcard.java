package Rough;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricBuzzcard {
	
	
	
 public static void main(String[] args) {
	 String url;
	 WebDriver driver;
	 url="https://www.cricbuzz.com/live-cricket-scorecard/26790/sl-vs-wi-2nd-odi-west-indies-tour-of-sri-lanka-2020";
	WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   driver.get(url);
	  List<WebElement> score= driver.findElements(By.xpath("//div[@id='innings_1']//div[@class='cb-col cb-col-100 cb-scrd-itms']/div"));
	  
	  for(WebElement web:score) {	
		 
		 System.out.print(web.getText().trim()+" ");
		  if (web.getText().contains(".")) {
				 System.out.println("");
			 }	
		 	  
	  }
	  driver.quit();
	
}
}