package com.qa.beameducation.testscripts;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;

public class Class6Test extends BaseTest{

		private int rowIndex = 0; // Initialize rowIndex
	    private int columnIndex = 0; // Initialize columnIndex
		
		String class6 = "//span[text()='SmartClass6']";
		String addWritingAssesment = "//span[@class='addButton']/button";
		String scroll = "//span[text()='Scroll']";
		String calculateOutCome = "//button[text()='Calculate outcome']";
		String outcomeTextLocator = "//span[@class='mappix-outcome']";
		String save = "//button[text()='Save']";
		
		@BeforeTest 
		public void login() throws InterruptedException {
			BaseTest.launchBrowser();
			Thread.sleep(2000);
		}
		
		@Test(priority=1,  dataProvider = "Beam", dataProviderClass = Class6ExcelData.class)
		public void addcase(String cases, String composingsentense, String structuraldevices, 
		String developingparagraphs, String creatingnarrativeness, String Purpose, 
		String Punctuation,String Tenses, String joinedupwriting, String dictionaryorthesaurus, 
		String spellinglists, String formalandinformal, String formalvacabulary,
		String expectedresults) throws InterruptedException, IOException
		{ 
			
			page.click(class6);
			page.click(addWritingAssesment);
			Thread.sleep(2500);
			page.click("//span[text()='Composing Sentences']");
			page.click(scroll);
			page.click(composingsentense);
			Thread.sleep(500);
			page.click("//span[text()='Structural Devices']");
			page.click(scroll);
			page.click(structuraldevices);
			Thread.sleep(500);
			page.click("//span[text()='Developing Paragraphs']");
			page.click(scroll);
			page.click(developingparagraphs);
			Thread.sleep(500);
			page.click("//span[text()='Creating Narratives']");
			page.click(scroll);
			page.click(creatingnarrativeness);
			Thread.sleep(500);
			page.click("//span[text()='Purpose']");
			page.click(scroll);
			page.click(Purpose);
			Thread.sleep(500);
			page.click("//span[text()='Punctuation']");
			page.click(scroll);
			page.click(Punctuation);
			Thread.sleep(500);
			page.click("//span[text()='Tenses']");
			page.click(scroll);
			page.click(Tenses);
			Thread.sleep(500);
			page.click("//span[text()='Joined-Up Writing']");
			page.click(scroll);
			page.click(joinedupwriting);
			Thread.sleep(500);
			page.click("//span[text()='Dictionary / Thesaurus']");
			page.click(scroll);
			page.click(dictionaryorthesaurus);
			Thread.sleep(500);
			page.click("//span[text()='Spelling Lists']");
			page.click(scroll);
			page.click(spellinglists);
			Thread.sleep(500);
			page.click("//span[text()='Formal & Informal']");
			page.click(scroll);
			page.click(formalandinformal);
			Thread.sleep(500);
			page.click("//span[text()='Formal Vocabulary']");
			page.click(scroll);
			page.click(formalvacabulary);
			Thread.sleep(500);
			
			Locator element =page.locator(calculateOutCome).first();
	         element.hover();
	         Thread.sleep(3000);
	         page.click(calculateOutCome);
	         Thread.sleep(2000);
	         String outcomeText = page.locator(outcomeTextLocator).textContent();
	         System.out.println(outcomeText);   
	         
	         try {
	             // Load the Excel file (change the file path as per your requirement)
	             String excelFilePath = "C:\\Users\\Rhibhus\\git\\beameducation\\BeamEducation\\src\\main\\java\\excel\\OutcomeDataSheet.xlsx";
	             FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	             Workbook workbook = new XSSFWorkbook(inputStream);
	             Sheet sheet = workbook.getSheet("Class6");

	          // Assuming 'rowIndex' tracks the row where you want to store the data
	             Row row = sheet.createRow(rowIndex);

	             // Assuming 'columnIndex' tracks the column where you want to store the outcomeText1
	             Cell cell = row.createCell(columnIndex);
	             cell.setCellValue(outcomeText);

	             // Write the data back to the Excel file
	             FileOutputStream outputStream = new FileOutputStream(excelFilePath);
	             workbook.write(outputStream);
	             workbook.close();

	             // Increment rowIndex for the next iteration
	             rowIndex++;
	             
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
	         
	         
	         assertEquals(outcomeText, expectedresults,"Both are equal");           
	         if(outcomeText.equals(expectedresults))
	         {
	         	System.out.println(expectedresults+" " +outcomeText+ " " +"is same");
	         }
	         else {
	         	System.out.println(expectedresults+" " +outcomeText+"is not same");
	         }

	         Thread.sleep(2000);
	         page.click(save);
	         Thread.sleep(3000);

	 //        browser.close();
			
		}
}
