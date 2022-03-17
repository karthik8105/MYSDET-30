package com.crm.GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITestListnerImplementationClass implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	public void onFinish(ITestContext context) {
		//consalidate all the parameter and generate the report
		report.flush();
		
	}

	public void onStart(ITestContext context)
	{
		//Extention will start here
		/* configure the report*/
		ExtentSparkReporter htmlReport = new  ExtentSparkReporter("./ExtentReports/Report"+ new JavaUtility().getSystemDateInFormate()+".html"); 
	htmlReport.config().setDocumentTitle("SDET-30 Extenet report");
	htmlReport.config().setTheme(Theme.DARK);
	htmlReport.config().setReportName("Selenium Extention Report");
	
	report =new ExtentReports();
	report.attachReporter(htmlReport);
	report.setSystemInfo("Base-browser", "chrome");
	report.setSystemInfo("os", "windows");
	report.setSystemInfo("Base-url", "http://localhost/8888");
	report.setSystemInfo("Reporter name", "karthik");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onTestFailure(ITestResult result) {
		String path = null;
		
		String MethodName = result.getMethod().getMethodName()+"-";
		
		//Reporter.log(MethodName + "--- TestScript Failed",true);
		
		//Step 1: Configure screenshot name
		String screenshotName = MethodName+new JavaUtility().getSystemDateInFormate();
		System.out.println(screenshotName);
		
		//Step 2: using screenshot method from webDriver Utility
		try {
			
			new WebDriverUtility().getScreenShot(BaseClass.sdriver, screenshotName);
			
	
			//EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
			//File src = eDriver.getScreenshotAs(OutputType.FILE);
			//String pa = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
			 path = "./Screenshots/"+screenshotName+".png";
			//File dst = new File(pa);
			//Files.copy(src, dst);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, MethodName+"----failed");
		//it will capture the exception log it in the report
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(path);
		
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"-----skipped");
		//Reporter.log(MethodName + "--- TestScript Skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		
		//Reporter.log(MethodName + "--- testscript execution started");
	     test =report.createTest(MethodName);
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log(MethodName + "--- testscript execution sucessfull - PASS");
		test.log(Status.PASS,MethodName+"pass");
		
	}}
