package testCases;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;
import pageObjectRepository.PageObjects;
import testData.TestDataProvider;

public class LoginLogoutEndToEnd_TestCases extends PageObjects {

//	demonstrates dataProvider implementation from different class. Alternatively data can be taken from properties file.
	@Test(priority = 0, dataProvider="active-user-credentials", dataProviderClass = TestDataProvider.class)
	public void loginToApplication(String username, String password) {
//		String username = propObj.getPropertyValueByKey("active-username");
//		String password = propObj.getPropertyValueByKey("password");
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
	}

	@Test(priority = 1, dependsOnMethods = "loginToApplication")
	public void verifyProductPageTitle() {
		String actualTitle = productPage.getProductPageTitle();
		String expectedTitle = "Products";
		assertThat("The Title on Product page is not as expected.", actualTitle, is(expectedTitle));
	}
	
//	demonstrates expected set of data taken from properties file.

	@Test(priority = 2, dependsOnMethods = "loginToApplication")
	public void verifyDowndownValuesOfSortOnProductsPage() {
		String abd[] = propObj.getPropertyValueByKey("expected_values_in_sort").split(",");
		List<String> expectedValues = Arrays.asList(abd);
		List<String> actualValues = productPage.getDropdownOptions_sort();
		assertThat("The Sort dropdown values are not as expected.", actualValues, contains(expectedValues.toArray()));
	}

	@Test(priority = 3, dependsOnMethods = "verifyDowndownValuesOfSortOnProductsPage")
	public void selectDowndownValues() throws Exception {
		String visibleText = "Price (low to high)";
		productPage.selectOptionFromDropdown(visibleText);
	}

	@Test(priority = 4, dependsOnMethods = "loginToApplication")
	public void logoutFromoApplication() {
		sideMenu.clickOnSideMenuToOpen();
		sideMenu.clickLogout();
	}
}
