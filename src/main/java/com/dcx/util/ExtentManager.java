//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html

package com.dcx.util;

import java.io.File;

import com.dcx.config.Constants;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;	
	private ExtentManager(){
		
	}

	public static ExtentReports getInstance() {
		if (extent == null) {
			
			extent = new ExtentReports(Constants.REPORTS_FILE_PATH, true, DisplayOrder.NEWEST_FIRST);

			// optional
		//	extent.config().documentTitle("Automation Report")
		//			.reportName("Regression").reportHeadline("");
			extent.loadConfig(new File(Constants.REPORTS_CONFIG_FILE_PATH));
			// optional
			extent.addSystemInfo("Appium version", "1.7").addSystemInfo(
					"Environment", "Test");
		}
		return extent;
	}
}
