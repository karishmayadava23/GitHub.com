package com.crm.qa.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;
import com.google.common.io.Files;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String TESTDATA_SHEET_PATH = "E:\\Selenium2018\\SeleniumPrograms\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testData\\FreeCRM.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	// switch to frame is common method so we are creating here
	public void switchToFrame() {
		driver.switchTo().frame("downloadFrame");
	}

	public static Object[][] geTestData(String sheetName) throws IOException, Exception {
		FileInputStream file = null;
		file = new FileInputStream(TESTDATA_SHEET_PATH);
		book = WorkbookFactory.create(file);
		sheet = (Sheet) ((Workbook) book).getSheet(sheetName);
		Object[][] data = new Object[((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum()][((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "------"
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < ((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum(); i++) {
			for (int k = 0; k < ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(0).getLastCellNum(); k++) {
				data[i][k] = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;

	}
	public static  void takeScreenshotAtEndofTest() throws IOException{
	File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String currentDir= System.getProperty("user.dir");
	FileUtils.copyFile(scrFile,new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    
    
	
	
	}

	

}
