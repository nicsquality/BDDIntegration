Feature: Finding distance in two locations

Scenario: Navigate to Go button

Given I launch app to execute testcase "FindDistance"
And I click on "GoButton_id"

Scenario Outline: Finding distance
Given testcase is "FindDistance" and testcaseId is "<TestCaseId>"
And I click on "FromField_id" 
And I enter "FromTextField_id" as "StartingPoint"
And I click on "DestinationField_id" 
And I enter "DestinationTextField_id" as "DestinationPoint"
Then Distance found in "DistanceOutput_xpath" should be correct

Examples:
|TestCaseId	|
|TC1		|
|TC2		|

Scenario: Closing app
And I close app