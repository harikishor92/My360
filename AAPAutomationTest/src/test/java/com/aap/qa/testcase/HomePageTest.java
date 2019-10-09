package com.aap.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aap.qa.Base.TestBase;

import com.aap.qa.Pages.HomePage;
import com.aap.qa.Pages.LoginPage;
import com.aap.qa.Pages.WelcomePage;
import com.aap.qa.Util.TestUtil;

public class HomePageTest extends TestBase{
	
	
	LoginPage loginPage;
	HomePage homePage;
	WelcomePage wlcmPage;
	

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		wlcmPage = new WelcomePage();
		wlcmPage.ClickOnLoginButton();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "My360");
	}
	
	/*@Test(priority=2)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}*/
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
