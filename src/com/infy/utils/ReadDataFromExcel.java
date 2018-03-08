package com.infy.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	
	File src;
	FileInputStream fis;
	XSSFWorkbook xs;
	XSSFSheet sheet;
	

	/**
	 * @desc reading data from excel
	 */
	public void readDataFromExcel(){
		 try {
			 String ExcelPath = System.getProperty("user.dir") +"/TestData/eBayTestLogin.xlsx";
			 src = new File(ExcelPath);
			 fis = new FileInputStream(src);
			 xs = new XSSFWorkbook(fis);
		} 
		 catch (Exception e) {
			e.printStackTrace();
		}
	 }

	/**
	 * @desc fetch data from excel
	 */
	public String getdata(int sheetno ,int rownum ,int columno){
		sheet =  xs.getSheetAt(sheetno);
		String data =	sheet.getRow(rownum).getCell(columno).getStringCellValue();
		return data;
	}
	
	/**
	 * @desc fetch row count from excel
	 */
	public int getrowcount(int sheetindex){
		int a = xs.getSheetAt(sheetindex).getLastRowNum();
		a=a+1;
		return a;
	}
	
}

	
	
