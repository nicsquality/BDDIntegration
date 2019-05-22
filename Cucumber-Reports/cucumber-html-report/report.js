$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("findDistance.feature");
formatter.feature({
  "line": 1,
  "name": "Finding distance in two locations",
  "description": "",
  "id": "finding-distance-in-two-locations",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Navigate to Go button",
  "description": "",
  "id": "finding-distance-in-two-locations;navigate-to-go-button",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I launch app to execute testcase \"FindDistance\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on \"GoButton_id\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "FindDistance",
      "offset": 34
    }
  ],
  "location": "findDistanceTest.I_launch_app_to_execute_testcase(String)"
});
formatter.result({
  "duration": 16329718872,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "GoButton_id",
      "offset": 12
    }
  ],
  "location": "findDistanceTest.i_click_on(String)"
});
formatter.result({
  "duration": 5773669764,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 8,
  "name": "Finding distance",
  "description": "",
  "id": "finding-distance-in-two-locations;finding-distance",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "testcase is \"FindDistance\" and testcaseId is \"\u003cTestCaseId\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I click on \"FromField_id\"",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I enter \"FromTextField_id\" as \"StartingPoint\"",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I click on \"DestinationField_id\"",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I enter \"DestinationTextField_id\" as \"DestinationPoint\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Distance found in \"DistanceOutput_xpath\" should be correct",
  "keyword": "Then "
});
formatter.examples({
  "line": 16,
  "name": "",
  "description": "",
  "id": "finding-distance-in-two-locations;finding-distance;",
  "rows": [
    {
      "cells": [
        "TestCaseId"
      ],
      "line": 17,
      "id": "finding-distance-in-two-locations;finding-distance;;1"
    },
    {
      "cells": [
        "TC1"
      ],
      "line": 18,
      "id": "finding-distance-in-two-locations;finding-distance;;2"
    },
    {
      "cells": [
        "TC2"
      ],
      "line": 19,
      "id": "finding-distance-in-two-locations;finding-distance;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 18,
  "name": "Finding distance",
  "description": "",
  "id": "finding-distance-in-two-locations;finding-distance;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "testcase is \"FindDistance\" and testcaseId is \"TC1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I click on \"FromField_id\"",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I enter \"FromTextField_id\" as \"StartingPoint\"",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I click on \"DestinationField_id\"",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I enter \"DestinationTextField_id\" as \"DestinationPoint\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Distance found in \"DistanceOutput_xpath\" should be correct",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "FindDistance",
      "offset": 13
    },
    {
      "val": "TC1",
      "offset": 46
    }
  ],
  "location": "findDistanceTest.testcase_is(String,String)"
});
formatter.result({
  "duration": 947318796,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "FromField_id",
      "offset": 12
    }
  ],
  "location": "findDistanceTest.i_click_on(String)"
});
formatter.result({
  "duration": 2814424073,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "FromTextField_id",
      "offset": 9
    },
    {
      "val": "StartingPoint",
      "offset": 31
    }
  ],
  "location": "findDistanceTest.i_enter_as(String,String)"
});
formatter.result({
  "duration": 15356190749,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DestinationField_id",
      "offset": 12
    }
  ],
  "location": "findDistanceTest.i_click_on(String)"
});
formatter.result({
  "duration": 3112098463,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DestinationTextField_id",
      "offset": 9
    },
    {
      "val": "DestinationPoint",
      "offset": 38
    }
  ],
  "location": "findDistanceTest.i_enter_as(String,String)"
});
formatter.result({
  "duration": 11120989439,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DistanceOutput_xpath",
      "offset": 19
    }
  ],
  "location": "findDistanceTest.distance_between_the_location_should_be(String)"
});
formatter.result({
  "duration": 3409319659,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Finding distance",
  "description": "",
  "id": "finding-distance-in-two-locations;finding-distance;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "testcase is \"FindDistance\" and testcaseId is \"TC2\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I click on \"FromField_id\"",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I enter \"FromTextField_id\" as \"StartingPoint\"",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I click on \"DestinationField_id\"",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I enter \"DestinationTextField_id\" as \"DestinationPoint\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Distance found in \"DistanceOutput_xpath\" should be correct",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "FindDistance",
      "offset": 13
    },
    {
      "val": "TC2",
      "offset": 46
    }
  ],
  "location": "findDistanceTest.testcase_is(String,String)"
});
formatter.result({
  "duration": 1599399,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "FromField_id",
      "offset": 12
    }
  ],
  "location": "findDistanceTest.i_click_on(String)"
});
formatter.result({
  "duration": 3482211464,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "FromTextField_id",
      "offset": 9
    },
    {
      "val": "StartingPoint",
      "offset": 31
    }
  ],
  "location": "findDistanceTest.i_enter_as(String,String)"
});
formatter.result({
  "duration": 12776434939,
  "error_message": "org.openqa.selenium.WebDriverException: An unknown server-side error occurred while processing the command. Original error: el.setText() failed!\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027din16001110.corp.capgemini.com\u0027, ip: \u002710.79.1.115\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.13.6\u0027, java.version: \u00271.8.0_181\u0027\nDriver info: io.appium.java_client.android.AndroidDriver\nCapabilities {appActivity: com.google.android.maps.Map..., appPackage: com.google.android.apps.maps, databaseEnabled: false, desired: {appActivity: com.google.android.maps.Map..., appPackage: com.google.android.apps.maps, deviceName: 3300ecdcbc951375, platformName: android, takesScreenshot: true}, deviceManufacturer: Xiaomi, deviceModel: Redmi Note 3, deviceName: 10.79.1.234:5557, deviceScreenSize: 1080x1920, deviceUDID: 10.79.1.234:5557, javascriptEnabled: true, locationContextEnabled: false, networkConnectionEnabled: true, platform: LINUX, platformName: Android, platformVersion: 6.0.1, takesScreenshot: true, warnings: {}, webStorageEnabled: false}\nSession ID: b005998c-0339-4d38-a30c-9b120cd13212\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\n\tat io.appium.java_client.remote.AppiumCommandExecutor.execute(AppiumCommandExecutor.java:239)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\n\tat io.appium.java_client.DefaultGenericMobileDriver.execute(DefaultGenericMobileDriver.java:42)\n\tat io.appium.java_client.AppiumDriver.execute(AppiumDriver.java:1)\n\tat io.appium.java_client.android.AndroidDriver.execute(AndroidDriver.java:1)\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\n\tat io.appium.java_client.DefaultGenericMobileElement.execute(DefaultGenericMobileElement.java:45)\n\tat io.appium.java_client.MobileElement.execute(MobileElement.java:1)\n\tat io.appium.java_client.android.AndroidElement.execute(AndroidElement.java:1)\n\tat org.openqa.selenium.remote.RemoteWebElement.sendKeys(RemoteWebElement.java:106)\n\tat com.dcx.util.BaseTest.type(BaseTest.java:209)\n\tat com.dcx.testcases_stepdefination.findDistanceTest.i_enter_as(findDistanceTest.java:48)\n\tat ✽.And I enter \"FromTextField_id\" as \"StartingPoint\"(findDistance.feature:11)\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "DestinationField_id",
      "offset": 12
    }
  ],
  "location": "findDistanceTest.i_click_on(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "DestinationTextField_id",
      "offset": 9
    },
    {
      "val": "DestinationPoint",
      "offset": 38
    }
  ],
  "location": "findDistanceTest.i_enter_as(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "DistanceOutput_xpath",
      "offset": 19
    }
  ],
  "location": "findDistanceTest.distance_between_the_location_should_be(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 21,
  "name": "Closing app",
  "description": "",
  "id": "finding-distance-in-two-locations;closing-app",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "I close app",
  "keyword": "And "
});
formatter.match({
  "location": "findDistanceTest.I_close_app()"
});
formatter.result({
  "duration": 3163190168,
  "status": "passed"
});
});