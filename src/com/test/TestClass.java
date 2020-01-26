package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.EnterCheckOutDetails;
import com.pages.FromAndToPage;
import com.pages.SelectFlightpage;


public class TestClass {

	
	private String url ="https://www.cleartrip.com";
	private WebDriver driver=null; 
	
	
	@BeforeMethod
	public void initialise()
	{
		System.setProperty("webdriver.chrome.driver","C:\\SeleniumHub\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test( dataProvider ="allDetails" , dataProviderClass = com.dataprovider.DataProviderclass.class)
	public void tesBookingFunctionality(String username,String adultFname,String adultLname,String title,String mNumber,String datefirst,String dateSecond, String from,String to)
	{
		
		FromAndToPage firstpage= new FromAndToPage(driver);
		firstpage.selectRoudtrip();
		firstpage.enterDetailsToAndfrom(from, to);
		firstpage.enterDates(datefirst, dateSecond);
		SelectFlightpage secondpage=firstpage.search();
		EnterCheckOutDetails thirdpage=secondpage.bookFlight();
		thirdpage.clickContinueButton();
		thirdpage.enterUserDetails(username);
		boolean sol=thirdpage.enterAdultdetails(adultFname, adultLname, mNumber, title);
		Assert.assertEquals(sol, true);
	}
	
	
	
}
