package com.aap.qa.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aap.qa.Base.TestBase;

public class LoginPage extends TestBase{
	
	
	//Page Factory - OR:
		@FindBy(xpath = "//input[@name='email']")
		WebElement emailid;
		
		@FindBy(xpath="//input[@name = 'password']")
		WebElement pwds;
		
		@FindBy(xpath="//button[. = 'Sign in']")
		WebElement loginBtn;
		
		@FindBy(xpath="//a[text()=' Signup ']")
		WebElement signUpBtn;
		
		@FindBy(xpath="//img[@src = '/static/media/aroha.2671980f.png']")
		WebElement AAPLogo;
		@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
		WebElement verifyLogin;
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
	
		
		public boolean validateAAPImage(){
			return AAPLogo.isDisplayed();
		}
		
		public String validateAAPLoginStatus(){
			return verifyLogin.getText();
		}
		
		
		public HomePage login(String uname, String password) throws InterruptedException{
			Thread.sleep(2000);		
			emailid.sendKeys(uname);
			Thread.sleep(1000);
			pwds.sendKeys(password);
			Thread.sleep(1000);
			loginBtn.click();
			    	
			return new HomePage();
		}

}
