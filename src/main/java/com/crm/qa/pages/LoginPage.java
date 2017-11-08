package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	//Page factory - Object Repository(OR)
	//declare Page factory objects
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="html/body/div[2]/div/div[1]/a/img")
	WebElement crmLogo;
	
	//initialize page factory
	public LoginPage(){
		PageFactory.initElements(webDriver, this);
		//PageFactory.initElements(webDriver, this);
	}
	
	//Actions
	//validate login page title
	public String validateTitle(){
		return webDriver.getTitle();
	}
	
    //verify fb logo
	public boolean verifyCRMLogo(){
		return crmLogo.isDisplayed();
	}
	
	//verify login activity
	public HomePage loginActivity(String e, String pwd){
		System.out.println("loginActivity()method");
		username.sendKeys(e);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}

}
