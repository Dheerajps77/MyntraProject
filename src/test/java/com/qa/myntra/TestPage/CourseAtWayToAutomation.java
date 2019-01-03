package com.qa.myntra.TestPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CourseAtWayToAutomation {
	

	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	public CourseAtWayToAutomation(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//ul[contains(@class,'nav navbar-nav')]//li[3]//a[text()='Courses']")
	WebElement CourseMenu;
	
	@FindBy(how=How.XPATH, using="//ul[contains(@class,'nav navbar-nav')]//li[@class='dropdown']//a[text()='Courses']//following::ul[1]//li")
	public List<WebElement> listOfCourse;
	
	public void MouseHoverToCourseMenuLink() throws InterruptedException
	{
		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(CourseMenu));
		
		action=new Actions(driver);
		action.moveToElement(CourseMenu).build().perform();
		Thread.sleep(4000);
	}
	
	public void ListOfCourseOffered()
	{
		int totalSizeOfCourse=listOfCourse.size();
		System.out.println("Total size of Course are ---> " + totalSizeOfCourse);
		System.out.println("Below are the List of Course Offered by Way2Automation");
		for(int i=0;i<totalSizeOfCourse;i++)
		{
			String s1=listOfCourse.get(i).getText();
			System.out.println(s1);
		}
	}
}
