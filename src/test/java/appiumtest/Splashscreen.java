package appiumtest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;


public class Splashscreen extends Automationdriver {
	public static int row = 1;
	public static int colstatus = 4;
	public static int colcomment = 6;

	public static void testcase1() throws IOException {
		
		System.out.println("started");
		//var driver = Automationdriver.Sbiyonoliteautomation();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//Automationdriver.Sbiyonoliteautomation();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/******** Splash Screen deny check - deny - Exiting the application **********/

		try {

			MobileElement splashdeny = (MobileElement) driver
					.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button"));
			splashdeny.click();
			System.out.println("success1");
			MobileElement splashdeny2 = (MobileElement) driver.findElement(By.id("android:id/button2"));
			splashdeny2.click();

			Boolean exitingpopcheck = driver.findElements(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
					.size() > 0;
			System.out.println("Exiting the application");
			if (exitingpopcheck == true) {
				Excelfile.updateexcel(row, colstatus, "Pass");
			} else {
				Excelfile.updateexcel(row, colstatus, "fail");
			}

			MobileElement exitingpopok = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			exitingpopok.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			

			/********
			 * Splash Screen deny check - deny - retry - allow - Any desk/ SIM Screen
			 **********/

			driver.activateApp("com.sbi.SBIFreedomPlus");
			MobileElement splashretry = (MobileElement) driver.findElement(By.id("android:id/button1"));
			splashretry.click();
			MobileElement splashallow = (MobileElement) driver
					.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
			splashallow.click();
			row = row + 1;
			System.out.println(row);
			Excelfile.updateexcel(row, colstatus, "Pass");
		} catch (Exception e) {
			// wait.until(ExpectedConditions.visibilityOf(Anydesk));
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
			Excelfile.updateexcel(row, colstatus, "crash");
			Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
		}

		/******** If Anydesk > Exit > Uninstall **********/

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Boolean AnydeskDisplayed = driver.findElements(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
				.size() > 0;

		// MobileElement Anydesk = (MobileElement)
		// driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));

		// boolean AnydeskDisplayed = Anydesk.isDisplayed();
		System.out.print(AnydeskDisplayed);

		if (AnydeskDisplayed == true) {
			MobileElement Anydeskexit = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			try {
				System.out.println("inside anydesk exit");
				Anydeskexit.click();

				row = row + 1;
				Excelfile.updateexcel(row, colstatus, "Pass");
			} catch (Exception e) {

				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
				Excelfile.updateexcel(row, colstatus, "crash");
				Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
			}

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.removeApp("com.anydesk.anydeskandroid");

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.activateApp("com.sbi.SBIFreedomPlus");
			System.out.println("unexpected");
		}

		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String name = "neethudevaraj";
		String pass = "Neethu@9466";

		/******** No SIM available **********/

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		row = row + 1;
		System.out.println("SIM Screen");

		Boolean dualsim1 = driver.findElements(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView"))
				.size() > 0;

		Boolean dualsim2 = driver.findElements(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.ImageView"))
				.size() > 0;

		Boolean singlesim1 = driver.findElements(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ImageView"))
				.size() > 0;

		if (dualsim1 == false && dualsim2 == false && singlesim1 == false) {
			System.out.println("No SIM available");
			MobileElement nosimexit = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			nosimexit.click();
			Excelfile.updateexcel(row, colstatus, "Pass");

		}

		else {
			row = row + 1;
			Excelfile.updateexcel(row, colstatus, "Fail");
		}

		/******** Dual SIM > No SIM selected > Proceed > Validation > OK **********/

		if (dualsim1 == true && dualsim2 == true)

		{
			System.out.println("Both SIM available");
			try {
				MobileElement simnoproceed = (MobileElement) driver.findElement(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.Button"));
				simnoproceed.click();

				Boolean simchoose = driver.findElements(By.xpath(
						"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
						.size() > 0;
				System.out.println("Please choose any SIM");
				if (simchoose == true) {
					System.out.println("Please choose any SIM pop up came");
					MobileElement validationchoosesimok = (MobileElement) driver.findElement(By.xpath(
							"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
					validationchoosesimok.click();

					Excelfile.updateexcel(row, colstatus, "Pass");
				} else {
// row=row+1;
					Excelfile.updateexcel(row, colstatus, "Fail");

				}

			}

			catch (Exception e) {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
				Excelfile.updateexcel(row, colstatus, "crash");
				Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
			}

			MobileElement choosesim = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.ImageView"));
			choosesim.click();

			/******** SIM permission deny **********/

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			row = row + 1;

			try {

				MobileElement simproceed1 = (MobileElement) driver.findElement(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.Button"));
				simproceed1.click();

				MobileElement simdeny = (MobileElement) driver
						.findElement(By.id("com.android.packageinstaller:id/permission_deny_button"));
				simdeny.click();

				MobileElement simdeny2 = (MobileElement) driver.findElement(By.id("android:id/button2"));
				simdeny2.click();

				Excelfile.updateexcel(row, colstatus, "Pass");

			}

			catch (Exception e) {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
				Excelfile.updateexcel(row, colstatus, "fail");
				Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
			}

			/******** SIM permission allow **********/

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			row = row + 1;

			try {
				MobileElement simproceed2 = (MobileElement) driver.findElement(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.Button"));
				simproceed2.click();

				MobileElement simretry = (MobileElement) driver.findElement(By.id("android:id/button1"));
				simretry.click();

				MobileElement simallow = (MobileElement) driver
						.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
				simallow.click();

				Excelfile.updateexcel(row, colstatus, "Pass");

			}

			catch (Exception e) {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
				Excelfile.updateexcel(row, colstatus, "Fail");
				Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
			}

			/********
			 * Registered SIM slot 2 + Other Sim in slot 1> SMS from non-registered SIM >
			 * While Registration , will get error "We are unable to process your request.
			 * Please try after sometime with registered Mobile number"
			 **********/
			/********
			 * "Registered SIM slot 2 + Other Sim in slot 1> SMS from registered SIM >
			 * Registration"
			 **********/
			
			row = row + 1;
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			/******** "Registered SIM, but SMS sending failed" *********/
			
			Boolean smssendcheck = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Button")).size() > 0;
			
			Boolean smsfailed = driver.findElements(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
					.size() > 0;

			if (smssendcheck == true)
					{
						
						try {

							MobileElement username = (MobileElement) driver.findElement(By.xpath(
									"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
							username.click();
							username.sendKeys(name);
							driver.hideKeyboard();

							MobileElement password = (MobileElement) driver.findElement(By.xpath(
									"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
							password.click();
							password.sendKeys(pass);
							driver.hideKeyboard();

							MobileElement register = (MobileElement) driver.findElement(By.xpath(
									"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Button"));
							register.click();

							Boolean regscreen2 = driver.findElements(By.xpath(
									"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[2]/android.widget.TextView"))
									.size() > 0;
							
							if (regscreen2 == true)

							{
								System.out.println("SMS from registered SIM");
								
								Excelfile.updateexcel(row, colstatus, "Pass");
								MobileElement backregscreen1 = (MobileElement) driver.findElement(By.xpath(
										"//android.widget.LinearLayout[@content-desc=\"Back buttonHelps you to navigate to previous page\"]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ImageView"));
								backregscreen1.click();
							}

							else {

								Boolean smsnonregsim = driver.findElements(By.xpath(
										"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
										.size() > 0;

								System.out.println("SMS from non registered SIM");
								
								row = row + 1;
								if (smsnonregsim == true) {
									Excelfile.updateexcel(row, colstatus, "Pass");
									MobileElement simwrongok = (MobileElement) driver.findElement(By.xpath(
											"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
									simwrongok.click();
									
									MobileElement correctsim = (MobileElement) driver.findElement(By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.ImageView"));
									correctsim.click();
									MobileElement simproceed1 = (MobileElement) driver.findElement(By.xpath(
											"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.Button"));
									simproceed1.click();
									
								}

							}

						}

						catch (Exception e) {
							File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
							FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
							Excelfile.updateexcel(row, colstatus, "Fail");
							Excelfile.updateexcel(row, colcomment,
									"This is due to crash in permission allow click splashscreen");
						}
					
					}

				if (smsfailed == true) {

				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Excelfile.updateexcel(row, colstatus, "Pass");
				
				System.out.print("SMS sending failed");
				
				MobileElement smsnotsendok = (MobileElement) driver.findElement(By.xpath(
						"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
				smsnotsendok.click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				MobileElement choosesim1 = (MobileElement) driver.findElement(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.ImageView"));
				choosesim1.click();
				MobileElement simproceed1 = (MobileElement) driver.findElement(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.Button"));
				simproceed1.click();
				
				// to be terminated here
			}
			
			
		}

		/************ Single SIM available ***************/

		else {
			System.out.println("Single SIM available");

			/******** SIM permission deny **********/

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			row = row + 1;

			try {

				MobileElement simproceed1 = (MobileElement) driver.findElement(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.Button"));
				simproceed1.click();

				MobileElement simdeny = (MobileElement) driver
						.findElement(By.id("com.android.packageinstaller:id/permission_deny_button"));
				simdeny.click();

				MobileElement simdeny2 = (MobileElement) driver.findElement(By.id("android:id/button2"));
				simdeny2.click();

				Excelfile.updateexcel(row, colstatus, "Pass");

			}

			catch (Exception e) {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
				Excelfile.updateexcel(row, colstatus, "Fail");
				Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
			}

			/******** SIM permission allow **********/

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			row = row + 1;

			try {
				MobileElement simproceed2 = (MobileElement) driver.findElement(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.Button"));
				simproceed2.click();

				MobileElement simretry = (MobileElement) driver.findElement(By.id("android:id/button1"));
				simretry.click();

				MobileElement simallow = (MobileElement) driver
						.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
				simallow.click();

				Excelfile.updateexcel(row, colstatus, "Pass");

			}

			catch (Exception e) {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
				Excelfile.updateexcel(row, colstatus, "Fail");
				Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
			}

			/********
			 * Registered SIM slot 1> SMS from non-registered SIM > While Registration ,
			 * will get error "We are unable to process your request. Please try after
			 * sometime with registered Mobile number"
			 **********/
			/********
			 * "Registered SIM slot 1> SMS from registered SIM > Registration"
			 **********/
			
			row = row + 1;
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			/******** "Registered SIM, but SMS sending failed" *********/
			
			Boolean smssendcheck1 = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Button")).size() > 0;
			
			
			Boolean smsfailed = driver.findElements(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
					.size() > 0;
							
					
			if (smssendcheck1 == true)
					{
				      
						try {

							MobileElement username = (MobileElement) driver.findElement(By.xpath(
									"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
							username.click();
							username.sendKeys(name);
							driver.hideKeyboard();

							MobileElement password = (MobileElement) driver.findElement(By.xpath(
									"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
							password.click();
							password.sendKeys(pass);
							driver.hideKeyboard();

							MobileElement register = (MobileElement) driver.findElement(By.xpath(
									"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Button"));
							register.click();

							Boolean regscreen2 = driver.findElements(By.xpath(
									"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[2]/android.widget.TextView"))
									.size() > 0;

							
							if (regscreen2 == true)

							{ 
								System.out.println("SMS from registered SIM");
							
								Excelfile.updateexcel(row, colstatus, "Pass");
								MobileElement backregscreen1 = (MobileElement) driver.findElement(By.xpath(
										"//android.widget.LinearLayout[@content-desc=\"Back buttonHelps you to navigate to previous page\"]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ImageView"));
								backregscreen1.click();
							}

							else {

								Boolean smsnonregsim = driver.findElements(By.xpath(
										"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
										.size() > 0;

								System.out.println("SMS from non registered SIM");
								row = row + 1;
								if (smsnonregsim == true) {
									Excelfile.updateexcel(row, colstatus, "Pass");
									MobileElement simwrongok = (MobileElement) driver.findElement(By.xpath(
											"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
									simwrongok.click();
									
									System.out.println("Insert registered sim to continue");
								}

							}

						}

						catch (Exception e) {
							File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
							FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
							Excelfile.updateexcel(row, colstatus, "Fail");
							Excelfile.updateexcel(row, colcomment,
									"This is due to crash in permission allow click splashscreen");
						}

					
					
					}

			if (smsfailed == true) {

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Excelfile.updateexcel(row, colstatus, "Pass");
				System.out.print("SMS sending failed");
				MobileElement smsnotsendok = (MobileElement) driver.findElement(By.xpath(
						"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
				smsnotsendok.click();
			}

		}

		/******** "New User Registration Navigation" **********/

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		row = row + 1;

		try {

			MobileElement newuserlink = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[9]/android.widget.TextView"));
			newuserlink.click();


			Boolean newreg = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Button")).size() > 0;
			
			System.out.println("New Registrtaion check");
			if (newreg == true) {

				Excelfile.updateexcel(row, colstatus, "Pass");
			}

			 
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.navigate().back();
			

		}

		catch (Exception e) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
			Excelfile.updateexcel(row, colstatus, "Fail");
			Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
		}

		/********
		 * Boolean dualsim11 = driver.findElements(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView"))
		 * .size() > 0;
		 * 
		 * Boolean dualsim21 = driver.findElements(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.ImageView"))
		 * .size() > 0;
		 * 
		 * Boolean singlesim11 = driver.findElements(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ImageView"))
		 * .size() > 0;
		 * 
		 * if (dualsim11 == true && dualsim21 == true) { System.out.println("Dual SIM");
		 * MobileElement dualsim = (MobileElement) driver.findElements(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView"));
		 * dualsim.click(); }
		 * 
		 * else { System.out.println("Single SIM");
		 * 
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * 
		 * MobileElement newuserproceed2 = (MobileElement) driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.Button"));
		 * newuserproceed2.click();
		 * 
		 * System.out.println("Single SIM proceed check"); }
		 **********/

		/********
		 * "Validations and Successful Registration of Registration Screen 1"
		 **********/

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		row = row + 1;

		try {

			MobileElement regbutton = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Button"));
			regbutton.click();

			MobileElement credentialpop = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
			String cred = credentialpop.getText();
			System.out.println(cred);
			MobileElement ok1 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			ok1.click();

			MobileElement username1 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
			username1.click();
			username1.sendKeys(name);
			driver.hideKeyboard();

			MobileElement regbutton1 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Button"));
			regbutton1.click();

			MobileElement passpop = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
			String passw = passpop.getText();
			System.out.println(passw);

			MobileElement ok2 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			ok2.click();

			MobileElement password1 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
			password1.click();
			password1.sendKeys(pass);
			driver.hideKeyboard();

			MobileElement regbutton2 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Button"));
			regbutton2.click();

			MobileElement userpop = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
			String user = userpop.getText();
			System.out.println(user);

			MobileElement ok3 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			ok3.click();

			MobileElement username3 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
			username3.click();
			username3.sendKeys("ffjfhjwrdhg");
			driver.hideKeyboard();

			MobileElement password3 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
			password3.click();
			password3.sendKeys("fffffhnkk");
			driver.hideKeyboard();

			MobileElement regbutton3 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Button"));
			regbutton3.click();

			MobileElement invalidpop = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
			String invalidboth = invalidpop.getText();
			System.out.println(invalidboth);

			MobileElement ok4 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			ok4.click();

			MobileElement username4 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
			username4.click();
			username4.sendKeys("ffjfhjwrdhg");
			driver.hideKeyboard();

			MobileElement password4 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
			password4.click();
			password4.sendKeys("fffffhnkk");
			driver.hideKeyboard();

			MobileElement regbutton4 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Button"));
			regbutton4.click();

			MobileElement invalidpop2 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
			String invalidboth2 = invalidpop2.getText();
			System.out.println(invalidboth2);

			MobileElement ok5 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			ok5.click();

			MobileElement username5 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
			username5.click();
			username5.sendKeys("ffjfhjwrdhg");
			driver.hideKeyboard();

			MobileElement password5 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
			password5.click();
			password5.sendKeys("fffffhnkk");
			driver.hideKeyboard();

			MobileElement regbutton5 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Button"));
			regbutton5.click();

			MobileElement resetreg = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
			String reset = resetreg.getText();
			System.out.println(reset);

			MobileElement ok6 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			ok6.click();

			Boolean dualsim110 = driver.findElements(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView"))
					.size() > 0;

			Boolean dualsim210 = driver.findElements(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.ImageView"))
					.size() > 0;

			Boolean singlesim110 = driver.findElements(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ImageView"))
					.size() > 0;

			if (dualsim110 == true && dualsim210 == true) {
				
				System.out.println("Dual SIM");
				
				MobileElement dual1sim = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.ImageView"));
				dual1sim.click();
				
				MobileElement dualproclick = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.Button"));
				dualproclick.click();
				
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				
				Excelfile.updateexcel(row, colstatus, "Pass");
				
				
			}
			
			else {
				
				System.out.println("Single SIM");
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				MobileElement singlesim = (MobileElement) driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ImageView"));
				singlesim.click();

				MobileElement singlesimpro = (MobileElement) driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.Button"));
				singlesimpro.click();

				System.out.println("Single SIM proceed check");
				Excelfile.updateexcel(row, colstatus, "Pass");
				
			}

		}

		catch (Exception e) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
			Excelfile.updateexcel(row, colstatus, "Fail");
			Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
		}

		/********
		 * "Validations and Successful Registration of Registration Screen 2"
		 **********/

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		row = row + 1;

		try {

			MobileElement username123 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
			username123.click();
			username123.sendKeys(name);
			driver.hideKeyboard();

			MobileElement password123 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
			password123.click();
			password123.sendKeys(pass);
			driver.hideKeyboard();

			MobileElement register123 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Button"));
			register123.click();

			MobileElement urlcheck1 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
			urlcheck1.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Boolean urlcheck11 = driver
					.findElements(By
							.xpath("(//android.view.View[@content-desc=\"Terms of Service (Terms & Conditions)\"])[2]"))
					.size() > 0;

			if (urlcheck11 == true) {
				MobileElement url1back = (MobileElement) driver.findElement(By.xpath(
						"//android.widget.LinearLayout[@content-desc=\"Back ButtonHelps you to navigate to previous page\"]/android.widget.LinearLayout/android.widget.ImageView"));
				url1back.click();
				System.out.println("url1 working fine");
				Excelfile.updateexcel(row, colstatus, "Pass");
			}

			else {
				System.out.println("Error in url1");
				Excelfile.updateexcel(row, colstatus, "Fail");
			}

			MobileElement urlcheck2 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView"));
			urlcheck2.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Boolean urlcheck21 = driver.findElements(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.webkit.WebView"))
					.size() > 0;

			if (urlcheck21 == true) {
				MobileElement url2back = (MobileElement) driver.findElement(By.xpath(
						"//android.widget.LinearLayout[@content-desc=\"Back ButtonHelps you to navigate to previous page\"]/android.widget.LinearLayout/android.widget.ImageView"));
				url2back.click();
				System.out.println("url2 working fine");
				Excelfile.updateexcel(row, colstatus, "Pass");
			}

			else

			{
				System.out.println("Error in url2");
				Excelfile.updateexcel(row, colstatus, "Fail");
			}

		}

		catch (Exception e) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
			Excelfile.updateexcel(row, colstatus, "Fail");
			Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
		}

		/******** "Validations of checkbox in Registration Screen 2" **********/

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		row = row + 1;

		try {
			
			System.out.println("Proper navigation from url");
			MobileElement acceptcheckbox = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.ImageView"));
			acceptcheckbox.click();

			Boolean accept1 = driver.findElements(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout[1]/android.widget.Button"))
					.size() > 0;

			Boolean cancel1 = driver.findElements(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout[2]/android.widget.Button"))
					.size() > 0;

			if (accept1 == true && cancel1 == true) {
				Excelfile.updateexcel(row, colstatus, "Pass");
			}

			else

			{
				Excelfile.updateexcel(row, colstatus, "Fail");
				System.out.println("Error in accept reg screen");
			}

		}

		catch (Exception e) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
			Excelfile.updateexcel(row, colstatus, "Fail");
			Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
		}

		/********
		 * "Validations of cancel navigation in Registration Screen 2"
		 **********/

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		row = row + 1;

		try {

			MobileElement cancelreg = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout[2]/android.widget.Button"));
			cancelreg.click();
			System.out.println("Cancelled reg from accept T&C screen");
			Excelfile.updateexcel(row, colstatus, "Pass");
		}

		catch (Exception e) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
			Excelfile.updateexcel(row, colstatus, "Fail");
			Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
		}

		Boolean dualsim110 = driver.findElements(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView"))
				.size() > 0;

		Boolean dualsim210 = driver.findElements(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.ImageView"))
				.size() > 0;

		Boolean singlesim110 = driver.findElements(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ImageView"))
				.size() > 0;

		if (dualsim110 == true && dualsim210 == true) {
			
			System.out.println("Dual SIM, cancel navigation of aceept T&C");
			
			MobileElement dual1siim = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.ImageView"));
			dual1siim.click();
			
			MobileElement dualprocliick = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.Button"));
			dualprocliick.click();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			MobileElement username123 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
			username123.click();
			username123.sendKeys(name);
			driver.hideKeyboard();

			MobileElement password123 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
			password123.click();
			password123.sendKeys(pass);
			driver.hideKeyboard();

			MobileElement register123 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Button"));
			register123.click();

			MobileElement acceptcheckbox = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.ImageView"));
			acceptcheckbox.click();

		}

		else {
			System.out.println("Single SIM, cancel navigation of aceept T&C");
			MobileElement newuserproceed2 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.Button"));
			newuserproceed2.click();

			MobileElement username123 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
			username123.click();
			username123.sendKeys(name);
			driver.hideKeyboard();

			MobileElement password123 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
			password123.click();
			password123.sendKeys(pass);
			driver.hideKeyboard();

			MobileElement register123 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Button"));
			register123.click();

		}

		/********
		 * "Validations of accept navigation in Registration Screen 2"
		 **********/

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		row = row + 1;

		try {

			MobileElement acceptcheckbox = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.ImageView"));
			acceptcheckbox.click();
			
			MobileElement acceptcheckbox1 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.ImageView"));
			acceptcheckbox1.click();

			MobileElement accept = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout[1]/android.widget.Button"));
			accept.click();

			Excelfile.updateexcel(row, colstatus, "Pass");
		}

		catch (Exception e) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
			Excelfile.updateexcel(row, colstatus, "Fail");
			Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
		}

		/********
		 * "Check whether the Resend Activation code link and Activation code/ Resend
		 * Activation code is working as expected in Registration Screen 3"
		 **********/

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		row = row + 1;

		try {
			for (int i = 0; i < 2; i++) {
				MobileElement resendact = (MobileElement) driver.findElement(By.xpath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.TextView"));
				resendact.click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}

			Boolean note = driver.findElements(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"))
					.size() > 0;

			MobileElement submitnocode = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.Button"));
			submitnocode.click();

			Boolean actpop = driver.findElements(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
					.size() > 0;

			MobileElement ok1 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			ok1.click();

			MobileElement actfield = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[6]/android.widget.EditText"));
			actfield.click();
			actfield.sendKeys("1234");
			driver.hideKeyboard();

			MobileElement submitwrngcode = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.Button"));
			submitwrngcode.click();

			Boolean actpopless = driver.findElements(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
					.size() > 0;

			MobileElement ok2 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			ok2.click();

			if (note == true && actpop == true && actpopless == true) {
				System.out.println("Validations success in activation screen");
				Excelfile.updateexcel(row, colstatus, "Pass");
			}

			else {
				Excelfile.updateexcel(row, colstatus, "Fail");
				System.out.println("Error in activation screen");
			}

		}

		catch (Exception e) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
			Excelfile.updateexcel(row, colstatus, "Fail");
			Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
		}

		/********
		 * "Validations and Successful Registration of Registration Screen 3"
		 **********/

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		row = row + 1;

		try {
			System.out.println("Enter, submit pls");

// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			/********
			 * driver.openNotifications(); TouchAction Swipes = new
			 * TouchAction(driver).press(PointOption.point(180,
			 * 742)).waitAction().moveTo(PointOption.point(762, 742)).release().perform();
			 * 
			 * 
			 * MobileElement msgexpand = (MobileElement)
			 * driver.findElement(By.xpath("android:id/expand_button")); msgexpand.click();
			 * 
			 * MobileElement messagereceived = (MobileElement)
			 * driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout[3]/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView"));
			 * 
			 * String OTP= messagereceived.getText().replaceAll("[^0-9]","").substring(0,8);
			 * System.out.println("OTP Message"+OTP); driver.navigate().back();
			 * 
			 * 
			 * MobileElement enterActivation= (MobileElement)
			 * driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[6]/android.widget.EditText"));
			 * enterActivation.click(); enterActivation.sendKeys(OTP);
			 * driver.hideKeyboard();
			 ******/

			MobileElement submitactcode = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.Button"));
			submitactcode.click();

			Excelfile.updateexcel(row, colstatus, "Pass");

		}

		catch (Exception e) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
			Excelfile.updateexcel(row, colstatus, "Fail");
			Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
		}

		/******** "Validation of successful registration in Login Screen " **********/

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		row = row + 1;

		try {
			System.out.println("Success message in login screen");
			Boolean actsuccess = driver.findElements(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
					.size() > 0;

			MobileElement successregok = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			successregok.click();

			if (actsuccess == true) {
				System.out.println("Successful registration");
				Excelfile.updateexcel(row, colstatus, "Pass");
			}

			else {
				Excelfile.updateexcel(row, colstatus, "Fail");
				System.out.println("Error in registration");
			}

		}

		catch (Exception e) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
			Excelfile.updateexcel(row, colstatus, "Fail");
			Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
		}

		/******************* Login Screen **************/

		/******** "Validate the UI of login Screen" **************/

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		row = row + 1;

		try {
			Boolean LoginUI1 = driver.findElements(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Button"))
					.size() > 0;
			Boolean LoginUI2 = driver.findElements(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.Button"))
					.size() > 0;
			Boolean LoginUI3 = driver.findElements(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView"))
					.size() > 0;
			Boolean LoginUI4 = driver.findElements(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.ImageView"))
					.size() > 0;
			Boolean LoginUI5 = driver.findElements(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView"))
					.size() > 0;

			if (LoginUI1 == true || LoginUI2 == true || LoginUI3 == true || LoginUI4 == true || LoginUI5 == true) {

				Excelfile.updateexcel(row, colstatus, "Pass");
			}

			else {
				Excelfile.updateexcel(row, colstatus, "Fail");
				System.out.println("Error in Login UI");
			}

		}

		catch (Exception e) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
			Excelfile.updateexcel(row, colstatus, "Fail");
			Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
		}

		/******** "Validations in the login screen" **************/

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		row = row + 1;

		try {

			MobileElement logintab = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.Button"));
			logintab.click();

			MobileElement loginbutton = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Button"));
			loginbutton.click();

			MobileElement credentialpop = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
			String cred = credentialpop.getText();
			System.out.println(cred);
			MobileElement ok1 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			ok1.click();

			MobileElement username1 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
			username1.click();
			username1.sendKeys(name);
			driver.hideKeyboard();

			MobileElement loginbutton1 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Button"));
			loginbutton1.click();

			MobileElement passpop = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
			String passw = passpop.getText();
			System.out.println(passw);

			MobileElement ok2 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			ok2.click();

			MobileElement password1 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
			password1.click();
			password1.sendKeys(pass);
			driver.hideKeyboard();

			MobileElement loginbutton2 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Button"));
			loginbutton2.click();

			MobileElement userpop = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
			String user = userpop.getText();
			System.out.println(user);

			MobileElement ok3 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			ok3.click();

//			MobileElement username = (MobileElement) driver.findElement(By.xpath(
//					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
//			username.click();
//			username.sendKeys(name);
//			driver.hideKeyboard();
//
//			MobileElement password = (MobileElement) driver.findElement(By.xpath(
//					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
//			password.click();
//			password.sendKeys(pass);
//			driver.hideKeyboard();
//
//			MobileElement loginbutton3 = (MobileElement) driver.findElement(By.xpath(
//					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Button"));
//			loginbutton3.click();
//
//			Boolean loginsuccess = driver.findElements(By.xpath(
//					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView"))
//					.size() > 0;
//			if (loginsuccess == true) {
//				Excelfile.updateexcel(row, colstatus, "Pass");
//				MobileElement logout = (MobileElement) driver.findElement(By.xpath(
//						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.ImageView"));
//				logout.click();
//
//				MobileElement logoutyes = (MobileElement) driver.findElement(By.xpath(
//						"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.Button"));
//				logoutyes.click();
//
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				
//
//			} else {
//				Excelfile.updateexcel(row, colstatus, "Fail");
//				System.out.println("Error in Login");
//			}

		}

		catch (Exception e) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
			Excelfile.updateexcel(row, colstatus, "Fail");
			Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
		}

		/******** "Url navigations in login screen" **************/

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		row = row + 1;

		try {

			MobileElement logintab = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.Button"));
			logintab.click();

			MobileElement forgotpasswordurl = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[9]/android.widget.TextView"));
			forgotpasswordurl.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Boolean frgtpasspage = driver.findElements(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
					.size() > 0;

			if (frgtpasspage == true) {
				MobileElement url1back = (MobileElement) driver.findElement(By.xpath(
						"//android.widget.LinearLayout[@content-desc=\"Back ButtonHelps you to navigate to previous page\"]/android.widget.LinearLayout/android.widget.ImageView"));
				url1back.click();
				System.out.println("forgot password link working fine");
				Excelfile.updateexcel(row, colstatus, "Pass");
			}

			else {
				System.out.println("forgot password link");
				Excelfile.updateexcel(row, colstatus, "Fail");
			}

			MobileElement logintab1 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.Button"));
			logintab1.click();

			MobileElement lockunlock = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView"));
			lockunlock.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Boolean lockunlockpage = driver.findElements(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
					.size() > 0;

			if (lockunlockpage == true) {
				MobileElement lockunlockback = (MobileElement) driver.findElement(By.xpath(
						"//android.widget.LinearLayout[@content-desc=\"Back ButtonHelps you to navigate to previous page\"]/android.widget.LinearLayout/android.widget.ImageView"));
				lockunlockback.click();
				System.out.println("Lock/Unlock User ID link working fine");
				Excelfile.updateexcel(row, colstatus, "Pass");
			}

			else

			{
				System.out.println("Error in Lock/Unlock User ID link");
				Excelfile.updateexcel(row, colstatus, "Fail");
			}

		}

		catch (Exception e) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
			Excelfile.updateexcel(row, colstatus, "Fail");
			Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
		}

		/******** "Successful Login" **************/

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		row = row + 1;

		try {

			MobileElement logintab1 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.Button"));
			logintab1.click();

			MobileElement username = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
			username.click();
			username.sendKeys(name);
			driver.hideKeyboard();

			MobileElement password = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText"));
			password.click();
			password.sendKeys(pass);
			driver.hideKeyboard();

			MobileElement loginbutton3 = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[8]/android.widget.Button"));
			loginbutton3.click();

			Boolean loginsuccess = driver.findElements(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView"))
					.size() > 0;
			if (loginsuccess == true) {
				Excelfile.updateexcel(row, colstatus, "Pass");
			} else {
				Excelfile.updateexcel(row, colstatus, "Fail");
				System.out.println("Error in Login");
			}

		}

		catch (Exception e) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
			Excelfile.updateexcel(row, colstatus, "Fail");
			Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
		}

		/******* Post Login ***********/

		/***** Quick Transfer_Modules available check *******/

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		row = row + 1;

		try {

			MobileElement QuickTransfer = (MobileElement) driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.ImageView"));
			QuickTransfer.click();

//			Boolean accountdetails = driver.findElements(By.xpath(
//					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView"))
//					.size() > 0;
//			Boolean sendmoneyQR = driver.findElements(By.xpath(
//					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.TextView"))
//					.size() > 0;
//			Boolean recievemoney = driver.findElements(By.xpath(
//					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout[2]/android.widget.TextView"))
//					.size() > 0;
//			Boolean donations = driver.findElements(By.xpath(
//					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.LinearLayout[2]/android.widget.TextView"))
//					.size() > 0;
//
//			if (accountdetails == true && sendmoneyQR == true && recievemoney == true && donations == true) {
//
//				System.out.println("Modules of Quick Transfer Sub menu screen is as expected");
//				Excelfile.updateexcel(row, colstatus, "Pass");
//			}
//
//			else {
//				Excelfile.updateexcel(row, colstatus, "Fail");
//				System.out.println("Error in Quick Transfer Sub menu screen");
//			}
//		}
//
//		catch (Exception e) {
//			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
//			Excelfile.updateexcel(row, colstatus, "Fail");
//			Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
//		}
//
//		/***** Quick Transfer_Send Money using account details *******/
//
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		row = row + 1;
//
//		try {

			MobileElement sendmoneyaccount = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView"));
			sendmoneyaccount.click();

			MobileElement emptysubmit = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[14]/android.widget.Button"));
			emptysubmit.click();

			Boolean enterbenenameval1 = driver.findElements(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
					.size() > 0;

			MobileElement enterbenenameok1 = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			enterbenenameok1.click();

			MobileElement enterbenename1 = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.EditText"));
			enterbenename1.click();
			enterbenename1.sendKeys("neethu@#$%^&*dhfsgsggdhfjddfjdjjd");
			driver.hideKeyboard();

			MobileElement emptysubmit1 = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[14]/android.widget.Button"));
			emptysubmit1.click();

			Boolean enterbenenameval2 = driver.findElements(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
					.size() > 0;

			MobileElement enterbenenameok2 = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			enterbenenameok2.click();

			MobileElement enterbenename2 = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.EditText"));
			enterbenename2.click();
			enterbenename2.sendKeys("neethu");
			driver.hideKeyboard();

			MobileElement emptysubmit2 = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[14]/android.widget.Button"));
			emptysubmit2.click();

			Boolean enteraccountval1 = driver.findElements(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
					.size() > 0;

			MobileElement enteraccountvalok1 = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			enteraccountvalok1.click();

			MobileElement enteraccountnum1 = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.EditText"));
			enteraccountnum1.click();
			enteraccountnum1.sendKeys("1234567890");
			driver.hideKeyboard();

			MobileElement emptysubmit3 = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[14]/android.widget.Button"));
			emptysubmit3.click();

			Boolean accountmismatchval = driver.findElements(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
					.size() > 0;

			MobileElement accountmismatchvalok = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			accountmismatchvalok.click();

			MobileElement enteraccountnum = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.EditText"));
			enteraccountnum.click();
			enteraccountnum.sendKeys("1234567890");
			driver.hideKeyboard();

			MobileElement confirmaccountnum = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.EditText"));
			confirmaccountnum.click();
			confirmaccountnum.sendKeys("1234567890");
			driver.hideKeyboard();

			MobileElement emptysubmit4 = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[14]/android.widget.Button"));
			emptysubmit4.click();

			Boolean ifsceval = driver.findElements(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
					.size() > 0;

			MobileElement ifscevalok = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			ifscevalok.click();

			MobileElement enterifsc = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[9]/android.widget.EditText"));
			enterifsc.click();
			enterifsc.sendKeys("sbin0000437");
			driver.hideKeyboard();

			MobileElement emptysubmit5 = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[14]/android.widget.Button"));
			emptysubmit5.click();

			Boolean enteramtval = driver.findElements(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
					.size() > 0;

			MobileElement enteramtvalok = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			enteramtvalok.click();

			MobileElement enteramt = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[11]/android.widget.LinearLayout[2]/android.widget.EditText"));
			enteramt.click();
			enteramt.sendKeys("1.06678");
			driver.hideKeyboard();

			MobileElement remarks = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[13]/android.widget.EditText"));
			remarks.click();
			remarks.sendKeys("@$%FDJHFSGJK");
			driver.hideKeyboard();

			MobileElement emptysubmit6 = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[14]/android.widget.Button"));
			emptysubmit6.click();

			Boolean remarksval = driver.findElements(By.xpath(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
					.size() > 0;

			MobileElement remarksvalok = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button"));
			remarksvalok.click();

			MobileElement remarks1 = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[13]/android.widget.EditText"));
			remarks1.click();
			remarks1.sendKeys("sending money through quick transfer imps");
			driver.hideKeyboard();

			MobileElement emptysubmit7 = (MobileElement) driver.findElement(By.id(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[14]/android.widget.Button"));
			emptysubmit7.click();

			MobileElement back = (MobileElement) driver.findElement(By.id(
					"//android.widget.LinearLayout[@content-desc=\"Back buttonHelps you to navigate to previous page\"]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ImageView"));
			back.click();

			if (enterbenenameval1 == true && enterbenenameval2 == true && enteraccountval1 == true
					&& accountmismatchval == true && ifsceval == true && enteramtval == true && remarksval == true) {

				System.out.println("Send money through quick transfer imps is as expected");
				Excelfile.updateexcel(row, colstatus, "Pass");
			}

			else {
				Excelfile.updateexcel(row, colstatus, "Fail");
				System.out.println("Error in validations of send money through quick transfer imps screen");
			}
		}

		catch (Exception e) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("failureScreenshots/splashscreen.png"));
			Excelfile.updateexcel(row, colstatus, "Fail");
			Excelfile.updateexcel(row, colcomment, "This is due to crash in permission allow click splashscreen");
		}

		
		
		
		
		
		
		
	
	
	}
	
	
	}

