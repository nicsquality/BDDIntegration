package com.dcx.testcases_stepdefination;

import org.jsoup.Connection.Base;
import org.junit.*;

import com.dcx.util.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class findDistanceTest {
	BaseTest appium = BaseTest.getInstance();
	

	@Given("^I launch app to execute testcase \"([^\"]*)\"$")
	public void I_launch_app_to_execute_testcase(String testCaseName) {
		BaseTest.test = BaseTest.getExtentTest(BaseTest.extent, testCaseName);
		BaseTest.test.log(LogStatus.INFO, "Launching app");	  

	    appium.launchApp();
	    BaseTest.test.log(LogStatus.INFO, "App is successfully launched");
	    
	   
	}
	
	@Given("^testcase is \"([^\"]*)\" and testcaseId is \"([^\"]*)\"$")
	public void testcase_is(String testCaseName, String testCaseId) {
		System.out.println("initializing xl - tascase "+testCaseName+"---"+testCaseId);
		BaseTest.test.log(LogStatus.INFO, "Verifying testcase - "+testCaseName+" with test data for testcase id - "+testCaseId);
	    BaseTest.data = BaseTest.getData(testCaseName, testCaseId);
	    //System.out.println(data.get("TestCaseId"));
	   
   
	   	    
	   
	}

	@And("^I click on \"([^\"]*)\"$")
	public void i_click_on(String locatorKey)  {
			appium.click(locatorKey);
	    
	}

	@And("^I enter \"([^\"]*)\" as \"([^\"]*)\"$")
	public void i_enter_as(String locatorKey, String inputText) {
		appium.type(locatorKey, inputText);
		
	   
	}

	@Then("^Distance found in \"([^\"]*)\" should be correct$")
	public void distance_between_the_location_should_be(String locatorKey){
		
		String distanceOnMap = appium.getTextFromElement(locatorKey);
		System.out.println(distanceOnMap);
	
		
		String actualDistanceInString = distanceOnMap.trim().substring(1, distanceOnMap.length()-4);			
				
		double actualDistance = Double.parseDouble(actualDistanceInString);
		BaseTest.test.log(LogStatus.INFO, "distance found on App is  "+actualDistance+" km");
		System.out.println("distance found on App is  "+actualDistance+" km");
		appium.takeSceenshot();
	
		
		
		String distanceFromAPI = appium.APICall(BaseTest.data.get("StartingPoint"), BaseTest.data.get("DestinationPoint"));
		String expectedDistanceInString = distanceFromAPI.trim().substring(0, distanceFromAPI.length()-3);		
		
		
		double expectedDistance = Double.parseDouble(expectedDistanceInString);
		BaseTest.test.log(LogStatus.INFO, "distance found from API is  "+expectedDistance+" km");
		System.out.println("expected distance is "+expectedDistance);
		
				
		BaseTest.test.log(LogStatus.INFO, "Validating expected and actual distance");
		try {
			Assert.assertEquals(expectedDistance, actualDistance, 0.0001);
			appium.reportPass();
		} catch (Error e) {
			appium.reportFailure("Distance found in google map is not as per expected distance."+e.getMessage());
			
		}			
		
	}
	
	@And("^I close app$")
	public void I_close_app(){
		appium.closeApp();
		
	}
}
