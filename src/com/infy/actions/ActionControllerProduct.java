package com.infy.actions;

import com.infy.pages.ProductDetails;

import io.appium.java_client.AppiumDriver;

public class ActionControllerProduct {
	
	public AppiumDriver driver;
	/**
	 * @param driver
	 */
	public ActionControllerProduct(AppiumDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * @author karamvir_garga
	 * @desc method for adding item to cart and 
	 * navigating to review page
	 */
	public void buySelectedItem()
	{
		ProductDetails _ProductDetails = new ProductDetails(driver);
		_ProductDetails.clickBuy();
		_ProductDetails.clickReview();
	}

}
