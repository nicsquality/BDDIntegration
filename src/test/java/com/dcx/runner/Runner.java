package com.dcx.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/dcx/features",
		glue={"com.dcx.testcases_stepdefination"},format={"pretty","html:test-output"},
		plugin={"html:Cucumber-Reports/cucumber-html-report"}
		)

public class Runner extends AbstractTestNGCucumberTests{

}
