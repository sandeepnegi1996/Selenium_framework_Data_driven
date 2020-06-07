package com.sandy.basepackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase {
	
	public static  Logger logger = LogManager.getLogger(TestBase.class);
	
	public static WebDriver driver;
	
	
	@BeforeSuite
	public void setUp() {
		
		if(driver==null) {
			
			
		}
		
		
	}
	
	@AfterSuite
	public void tearDown() {
		
	}

}
