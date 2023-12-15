package com.qa.beameducation.testscripts;

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
//118, 144, 152, 153, 
public class Class4Test{

	public Page page;
public Workbook workbook;
public Cell cell;
String File_Path = "C:\\Users\\Rhibhus\\eclipse-workspace\\BeamEducation\\src\\main\\java\\excel\\OutcomeDataSheet.xlsx";

String url = "https://testing.dj9yhpcsi54a3.amplifyapp.com/";
String username = "//input[@id='userNamePlaceholder']";
String password = "//input[@id='userPasswordPlaceholder']";
String loginButton = "//button[text()='Login']";
String OTP = "//input[@id='userPasswordPlaceholder']";
String submitOTP = "//button[text()='Login']";
String myClasses = "//span[text()='My Classes']";
String class1 = "//span[text()='SmartClass1']";



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
	public void launchBrowser() throws InterruptedException {
	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
     page = browser.newPage();
     page.navigate(url);
     page.fill(username, "divyashree.kumara@rhibhus.com");
     page.fill(password, "Divya@123");
     page.click(loginButton);
     Thread.sleep(4000);
     page.fill(OTP, "123456");
     page.click(submitOTP);
     Thread.sleep(2000);
     page.click(myClasses);
	}

	
	
	@Test(priority=1,  dataProvider = "Beam", dataProviderClass = Class4ExcelData.class)
	public void addcase(String composingsentences, String structuraldevices, String Developingparagraphs, String CreatingNarratives, String Purpose, String Punctuation, String Tenses, String Joinedupwritting, String PrefixesandSuffixes, String SpellingLists, 	String Timeandcause, String NounsandPronouns) throws InterruptedException, IOException
	{
			page.click("//span[text()='SmartClass4']");
            page.click("//td[@class='addButton']");
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
            String outcomeText1 = page.locator(outcomeTextLocator).textContent();
            System.out.println(outcomeText1);   
//            String expectedResult = expectedresult;
//            if(expectedResult.equals(outcomeText1))
//            {
//            	System.out.println(expectedResult + " "+ outcomeText1+ " "+ "is same");
//            }
//            else {
//            	System.out.println(expectedResult + " "+ outcomeText1+ " "+ "is not same");
//            }
//            
            String[] textData = { outcomeText1 };
            
            try (Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet("Outcome Data");
                for (int i = 0; i < textData.length; i++) {
                   Row row = sheet.createRow(0);
                  Cell cell = row.createCell(0);
                  cell.setCellValue(textData[i]);
                  }
               
                try (FileOutputStream outputStream = new FileOutputStream(File_Path)) {
                 workbook.write(outputStream);
 //                System.out.println("Text stored in Excel successfully.");
              } catch (IOException e) {
                 e.printStackTrace();
              }
            }
          catch (IOException e) {
              e.printStackTrace();
          }
      
            Thread.sleep(2000);
            page.click(save);
            Thread.sleep(3000);
//    browser.close();        
	}
}
 

//
//if (pageTitle.equals(expectedTitle)) {
//    System.out.println("Page titles are equal.");
//    // Additional actions or logging for when they are equal
//} else {
//    System.out.println("Page titles are not equal.");
//    // Additional actions or logging for when they are not equal
//}

   
// Get the last used row index or start from 0 if the sheet is empty
//int lastRowIndex = sheet.getLastRowNum() >= 0 ? sheet.getLastRowNum() + 1 : 0;
//
//// Loop through each outcome locator
//for (String locator : textData) {
//
//// Retrieve text content for each outcome locator
//  String outcomeText = page.locator(outcomeTextLocator).textContent();
//
//    // Create a new row and cell for each outcome
//    Row row = sheet.createRow(lastRowIndex);
//    Cell cell = row.createCell(0);
////             cell.setCellValue(outcomeText);
//
//    // Move to the next row for the next outcome
//    lastRowIndex++;
//}
//             cell.setCellValue(outcomeText1);



            
          
