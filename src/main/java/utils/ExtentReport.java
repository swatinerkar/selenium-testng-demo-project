package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	static ExtentReports extent;

	public static ExtentReports setupExtentReport() {
		String pattern = "dd-MM-yyyy HH-mm-ss";
		DateUtil dateUtil = DateUtil.getDateUtilObj();
		String reportPath = System.getProperty("user.dir") + "/Reports/ExecutionReport_"
				+ dateUtil.setDatePattern(pattern).getDateInString() + ".html";
		System.out.println(reportPath);
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		extent.attachReporter(spark);

		spark.config().setDocumentTitle("Execution Report");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Test case execution report");

		return extent;
	}

	public static void closeExtentReport() {
		extent.flush();
	}

	public static ExtentTest createTest(String methodName) {
		ExtentTest test = extent.createTest(methodName);
		return test;

	}
}
