package com.dsalgo.testcases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.dsalgo.pageobjects.HomePage;
import com.dsalgo.pageobjects.LinkedListPage;
import com.dsalgo.pageobjects.LoginPage;
import com.dsalgo.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class BaseClass {
	
	private static final Logger logger = LogManager.getLogger(BaseClass.class.getName());
	ReadConfig config=new ReadConfig();
	public String baseurl=config.getApplicationURL();
	public String username=config.getUserName();
	public String password=config.getPassword();
	public  static WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser)
	{
		initialize_driver(browser);
		logger.info("******************"+browser+ "browser launched "+ "*******************************");
		logger.info( "*************************************************************** ");
		
		driver.get(baseurl);
		logger.info( "Application Launched");
		driver.manage().window().maximize();
		logger.info( "Screen Maximized");
		ReadConfig config=new ReadConfig();
	
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);  
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		logger.info("Screenshot taken target details:"+target);
	}
	
	public void signIn() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		logger.info( "**************Signin Test case started************************* ");
		logger.info( "*************************************************************** ");
		lp.clickSignin();
		logger.info("click Signin link");
		Thread.sleep(5000);
		lp.setLoginUser(username);
		logger.info("Entered username");
		lp.setLoginPwd(password);
		logger.info("Entered password");
		lp.clickSigninBtn();
		logger.info("Clicked signin button");
		Thread.sleep(5000);
	}

	public WebDriver initialize_driver(String br) {
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
		
		}
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();
		
		}
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		tdriver.set(driver);
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

}
