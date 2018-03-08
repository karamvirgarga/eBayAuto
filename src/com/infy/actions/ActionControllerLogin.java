package com.infy.actions;

import com.infy.pages.SignInPage;

import io.appium.java_client.AppiumDriver;

public class ActionControllerLogin {
	
	public AppiumDriver driver;
	
	/**
	 * @param driver
	 */
	public ActionControllerLogin(AppiumDriver driver)
	{
		this.driver = driver;
	}

	/**
	 * @param userName
	 * @param strPass
	 * @desc method to perform login
	 */
	public void performLogin(String userName, String strPass)
	{
		SignInPage _SignInPage = new SignInPage(driver);
		_SignInPage.clickSignINMain();
		_SignInPage.setAeEmail(userName);
		_SignInPage.setUserPwd(strPass);
		_SignInPage.clickSignIn();
	}
}
