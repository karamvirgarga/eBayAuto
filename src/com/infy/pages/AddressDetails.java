package com.infy.pages;

import org.openqa.selenium.support.PageFactory;

import com.infy.utils.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddressDetails {
public final AppiumDriver driver;
	
	/**
	 * @param driver
	 */
	public AddressDetails(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/**
	 * @desc setting locators for address details
	 */
	
	@AndroidFindBy(id="address1")
	public static AndroidElement aeAddressLine1;
	
	@AndroidFindBy(id="address2")
	public static AndroidElement aeAddressLine2;
	
	@AndroidFindBy(id="city")
	public static AndroidElement aeCity;
	
	@AndroidFindBy(id="state")
	public static AndroidElement aeState;
	
	@AndroidFindBy(id="zip")
	public static AndroidElement aePinCode;
	
	@AndroidFindBy(xpath="//*[@text='Mobile number']")
	public static AndroidElement aeMobileNumber;
	
	@AndroidFindBy(xpath="//android.widget.CheckedTextView[@index='7']")
	public static AndroidElement aeSelectedState;
	
	@AndroidFindBy(id="sbtBtn")
	public static AndroidElement aeSubmitAddress;
	
	/**
	 * @desc methods to set value in all attributes
	 */
	public void setAddressLine1(){
		
		aeAddressLine1.sendKeys(Utils.readFileData().getProperty("AddressLine1"));
	}
    public void setAddressLine2(){
		
		aeAddressLine2.sendKeys(Utils.readFileData().getProperty("AddressLine2"));
	}
    public void setCity(){
		
		aeCity.sendKeys(Utils.readFileData().getProperty("City"));
	}
    public void setPinCode(){
		
		aePinCode.sendKeys(Utils.readFileData().getProperty("PinCode"));
	}
    public void setState(){
		
		aeState.click();
		aeSelectedState.click();
	}
    public void setMobileNumber(){
		
		aeCity.sendKeys(Utils.readFileData().getProperty("MobileNumber"));
	}
	public void clickSubmit()
	{
		aeSubmitAddress.click();
	}
}
