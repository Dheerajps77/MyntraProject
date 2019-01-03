package com.qa.myntra.TestClass;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.myntra.TestBase.TestbaseClass;
import com.qa.myntra.TestPage.CourseAtWayToAutomation;

public class CourseAtWayToAutomationClass extends TestbaseClass {
	
	
	CourseAtWayToAutomation objCourseAtWayToAutomation;
	
	
	@Test(priority=0)
	public void MouseHoverToCourseMenuLink() throws InterruptedException
	{
		objCourseAtWayToAutomation=PageFactory.initElements(driver, CourseAtWayToAutomation.class);
		objCourseAtWayToAutomation.MouseHoverToCourseMenuLink();
	}
	
	@Test(priority=1, dependsOnMethods="MouseHoverToCourseMenuLink", description="This is ListCourseMethod")
	public void ListOfCourseOffered()
	{
		objCourseAtWayToAutomation.ListOfCourseOffered();
	}

}
