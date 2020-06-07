package com.sandy.utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;
import com.sandy.basepackage.TestBase;

public class CaptureScreenShotUtility extends TestBase{
	public static String screenshotPath;
	public static String screenshotName;
	
	
	public static void captureScreenshot() throws IOException {
		

		//This will take the screenshot
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date(0);
		
		//Creating a screen shot name by replace ing the : and " " by  "underscore"
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		/*FileUtil.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));
		*/
		//Pasting the file in the reports
		Files.copy(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

		
	}
	

}
