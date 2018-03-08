package com.infy.actions;

import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.infy.pages.PaymentDetails;
import com.infy.pages.ProductDetails;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ActionControllerPayment {

	AppiumDriver driver;
	/**
	 * @param driver
	 */
	public ActionControllerPayment(AppiumDriver driver) {
		this.driver = driver;
	}

	/**
	 * @author karamvir_garga
	 * @desc method for proceeding to payment,
	 * selecting payment type
	 * entering payment details and completing payment
	 */
	public void enterPayment() {
		// TODO Auto-generated method stub
		
		PaymentDetails _PaymentDetails= new PaymentDetails(driver);
		_PaymentDetails.clickProceedToPay();
		_PaymentDetails.clickPaymentMethod();
		_PaymentDetails.clickCreditCardType();
		_PaymentDetails.clickPayNow();
		_PaymentDetails.setCardNumber();
		_PaymentDetails.setNameOnCard();
		_PaymentDetails.setExpMon();
		_PaymentDetails.setExpYear();
		_PaymentDetails.setBatchNumber();
		_PaymentDetails.clickSubmitPayment();
			
	}

	public boolean performAssertion() {
		// TODO Auto-generated method stub
		
		PaymentDetails _PaymentDetails= new PaymentDetails(driver);
		
		String strProdName = ProductDetails.strProdName;
		String strProdPrice = ProductDetails.strProdPrice;
		String strProdNameSum = _PaymentDetails.getProdNameSumText();
		String strProdPriceSum = _PaymentDetails.getProdPriceSumText();
		
		boolean actual = true;
		if(strProdName.equalsIgnoreCase(strProdNameSum) && strProdPrice.equalsIgnoreCase(strProdPriceSum))
			actual = true;
		else
			actual = false;
		return actual;
	}

}
