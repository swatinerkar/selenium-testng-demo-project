package pageObjectRepository;

import org.testng.annotations.BeforeMethod;

import testBase.TestBase;

public class PageObjects extends TestBase {

	public LoginPageObjects loginPage;
	public ProductPageObjects productPage;
	public SideMenuAndSubMenuPageObjects sideMenu;

	@BeforeMethod
	public void initPageObjects() {
		loginPage = new LoginPageObjects(driver);
		productPage = new ProductPageObjects(driver);
		sideMenu = new SideMenuAndSubMenuPageObjects(driver);

	}

}
