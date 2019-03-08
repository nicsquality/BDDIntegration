package com.dcx.config;

import java.io.File;

public class Constants {
	
	/*public static final String PROPERTY_FILE_PATH = System.getProperty("user.dir")+"\\src\\main\\java\\com\\dcx\\config\\OS.properties";
	public static final String EXCEL_FILE_PATH = System.getProperty("user.dir")+"\\Data\\Data.xlsx";
	public static final String CONFIG_FILE_PATH = System.getProperty("user.dir")+"\\src\\main\\java\\com\\dcx\\config\\";
	public static final String SCREENSHOT_FILE_PATH = System.getProperty("user.dir")+"\\ExtentReports\\Screenshots\\";
	public static final String REPORTS_FILE_PATH = System.getProperty("user.dir")+"\\ExtentReports\\report.html";
	public static final String REPORTS_CONFIG_FILE_PATH = System.getProperty("user.dir")+"\\ReportsConfig.xml";*/
	
	public static final String PROPERTY_FILE_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"dcx"+File.separator+"config"+File.separator+"OS.properties";
	public static final String EXCEL_FILE_PATH = System.getProperty("user.dir")+File.separator+"Data"+File.separator+"Data.xlsx";
	public static final String CONFIG_FILE_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"dcx"+File.separator+"config"+File.separator;
	public static final String SCREENSHOT_FILE_PATH = System.getProperty("user.dir")+File.separator+"ExtentReports"+File.separator+"Screenshots"+File.separator;
	public static final String REPORTS_FILE_PATH = System.getProperty("user.dir")+File.separator+"ExtentReports"+File.separator+"report.html";
	public static final String REPORTS_CONFIG_FILE_PATH = System.getProperty("user.dir")+File.separator+"ReportsConfig.xml";
}
