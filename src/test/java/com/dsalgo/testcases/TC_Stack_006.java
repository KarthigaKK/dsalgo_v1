package com.dsalgo.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsalgo.pageobjects.HomePage;
import com.dsalgo.pageobjects.LoginPage;
import com.dsalgo.pageobjects.StackPage;
import com.dsalgo.utilities.ReadConfig;
import com.dsalgo.utilities.WaitHelper;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import java.util.List;


import org.openqa.selenium.WebElement;

public class TC_Stack_006 extends BaseClass{
	
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
	public void linkStackTest() throws InterruptedException, IOException {
		
		
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
		Thread.sleep(2000);
		List<WebElement> stackLinks=stk.getListLinks();
		
		menuLinkOperations(stackLinks);	
		
		
		logger.info( "*************************************************************** ");
		logger.info( "**************Operations Test case ended************************* ");
		
	}
	
	private void menuLinkOperations(List<WebElement> stackLinks) throws InterruptedException
	{
		for (int i=0;i<stackLinks.size();i++)
		{
			String linkname=stackLinks.get(i).getText();
			Thread.sleep(3000);
			System.out.println(linkname);
			stackLinks.get(i).click();
			logger.info("click "+linkname+" link");
			Thread.sleep(3000);
			stk.btnTryHere();
			logger.info("click try here");
			Thread.sleep(2000);
			js1.executeScript(js_call); 
			Thread.sleep(2000);
			logger.info("Code entered in code editor");
			stk.btnRun();
			logger.info("Run Button clicked");
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
		}
	}
	

}
