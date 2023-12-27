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
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Class1Test extends BaseTest{

	private int rowIndex = 0; // Initialize rowIndex
    private int columnIndex = 0; // Initialize columnIndex
	
	String class1 = "//span[text()='SmartClass1']";
	String addWritingAssesment = "//td[@class='addButton']/button";
	String letterFormation = "//span[text()='Letter Formation 1']";
	String spellingList = "//span[text()='Spellings Lists']";
	String phenomes = "//span[text()='40+ Phonemes']";
	String trickyWords = "//span[text()='Tricky Words']";
	String punctuation = "//span[text()='Punctuation']";
	String creatingNarratives = "//span[text()='Creating Narratives']";
	String scroll = "//span[text()='Scroll']";
	String calculateOutCome = "//button[text()='Calculate outcome']";
	String outcomeTextLocator = "//span[@class='mappix-outcome']";
	String save = "//button[text()='Save']";
		
	@BeforeTest 
	public void login() throws InterruptedException {
		BaseTest.launchBrowser();
		Thread.sleep(2000);
	}
	
	@Test(priority=1,  dataProvider = "Beam", dataProviderClass = Class1ExcelData.class)
	public void addcase(String cases, String letterinformation, String spellinglists, String Phonemes, String trickywords, String Punctuation, String creatingnarratives, String expectedresults) throws InterruptedException, IOException
	{     
            page.click(class1);
            page.click(addWritingAssesment);           
            page.click(letterFormation);
            page.click(scroll);
            page.click(letterinformation);
            Thread.sleep(1000);
            page.click(spellingList);
            page.click(scroll);
            page.click(spellinglists);
            Thread.sleep(1000);
            page.click(phenomes);
            page.click(scroll);
            page.click(Phonemes);
            Thread.sleep(1000);
            page.click(trickyWords);
            page.click(scroll);
            page.click(trickywords);
            Thread.sleep(1000);
            page.click(punctuation);
            page.click(scroll);
            page.click(Punctuation);
            Thread.sleep(1000);
            page.click(creatingNarratives);
            page.click(scroll);
            page.click(creatingnarratives);
            
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
                Sheet sheet = workbook.getSheet("Class1");

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
