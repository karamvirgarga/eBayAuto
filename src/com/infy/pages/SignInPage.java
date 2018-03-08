package com.infy.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.infy.utils.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignInPage {
	
	public final AppiumDriver driver;
	
	/**
	 * @param driver
	 */
	public SignInPage(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/**
	 * @desc setting locators for login page
	 */
	
	@AndroidFindBy(id="com.ebay.mobile:id/button_sign_in")
	public static AndroidElement aeSignInMain;
	
	@AndroidFindBy(xpath="//*[@text='Email or username']")
	public static AndroidElement aeEmail;
	
	@AndroidFindBy(xpath="//*[@text='Password']")
	public static AndroidElement aePass;
	
	@FindBy(xpath="//*[@text='SIGN IN']")
	public static AndroidElement aeSignIN;

	/**
	 * @desc methods for setting values in attributes
	 */
	
	public void setAeEmail(String userName) {
		aeEmail.sendKeys(userName);
	}

	public void clickSignIn()
	{
		Utils.clickCustom(aeSignIN, driver);
		
	}
	
	public void setUserPwd(String strPass) 
	{
		aePass.sendKeys(strPass);
	}

	public void clickSignINMain()
	{
		Utils.clickCustom(aeSignInMain, driver);
		
	}

}
