package com.qa.beameducation.testscripts;

import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest {
	
	public static Page page;
	static String url = "https://testing.dj9yhpcsi54a3.amplifyapp.com/";
	static String username = "//input[@id='userNamePlaceholder']";
	static String password = "//input[@id='userPasswordPlaceholder']";
	static String loginButton = "//button[text()='Login']";
	static String OTP = "//input[@id='userPasswordPlaceholder']";
	static String submitOTP = "//button[text()='Login']";
	static String myClasses = "//span[text()='My Classes']";
	
	public static Page launchBrowser() throws InterruptedException {
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
     return page;
	}	
}
