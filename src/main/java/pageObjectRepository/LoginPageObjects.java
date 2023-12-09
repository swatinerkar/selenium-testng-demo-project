package pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

	@FindBy(id = "user-name")
	WebElement input_username;
	@FindBy(id = "password")
	WebElement input_password;
	@FindBy(id = "login-button")
	WebElement btn_login;
	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement msg_error;

	public LoginPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		input_username.clear();
		input_username.sendKeys(username);
	}

	public void enterPassword(String password) {
		input_password.clear();
		input_password.sendKeys(password);
	}

	public void clickLoginBtn() {
		btn_login.click();
	}

	public String getErrorMessageOnLoginPage() {
		return msg_error.getText();
	}

}
