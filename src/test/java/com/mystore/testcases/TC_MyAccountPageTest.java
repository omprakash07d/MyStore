package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccountPage;
import com.mystore.pageobject.registeredUserAccount;


public class TC_MyAccountPageTest extends BaseClass {


	@Test(enabled=false)
	public void verifyRegistrationAndLogin()
	{

		logger.info("***************TestCase Verify Registration and Login starts*****************"); 


		indexPage pg = new indexPage(driver);

		pg.clickOnSignIn();
		logger.info("Clicked on sign in link");

		myAccountPage myAcpg = new myAccountPage(driver);
		myAcpg.enterCreateEmailAddress("om12345gmail.com");
		logger.info("Email address entered in create account section.");

		myAcpg.clickSubmitCreate();

		logger.info("clicked on create an account button");

		accountCreationDetails accCreationPg = new accountCreationDetails(driver);

		accCreationPg.selectTitleMrs();
		accCreationPg.enterCustomerFirstName("Omprakash");
		accCreationPg.enterCustomerLastName("Diwathe");
		accCreationPg.enterPassword("12345");
		

		logger.info("entered user details on account creation page.");

		accCreationPg.clickOnRegister();
		logger.info("clicked on Register button");

		registeredUserAccount regUser = new registeredUserAccount(driver);
		String userName = regUser.getUserName();

		Assert.assertEquals("Omprakash Diwathe", userName);

		logger.info("***************TestCase Verify Registration and Login ends*****************"); 

	}

	@Test
	public void VerifyLogin() throws IOException 
	{

		logger.info("***************TestCase Verify Login starts*****************"); 

		indexPage pg = new indexPage(driver);

		pg.clickOnSignIn();
		logger.info("Clicked on sign in link");

		myAccountPage myAcpg = new myAccountPage(driver);

		myAcpg.enterEmailAddress("om12345@gmail.com");
		logger.info("Entered email address");

		myAcpg.enterPassword("12345");
		logger.info("Entered password");

		myAcpg.clickSignIn();
		logger.info("Clicked on sign in link..");


		registeredUserAccount regUser = new registeredUserAccount(driver);
		String userName = regUser.getUserName();


		if(userName.equals("Omprakash Diwathe"))
		{
			logger.info("VerifyLogin - Passed");
			regUser.clickOnSignOut();
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("VerifyLogin - Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);

		}

		logger.info("***************TestCase Verify Login ends*****************"); 


	}


	@Test
	public void VerifySignOut() throws IOException 
	{

		logger.info("***************TestCase Verify Sign out starts*****************"); 

		indexPage pg = new indexPage(driver);

		pg.clickOnSignIn();
		logger.info("Clicked on sign in link");

		myAccountPage myAcpg = new myAccountPage(driver);

		myAcpg.enterEmailAddress("om12345@gmail.com");
		logger.info("Entered email address");

		myAcpg.enterPassword("12345");
		logger.info("Entered password");

		myAcpg.clickSignIn();
		logger.info("Clicked on sign in link..");


		registeredUserAccount regUser = new registeredUserAccount(driver);
		regUser.clickOnSignOut();

		if(pg.getPageTitle().equals("Login - My Store"))
		{
			logger.info("VerifySignOut - Passed");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("VerifySignOut - Failed");
			captureScreenShot(driver,"VerifySignOut");
			Assert.assertTrue(false);
		}

	
		logger.info("***************TestCase Verify Sign out ends*****************"); 

	}


}
