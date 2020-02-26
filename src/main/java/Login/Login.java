package Login;

import org.openqa.selenium.By;

import Base.Base;
import Utility.ElementUtil;
import Utility.JavaScriptUtil;

public class Login extends Base {
	ElementUtil el;

	public Login() {
		el = new ElementUtil();
    }


	By Username=By.name("username");
	By Password = By.name("password");
	By Login = By.xpath("//input[@value='Login']");

	public void enterUsername(String username) {
		el.doSendKeys(Username, username, "username textbox");
	}

	public void enterPassword(String password) {
		el.doSendKeys(Password, password, "password textbox");
	}

	public void clickLogin() {
		//el.doClick(Login, "Login btn");
		JavaScriptUtil.jsClick(Login, "Login btn");
	}

	
//	public void clickLogin() {
//		el.doClickAction(Login, "Login button");
//	
//	}
	}
