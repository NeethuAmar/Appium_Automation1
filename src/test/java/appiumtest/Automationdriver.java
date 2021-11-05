package appiumtest;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class Automationdriver {
	
public static AndroidDriver<MobileElement>  driver;

public static void Sbiyonoliteautomation()  throws MalformedURLException {
		
		
	
		DesiredCapabilities mob= new DesiredCapabilities();
		mob.setCapability("devicename", "Samsung");
		mob.setCapability("udid", "RZ8N92FC0EA");
		mob.setCapability("platformName", "Android");
		mob.setCapability("platformVersion", "11");
		mob.setCapability("appPackage", "com.sbi.SBIFreedomPlus");
		mob.setCapability("appActivity", ".sbunifiedcug");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(url,mob);
		System.out.println("Application Started....");
		
		
		//return driver;
		
		
				
}


	
}

