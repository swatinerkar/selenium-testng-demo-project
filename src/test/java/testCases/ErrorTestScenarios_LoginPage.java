package testCases;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import pageObjectRepository.PageObjects;

public class ErrorTestScenarios_LoginPage extends PageObjects {

//	Demonstrates the data is taken from testng.xml file at class level.
	@Test(enabled = true)
	@Parameters({"locked-user","password"})
	public void loginWithLockedUser(String locked_user,String password) {
		loginPage.enterUsername(locked_user);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		String actualErrorMsg = loginPage.getErrorMessageOnLoginPage();
		String expectedErrorMsg = "Epic sadface: Sorry, this user has been locked out.";
		assertThat("The error message when locked user trying to login is not as expected.", actualErrorMsg,
				is(expectedErrorMsg));
	}
}
