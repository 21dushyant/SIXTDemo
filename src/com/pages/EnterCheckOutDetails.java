package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterCheckOutDetails {

	WebDriver driver=null;
	public EnterCheckOutDetails(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.CSS, using = "input#itineraryBtn")
	  private WebElement continueBookingButton;
	  
	  @FindBy(how = How.CSS, using = "input#username")
	  private WebElement username;
	  
	  @FindBy(how = How.CSS, using = "input#LoginContinueBtn_1")
	  private WebElement checkLoginButton;
	  
	  @FindBy(how = How.CSS, using = "dd > input[name='AdultFname1']")
	  private WebElement adultFName;
	  
	  @FindBy(how = How.CSS, using = "dd > input[name='AdultLname1']")
	  private WebElement adultLName;
	  
	  @FindBy(how = How.CSS, using = ".last #mobileNumber")
	  private WebElement mobileNumber;

	  @FindBy(how = How.CSS, using = "select[name='AdultTitle1']")
	  private WebElement adultTitle;
	  
	  @FindBy(how = How.CSS, using = "input#travellerBtn")
	  private WebElement continueButton;
	  
	  @FindBy(how = How.CSS, using = "div#CCTab  .card_number > label")
	  private WebElement CCText;
	  
	  @FindBy(how = How.CSS, using = " select#AdultDobDay1")
	  private WebElement dobd;
	  @FindBy(how = How.CSS, using = "select#AdultDobMonth1")
	  private WebElement dobm;
	  @FindBy(how = How.CSS, using = "select#AdultDobYear1")
	  private WebElement doby;
	  @FindBy(how = How.CSS, using = ".arabicChars.forceKey.name.required.restictSplChars.span.span8.ui-autocomplete-input")
	  private WebElement citizen;
	 
	 
	  

	  public void clickContinueButton()
	  {
		  continueBookingButton.click();
	  }
	  
	  
	  public void enterUserDetails(String userName)
	  { 
		  WebDriverWait wait= new WebDriverWait(driver,45);
		  wait.until(ExpectedConditions.visibilityOfAllElements(username));
		  
		  username.sendKeys(userName);
		  checkLoginButton.click();
	  }
	  
	  public boolean enterAdultdetails(String fName,String lName,String mNumber,String title)
	  {
		  WebDriverWait wait= new WebDriverWait(driver,45);
		  wait.until(ExpectedConditions.elementToBeClickable(adultTitle));
		  adultTitle.click();
		  Select select = new Select(adultTitle);
		  Select select1 = new Select(dobd);
		  Select select2 = new Select(dobm);
		  Select select3 = new Select(doby);
			 
		  select.selectByValue(title);
		  select1.selectByValue("21");
		  select2.selectByValue("7");
		  select3.selectByValue("2008");
		  
		  citizen.sendKeys("India");
		  
		  adultFName.sendKeys(fName);
		  adultLName.sendKeys(lName);
		  mobileNumber.sendKeys(mNumber);
		  continueButton.click();
		  if(CCText.isDisplayed())
			  return true;
		  else
			  return false;
					 
	  }
	  
	
}
