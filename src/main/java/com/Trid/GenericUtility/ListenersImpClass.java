package com.Trid.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImpClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		//Execution Start
		String method=result.getMethod().getMethodName();
		test=report.createTest(method);
		Reporter.log(method+"=========>TestScript execution started");
	}
	public void onTestSuccess(ITestResult result) {
		String method=result.getMethod().getMethodName();
		test.log(Status.PASS, method+"====>Passed");
		Reporter.log(method+"======>TestScript passed");
	}

	public void onTestFailure(ITestResult result) {
		String FScript=result.getMethod().getMethodName();
		String FailedScript=FScript+new JavaUtility().getSystemDateInFormat();
		/*EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot/"+res+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		String failedScript;
		test.log(Status.FAIL, result.getThrowable());
		try {
			 failedScript=WebDriverUtility.getScreenShot(BaseClass.sdriver, FailedScript);
			test.addScreenCaptureFromPath(failedScript);
		} 
		catch (Throwable e) {
			e.printStackTrace();
		}
		
//		test.log(Status.SKIP, failedScript+"=====>Skipped");
//		test.log(Status.SKIP,result.getThrowable());
	}
	
	
	public void onTestSkipped(ITestResult result) {
		String method=result.getMethod().getMethodName();
		test.log(Status.SKIP, method+"=====>Skipped");
		test.log(Status.SKIP,result.getThrowable());
		Reporter.log(method+"======>TestScript Skipped");
	}
	
	public void onStart(ITestContext context) {
	// create html report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("Sales&Inventory");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Trid");
		
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS","Windows");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("reporter Name", "Prajwal");
	}

	public void onFinish(ITestContext context) {
		// consolidate the report
		report.flush();
		
	}
}
