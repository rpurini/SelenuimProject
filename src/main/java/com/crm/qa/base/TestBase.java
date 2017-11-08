package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

//Super class for page classes and test classes
public class TestBase {
    
	 public static Properties props;
	 public static InputStream inputStream;
	 public static WebDriver webDriver;
	 
	 static //creating loggin object
	 Logger logger=Logger.getLogger(TestBase.class);
	//constructor to read values from property file
	public TestBase() {
		//read property file values
		props=new Properties();
		try {
			inputStream=new FileInputStream("R:/Java_Purini/Selenium_Programs/POMTestProject/src/main/java/com/crm/qa/config/config.properties");
			props.load(inputStream);
			logger.info("Properties file is loaded..");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.fatal("FileNotFoundException due to properties file is not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	//initialize method to to initialize all values from properties object
	public static void initialization(){
		//get browser values
		String browserName=props.getProperty("browser");
		
		//Open firefox browser
		if(browserName.equals("firefox")){
			logger.info("Firefox browser is opening..");
			System.setProperty(props.getProperty("firefoxDriver"),props.getProperty("firefoxDriverPath"));
			webDriver=new FirefoxDriver();
		}//if
		
		//Open chrome browser
		else if(browserName.equals("chrome")){
			logger.info("chrome browser is opening..");
			System.setProperty("webdriver.chrome.driver","R:\\Java_Purini\\Selenium\\drivers\\chromedriver.exe");
			webDriver=new ChromeDriver();
		}//else
		
		if(webDriver!=null){
		//delete coockies
		webDriver.manage().deleteAllCookies();
		
		//set browser time out
		webDriver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		
		//set implicit wait
		webDriver.manage().timeouts().implicitlyWait(TestUtil.SET_IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//launch URL
		webDriver.get(props.getProperty("url"));
		logger.info("brower is navigated to entered url");
		
		//maximize window
		webDriver.manage().window().maximize();
		logger.info("brower maximised");
		}//if		
	}//initialization()
	
}//TestBase
