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

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Class2Test extends BaseTest{

	public Workbook workbook;
	public Cell cell;
	String File_Path = "C:\\Users\\Rhibhus\\eclipse-workspace\\BeamEducation\\src\\main\\java\\excel\\OutcomeDataSheet.xlsx";

	private int rowIndex = 0; // Initialize rowIndex
    private int columnIndex = 0; // Initialize columnIndex
	
	String class2 = "//span[text()='SmartClass2']";
	String addWritingAssesment = "(//td[@class='addButton'])[1]";
	
	String scroll = "//span[text()='Scroll']";
	String calculateOutCome = "//button[text()='Calculate outcome']";
	String outcomeTextLocator = "//span[@class='mappix-outcome']";
	String save = "//button[text()='Save']";
		
	@BeforeTest
	public void login() throws InterruptedException {
		BaseTest.launchBrowser();
		Thread.sleep(2000);
	}
	
	@Test(priority=1,  dataProvider = "Beam", dataProviderClass = Class2ExcelData.class)
	public void addcase(String cases, String creatingnarratives, String realevents, String Purpose, 
			String complexandcompound, String Punctuation, String Tenses,
			String letterformationone, String letterformationtwo,  String joinedupwritting, 
			String leavingspaces, String Phonemes, String trickywords, String Suffixes,String spellinglists, 
			String Homophones, String expectedresults) throws InterruptedException, IOException
	{     
           page.click(class2);
           page.click(addWritingAssesment);           
           page.click("//span[text()='Creating narratives']");
           page.click(scroll);
           page.click(creatingnarratives);
           Thread.sleep(500);
           page.click("//span[text()='Real events']");
           page.click(scroll);
           page.click(realevents);
           Thread.sleep(500);
           page.click("//span[text()='Purpose']");
           page.click(scroll);
           page.click(Purpose);
           Thread.sleep(500);
           page.click("//span[text()='Complex & Compound']");
           page.click(scroll);
           page.click(complexandcompound);
           Thread.sleep(500);
           page.click("//span[text()='Punctuation']");
           page.click(scroll);
           page.click(Punctuation);
           Thread.sleep(500);
           page.click("//span[text()='Tenses']");
           page.click(scroll);
           page.click(Tenses);
           Thread.sleep(500);
           page.click("//span[text()='Letter Formation 1']");
           page.click(scroll);
           page.click(letterformationone);
           Thread.sleep(500);
           page.click("//span[text()='Letter Formation 2']");
           page.click(scroll);
           page.click(letterformationtwo);
           Thread.sleep(500);
           page.click("//span[text()='Joined-Up Writing']");
           page.click(scroll);
           page.click(joinedupwritting);
           Thread.sleep(500);
           page.click("//span[text()='Leaving Spaces']");
           page.click(scroll);
           page.click(leavingspaces);
           Thread.sleep(500);
           page.click("//span[text()='40+ Phonemes']");
           page.click(scroll);
           page.click(Phonemes);
           Thread.sleep(500);
           page.click("//span[text()='Tricky Words']");
           page.click(scroll);
           page.click(trickywords);
           Thread.sleep(500);
           page.click("//span[text()='Suffixes']");
           page.click(scroll);
           page.click(Suffixes);
           Thread.sleep(500);
           page.click("//span[text()='Spellings Lists']");
           page.click(scroll);
           page.click(spellinglists);
           Thread.sleep(500);
           page.click("//span[text()='Homophones']");
           page.click(scroll); 
           page.click(Homophones);
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
               Sheet sheet = workbook.getSheet("Class2");

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
