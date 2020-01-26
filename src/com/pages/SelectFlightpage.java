package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectFlightpage {
	
	WebDriver driver=null;
	public SelectFlightpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(how = How.XPATH, using = "//*[@id=\"flightForm\"]/section[2]/div[2]/table/td[2]")
	  private WebElement option;
	  
	  @FindBy(how = How.CSS, using = ".allDone.resultContainer > .container.viewContainer form#flightForm .booking.fRight")
	  private WebElement bookButton;
	  
	
	  
	  public EnterCheckOutDetails bookFlight()
	  {
		  WebDriverWait wait= new WebDriverWait(driver,45);
		  wait.until(ExpectedConditions.elementToBeClickable(bookButton));
		 
		  bookButton.click();
		  return new EnterCheckOutDetails(driver);
	  }
	  
}
