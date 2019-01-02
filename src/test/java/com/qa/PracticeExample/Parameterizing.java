package com.qa.PracticeExample;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterizing {
	
	
	@Parameters({"UserName","Password"})
	@Test(priority=0)
	public void Login(String UserName, String Password)
	{
		System.out.println("The user name is : "+UserName);
		System.out.println("The password is : "+Password);
	}
	
	@Test(dependsOnMethods="Login")
	public void PaymentPage()
	{
		System.out.println("I am in PaymentPage");
	}

}
