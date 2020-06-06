package com.sandy.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.sandy.basepackage.TestBase;


public class SignupTest extends TestBase {
  @Test
  public void signupTest() {
	  System.out.println("inside sign uptest");
	  logger.debug("inside the signuptest");
	  assertEquals(true, true);
  }
}
