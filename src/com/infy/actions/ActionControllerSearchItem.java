package com.infy.actions;

import com.infy.pages.ItemSearchDetails;

import io.appium.java_client.AppiumDriver;

public class ActionControllerSearchItem {

	public AppiumDriver driver;
	/**
	 * @param driver
	 */
	public ActionControllerSearchItem(AppiumDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * @author karamvir_garga
	 * @desc method for searching an item and 
	 * selecting an item from search results
	 */
	public void searchItem() {
		// TODO Auto-generated method stub
		ItemSearchDetails _ItemSearchDetails = new ItemSearchDetails(driver);
		_ItemSearchDetails.clickSearchBox();
		_ItemSearchDetails.setSearchText();
		_ItemSearchDetails.clickSearchedItem();
	}

}
