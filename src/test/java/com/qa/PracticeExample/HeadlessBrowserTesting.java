package com.qa.PracticeExample;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HeadlessBrowserTesting {
	
	WebDriverWait wait;
	WebDriver driver;
	String url = "https://www.myntra.com/";
	@FindBy(how=How.XPATH, using="//a[text()='Gift Card']")
	public WebElement GiftCardLink;
	
	@BeforeTest
	public void OpeningBrowser()
	{
		File file=new File("C:\\Users\\dheeraj.singh\\eclipse-workspace\\Myntra\\BrowserDriver\\phantomjs.exe");
		System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
		driver = new PhantomJSDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		//manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	
	@AfterTest
	public void tearDownDriverInstance()
	{
		driver.close();
	}
	
	
	
	
	@Test
	public void ClickOnGiftCard() throws InterruptedException
	{
		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(GiftCardLink));
		GiftCardLink.click();
		Thread.sleep(4000);
	}

}
