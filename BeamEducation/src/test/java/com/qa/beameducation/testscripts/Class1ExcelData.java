package com.qa.beameducation.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class Class1ExcelData {

	public static String 	F_NAME="C:\\Users\\Rhibhus\\eclipse-workspace\\BeamEducation\\src\\main\\java\\excel\\Class1.xlsx";
	public static String 	S_name="Sheet1";
	public static int rowCount;
	public static int  rownumber;
	
			@DataProvider(name = "Beam")
		     public static Object[][] readExcelData() throws IOException {
		        List<Object[]> data = new ArrayList<>();
		        File file = new File(F_NAME);
		          FileInputStream inputStream = new FileInputStream(file);
		        Workbook workbook = WorkbookFactory.create(inputStream);
		        Sheet sheet = workbook.getSheet(S_name);
		        
		//  int totalRows = sheet.getLastRowNum()+1; //counting the rows, adding 1 as the index is 0- based.
		        
		          rowCount = sheet.getLastRowNum();
		          
		         for (int i = 1; i <= rowCount; i++) { // start from second row  
		            Row row = sheet.getRow(i);
		               rownumber=  row.getRowNum();
		             System.out.println("row number is :"+ rownumber);
		            Object[] rowValues = new Object[row.getLastCellNum()];
		            for (int j = 0; j < row.getLastCellNum(); j++) 
		            {
		                Cell cell = row.getCell(j, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		               System.out.println("cell============"+cell);
		                if (cell != null) {
		                    rowValues[j] = getCellValue(cell);
		                } else {
		                    rowValues[j] = null;
		                }
		                
		            }
		         data.add(rowValues);
		        }
		         
		        return data.toArray(new Object[0][0]);
		    }
	 
			public static int getRowNumber() {
				return rownumber;
			}
			
		    private static Object getCellValue(Cell cell) {
		        CellType cellType = cell.getCellType();
		        switch (cellType) {
		            case BOOLEAN:
		                return cell.getBooleanCellValue();
		            case NUMERIC:
		                return cell.getNumericCellValue();
		            case STRING:
		                return cell.getStringCellValue();
		             default:
		                return null;
		        }
		    }
}
