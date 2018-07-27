package com.dcx.util;

import java.util.Hashtable;

public class DataUtil {
	
	public static Hashtable<String, String> getdata(Xls_Reader xls,String testCaseName, String testCaseId){
				
		String sheetName = "Data";
		
		int testStartRowNum = 1;
		while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName)){
			testStartRowNum++;
		}
		System.out.println(testCaseName+" is starting from "+testStartRowNum);
		
		int colStartRowNum = testStartRowNum+1;
		int dataStartRowNum = testStartRowNum+2;
		
		int rows = 0;
		while(!xls.getCellData(sheetName, 0, dataStartRowNum+rows).equals("")){
			rows++;
		}
		
		System.out.println("Total no. of rows are "+rows);
		
		int cols = 0;
		while(!xls.getCellData(sheetName, cols, colStartRowNum).equals("")){
			cols++;
		}	
		
		System.out.println("Total no. of cols are "+cols);
		
		
		Hashtable<String,String> table = null;
		for(int rNum=dataStartRowNum; rNum<dataStartRowNum+rows;rNum++){
			//table = new Hashtable<String,String>();
			//for(int cNum=0;cNum<cols;cNum++){
				//String key = xls.getCellData(sheetName, 0, colStartRowNum);
				String currentTestCaseId = xls.getCellData(sheetName, 0, rNum);				
				if(currentTestCaseId.equals(testCaseId)){					
					table = new Hashtable<String,String>();
					for(int cNum=0;cNum<cols;cNum++){						
						String key = xls.getCellData(sheetName, cNum, colStartRowNum);
						String value = xls.getCellData(sheetName, cNum, rNum);
						table.put(key, value);
											
				}
					return table;
					
						
				//data[dataRow][cNum]=xls.getCellData(sheetName, cNum, rNum);
			}
			
			
		}
		
		return null;
		
		
	}
	
	public static boolean isTestRunnable(Xls_Reader xls, String testCaseName){
		
		String sheetName = "TestCases";
		int rows = xls.getRowCount(sheetName);
		int rNum = 2;
		while(!xls.getCellData(sheetName, 0, rNum).equals(testCaseName)){
			rNum++;
		}
		if(xls.getCellData(sheetName, 1, rNum).equals("Y"))
			return true;
		else 
			return false;
	
	}

}
