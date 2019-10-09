package com.aap.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aap.qa.Base.TestBase;

public class WelcomePage extends TestBase {
	
	@FindBy(xpath="//a[@id='login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()=' Signup ']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//a[@class='navbar-brand home-logo']//img")
	WebElement aapLogo;
	
	public WelcomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
			public String validateWelcomePageTitle(){
				return driver.getTitle();
			}
			
			public boolean validateAAPImage(){
				return aapLogo.isDisplayed();
			}
			public LoginPage ClickOnLoginButton()  
			{
				//Thread.sleep(2000);
				loginBtn.click();
				//Thread.sleep(2000);
				return new LoginPage();
			}
			
			public SignUpPage ClickOnSignUpButton()  
			{
				//Thread.sleep(2000);
				signUpBtn.click();
				//Thread.sleep(2000);
				return new SignUpPage();
			}

}
