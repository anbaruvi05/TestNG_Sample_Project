package com.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData_UserDetails {

	public FileInputStream file;
	public XSSFWorkbook work;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path;
	
	public ExcelData_UserDetails(String pathname) {
		this.path=pathname;
		
	}
	
	
	public int getRowCount(String sheetname) throws Throwable {
		file = new FileInputStream(path);
		work = new XSSFWorkbook(file);
		sheet = work.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		return rowcount;
	}
	
	public  int getCellCount(String sheetname,int rownum) throws Throwable {
		file = new FileInputStream(path);
		work = new XSSFWorkbook(file);
		sheet = work.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		return cellcount;
		
	}
	public  String getCellData(String sheetname, int rownum,int cell) throws Throwable {

		file = new FileInputStream(path);
		work = new XSSFWorkbook(file);
		sheet = work.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cellvalue = row.getCell(cell);
		
		DataFormatter format = new DataFormatter();
		
		String data = format.formatCellValue(cellvalue);
		
		return data;
	}
	
	
	


}
