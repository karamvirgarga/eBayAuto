package com.infy.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.infy.utils.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ItemSearchDetails {
	
	public final AppiumDriver driver;
	
	/**
	 * @param driver
	 */
	public ItemSearchDetails(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/**
	 * @desc setting locators for search 
	 */
	
	@AndroidFindBy(id="com.ebay.mobile:id/search_box")
	public static AndroidElement aeSearchBox;
	
	@AndroidFindBy(id="com.ebay.mobile:id/search_src_text")
	public static AndroidElement aeSearchText;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='2']")
	public static AndroidElement aeSearchItem2;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='1']")
	public static AndroidElement aeSearchItem1;
	
	/**
	 * @desc methods for setting values in attributes
	 */
	public void clickSearchBox()
	{
		Utils.clickCustom(aeSearchBox, driver);
		
	}
	
	public void setSearchText()
	{
		aeSearchText.sendKeys(Utils.readFileData().getProperty("ItemDescription"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<AndroidElement> textViews = driver.findElementsByClassName("android.widget.TextView");
        for (WebElement textView : textViews) {
             String str = textView.getText();
             if(str.equalsIgnoreCase("65 inch led tv"))
             {
               	textView.click();
             }
        }
	}
	
	public void clickSearchedItem()
	{
		Utils.scrollListingScreen(aeSearchItem1, aeSearchItem2, driver);
		Utils.clickCustom(aeSearchItem2, driver);
	}
}
