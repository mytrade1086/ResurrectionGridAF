package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Base;

public class ElementUtil extends Base {

	public WebElement getElement(By by, String elementName) {
		WebElement ele = null;
		waitforElement(by);
		
		try {
			ele = driver.findElement(by);
			return ele;
		} catch (Exception e) {
			System.out.println("Problem Locating " + elementName);
			return null;
		}
	}
	
	
	
	
	public void waitforElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		
	}

	
	
	public void doClick(By by, String elementName) {
		waitforElement(by);
		WebElement el = getElement(by, elementName);
		try {
			el.click();
			System.out.println("Clicked " + elementName);
		}
		catch (Exception e) {
			System.out.println("Error while clicking " + elementName);
		}
	}

	
	
	public void doSendKeys(By by,String texttoBeEntered, String elementName) {
		waitforElement(by);
		WebElement el = getElement(by, elementName);
		try {
			el.clear();
			el.sendKeys(texttoBeEntered);
			System.out.println("Entered "+texttoBeEntered + "in " + elementName);
		}
		catch (Exception e) {
			System.out.println("Error while entering data in " + elementName);
		}
	}
	
	
	public void doClickAction(By by,String elementName) {
		waitforElement(by);
		WebElement el = getElement(by, elementName);
		//Actions a=new Actions(driver);
		try {
			//a.click(el).build().perform();;
			
			el.click();
			System.out.println("Clicked on "+ elementName+" using action class");
		}
		catch (Exception e) {
			System.out.println("Error while clicking "+elementName+ "using action class");
		}
	}
	
	
	
	
	
	
	
	
	

}
