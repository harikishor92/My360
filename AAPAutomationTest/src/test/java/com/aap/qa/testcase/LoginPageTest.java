package com.aap.qa.testcase;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aap.qa.Base.TestBase;
import com.aap.qa.Pages.HomePage;
import com.aap.qa.Pages.LoginPage;
import com.aap.qa.Pages.WelcomePage;
import com.aap.qa.Util.TestUtil;

public class LoginPageTest extends TestBase{
	
	
	LoginPage loginPage;
	HomePage homePage;
	WelcomePage wlcmPage;
	String sheetName = "Login";
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		wlcmPage = new WelcomePage();
		wlcmPage.ClickOnLoginButton();
		loginPage = new LoginPage();	
	}

	
	@Test
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "My360");
	}
	
	@Test
	public void aapLogoImageTest(){
		boolean flag = loginPage.validateAAPImage();
		Assert.assertTrue(flag);
	}
	
	@DataProvider
	public Object[][] getAAPTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		System.out.println(data);
		return data;
		
	}
	
	@Test(dataProvider = "getAAPTestData")
	public void loginTest(String uname, String pwds) throws InterruptedException{
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(uname, pwds);
		Thread.sleep(1000);
		String text = loginPage.validateAAPLoginStatus();
		
		if(text.equals("Login Success"))
		{
		Assert.assertEquals(text, "Login Success");
		Reporter.log("User name and Password are correct", true);
		}
		else
		{
			Assert.assertEquals(text, "Login Error");
			Reporter.log("Either User name or  Password or both are wrong", true);
		}
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
