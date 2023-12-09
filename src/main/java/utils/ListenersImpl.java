package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersImpl implements ITestListener {
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test = ExtentReport.createTest(result.getMethod().getMethodName());
		test.info("********************* TEST CASE EXECUTION STARTED *******************");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		test.log(Status.PASS, "Test Case: " + result.getMethod().getMethodName() + " is Passed.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		test.log(Status.FAIL, "Test Case: " + result.getMethod().getMethodName() + " is Failed.");
		test.log(Status.FAIL, result.getThrowable().getMessage());
//		Add screenshot		
		String screenShotPath = TakeScreenShot.getTakeScreenShotObj().screenShot();
		test.addScreenCaptureFromPath(screenShotPath, "Test Case Failure ScreenShot.");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		test.log(Status.SKIP, "Test Case: " + result.getMethod().getMethodName() + " is Skipped.");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
		ExtentReport.setupExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		ExtentReport.closeExtentReport();
	}

}
