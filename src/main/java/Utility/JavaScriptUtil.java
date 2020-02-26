package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Base;

public class JavaScriptUtil extends Base{
	
public static JavascriptExecutor js=(JavascriptExecutor)driver;

public static void  jsClick(By by,String elementName) {
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.presenceOfElementLocated(by));
	
	try {	
		WebElement we=driver.findElement(by);
		js.executeScript("arguments[0].click();", we);
		//note missing bracket after click does not show any error. 
		//We careful with syntaxes as debugging will be difficult
		
		System.out.println("Clicked " +elementName + "using javascript function");	
	}
	
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
	
}

}
