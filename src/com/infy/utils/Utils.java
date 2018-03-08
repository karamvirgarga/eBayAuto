package com.infy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utils {
	
	
	public static AppiumDriver driver;
	
	/**
	 * @author karamvir_garga
	 * @desc method for setting desired capabilities,
	 * instantiate the driver
	 * @return appium driver
	 * @throws MalformedURLException
	 */
	public static AppiumDriver setUp() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("deviceName", "Moto G4 Plus");
		capabilities.setCapability("app", "/Users/chdsez97152lADM/Desktop/Karam/apk/com.ebay.mobile_v5.17.0.18-117_Android-5.0.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}
	
	/**
	 * @author karamvir_garga
	 * @param AndroidElement ae
	 * @param AppiumDriver d
	 * @desc click method customized for elements to be clickable
	 */
	public static void clickCustom(AndroidElement ae, AppiumDriver d)
	{
		WebDriverWait wait = new WebDriverWait(d, 20);
		wait.until(ExpectedConditions.elementToBeClickable(ae));
		ae.click();
	}
	
	/**
	 * @author karamvir_garga
	 * @return
	 * @desc reading data from property file as external data source
	 */
	public static Properties readFileData(){
		
		Properties prop = new Properties();
		File file = new File(System.getProperty("user.dir") +"/TestData/EBayTestData.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
			prop.load(fileInput);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}
	
	
	/**
	 * @author karamvir_garga
	 * @param AndroidElement X
	 * @param AndroidElement Y
	 * @param AppiumDriver d
	 */
	public static void scroll(AndroidElement X,AndroidElement Y, AppiumDriver d) {
		
		WebDriverWait wait = new WebDriverWait(d, 20);
		wait.until(ExpectedConditions.elementToBeClickable(X));
		Dimension dimensions = driver.manage().window().getSize();
        int Startpoint = (int) (dimensions.getHeight() * 0.96);
        int scrollEnd = (int) (dimensions.getHeight() * 0.01);
        driver.swipe(0, Startpoint, 0,scrollEnd, 1000); 
     
    }
	
	/**
	 * @author karamvir_garga
	 * @param AndroidElement X
	 * @param AndroidElement Y
	 * @param AppiumDriver d
	 */
	public static void scrollListingScreen(AndroidElement X, AndroidElement Y, AppiumDriver d) {
		
		WebDriverWait wait = new WebDriverWait(d, 20);
		wait.until(ExpectedConditions.visibilityOf(X));
		Dimension dimensions = driver.manage().window().getSize();
        int Startpoint = (int) (dimensions.getHeight() * 0.96);
        int scrollEnd = (int) (dimensions.getHeight() * 0.01);
        driver.swipe(0, Startpoint, 0,scrollEnd, 1000); 
        wait.until(ExpectedConditions.visibilityOf(Y));
    }
}
