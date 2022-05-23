package com.dsalgo.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dsalgo.pageobjects.GetStartedPage;
import com.dsalgo.pageobjects.HomePage;
import com.dsalgo.pageobjects.LinkedListPage;
import com.dsalgo.pageobjects.LoginPage;
import com.dsalgo.pageobjects.RegisterPage;
import com.dsalgo.utilities.AllureListener;
import com.dsalgo.utilities.ReadConfig;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Listeners({AllureListener.class})
public class TC_LinkedList_003 extends BaseClass {
	
	 // Define a static logger variable so that it references the
    // Logger instance named "TC_RegisterTest_001".
    private static final Logger logger = LogManager.getLogger(TC_LinkedList_003.class.getName());
    
	LinkedListPage link;
	public HomePage rp;
	public LoginPage lp;
	JavascriptExecutor js1;
	public String js_call = "window.editor.setValue('print  \"deletion\";')"; 
	
	@BeforeMethod //This method will excute before every test method
	public void setUp() {
		ReadConfig config=new ReadConfig();
		link=new LinkedListPage(driver);
		rp=new HomePage(driver);
		lp=new LoginPage(driver);
		js1 = (JavascriptExecutor)driver;
		
	}
	
	
	
	@Test(priority=1,description="Introduction")
	@Description("Introduction")
	@Severity(SeverityLevel.MINOR)
	public void linkedListTest() throws InterruptedException, IOException {
		
		signIn();
		rp.clickdropdownlink();
		logger.info("Clicked dropdown link");
		Thread.sleep(1000);
		rp.clickLinkedlist();
		logger.info("Selected LinkedList from menu");
		Thread.sleep(1000);
		link.clickLinkIntro();
		logger.info("Selected Introduction link");
		Thread.sleep(1000);
		link.btnTryHere();
		logger.info("Clicked TryHere button");
		Thread.sleep(1000);
		js1.executeScript(js_call); 
		Thread.sleep(1000);
		logger.info("Code entered in code editor");
		link.btnRun();
		logger.info("Rn Button clicked");
		Thread.sleep(1000);
		logger.info( "*************************************************************** ");
		logger.info( "**************LinkedList Test case ended************************* ");
}
	
	@Test(priority=2,description="Creating Linked List")
	@Description("Creating Linked List")
	@Severity(SeverityLevel.MINOR)
	public void createLinkedList() throws InterruptedException, IOException {
		logger.info( "**************CreateLinkedList Test case started************************* ");
		logger.info( "*************************************************************** ");
	
		driver.navigate().back();
		logger.info("Browser navigated to previous page");
		Thread.sleep(1000);
		js1.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		Thread.sleep(1000);
		logger.info("Page scrolled up");
		link.clickLinkCreate();
		Thread.sleep(1000);
		logger.info("Clicked Createlink");
		link.btnTryHere();
		logger.info("Clicked Try here button");
		Thread.sleep(1000);
		js1.executeScript(js_call); 
		Thread.sleep(1000);
		logger.info("Code entered in codeeditor");
		link.btnRun();
		logger.info("Run button clicked");
		Thread.sleep(1000);
		logger.info( "*************************************************************** ");
		logger.info( "**************CreateLinkedList Test case ended************************* ");
		
}
	
	@Test(priority=3,description="Types of Linked list")
	@Description("Types of Linked list")
	@Severity(SeverityLevel.MINOR)
	public void typeOfLinkedList() throws InterruptedException, IOException {
		logger.info( "**************TypeOfLinkedList Test case started************************* ");
		logger.info( "*************************************************************** ");
		
		driver.navigate().back();
		logger.info("Browser navigated to previous page");
		Thread.sleep(1000);
		link.clickTypesofLink();
		Thread.sleep(1000);
		logger.info("Clicked Typesof linkedlist");
		link.btnTryHere();
		Thread.sleep(1000);
		logger.info("Clicked Try here button"); 
		js1.executeScript(js_call); 
		Thread.sleep(1000);
		logger.info("Code entered in codeeditor");
		link.btnRun();
		Thread.sleep(1000);
		logger.info("Run button clicked");
		logger.info( "*************************************************************** ");
		logger.info( "**************TypeOfLinkedList Test case ended************************* ");
	}
	
	
	  @Test(priority=4,description="Implementing Linked List in Python")
	  @Description("Implementing Linked List in Python") 
	  @Severity(SeverityLevel.MINOR) 
	  public void implementLinkedList() throws
	  InterruptedException, IOException 
	  { 
		  logger.info( "**************ImplementLinkedList Test case started************************* ");
			logger.info( "*************************************************************** ");
		
		  driver.navigate().back();
	  Thread.sleep(1000); 
	  logger.info("Browser navigated to previous page");
	  link.clickImplementLink(); 
	  Thread.sleep(1000);
	  logger.info("Clicked implementLinkedList");
	  link.btnTryHere(); 
	  Thread.sleep(1000);
		logger.info("Clicked Try here button");
	  js1.executeScript(js_call);
	  Thread.sleep(1000);
	  logger.info("Code entered in codeeditor");
	  link.btnRun();
	  Thread.sleep(1000);
		logger.info("Run button clicked");
	  logger.info( "*************************************************************** ");
		logger.info( "**************ImplementLinkedList Test case ended************************* ");
	  }
	  
	  @Test(priority=5,description="Traversal") 
	  @Description("Traversal")
	  @Severity(SeverityLevel.MINOR) 
	  public void traversal() throws
	  InterruptedException, IOException 
	  { 
		  logger.info( "**************Traversal Test case started************************* ");
			logger.info( "*************************************************************** ");
		 
	  driver.navigate().back();
	  Thread.sleep(1000); 
	  logger.info("Browser navigated to previous page");
	  link.clickTraversal(); 
	  Thread.sleep(1000);
	  logger.info("Clicked traversal");
	  link.btnTryHere(); 
	  logger.info("Clicked Try here button");
	  Thread.sleep(1000); 
	  js1.executeScript(js_call);
	  Thread.sleep(1000); 
	  logger.info("Code entered in codeeditor");
	  link.btnRun(); 
	  logger.info("Run button clicked");
	  Thread.sleep(1000); 
	  logger.info( "*************************************************************** ");
		logger.info( "**************Traversal Test case ended************************* ");
	  }
	  
	  @Test(priority=6,description="Insertion") 
	  @Description("Insertion")
	  @Severity(SeverityLevel.MINOR) 
	  public void insertion() throws
	  InterruptedException, IOException 
	  { 
		  logger.info( "**************Insertion Test case started************************* ");
			logger.info( "*************************************************************** ");
		 
		  driver.navigate().back();
	  Thread.sleep(1000);
	  logger.info("Browser navigated to previous page");
	  link.clickInsertion();
	  logger.info("Clicked Insertion");
	  Thread.sleep(1000);
	  link.btnTryHere();
	  Thread.sleep(1000);
	  logger.info("Clicked Try here button"); 
	  js1.executeScript(js_call);
	  Thread.sleep(1000); 
	  logger.info("Code entered in codeeditor");
	  link.btnRun(); 
	  logger.info("Run button clicked");
	  Thread.sleep(1000);
	  logger.info( "*************************************************************** ");
		logger.info( "**************Insertion Test case ended************************* ");
	  }
	  
	  @Test(priority=7,description="Deletion")
	  
	  @Description("Deletion")
	  
	  @Severity(SeverityLevel.MINOR) 
	  public void deletion() throws
	  InterruptedException, IOException 
	  {
		 logger.info( "**************Deletion Test case started************************* ");
		logger.info( "*************************************************************** ");
		
	  driver.navigate().back();
	  Thread.sleep(1000);
	  logger.info("Browser navigated to previous page");
	  link.clickDeletion(); 
	  Thread.sleep(1000);
	  logger.info("Clicked deletion");
	  link.btnTryHere(); 
	  logger.info("Clicked Try here button");
	  Thread.sleep(1000); 
	  js1.executeScript(js_call);
	  Thread.sleep(1000);
	  logger.info("Code entered in codeeditor");
	  link.btnRun(); 
	  Thread.sleep(1000); 
	  logger.info("Run button clicked");
	  logger.info( "*************************************************************** ");
		logger.info( "**************Deletion Test case ended************************* ");
	  }
	 
}
