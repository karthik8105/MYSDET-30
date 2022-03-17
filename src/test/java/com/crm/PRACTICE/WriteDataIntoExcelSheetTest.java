package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataIntoExcelSheetTest
{
	@Test
	public void writeDataFromExcelSheetTest() throws Throwable 
	{
		FileInputStream fis = new FileInputStream(".//src//test//resources//Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row ro = sh.getRow(1);
		Cell ce = ro.getCell(1);
	ce.setCellValue("11");
	//open file in write mode
	FileOutputStream fos = new FileOutputStream(".//src//test//resources//Data.xlsx");
	wb.write(fos);
	}

	}

