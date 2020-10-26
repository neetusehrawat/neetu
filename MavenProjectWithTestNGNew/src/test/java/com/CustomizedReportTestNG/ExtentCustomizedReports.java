package com.CustomizedReportTestNG;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentCustomizedReports {
	
	public static ExtentReports report;
	public static ExtentTest test;
	
	// whenever this class will be called constructor will be automatically invoked
	public ExtentCustomizedReports(){
		report= new ExtentReports(System.getProperty("user.dir")+"\\target\\extentreport.html", true);
		
	}
	

	
	
	
	
	

}
