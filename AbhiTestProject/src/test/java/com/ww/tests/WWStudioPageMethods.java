package com.ww.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ww.base.BaseClass;

import pageobjects.PageObjects;

public class WWStudioPageMethods extends BaseClass{
	
	PageObjects PO;
	
	public String FirstStudioName;
	public String FirstStudioLocation;

	
	//Defining Test Methods
	public void AssertTitle() {
		//Get Window Title
		String title = driver.getTitle();
		//Verify that the Title matches the provided Text
		Assert.assertEquals(title, "Find WW Studios & Meetings Near You | WW USA");
		System.out.println("Page Title is "+title+"\n");
	}	
	
	public void GetFirstStudio() throws InterruptedException {
		
		PO = new PageObjects(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait until Studio tab is visible
		wait.until(ExpectedConditions.visibilityOf(PO.Studio));
		//click on Studio tab
		PO.Studio.click();
		//wait until location box is visible
		wait.until(ExpectedConditions.visibilityOf(PO.LocationBox));
		//send 10011 in location
		PO.LocationBox.sendKeys("10011");
		//adding sleep in next step for visibility on screen
		Thread.sleep(2000);
		//Click Search button
		PO.SearchButton.click();
		//wait until Search Results are visible
		wait.until(ExpectedConditions.visibilityOf(PO.FirstSearchResultName));
		//Scroll down using jsexecutor for visibility 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		//adding sleep for visibility on screen
		//Thread.sleep(3000);
		//Get title of the First Result
		FirstStudioName = PO.FirstSearchResultName.getText();
		System.out.println("The First Result is "+FirstStudioName+"\n");
		//get the Distance for the First Result
		String distance = PO.FirstSearchResultDistance.getText();
		System.out.println("Distance of the Studio is "+distance+"\n");
		//get location info for first result
		FirstStudioLocation = PO.DetailLocLine1.getText();
		
	}
	
	public void GetLocationInfo(){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//Click on First Search Result
		PO.FirstSearchResultName.click();
		//Wait until Studio Details are available
		wait.until(ExpectedConditions.visibilityOf(PO.DetailName));
		//Store studio name in a string after opening the first search result
		String studiodetailname = PO.DetailName.getText();
		//Verify if Location name matches the name for First Search Result
		if(studiodetailname.equals(FirstStudioName))
		{
			System.out.println("The location name matches the search result name! Location name is " +studiodetailname+"\n");
		}
		else
			System.out.println("The location name does not match the search result name! The First search result location name was "+FirstStudioName+" but the Studio Page opened was "+studiodetailname+"\n");
	
	}
	
	
	public void BusinessHours() throws InterruptedException{
		//Click on Business Hours
		PO.BusinessHours.click();
		//Scroll down using jsexecutor for visibility 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		//adding sleep time so hours are visible on screen for this project
		Thread.sleep(3000);
		//Logic for getting business hours and printing
		List<WebElement> gethours = driver.findElements(By.xpath("//*[contains(@class,'hours-')]/div[2]/div/div/div")); 
			for(int i = 0; i< gethours.size(); i+=2) {
				String s = gethours.get(i).getText();
				String s1 = gethours.get(i+1).getText();
		         System.out.println(s +" "+s1+"\n");
			}
				 
		
		 } 
	
}



