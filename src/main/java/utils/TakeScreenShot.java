package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import testBase.TestBase;

public class TakeScreenShot {
	String destinationPath;
	private static TakeScreenShot takeScreenShot;
	
	private TakeScreenShot() {}

	public static TakeScreenShot getTakeScreenShotObj() {
		if (takeScreenShot == null)
			takeScreenShot = new TakeScreenShot();
		return takeScreenShot;
	}

	public String screenShot() {

		String pattern = "dd-MM-yyyy HH-mm-ss";
		destinationPath = System.getProperty("user.dir") + "/Reports/Screenshots/ExecutionReport_screenshot"
				+ DateUtil.getDateUtilObj().setDatePattern(pattern).getDateInString() + ".jpeg";
		File screenShotFile = ((TakesScreenshot) TestBase.getDriverObj()).getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(destinationPath);
		try {
			FileHandler.copy(screenShotFile, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationPath;
	}

}
