package com.Trid.GenericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {
	/**
	 * This method is used to read the data from excel file
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheetName,int rowNo,int cellNo) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	/**
	 * This method is used to write the data to excel file
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @throws Throwable
	 */
	public void writeDataToExcel(String sheetName,int rowNo,int cellNo,String data) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).setCellValue(data);
		FileOutputStream fout=new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fout);
		wb.close();
	}
	/**
	 * This method is used to get the last row number in the excel file
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public int getLastRowNo(String sheetName) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		int count=wb.getSheet(sheetName).getLastRowNum();
		return count;
	}
	/**
	 * This method is used to read the multiple data from Excel file
	 * @param sheetName
	 * @param KeycellNo
	 * @param ValueCellNo
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String, String> getMultipleDataFromExcel(String sheetName,int KeycellNo,int ValueCellNo) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
//		JavaUtility jLib=new JavaUtility();
		for (int i = 0; i <= count; i++) {
			String key=sh.getRow(i).getCell(KeycellNo).getStringCellValue();
			String value=sh.getRow(i).getCell(ValueCellNo).getStringCellValue();
			map.put(key, value); 
		}
		return map;
	}
	public Object[][] DPMultipleSetOfData(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		Object[] []obj=new Object[lastRow+1][lastCell];
		for (int i = 0; i <= lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
