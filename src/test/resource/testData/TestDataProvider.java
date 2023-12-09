package testData;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	@DataProvider(name = "active-user-credentials")
	public Object[][] activeUserCredential() {
		return new Object[][] { { "standard_user", "secret_sauce" }, };
	}

}
