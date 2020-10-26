package com.CustomizedReportTestNG;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;



import com.Reusable.Reusable;

public class TestListener extends Reusable implements ITestListener{
	
	//@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("****Error " + result.getName()+" test has failed****");
		String methodName=result.getName().toString().trim();
		takeScreenShot(methodName,driver);
		
		}
	
	public void takeScreenShot(String methodName,WebDriver driver ) {
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat format=new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		File sourceFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportdirectory=new File(System.getProperty("user.dir")).getAbsolutePath()+"/target/surefire-reports";
			File destFile=new File((String) reportdirectory+"/failure_screenhots/"+ methodName+"_"+format.format(calendar.getTime())+".png");
			 FileUtils.copyFile(sourceFile,destFile);
			Reporter.log("<a href='"+destFile.getAbsolutePath() +"'><img src='"+ destFile.getAbsolutePath()+" ' height='100' width='100'/> <a/>");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		
		public void onFinish(ITestContext context) {
			
		}
		
		public void onTestStart(ITestResult result) {
			
		}
		
		public void onTestSuccess(ITestResult result) {
			
		}
		public void onTestSkipped(ITestResult result) {
			
		}
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			
		}
		
		
		
		
		
		
		
	}




