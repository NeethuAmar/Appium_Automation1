package appiumtest;



public class SBI extends Automationdriver{

	
		
	public static void main(String[] args) {
		try {
            
			Automationdriver.Sbiyonoliteautomation();
			
//			DesiredCapabilities mob= new DesiredCapabilities();
//			mob.setCapability("devicename", "Samsung");
//			mob.setCapability("udid", "RZ8N92FC0EA");
//			mob.setCapability("platformName", "Android");
//			mob.setCapability("platformVersion", "11");
//			mob.setCapability("appPackage", "com.sbi.SBIFreedomPlus");
//			mob.setCapability("appActivity", ".sbunifiedcug");
//			
//			URL url = new URL("http://127.0.0.1:4723/wd/hub");
//			
//			AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url,mob);
//			
//			System.out.println("Application Started....");
				        			
			Splashscreen.testcase1();
			System.out.println("testcase1 passed");
			//Splashscreen.testcase2();
			
		}
		catch(Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}

	}

}

