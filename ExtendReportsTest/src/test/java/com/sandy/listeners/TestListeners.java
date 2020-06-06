package com.sandy.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener{
	
	public void onTestStart(ITestResult result) {
        
    }
    public void onTestSuccess(ITestResult result) {
    	System.out.println("==========================================================");
        System.out.println("Test Successfully Finished" + result.getName());
    }
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed" + result.getName());
    }
    public void onTestSkipped(ITestResult result) {
       
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        
    }
    public void onStart(ITestContext context) {
      
    }
    public void onFinish(ITestContext context) {
      
    }

}
