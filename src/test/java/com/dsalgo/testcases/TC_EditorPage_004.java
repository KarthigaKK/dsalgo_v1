package com.dsalgo.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.hc.core5.util.Asserts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dsalgo.pageobjects.TryEditorPage;
import com.dsalgo.utilities.AllureListener;
import com.dsalgo.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({ AllureListener.class })
public class TC_EditorPage_004 {
	
	 // Define a static logger variable so that it references the
    // Logger instance named "MyApp".
	WebDriver driver;
    private static final Logger logger = LogManager.getLogger(TC_EditorPage_004.class.getName());
    ReadConfig config=new ReadConfig();
    TryEditorPage ty;
    String text;
    @BeforeMethod
    public void setup() throws InterruptedException
    {
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		logger.info( "**************Launched editor page************************* ");
		logger.info( "*************************************************************** ");
    	driver.get(config.geteditorpage());
    	driver.manage().window().maximize();
    	Thread.sleep(2000);
    	 text="welcome";
    	 ty=new TryEditorPage(driver);
    }
	
	@Test( priority=1,description = "Editorpage test")
	@Description("Editorpage test")
	@Severity(SeverityLevel.NORMAL)
	@Story("Story Name: Editorpage validation")

	public void runEditorCodeAndVerify() throws InterruptedException {
		logger.info( "Enter code inside codemirror");
	ty.setTextBoxValue("print(\""+text+"\")");
	Thread.sleep(1000);
	ty.runBtn();
	logger.info( "Click run button");
	Thread.sleep(1000);
	String op=ty.getOutput();
	Assert.assertTrue(op.contains(text));
	logger.atTrace();
	
	
	}
	
	@Test( priority=2,description = "Runcode and verify alert")
	@Description("Runcode and verify alert")
	@Severity(SeverityLevel.NORMAL)
	@Story("Story Name: Runcode and verify alert")

	public void runAndVerifyAlert() throws InterruptedException, IOException {
		logger.info( "Enter code inside codemirror");
		ty.setTextBoxValue(text);
		Thread.sleep(1000);
		ty.runBtn();
		Thread.sleep(1000);
		logger.info("Registration Failed");
		Assert.assertTrue(false);
		logger.info( "Clicked run button");
		String getcode=driver.switchTo().alert().getText();
		logger.info("Code entered wrong and triggered alert message :"+getcode);
		driver.switchTo().alert().accept();
		driver.close();
		logger.info( "**************editor page code verified************************* ");
		logger.info( "*************************************************************** ");
	}
	

	
	
}
