package com.tv.admin.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.tv.admin.base.BaseClass;

public class TestUtil extends BaseClass {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	static Workbook book;
	static Sheet sheet;

	public static Object[][] getTestData(String sheetName) throws FileNotFoundException {
		File src = new File(".//TestData//Data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			book = WorkbookFactory.create(fis);
		} catch (Exception e) {
			System.out.println("file not found");
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

	public static String getCurrentDataTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}
}
