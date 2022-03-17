package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic method to read and write the data into excel sheet
 * @author prave
 *
 */
public class ExcelFileUtility
{
	private static final String IPathConstants = null;

	public String readDataFromExcel(String sheetname,int rowNo,int cellno ) throws Throwable
	{
 	FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
  Workbook wb = WorkbookFactory.create(fis);
  Sheet sh = wb.getSheet(sheetname);
  Row ro = sh.getRow(rowNo);
  Cell cel = ro.getCell(cellno);
  String value = cel.getStringCellValue();
 return value;	  
	}
	/**
	 * This method will used to write data to excel sheet
	 * @param sheetname
	 * @param rowNo
	 * @throws Throwable 
	 */
public void writedataintoExcelsheet(String sheetname,int rowNo,int celnum,String value ) throws Throwable	
{
FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetname);
Row ro = sh.getRow(rowNo);
  Cell cel = ro.createCell(celnum);
  cel.setCellValue(value);
  
  FileOutputStream fos = new FileOutputStream(IPathConstant.ExcelPath);
  wb.write(fos);
}	

/**
 * This method will return last row number	
 * @throws Throwable 
 */
public int getRowCount(String sheetname) throws Throwable
{
	FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
	  Workbook wb = WorkbookFactory.create(fis);
	  Sheet sh = wb.getSheet(sheetname);
	 int row = sh.getLastRowNum();
	 return row;
}

/**
 * This method will read multiple data from excel sheet with the help of sheetname
 * and return 2 dimensional object [][]
 * @param SheetName
 * @return
 * @throws Throwable
 */
public Object[][] readmultipleDataFromExcel(String SheetName) throws Throwable
{
	FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(SheetName);
	int lastRow = sh.getLastRowNum();
	int lastCell = sh.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[lastRow][lastCell];
	
	for(int i = 0;i<lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	
	return data;

}}
