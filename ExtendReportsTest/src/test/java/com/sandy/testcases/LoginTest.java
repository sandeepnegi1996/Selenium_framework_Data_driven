package com.sandy.testcases;

import org.testng.annotations.Test;

import com.sandy.basepackage.TestBase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class LoginTest extends TestBase {
  @Test
  public void loginTest() {
	  System.out.println("Hello world");
	  
	  logger.debug("this is debug message");
	  logger.info("this is information message");
	  logger.error("this is the error log message");
	  

  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
