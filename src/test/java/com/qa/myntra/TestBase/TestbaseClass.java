package com.qa.myntra.TestBase;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestbaseClass {

	String browserpath = System.getProperty("user.dir") + "/BrowserDriver/chromedriver.exe";
	String extentreportpath = System.getProperty("user.dir") + "/ExtentReportsFolder/" + this.getClass().getSimpleName()
			+ ".html";
	//String url = "https://www.myntra.com/";
	String url = "http://www.way2automation.com/Jmeter%20Training/Jmeter_training_noida_delhi.html";
	public ExtentHtmlReporter e1;
	public ExtentReports e2;
	public ExtentTest e3;

	protected WebDriver driver;

	@BeforeSuite
	public void ExtentReportInit() {
		File file = new File(extentreportpath);
		e1 = new ExtentHtmlReporter(file);
		e2 = new ExtentReports();
		e2.attachReporter(e1);

		e2.setSystemInfo("Tester Name", "Dheeraj Pratap Singh");
		e2.setSystemInfo("UserName", "Dheeraj.Singh@westerunion.com");
		e2.setSystemInfo("Environment", "Production");
		e2.setSystemInfo("Sprint Name", "Flash");
		e2.setSystemInfo("Version Number", "ASHSJ1324_234");
		e2.setSystemInfo("Host", "127.0.0.1");
		
		e1.config().setDocumentTitle("This is automation testing module");
        e1.config().setReportName("Extent Report generator testing demo.");
        e1.config().setTheme(Theme.DARK);

	}

	@AfterSuite
	public void ExtentReportFlush() {
		e2.flush();
	}

	@BeforeTest
	public void OpeningBrowser() {
		System.setProperty("webdriver.chrome.driver", browserpath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.get(url);
	}

	@AfterTest
	public void tearDownBrowser() {
		driver.close();
	}

}
