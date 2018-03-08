package com.infy.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infy.utils.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductDetails {
	
public final AppiumDriver driver;
	
	/**
	 * @param driver
	 */
	public ProductDetails(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	/**
	 * @desc setting locators for adding item to cart
	 */
	
	@AndroidFindBy(id="com.ebay.mobile:id/textview_item_name")
	public static AndroidElement aeProductName;
	
	@AndroidFindBy(id="com.ebay.mobile:id/textview_item_price")
	public static AndroidElement aeProductPrice;
	
	@AndroidFindBy(id="com.ebay.mobile:id/button_bin")
	public static AndroidElement aeBuyButton;
	
	@AndroidFindBy(id="com.ebay.mobile:id/take_action")
	public static AndroidElement aeReviewButton;
	
	public static String strProdName;
	public static String strProdPrice;
	
	/**
	 * @desc methods for setting values in attributes
	 */
	
	public void clickBuy()
	{
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		strProdName = getProdNameText();
		strProdPrice = getProdPriceText();
		Utils.clickCustom(aeBuyButton, driver);
	}
	
	public void clickReview()
	{
		Utils.clickCustom(aeReviewButton, driver);
	}

	public String getProdNameText() {
		
		return aeProductName.getText();
	}

	public String getProdPriceText() {
		return aeProductPrice.getText();
	}
}
