package com.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderclass {
	@DataProvider(name="allDetails")
	public static Object[][] provideData()
	{
		return new Object[][] {{"21dushyant21@gmail.com","fname","lname","Mr","7022383593","15/01/2020","15/02/2020","delhi","bangalore"}};
	}
	
}
