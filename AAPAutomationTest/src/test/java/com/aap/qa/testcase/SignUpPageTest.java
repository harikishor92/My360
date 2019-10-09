package com.aap.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aap.qa.Base.TestBase;
import com.aap.qa.Pages.SignUpPage;
import com.aap.qa.Pages.WelcomePage;
import com.aap.qa.Util.TestUtil;

public class SignUpPageTest extends TestBase {
	
	
	SignUpPage signup;
	WelcomePage wlcmPage;
	String sheetName = "Sheet_name";
	
	public SignUpPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		wlcmPage = new WelcomePage();
		wlcmPage.ClickOnSignUpButton();
		signup = new SignUpPage();	
	}
	
	@DataProvider
	public Object[][] getAAPTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		System.out.println(data);
		return data;
		
	}
	@Test
	public void SignUpPageTitleTest() {
		String title = signup.ValidateSignupPageTitle();
		Assert.assertEquals(title, "My360");
	}
	@Test
	public void SignUpPageHeaderTest()
	{
		boolean b = signup.ValidateSignUpPageHeading();
		Assert.assertTrue(b, "Matching");
	}
	
	@Test
	public void SignUpPageLOGOTest()
	{
		boolean b = signup.ValidateSignUpPageLOGO();
		Assert.assertTrue(b, "Matching");
	}

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
