package com.dcx.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.dcx.config.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class BaseTest {
	Properties OS = null;
	Properties CONFIG = null;
	AppiumDriver<MobileElement> driver;
	public static BaseTest base = null;
	public static ExtentReports extent = ExtentManager.getInstance();
	public static ExtentTest test = null;
	public static Xls_Reader xls = null;
	public static Hashtable<String, String> data = null;
	public static DesiredCapabilities capabilities;

	private BaseTest() {
		// initialize properties file
		if (OS == null) {
			try {
				OS = new Properties();
				FileInputStream fs = new FileInputStream(Constants.PROPERTY_FILE_PATH);
				OS.load(fs);

				CONFIG = new Properties();
				fs = new FileInputStream(Constants.CONFIG_FILE_PATH + OS.get("OS") + ".properties");
				CONFIG.load(fs);

			} catch (Exception e) {
				System.out.println("properties file could not be initialized");
				e.printStackTrace();
			}

		}
	}

	/**************************** App Independent ******************************/

	public static BaseTest getInstance() {
		if (base == null)
			base = new BaseTest();
		return base;

	}

	public static ExtentTest getExtentTest(ExtentReports extent, String testCaseName) {
		if (test == null)
			test = extent.startTest(testCaseName);
		return test;

	}

	public static Xls_Reader getXlReader() {
		if (xls == null)
			xls = new Xls_Reader(Constants.EXCEL_FILE_PATH);
		return xls;

	}

	public static Hashtable<String, String> getData(String testCaseName, String testCaseId) {
		data = DataUtil.getdata(BaseTest.getXlReader(), testCaseName, testCaseId);
		return data;

	}

	public void reportPass() {
		test.log(LogStatus.PASS, "Validation pass");
		System.out.println("Validation pass");
	}

	public void reportFailure(String errMsg) {
		test.log(LogStatus.FAIL, "Validation failed: " + errMsg);
		takeSceenshot();
		System.out.println("Validation failed");

	}

	public void takeSceenshot() {
		Date d = new Date();
		String screenshot = d.toString().replace(" ", "_").replace(":", "_") + ".jpg";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(Constants.SCREENSHOT_FILE_PATH + screenshot));
		} catch (Exception e) {
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "screenshot below:(" + screenshot + ")"
				+ test.addScreenCapture(Constants.SCREENSHOT_FILE_PATH + screenshot));
	}

	public void launchApp() {
		capabilities = new DesiredCapabilities();
		String os = OS.getProperty("OS");
		if (os.equals("iOS")) {

			System.out.println(os);

			System.out.println("Executing iOS Test cases on RealDevices");
			capabilities.setCapability("platformName", "ios");

			capabilities.setCapability("automationName", CONFIG.getProperty("automationName"));
			capabilities.setCapability("udid", CONFIG.getProperty("deviceId"));
			capabilities.setCapability("deviceName", CONFIG.getProperty("deviceName"));
			capabilities.setCapability("platformVersion", CONFIG.getProperty("platformVersion"));
			capabilities.setCapability("bundleId", CONFIG.getProperty("bundleId"));

			try {
				driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			System.out.println(os);

			capabilities.setCapability("platformName", CONFIG.getProperty("platformName"));
			capabilities.setCapability("deviceName", CONFIG.getProperty("deviceName"));
			capabilities.setCapability("udid", System.getProperty("Mobile_ip"));
			capabilities.setCapability("platformVersion", CONFIG.getProperty("platformVersion"));
			capabilities.setCapability("appPackage", CONFIG.getProperty("appPackage"));
			capabilities.setCapability("appActivity", CONFIG.getProperty("appActivity"));

			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:"+System.getProperty("port")+"/wd/hub"), capabilities);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public String distanceOnMap(String locatorKey) {

		String os = OS.getProperty("OS");
		String distanceOnMapText = getTextFromElement(locatorKey);
		String actualDistanceInString;
		if (os.equals("iOS")) {
			actualDistanceInString = StringUtils.substringBetween(distanceOnMapText, ",", "kilometres").trim();
		} else {
			System.out.println(os);
			actualDistanceInString = distanceOnMapText.trim().substring(1, distanceOnMapText.length() - 4);
		}

		return actualDistanceInString;
	}

	public void closeApp() {
		System.out.println("Closing app");
		if (driver != null) {
			test.log(LogStatus.INFO, "closing app");
			extent.endTest(test);
			extent.flush();
			test = null;
			data = null;
			driver.quit();
		}
	}

	public MobileElement getElement(String locatorKey) {

		MobileElement e = null;
		try {
			if (locatorKey.endsWith("_id"))
				e = driver.findElement(By.id(CONFIG.getProperty(locatorKey)));
			else if (locatorKey.endsWith("_xpath"))
				e = driver.findElement(By.xpath(CONFIG.getProperty(locatorKey)));
			else if (locatorKey.endsWith("_name"))
				e = driver.findElement(By.name(CONFIG.getProperty(locatorKey)));
		} catch (Exception ex) {

			ex.printStackTrace();
		}

		return e;

	}

	public boolean isElementPresent(String locatorKey) {

		MobileElement e = null;
		try {
			if (locatorKey.endsWith("_id"))
				e = driver.findElement(By.id(CONFIG.getProperty(locatorKey)));
			else if (locatorKey.endsWith("_xpath"))
				e = driver.findElement(By.xpath(CONFIG.getProperty(locatorKey)));
			else if (locatorKey.endsWith("_name"))
				e = driver.findElement(By.name(CONFIG.getProperty(locatorKey)));

		} catch (Exception ex) {

			return false;
		}
		return true;
	}

	public void click(String locatorKey) {
		System.out.println("Clicking on - " + locatorKey);
		test.log(LogStatus.INFO, "Clicking on - " + locatorKey);
		getElement(locatorKey).click();
		test.log(LogStatus.INFO, "Successfully clicked on - " + locatorKey);
		takeSceenshot();

	}

	public void type(String locatorKey, String inputText) {
		System.out.println("Entering text in the field " + locatorKey);
		test.log(LogStatus.INFO, "Entering text - " + data.get(inputText) + " in the field - " + locatorKey);
		getElement(locatorKey).clear();
		getElement(locatorKey).sendKeys(data.get(inputText) + "\n");
		test.log(LogStatus.INFO,
				"successfully entered text - " + data.get(inputText) + " in the field - " + locatorKey);
		takeSceenshot();

	}

	public String getTextFromElement(String locatorKey) {
		return getElement(locatorKey).getText();

	}

	/************************** App dependent ***************************/

	public String APICall(String source, String destination) {
		source = source.replace(" ", "%20").replace("'", "%27");
		destination = destination.replace(" ", "%20").replace("'", "%27");

		String distance;
		try {
			String url = "https://maps.googleapis.com/maps/api/distancematrix/json?&origins=" + source
					+ "&destinations=" + destination + "&key=AIzaSyDOVwsX8WJ05kLO54wvw6gVnr4nRrVLBLo";

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			// optional default is GET
			con.setRequestMethod("GET");
			// add request header
			// con.setRequestProperty("User-Agent", "Chrome/5.0");
			int responseCode = con.getResponseCode();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print in String
			System.out.println(response.toString());
			// Read JSON response and print
			JSONObject myResponse = new JSONObject(response.toString());
			distance = myResponse.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0)
					.getJSONObject("distance").getString("text");
			System.out.println(distance);
			return distance;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}