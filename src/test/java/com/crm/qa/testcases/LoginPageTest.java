package com.crm.qa.testcases;
//autor:raj

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	
    Logger logger=Logger.getLogger(LoginPageTest.class);
    
	// constructor to call super class constructor
	public LoginPageTest() {
		super();
	}

	// set up environment
	@BeforeMethod
	public void setup() {
		logger.info("set up is creating");
		// initialize requred things - call super class initialization() method
		initialization();
        logger.fatal("This is fatal message");
        logger.debug("This is debug message");
        logger.warn("This is warn message");
		// create object for LoginPage
		loginPage = new LoginPage();
	}

	// TEST CASES
	// Login page title test
	@Test(priority=1)
	public void loginPageTitleTest() {
		logger.info("***************FIRST TEST CASE STARTS*************************");
		String title = "";
		title = loginPage.validateTitle();
		Assert.assertEquals(title, props.getProperty("loginPageTitle"));
		logger.info("***************FIRST TEST CASE ENDS*************************");
	}
   
	//test fb logo
	@Test(priority=2)
	public void fbLogoTest(){
		logger.info("***************SECOND TEST CASE  STARTS*************************");
		boolean flag=false;
		flag=loginPage.verifyCRMLogo();
		Assert.assertTrue(flag);
		logger.info("***************SECOND TEST CASE ENDS*************************");
	}
	
	//test login activity
	@Test(priority=3)
	public void loginActivityTest(){
		logger.info("***************THIRD TEST CASE  STARTS*************************");
		System.out.println("loginActivityTest()method");
		homePage=loginPage.loginActivity(props.getProperty("username"), props.getProperty("password"));
		logger.info("***************FIRST TEST CASE ENDS************************");
	}
	@AfterMethod
	public void tearDown(){
		
		webDriver.quit();
		logger.info("***************BROWSER ID SHUT DOWN*************************");
	}
}//LoginPageTest;
