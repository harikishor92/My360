package com.aap.qa.testcase;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aap.qa.Base.TestBase;
import com.aap.qa.Pages.LoginPage;
import com.aap.qa.Pages.WelcomePage;
import com.aap.qa.Util.TestUtil;

public class WelcomePageTest extends TestBase{
	
	String sheetName = "AAP_Title";
	WelcomePage wlcmPage;
	
	
	WelcomePageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		//loginPage = new LoginPage();	
		wlcmPage = new WelcomePage();
	}
	
	/*@DataProvider
	public Object[][] getAAPTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}*/
	
	
	@Test //(dataProvider = "getAAPTestData")
	public void WelcomePageTitleTest()
	{
		String title = wlcmPage.validateWelcomePageTitle();
		Assert.assertEquals(title, "My360");
	}
	
	@Test
	public void WelcomePageLogoTest()
	{
		boolean logo = wlcmPage.validateAAPImage();
		Assert.assertTrue(true);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
