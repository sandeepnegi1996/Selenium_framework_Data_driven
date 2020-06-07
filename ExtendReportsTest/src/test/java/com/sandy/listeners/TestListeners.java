package com.sandy.listeners;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.sandy.utilities.CaptureScreenShotUtility;
import com.sandy.utilities.ExtentManager;

public class TestListeners implements ITestListener,ISuiteListener{
	
	
	static Date d=new Date();
	static String fileName="Extent "+ d.toString().replace(":","_").replace(" ","_")+".html";
	static String messageBody;
	
	private static ExtentReports extent=ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+fileName);
	
	public static ThreadLocal<ExtentTest> testReport=new ThreadLocal<ExtentTest>();
	
	
	
	public void onTestStart(ITestResult result) {
		ExtentTest test=extent.createTest(result.getTestClass().getName()+"  @TestCase :"+result.getMethod().getMethodName());
        testReport.set(test);
    }
    public void onTestSuccess(ITestResult result) {
    	String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(m);
		
    }
    public void onTestFailure(ITestResult result) {
    	String excepionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
				+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
		
		try {

			CaptureScreenShotUtility.captureScreenshot();
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreenShotUtility.screenshotName)
							.build());
		} catch (IOException e) {

		}
		
		String failureLogg="TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);

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
