package com.infy.actions;

import com.infy.pages.AddressDetails;

import io.appium.java_client.AppiumDriver;

public class ActionControllerAddress {
	
	public AppiumDriver driver;
	/**
	 * @param driver
	 */
	public ActionControllerAddress(AppiumDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * @author karamvir_garga
	 * @desc method to enter address details
	 */
	public void enterAddress(){
		
		AddressDetails _AddressDetails = new AddressDetails(driver);
		_AddressDetails.setAddressLine1();
		_AddressDetails.setAddressLine2();
		_AddressDetails.setCity();
		_AddressDetails.setState();
		_AddressDetails.setPinCode();
		_AddressDetails.setMobileNumber();
		_AddressDetails.clickSubmit();
	}

}
