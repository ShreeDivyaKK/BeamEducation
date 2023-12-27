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
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import bsh.Console;
 //From 109 error in last 2 xpaths
public class Class4Test extends BaseTest{
	
	private int rowIndex = 0; // Initialize rowIndex
    private int columnIndex = 0; // Initialize columnIndex
	
public Workbook workbook;
public Cell cell;
String File_Path = "C:\\Users\\Rhibhus\\eclipse-workspace\\BeamEducation\\src\\main\\java\\excel\\OutcomeDataSheet.xlsx";

	String class4 = "//span[text()='SmartClass4']";

	String composingSentences = "//span[text()='Composing Sentences']";
	String structuralDevice = "//span[text()='Structural Devices']";
	String developingParagrahs = "//span[text()='Developing Paragraphs']";
	String creatingNarratives = "//span[text()='Creating Narratives']";
	String purpose = "//span[text()='Purpose']";
	String punctuation = "//span[text()='Punctuation']";
	String tenses = "//span[text()='Tenses']";
	String joinedUpWriting = "//span[text()='Joined-Up Writing']";
	String prefixAndSuffix = "//span[text()='Prefixes & Suffixes']";
	String spellingLists = "//span[text()='Spelling Lists']";
	String timeAndCause = "//span[text()='Time & Cause']";
	String nounsAndPronouns = "//span[text()='Nouns & Pronouns']";
	String scroll = "//span[text()='Scroll']";
	String calculateOutcome = "//button[text()='Calculate outcome']";
	String outcomeTextLocator = "//span[@class='mappix-outcome']";
	String save = "//button[text()='Save']";

	@BeforeTest
	public void login() throws InterruptedException {
		BaseTest.launchBrowser();
		Thread.sleep(2000);	
	}
	@Test(priority=1,  dataProvider = "Beam", dataProviderClass = Class4ExcelData.class)
	public void addcase(String cases, String composingsentences, String structuraldevices, String Developingparagraphs, String CreatingNarratives, String Purpose, String Punctuation, String Tenses, String Joinedupwritting, String PrefixesandSuffixes, String SpellingLists, 	String Timeandcause, String NounsandPronouns, String expectedresults) throws InterruptedException, IOException
	{
			page.click(class4);
            page.click("//span[@class='addButton']");
            page.click(composingSentences);
            page.click(scroll);
            page.click(composingsentences);
            Thread.sleep(500);
            page.click(structuralDevice);
            page.click(scroll);
            page.click(structuraldevices); 
            Thread.sleep(500);
            page.click(developingParagrahs);
            page.click(scroll);
            page.click(Developingparagraphs);
            Thread.sleep(500);
            page.click(creatingNarratives);
            page.click(scroll);
            page.click(CreatingNarratives); 
            Thread.sleep(500);
            page.click(purpose);
            page.click(scroll);
            page.click(Purpose);
            Thread.sleep(500);
            page.click(punctuation);
            page.click(scroll);
            page.click(Punctuation);
            Thread.sleep(500);
            page.click(tenses);
            page.click(scroll);
            page.click(Tenses);   
            Thread.sleep(500);
            page.click(joinedUpWriting);
            page.click(scroll);
            page.click(Joinedupwritting); 
            Thread.sleep(500);
            page.click(prefixAndSuffix);
            page.click(scroll);
            page.click(PrefixesandSuffixes); 
            Thread.sleep(500);
            page.click(spellingLists);
            page.click(scroll);
            page.click(SpellingLists); 
            Thread.sleep(500);
            page.click(timeAndCause);
            page.click(scroll);
            page.click(Timeandcause); 
            Thread.sleep(500);
            page.click(nounsAndPronouns);
            page.click(scroll);
            page.click(NounsandPronouns);
            Thread.sleep(3000);
            Locator element =page.locator(calculateOutcome).first();
            element.hover();
            Thread.sleep(3000);
            page.click(calculateOutcome);
            Thread.sleep(2000);
            String outcomeText = page.locator(outcomeTextLocator).textContent();
            System.out.println(outcomeText);   
            
            try {
                // Load the Excel file (change the file path as per your requirement)
                String excelFilePath = "C:\\Users\\Rhibhus\\git\\beameducation\\BeamEducation\\src\\main\\java\\excel\\OutcomeDataSheet.xlsx";
                FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
                Workbook workbook = new XSSFWorkbook(inputStream);
                Sheet sheet = workbook.getSheet("Class4");

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
          
