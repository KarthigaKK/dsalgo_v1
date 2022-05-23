package com.dsalgo.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsalgo.pageobjects.HomePage;
import com.dsalgo.pageobjects.LinkedListPage;
import com.dsalgo.pageobjects.LoginPage;
import com.dsalgo.pageobjects.StackPage;
import com.dsalgo.utilities.ReadConfig;
import com.dsalgo.utilities.WaitHelper;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TC_Stack_005 extends BaseClass{
	
	 // Define a static logger variable so that it references the
    // Logger instance named "TC_RegisterTest_001".
    private static final Logger logger = LogManager.getLogger(TC_Stack_005.class.getName());
    
	StackPage stk;
	WaitHelper waithelper;
	public HomePage rp;
	public LoginPage lp;
	JavascriptExecutor js1;
	public String js_call = "window.editor.setValue('print  \"deletion\";')"; 
	
	@BeforeMethod //This method will excute before every test method
	public void setUp() {
		ReadConfig config=new ReadConfig();
		stk=new StackPage(driver);
		rp=new HomePage(driver);
		lp=new LoginPage(driver);
		js1 = (JavascriptExecutor)driver;
		waithelper=new WaitHelper(driver);
		
	}
	
	@Test(priority=1,description="Operations")
	@Description("Operations")
	@Severity(SeverityLevel.MINOR)
	public void linkOperationsTest() throws InterruptedException, IOException {
		
		
		signIn();
		logger.info( "**************Stack Test case started************************* ");
		logger.info( "*************************************************************** ");
		rp.clickdropdownlink();
		logger.info("Clicked dropdown link");
		Thread.sleep(2000);
		rp.clickStack();
		logger.info("Selected stack from menu");
		Thread.sleep(2000);
		stk.clicklinkOperations();
		logger.info("click operations link");
		Thread.sleep(2000);
		stk.btnTryHere();
		logger.info("click try here");
		Thread.sleep(2000);
		js1.executeScript(js_call); 
		Thread.sleep(2000);
		logger.info("Code entered in code editor");
		stk.btnRun();
		logger.info("Run Button clicked");
		Thread.sleep(2000);
		logger.info( "*************************************************************** ");
		logger.info( "**************Operations Test case ended************************* ");
		
	}
	

	@Test(priority=2,description="Implementation")
	@Description("Implementation")
	@Severity(SeverityLevel.MINOR)
	public void implementationTest() throws InterruptedException, IOException {
		logger.info( "**************Implementation Test case started************************* ");
		logger.info( "*************************************************************** ");
		driver.navigate().back();
		logger.info("Browser navigated to previous page");
		Thread.sleep(2000);
		stk.clicklinkImplementation();
		logger.info("Implementation link clicked");
		Thread.sleep(2000);
		stk.btnTryHere();
		logger.info("Try Here button clicked");
		Thread.sleep(2000);
		js1.executeScript(js_call); 
		Thread.sleep(2000);
		logger.info("Code entered in code editor");
		stk.btnRun();
		logger.info("Run Button clicked");
		Thread.sleep(2000);
		logger.info( "*************************************************************** ");
		logger.info( "**************Implementation Test case ended************************* ");
	}
	
	@Test(priority=3,description="Applications")
	@Description("Applications")
	@Severity(SeverityLevel.MINOR)
	public void applicationsTest() throws InterruptedException, IOException {
		logger.info( "**************Applications Test case started************************* ");
		logger.info( "*************************************************************** ");
		driver.navigate().back();
		logger.info("Browser navigated to previous page");
		Thread.sleep(2000);
		stk.clicklinkApplications();
		logger.info("Applications link clicked");
		Thread.sleep(2000);
		stk.btnTryHere();
		logger.info("Try Here button clicked");
		Thread.sleep(2000);
		js1.executeScript(js_call); 
		Thread.sleep(2000);
		logger.info("Code entered in code editor");
		stk.btnRun();
		logger.info("Run Button clicked");
		Thread.sleep(2000);
		logger.info( "*************************************************************** ");
		logger.info( "**************Applications Test case ended************************* ");
	}
}
