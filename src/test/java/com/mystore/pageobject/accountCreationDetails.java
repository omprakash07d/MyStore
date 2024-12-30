package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountCreationDetails {

  

	//1. create object of webdriver
	WebDriver ldriver;

	//constructor
	public accountCreationDetails(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	//identify webelements
	@FindBy(id = "uniform-id_gender1")
	WebElement titleMrs;


	@FindBy (id ="customer_firstname")
	WebElement custfirstname;
	
	@FindBy (id ="customer_lastname")
	WebElement custlastname;
	
	@FindBy (id ="passwd")
	WebElement password;

	@FindBy(id = "days")
	WebElement dayDropdown;

	@FindBy(id = "months")
	WebElement monthDropdown;

	@FindBy(id = "years")
	WebElement yearDropdown;

    @FindBy(id = "submitAccount")
	 WebElement registerButton;
    
    
	
	//identify action to be performed on web elements
	
	public void selectTitleMrs()
	{
		titleMrs.click();
	}
	
	public void enterCustomerFirstName (String fname)
	{
		custfirstname.sendKeys(fname);
	}
	
	public void enterCustomerLastName (String lname)
	{
		custlastname.sendKeys(lname);
	}
	
	public void enterPassword (String pass)
	{
		password.sendKeys(pass);
	}
	
	
	public void enterdate (String sday, int smonth, String syear)
	{
		
		Select sl1=new Select (dayDropdown);
		Select sl2=new Select (monthDropdown);
		Select sl3=new Select (yearDropdown);
		sl1.selectByValue(sday);
		sl2.selectByIndex(smonth);
		sl3.selectByValue(syear);
	}
	
	
	public void clickOnRegister()
	{
		registerButton.click();
	}

	
	//class="alert alert-success"
	
	
   
	
	
}
