package com.experitest.auto;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
public class IosWeb_Browser_Test {
	
		static IOSDriver driver;
		
//		@BeforeTest
//		  public void setUp() throws MalformedURLException {
//		    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//		    desiredCapabilities.setCapability("platformName", "iOS");
//		    desiredCapabilities.setCapability("appium:automationName", "XCUITest");
//		    desiredCapabilities.setCapability("appium:deviceName", "iPhone 12");
//		    desiredCapabilities.setCapability("appium:udid", "00008101-001A54D13485001E");
//		    desiredCapabilities.setCapability("browserName", "Safari");
//		    desiredCapabilities.setCapability("appium:includeSafariInWebviews", true);
//		    //desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
//		    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
//
//		    URL remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");
//
//		    driver = new IOSDriver(remoteUrl, desiredCapabilities);
//		  }
		@BeforeTest
		public static void setUp() throws MalformedURLException {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", "iOS");
			caps.setCapability("deviceName", "iPhone 12");
			caps.setCapability("udid", "00008101-001A54D13485001E");
			//caps.setCapability("udid", "96aac85338903218c16cb0916cb56b5202d56b49");
			
			caps.setCapability("browserName", "Safari");
			caps.setCapability("automationName", "XCUITest");
			caps.setCapability("autoWebview", true);
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new IOSDriver(url,caps);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		@AfterTest
		public static void tearDown() {
			driver.quit();
		}
		
	    @Test
	    public void quickStartiOSBrowserDemo() throws IOException, InterruptedException {
	        driver.get("https://www.google.com");
	        /*
	        WebElement searchBar = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
	        searchBar.sendKeys("Experitest123456789");
	        Thread.sleep(10000);
	        driver.findElement(By.xpath("//LI[1]")).click();
	        */
	        /*
	        Actions action = new Actions(driver);
	        //action.clickAndHold(searchBar).perform();
	        action.moveToElement(driver.findElement(By.name("q"))).click().build().perform();
	        */
	        Thread.sleep(2000);
	       
	       
	        //File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        //FileUtils.copyFile(file, new File("/Users/pradeep.kumar/Downloads/Screenshot.jpg"));
	       
	        Set<String> contextNames = driver.getContextHandles();
	        for (String contextName : contextNames)
	        {
//	        	if(contextName.startsWith("WEBVIEW"))
//	        		WebContext  = contextName;
	        	//WEBVIEW_266.1
	        	//WEBVIEW_405.1
	        	//WEBVIEW_415.1
	            System.out.println(contextName);
	        }
	    }
}





