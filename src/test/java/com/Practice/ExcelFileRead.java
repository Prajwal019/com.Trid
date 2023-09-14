package com.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileRead {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	Sheet s = wb.getSheet("Sheet1");
	int last = s.getLastRowNum();
	for (int i = 0; i <= last; i++) {
		Row r = s.getRow(i);
		Cell c = r.getCell(0);
		Cell c1 = r.getCell(1);
		String value = c.getStringCellValue();
		String value1 = c1.getStringCellValue();
		System.out.println(value+"========>"+value1);
	}
	Row r = s.getRow(1);
	Cell c = r.getCell(0);
	c.setCellValue("HellCat");
	FileOutputStream fout=new FileOutputStream("./src/test/resources/testdata.xlsx");
	wb.write(fout);
	wb.close();
	/*for (int i = 0; i <=last; i++) {
		for (int j = 0; j <=2; j++) {
			Row r1 = s.getRow(i);
			Cell c1= r1.getCell(j);
			String value = c1.getStringCellValue();
			System.out.println(value);
		}
	}*/

	
	}
}
