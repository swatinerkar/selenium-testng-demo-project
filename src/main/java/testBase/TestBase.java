package testBase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import utils.DateUtil;
import utils.PropertiesOperations;

/**
 * Base class - creates driver object, properties file object.
 * setter and getter methods to get WebDriver object.
 * @BeforeClass to set driver object and launch the application.
 * @AfterClass to close the browser
 * browser and application URL - read from Config.properties file.
 * @author 91758
 *
 */


public class TestBase {
	static Logger LOG = LoggerFactory.getLogger(TestBase.class);
	protected static WebDriver driver;
	public PropertiesOperations propObj;
	protected DateUtil dateUtil;

	@BeforeClass
	public void setup() throws IOException {
		this.propObj = PropertiesOperations.loadProperties();
		setupDriverObj();
	}

	public void setupDriverObj() throws IOException {
		String browser = propObj.getPropertyValueByKey("browser");
		driver = switch (browser) {
		case "chrome" -> new ChromeDriver();
		case "edge" -> new EdgeDriver();
		default -> throw new IllegalArgumentException("Unexpected value: " + browser);
		};
		LOG.info("WebDriver object is created for the browser : "+browser);
		launchBrowser();
	}

	public static WebDriver getDriverObj() {
		LOG.info("Returning the WebDriver object.....");
		return driver;
	}

	public void launchBrowser() throws IOException {
		String url = propObj.getPropertyValueByKey("url");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(url);
		LOG.info("Launching the application URL: "+url);
	}

	@AfterClass
	public void closeBrowser() throws IOException {
		LOG.info("Closing the browser....");
		driver.close();
		driver.quit();
	}
}
