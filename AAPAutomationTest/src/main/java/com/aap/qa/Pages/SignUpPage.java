package com.aap.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aap.qa.Base.TestBase;

public class SignUpPage extends TestBase{
	@FindBy(xpath = "//input[@name='fname']")
	WebElement fname;
	
	@FindBy(xpath = "//input[@name='lname']")
	WebElement lname;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement pwd;
	
	@FindBy(xpath = "//label[contains(text(),'Confirm Password')]")
	WebElement conformPwd;
	
	@FindBy(xpath = "//input[@id='materialUnchecked']")
	WebElement checkBox;
	
	@FindBy(xpath = "//button[@class='btn purple-gradient btn-rounded btn-block my-2 waves-effect']")
	WebElement signupBtn;
	
	@FindBy(xpath = "//a[@class='ml-2']")
	WebElement SignUpLoginBtn;
	
	@FindBy(xpath = "//div[@class='brand_signup']")
	WebElement SignupLOGO;
	
	@FindBy(xpath = "//div[@class='register_heading']")
	WebElement SignupHeading;
	
	public SignUpPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String ValidateSignupPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean ValidateSignUpPageHeading()
	{
		return SignupHeading.isDisplayed();
	}
	
	public boolean ValidateSignUpPageLOGO()
	{
		return SignupLOGO.isDisplayed();
	}

}
