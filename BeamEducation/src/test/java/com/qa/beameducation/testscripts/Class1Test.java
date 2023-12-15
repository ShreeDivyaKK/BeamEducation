package com.qa.beameducation.testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Class1Test extends Class1ExcelData{

	public Page page;
	
	String url = "https://testing.dj9yhpcsi54a3.amplifyapp.com/";
	String username = "//input[@id='userNamePlaceholder']";
	String password = "//input[@id='userPasswordPlaceholder']";
	String loginButton = "//button[text()='Login']";
	String OTP = "//input[@id='userPasswordPlaceholder']";
	String submitOTP = "//button[text()='Login']";
	
	String myClasses = "//span[text()='My Classes']";
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

	@Test(priority=1,  dataProvider = "Beam", dataProviderClass = Class1ExcelData.class)
	public void addcase(String letterinformation, String spellinglists, String Phonemes, String trickywords, String Punctuation, String creatingnarratives, String expectedresults) throws InterruptedException, IOException
	{     
          rownumber = Class1ExcelData.getRowNumber();
          System.out.println("Row no is"+ rownumber);
            
 //       for(int i=0; i<=rowCount+1;i++) {   
            page.click(class1);
            page.click(addWritingAssesment);
//            System.out.println("addWritingAssesment"+addWritingAssesment.length());
            
//            for(int i=0; i<=rowCount;i++) {   
//            	System.out.println("letterFormation"+ "1");
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
            String outcomeText1 = page.locator(outcomeTextLocator).textContent();
            System.out.println(outcomeText1);   
            
            assertEquals(outcomeText1, expectedresults,"Both are equal");           
            if(outcomeText1.equals(expectedresults))
            {
            	System.out.println(rownumber + " "+expectedresults+outcomeText1+ " " +"is same");
            }
            else {
            	System.out.println(rownumber + " "+ expectedresults+outcomeText1+"is not same");
            }
 //           rowCount++;
//        }
    //        browser.close();	
	}
	
}
