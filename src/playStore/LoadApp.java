package playStore;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;

public class LoadApp {
	
	private static AppiumDriver driver;
	private final static String APP_PACKAGE_NAME = "com.android.vending";
	private final static String APP_ACTIVITY_NAME = "com.google.android.finsky.activities.MainActivity";
	private final static String linkText = "Top Charts";
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
				  
		//Set the Appium Session
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		 
		 capabilities.setCapability("deviceName", "HUAWEI nova 3i");
		 capabilities.setCapability("udid", "KSY4C18823003909");  //Device ID of mobile phone
		 capabilities.setCapability("platformName", "Android");
		 capabilities.setCapability("platformVersion", "9");
		 capabilities.setCapability("appPackage", APP_PACKAGE_NAME);
		 capabilities.setCapability("appActivity", APP_ACTIVITY_NAME);
		 capabilities.setCapability("noReset", "true");
		 
		 //Instantiate Appium Driver
		 try{
			 driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			 driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		 }
		 
		 catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
		 
		 //Checking if Top Charts is displayed
		 if(((AndroidDriver<MobileElement>)driver).findElementByAndroidUIAutomator("new UiSelector().text(linkText)").isDisplayed())
		  	System.out.println("Test Completed Successfully");
		 
		driver.quit();
		 }
		
	}


