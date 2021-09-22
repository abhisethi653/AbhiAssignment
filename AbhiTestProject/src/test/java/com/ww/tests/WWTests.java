package com.ww.tests;


import org.testng.annotations.*;


public class WWTests extends WWStudioPageMethods{
	WWStudioPageMethods StudioFinderPage;

    //Test that nrowser opens successfully
	@Test(priority=1)
	public void TestBrowserOpensSuccessfully() {
		initialize();
	}
	
	//Test Page Title Assertion
	@Test(priority=2)
	public void TestPageTitle() {
		AssertTitle();
	}
	
	//Test to find studios for Zip Code 10011 and Print Title And Distance
	@Test(priority=3)
	public void FindClosestStudio() throws InterruptedException {
		GetFirstStudio();
		
		
	}
	
	//Test to Open First Result and Verify Location Title matches search Title
	@Test(priority=4)
	public void VerifyLocationTitleMatchesResult() {
	GetLocationInfo();
		}
	
	
	//Test to View Business Hours of Studio and Print Business Hours
	@Test(priority=5)
	public void CheckBusinessHours() throws InterruptedException {
	BusinessHours();
		}
	
	
	//Close Browser after Execution
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
