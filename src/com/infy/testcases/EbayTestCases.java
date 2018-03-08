package com.infy.testcases;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.infy.actions.ActionControllerAddress;
import com.infy.actions.ActionControllerLogin;
import com.infy.actions.ActionControllerPayment;
import com.infy.actions.ActionControllerProduct;
import com.infy.actions.ActionControllerSearchItem;
import com.infy.utils.ExtentReportsClass;
import com.infy.utils.ReadDataFromExcel;
import com.infy.utils.Utils;

import io.appium.java_client.AppiumDriver;


public class EbayTestCases  extends ExtentReportsClass{

	public static AppiumDriver driver;
	
	/**
	 * @author karamvir_garga
	 * @desc method for setting desired capabilities,
	 * instantiate the driver
	 * @throws MalformedURLException
	 */
	@BeforeTest
	public void mainSetUp() throws MalformedURLException
	{
		this.driver = Utils.setUp();
	}
	
	
	/**
	 * @author karamvir_Garga
	 * @Desc Test Case for Login into the application
	 */
	@Test(dataProvider = "readDatafromUtils", priority=0)
	public void validateLogin(String userName, String strPass)
	{
		logger = extent.createTest("validateLogin");
		logger.log(Status.INFO, "Login started");
		ActionControllerLogin _ActionControllerLogin = new ActionControllerLogin(driver);
		_ActionControllerLogin.performLogin(userName, strPass);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		logger.log(Status.INFO, "Login End");
	}
	
	/**
	 * @author karamvir_Garga
	 * @Desc Test Case for Searching an item
	 */
	@Test(priority=1)
	public void validateSearchItem()
	{
		logger = extent.createTest("validateSearchItem");
		logger.log(Status.INFO, "Search for an item");
		ActionControllerSearchItem _ActionControllerSearchItem = new ActionControllerSearchItem(driver);
		_ActionControllerSearchItem.searchItem();
	}
	
	
	/**
	 * @author karamvir_Garga
	 * @Desc Test Case for validating correct item is added in cart
	 */
	@Test(priority=2)
	public void validateItemBought()
	{
		logger = extent.createTest("validateItemBought");
		logger.log(Status.INFO, "Buy an item");
		ActionControllerProduct _ActionControllerProduct = new ActionControllerProduct(driver);
		_ActionControllerProduct.buySelectedItem();
	}
	
	
	/**
	 * @author karamvir_Garga
	 * @Desc Test Case for setting Address details
	 */
	@Test(priority=3)
	public void setAddressDetails()
	{
		logger = extent.createTest("setAddressDetails");
		logger.log(Status.INFO, "Set address details");
		ActionControllerAddress _ActionControllerAddress = new ActionControllerAddress(driver);
		_ActionControllerAddress.enterAddress();
	}
	
	
	/**
	 * @author Karamvir_Garga
	 * @Desc Test Case for Checkout
	 */
	@Test(priority=4)
	public void setPaymentDetails()
	{
		logger.log(Status.INFO, "Login End");
		logger = extent.createTest("setPaymentDetails");
		logger.log(Status.INFO, "Checkout");
		ActionControllerPayment _ActionControllerPayment = new ActionControllerPayment(driver);
		boolean result = _ActionControllerPayment.performAssertion();
		SoftAssert _SoftAssert = new SoftAssert(); 
		_SoftAssert.assertEquals(true, result);
		_ActionControllerPayment.enterPayment();
	}
	
	
	/**
	 * @author Karamvir_Garga
	 * @Desc data provider for login from excel as database
	 */
	@DataProvider
	public Object[][] readDatafromUtils(Method m)
	{
		ReadDataFromExcel _ReadDataFromExcel = new ReadDataFromExcel();
		_ReadDataFromExcel.readDataFromExcel();
		int iRows = _ReadDataFromExcel.getrowcount(0);
		Object[][] obj = new Object[iRows][2];
		
		for(int i=0; i<iRows;i++)
		{
			obj[i][0] = _ReadDataFromExcel.getdata(0, i, 0);
			obj[i][1] = _ReadDataFromExcel.getdata(0, i, 1);
		}
		return obj;
	}

}
