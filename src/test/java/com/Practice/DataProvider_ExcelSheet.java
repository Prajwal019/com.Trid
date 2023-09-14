package com.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Trid.GenericUtility.ExcelUtility;
import com.Trid.GenericUtility.IpathConstants;

public class DataProvider_ExcelSheet {
	@Test(dataProvider = "getDataFromExcel")
	public void fetchData(String brand,String name,String price) {
		System.out.println("Brand====>"+brand+"  Name====>"+name+"  Price====>"+price);
	}
	@DataProvider
	public Object[][] getDataFromExcel() throws Throwable {
		ExcelUtility eLib=new ExcelUtility();
		Object[][]value= eLib.DPMultipleSetOfData("DP");
		return value;
	/*	
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("DP");
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		
		Object[][]obj=new Object[lastRow+1][lastCell];
		for (int i = 0; i <=lastRow ; i++) {
			for (int j = 0; j < lastCell; j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;*/
	}
}
