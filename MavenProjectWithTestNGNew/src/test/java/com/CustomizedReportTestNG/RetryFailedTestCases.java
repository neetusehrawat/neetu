package com.CustomizedReportTestNG;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer{
	
	private int retryCnt=0;
	// max retry count number as per requirement
	private int maxretryCnt=2;
	
	
	// this will be called everytime test fails.It will return true if test fails and need to be retried
	//@Override
	public boolean retry(ITestResult result) {
		
		if(retryCnt<maxretryCnt) {
			System.out.println("Retrying " +result.getName() +" again and the count is " +  (retryCnt+1));
			retryCnt++;
			return true;
		}
		
		return false;
		
	}
	
	
	

}
