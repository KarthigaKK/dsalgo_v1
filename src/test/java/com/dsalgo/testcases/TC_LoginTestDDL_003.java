package com.dsalgo.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dsalgo.pageobjects.GetStartedPage;
import com.dsalgo.pageobjects.LoginPage;
import com.dsalgo.utilities.AllureListener;
import com.dsalgo.utilities.ReadConfig;
import com.dsalgo.utilities.XLUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({ AllureListener.class })
public class TC_LoginTestDDL_003 extends BaseClass{
	
	 // Define a static logger variable so that it references the
    // Logger instance named "MyApp".
    private static final Logger logger = LogManager.getLogger(TC_LoginTestDDL_003.class.getName());
 
	
	@Test(dataProvider = "LoginCredentials", description = "login into app test")
	@Description("login into app test")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Story Name: To check login functionality")

	public void loginDDL(String user, String pwd) throws InterruptedException, IOException {
		logger.info( "**************Login Test case started************************* ");
		logger.info( "*************************************************************** ");
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(2000);
		lp.VerifySignUpLink();
		logger.info("Signin link verified");
		lp.clickSignin();
		logger.info("Signin");
		Thread.sleep(2000);
		lp.setLoginUser(user);
		logger.info("Entered username");
		lp.setLoginPwd(pwd);
		logger.info("Entered Password");
		lp.clickSigninBtn();
		logger.info("Clicked sign in button");
		Thread.sleep(2000);
		
		if(lp.registerMessage().startsWith("You are logged in"))
		{
			Assert.assertTrue(true);
			logger.info("Logged in successfully");
		}
		else if(lp.registerMessage().startsWith("Invalid Username and Password"))
		{
			captureScreen(driver, "loginDDL");
			logger.info("Invalid login");
			Assert.assertTrue(false);
		}
		
		logger.info( "*************************************************************** ");
		logger.info( "**************Login Test case ended************************* ");
	}

	@DataProvider(name = "LoginCredentials")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/dsalgo/testdata/LoginCredentials.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int cellcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindetails[][] = new String[rownum][cellcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < cellcount; j++) {
				logindetails[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1 0
			}
		}
		return logindetails;
	}
}
