package com.infy.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infy.utils.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PaymentDetails {

public final AppiumDriver driver;
	
	/**
	 * @param driver
	 */
	public PaymentDetails(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/**
	 * @desc setting locators for payment details
	 */
	
	@AndroidFindBy(xpath="//android.view.View[@text='SAMSUNG 65 INCHES 65MU6470 165 cm 4K ULTRA HD LED SMART TV 2017 EDITION']")
	public static AndroidElement aeProductNameSum;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Rs. 229,000.00']")
	public static AndroidElement aeProductPriceSum;
	
	@AndroidFindBy(id="proceedToPay")
	public static AndroidElement aeProceedToPay;
	
	@AndroidFindBy(xpath="//*[@text='Credit Card']")
	public static AndroidElement aePaymentMethod;
	
	@AndroidFindBy(xpath="//*[@text='American Express'and @instance='1']")
	public static AndroidElement aeCreditCardType;
	
	@AndroidFindBy(id="btnPay")
	public static AndroidElement aePayNow;
	
	@AndroidFindBy(id="cnumber")
	public static AndroidElement aeCardNumber;
	
	@AndroidFindBy(id="cname2")
	public static AndroidElement aeNameDisplayedOnCard;
	
	@AndroidFindBy(id="expmon")
	public static AndroidElement aeExpMonth;
	
	@AndroidFindBy(id="expyr")
	public static AndroidElement aeExpYear;
	
	@AndroidFindBy(id="cvv2")
	public static AndroidElement aeCVV;
	
	@AndroidFindBy(id="submitbtn")
	public static AndroidElement aeSubmitPayment;
	
	@AndroidFindBy(xpath="//android.widget.CheckedTextView[@index='7']")
	public static AndroidElement aeSelectIndex;
	
	@AndroidFindBy(xpath="//*[@text='Change address']")
	public static AndroidElement aeChangeAddress;
	
	/**
	 * @desc methods for setting values in attributes
	 */
	
	public void clickProceedToPay(){
		
		Utils.scroll(aeChangeAddress, aeProceedToPay, driver);
		Utils.clickCustom(aeProceedToPay, driver);
	}
	public void clickPaymentMethod(){
		
		Utils.clickCustom(aePaymentMethod, driver);
	}
	public void clickCreditCardType(){
	
	Utils.clickCustom(aeCreditCardType, driver);
}
	public void clickPayNow()
	{
		Utils.clickCustom(aePayNow, driver);
	}
	public void setCardNumber(){
	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(aeCardNumber));
		aeCardNumber.sendKeys(Utils.readFileData().getProperty("CardNumber"));
}

	public void setNameOnCard(){
	
	aeNameDisplayedOnCard.sendKeys(Utils.readFileData().getProperty("CardName"));
}

	public void setExpMon(){
	
	Utils.clickCustom(aeExpMonth, driver);
	Utils.clickCustom(aeSelectIndex, driver);
	
}

	public void setExpYear(){
	
	Utils.clickCustom(aeExpYear, driver);
	Utils.clickCustom(aeSelectIndex, driver);
	
}
	public void setBatchNumber(){
	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(aeCVV));
		aeCVV.sendKeys(Utils.readFileData().getProperty("BatchNumber"));
}

	public void clickSubmitPayment(){
	
		aeSubmitPayment.sendKeys("1234");
	
}
	public String getProdNameSumText() {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(aeProductNameSum));
		return aeProductNameSum.getText();
	}
	public String getProdPriceSumText() {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(aeProductPriceSum));
		return aeProductPriceSum.getText();
	}
	
	
	
}
