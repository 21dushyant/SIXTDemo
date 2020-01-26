package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FromAndToPage {

	
	private WebDriver driver;
	public FromAndToPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	  @FindBy(how = How.ID, using = "RoundTrip")
	  private WebElement roundButton;
	  
	  @FindBy(how = How.ID, using = "FromTag")
	  private WebElement from;
	  
	  @FindBy(how = How.ID, using = "ToTag")
	  private WebElement to;
	  
	  @FindBy(how = How.ID, using = "SearchBtn")
	  private WebElement searchButton;
	  

	  
	  @FindBy(how = How.ID, using = "DepartDate")
	  private WebElement departDate;
	  
	  @FindBy(how = How.ID, using = "ReturnDate")
	  private WebElement returnDate;
	  
	  
	  public void selectRoudtrip()
	  {
		  roundButton.click();
	  }
	  
	  public void enterDetailsToAndfrom(String from,String to)
	  {
		  this.from.sendKeys(from);
		  this.to.sendKeys(to);

	  }
	  
	
	  public void enterDates(String depart,String retnDate) 
	  {
		  departDate.clear();
		  departDate.sendKeys(depart);
		  returnDate.clear();
		  returnDate.sendKeys(retnDate);
		  returnDate.sendKeys(Keys.TAB);
		  from.sendKeys("");
		  
				  
	  }
	  
	  public SelectFlightpage search()
	  {
		  searchButton.click();
		  return new SelectFlightpage(driver);
	  }
	  

}
