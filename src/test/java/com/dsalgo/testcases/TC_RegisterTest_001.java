package com.dsalgo.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dsalgo.pageobjects.GetStartedPage;
import com.dsalgo.pageobjects.LoginPage;
import com.dsalgo.pageobjects.RegisterPage;
import com.dsalgo.utilities.AllureListener;
import com.dsalgo.utilities.ReadConfig;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({AllureListener.class})
public class TC_RegisterTest_001 extends BaseClass {
	 // Define a static logger variable so that it references the
    // Logger instance named "TC_RegisterTest_001".
    private static final Logger logger = LogManager.getLogger(TC_RegisterTest_001.class.getName());
	ReadConfig config=new ReadConfig();
	public String registerPageTitle=config.getRegisterPageTitle();
	
	@Test(description="Register User for getting dsalgo app access")
	@Description("Register User for getting dsalgo app access")
	@Severity(SeverityLevel.BLOCKER)
	public void registerTest1() throws InterruptedException, IOException 
	{
		
		RegisterPage rp=new RegisterPage(driver);
		logger.info( "**************Registration Test case started************************* ");
		logger.info( "*************************************************************** ");
		Thread.sleep(1000);
		rp.clickRegisterLink();
		logger.info("Click Register Link");
		Thread.sleep(1000);
		rp.setUserName(randomestring());
		logger.info("Entered username");
		Thread.sleep(1000);
		rp.setPassword(password);
		logger.info("Entered password");
		rp.setConfirmPassword(password);
		logger.info("Entered confirm password");
		rp.clickRegisterBtn();
		logger.info("Clicked Register button");
		System.out.println(driver.getTitle());
		
		if(rp.registerMessage().startsWith("New Account"))
		{
			logger.info("Registration completed successfully");
			Assert.assertTrue(true);
		}
		
		else if(rp.registerMessage().startsWith("password_mismatch:"))
		{
			captureScreen(driver, "registerTest1"); 
			logger.info("Registration Failed");
			Assert.assertTrue(false);
		
		}
		rp.clickSignOutBtn();
		logger.info( "*************************************************************** ");
		logger.info( "**************Registration Test case ended************************* ");
		
	}
	

	@Test(description="Register User for getting dsalgo app access")
	@Description("Register User for getting dsalgo app access")
	@Severity(SeverityLevel.BLOCKER)
	public void registerTest2() throws InterruptedException, IOException 
	{
		logger.info( "**************Registration Test case started************************* ");
		logger.info( "*************************************************************** ");
		RegisterPage rp=new RegisterPage(driver);
		ReadConfig config=new ReadConfig();
		Thread.sleep(1000);
		rp.clickRegisterLink();
		logger.info("Click Register Link");
		Thread.sleep(2000);
		rp.setUserName(randomestring());
		logger.info("Entered Username");
		Thread.sleep(1000);
		rp.setPassword(randomeNum());
		logger.info("Entered password");
		Thread.sleep(1000);
		rp.setConfirmPassword(randomeNum());
		logger.info("Entered password doesnot match");
		Thread.sleep(1000);
		rp.clickRegisterBtn();	
		System.out.println(driver.getTitle());
		
		
		if(rp.registerMessage().startsWith("New Account"))
		{
			logger.info("Registration completed successfully");
			Assert.assertTrue(true);
		}
		
		else if(rp.registerMessage().startsWith("password_mismatch:"))
		{
			captureScreen(driver, "registerTest2"); 
			logger.info("Registration Failed");
			Assert.assertTrue(false);
		
		}
		rp.clickSignOutBtn();
		logger.info( "*************************************************************** ");
		logger.info( "**************Registration Test case ended************************* ");
		
	}
	
	@Test(description="Register User with special character as username in dsalgo app")
	@Description("Register User with special character as username  in dsalgo app")
	@Severity(SeverityLevel.BLOCKER)
	public void registerTest3() throws InterruptedException, IOException 
	{
		logger.info( "**************Registration Test case started************************* ");
		logger.info( "*************************************************************** ");
		RegisterPage rp=new RegisterPage(driver);
		ReadConfig config=new ReadConfig();
		Thread.sleep(1000);
		rp.clickRegisterLink();
		logger.info("Click Register Link");
		Thread.sleep(1000);
		rp.setUserName("@@@@@@@@@@@@@@");
		logger.info("Entered Username");
		Thread.sleep(1000);
		rp.setPassword("Wolf123@");
		logger.info("Password field Entered");
		Thread.sleep(1000);
		rp.setConfirmPassword("Wolf123@");
		logger.info("Confirm password Entered");
		Thread.sleep(1000);
		rp.clickRegisterBtn();	
		captureScreen(driver, "registerTest3"); 
		logger.info("Registration Passed");
		Assert.assertTrue(true);
		rp.clickSignOutBtn();
		logger.info( "*************************************************************** ");
		logger.info( "**************Registration Test case ended************************* ");
	}
	

	@Test(description="Register User with password field empty in dsalgo app")
	@Description("Register User with password field empty in dsalgo app")
	@Severity(SeverityLevel.BLOCKER)
	public void registerTest4() throws InterruptedException, IOException 
	{
		logger.info( "**************Registration Test case started************************* ");
		logger.info( "*************************************************************** ");
		RegisterPage rp=new RegisterPage(driver);
		ReadConfig config=new ReadConfig();
		Thread.sleep(1000);
		rp.clickRegisterLink();
		logger.info("Click Register Link");
		Thread.sleep(1000);
		rp.setUserName(username);
		logger.info("Entered Username");
		Thread.sleep(1000);
		rp.setPassword("");
		logger.info("Password field Not Entered");
		Thread.sleep(1000);
		rp.setConfirmPassword("");
		logger.info("Confirm password Not Entered");
	
		rp.clickRegisterBtn();	
		
		captureScreen(driver, "registerTest4"); 
		
		logger.info("Registration Incomplete password fields need to fill out");
		Assert.assertTrue(true);
		rp.clickSignOutBtn();
		driver.close();
		logger.info( "*************************************************************** ");
		logger.info( "**************Registration Test case ended************************* ");
	}

}
