package com.qa.myntra.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {

	String screenshotpath = System.getProperty("user.dir") + "/ScreenshotFolder/" + this.getClass().getSimpleName()
			+ ".png";

	public String ScreenshotCapture(WebDriver driver, String path) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		File Destination = new File(screenshotpath);
		FileUtils.copyFile(file, Destination);
		return screenshotpath;
	}

}
