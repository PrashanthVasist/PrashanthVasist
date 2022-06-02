package com.php.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.php.base.Base;

public class TestUtil extends Base{
	
	static Workbook book;
	static Sheet sheet;
	public static Object [][] getTestData (String sheetName) throws FileNotFoundException
	{
		File src = new File(".//TestData/Data.xlsx");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
		    book = WorkbookFactory.create(fis);
		} catch (Exception e) {
			System.out.println("File Not Found");
		}
		
		sheet = book.getSheet(sheetName);
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i=0;i<sheet.getLastRowNum();i++)
		{
			for (int v=0;v<sheet.getRow(0).getLastCellNum();v++)
			{
				data[i][v] = sheet.getRow(i+1).getCell(v).toString();
			}
		}
		return data;
	}
	
	public static String getDateTime()
	{
		DateFormat presDate = new SimpleDateFormat ("DD/MM/YYYY HH:mm:ss");
		Date currDate = new Date();
		presDate.format(currDate);
		return presDate.format(currDate);
	}

}
