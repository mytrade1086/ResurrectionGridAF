package homePage;
import org.openqa.selenium.By;
import Utility.ElementUtil;

public class homePage {
	ElementUtil el;
	public homePage() {
		el = new ElementUtil();
	}
	By Home = By.linkText("Home");
	By mainFrame = By.name("mainpanel");
	By linkNewEvent = By.linkText("New Event");
	By linkCalendar=By.xpath("//a[@title='Calendar']");
	
	public String gettitle() {
		return el.getTitle();
	}
	public void switchToFrame() {
		el.waitforFrameElement(mainFrame);
	}
	public void movetoElementCalender() {
		el.moveToelement(linkCalendar, "linkCalendar link");
	}
	
	public void movetoElementNewEvent() {
		el.moveToelement(linkNewEvent, "New Event link");
	}

	public void clickNewEvent() {
		 movetoElementNewEvent();
		el.doClickAction(linkNewEvent, "New Event");
	}

}
