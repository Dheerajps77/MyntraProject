package com.qa.myntra.TestClass;

import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.myntra.TestBase.TestbaseClass;
import com.qa.myntra.TestPage.HomePage;

public class HomePageClass extends TestbaseClass{
	
	
	HomePage ObjHomePage;
	
	@BeforeMethod
	public void Extentreport(Method method)
	{
		e3=e2.createTest(this.getClass().getSimpleName() + " : : " + method.getName());
	}
	
	@AfterMethod
	public void getResult(ITestResult result)
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

}
