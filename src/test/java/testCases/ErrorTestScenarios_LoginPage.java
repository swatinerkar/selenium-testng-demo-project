package testCases;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import pageObjectRepository.PageObjects;

public class ErrorTestScenarios_LoginPage extends PageObjects {
	
	Logger LOG = LoggerFactory.getLogger(ErrorTestScenarios_LoginPage.class);
	
	/**
	 * Always run it from testng.xml
	 * It is accepting values from testng.xml, when trying to run individual testng it will throw an error
	 * @param locked_user
	 * @param password
	 */
	@Test(enabled = true)
	@Parameters({"locked-user","password"})
	public void loginWithLockedUser(@Optional("locked_out_user") String locked_user,@Optional("secret_sauce")String password) {
		loginPage.enterUsername(locked_user);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		String expectedErrorMsg = "Epic sadface: Sorry, this user has been locked out.";
		String actualErrorMsg = loginPage.getErrorMessageOnLoginPage();
		assertThat("The error message when locked user trying to login is not as expected.", actualErrorMsg,
				is(expectedErrorMsg));
		
	}
	
	/**
	 * Failure test scenario to generate failed record in Execution report. When not using mark it as enabled = false.
	 * @param locked_user
	 * @param password
	 */
	
	@Test(enabled = false)
	@Parameters({"locked-user","password"})
	public void loginWithLockedUserFailureTest(@Optional("locked_out_user") String locked_user,@Optional("secret_sauce")String password) {
		loginPage.enterUsername(locked_user);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		String expectedErrorMsg = "Epic sadface: Sorry, this user has been locked.....";
		String actualErrorMsg = loginPage.getErrorMessageOnLoginPage();
		assertThat("The error message when locked user trying to login is not as expected.", actualErrorMsg,
				is(expectedErrorMsg));
		
	}
}
