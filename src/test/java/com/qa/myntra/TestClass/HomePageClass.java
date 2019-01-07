package com.qa.myntra.TestClass;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.myntra.TestBase.TestbaseClass;
import com.qa.myntra.TestPage.HomePage;
import com.qa.myntra.Utilities.CaptureScreenshot;

public class HomePageClass extends TestbaseClass{
	
	
	HomePage ObjHomePage;
	CaptureScreenshot ab;
	
	@BeforeMethod
	public void Extentreport(Method method)
	{
		e3=e2.createTest(this.getClass().getSimpleName() + " : : " + method.getName());
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			e3.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.GREEN));
			e3.log(Status.PASS, result.getMethod().getMethodName() + " has been passed");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			e3.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.RED));
			e3.log(Status.FAIL, result.getThrowable());
			//ab.ScreenshotCapture(driver, this.getClass().getSimpleName()+".png");
			e3.log(Status.FAIL, result.getMethod().getMethodName() + " has been failed");
		}
		
		else if(result.getStatus()==ITestResult.SKIP)
		{
			e3.log(Status.SKIP, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.ORANGE));
			e3.log(Status.SKIP, result.getThrowable());
			e3.log(Status.SKIP, result.getMethod().getMethodName() + " has been skipped");
		}
		
	}
	@Test(priority=0)
	public void ClickOnGiftCard() throws InterruptedException
	{
		e3.log(Status.INFO, "ClickOnGiftCard has been started");
		ObjHomePage=PageFactory.initElements(driver, HomePage.class);
		ObjHomePage.ClickOnGiftCard();
	}
	
	@Test(priority=1)
	public void ClickOnLoginButton()
	{
		e3.log(Status.INFO, "ClickOnLoginButton has been started");
		Assert.assertEquals(true, false);
	}
	
	@Test(priority=2)
	public void ClickOnRegisterButton()
	{
		e3.log(Status.INFO, "ClickOnRegisterButton has been started");
		Assert.assertEquals(true, true);
	}
	
	@Test(priority=3)
	public void ClickOnResetPasswordButton()
	{
		e3.log(Status.INFO, "ClickOnResetPasswordButton has been started");
		Assert.assertEquals(true, false);
	}
	
	@Test(priority=4)
	public void ClickOnOrderNowButton()
	{
		e3.log(Status.INFO, "ClickOnOrderNowButton has been started");
		Assert.assertEquals(true, true);
		throw new SkipException("ClickOnOrderNowButton is not ready to test. Hence skipping this one.");
	}
	
	@Test(priority=5)
	public void ClickOnBuyNowButton()
	{
		e3.log(Status.INFO, "ClickOnBuyNowButton has been started");
		Assert.assertEquals(true, true);
	}
	
	@Test(priority=6)
	public void ClickOnEMIButtonButton()
	{
		e3.log(Status.INFO, "ClickOnEMIButtonButton has been started");
		Assert.assertEquals(true, true);
		throw new SkipException("ClickOnEMIButtonButton is not ready to test. Hence skipping this one.");
	}
	
	@Test(priority=7)
	public void ClickOnSubmitButton()
	{
		e3.log(Status.INFO, "ClickOnSubmitButton has been started");
		Assert.assertEquals(true, true);
	}

}
