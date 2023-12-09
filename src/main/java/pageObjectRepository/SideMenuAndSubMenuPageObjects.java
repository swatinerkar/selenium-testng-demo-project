package pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideMenuAndSubMenuPageObjects {

	@FindBy(id = "react-burger-menu-btn")
	WebElement btn_sideMenu;
	@FindBy(id = "logout_sidebar_link")
	WebElement link_logout;

	public SideMenuAndSubMenuPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnSideMenuToOpen() {
		btn_sideMenu.click();
	}

	public void clickLogout() {
		link_logout.click();
	}
}
