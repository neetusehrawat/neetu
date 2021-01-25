package com.ExcelReader;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

		String excelPath;
		XSSFWorkbook wb;
		FileInputStream fi;
		
		public ExcelReader(String excelPath) throws IOException {
			
			this.excelPath=excelPath;
			fi=new FileInputStream(this.excelPath);
			wb=new XSSFWorkbook(fi);
		}
		
		public int getRowCount(String sheetName) {
			int totalRowCount=0;
			try {
			
			totalRowCount=wb.getSheet(sheetName).getLastRowNum()+1;
			} catch(Exception e) {
				e.printStackTrace();
			}
			return totalRowCount;
			
		}
		
		public String getCellData(String sheetName, int row, int cell) {
			String cellValue="";
			try {
			cellValue=wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
			} catch(Exception e) {
				e.printStackTrace();
			}
			return cellValue;
			
		}
		
		public void closeExcel() throws IOException {
			try {
			wb.close();
			fi.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		

	}




