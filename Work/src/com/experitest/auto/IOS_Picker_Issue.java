package com.experitest.auto;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.experitest.appium.SeeTestClient;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOS_Picker_Issue {
	
	private IOSDriver<IOSElement> driver = null;
    private DesiredCapabilities dc = new DesiredCapabilities();
    SeeTestClient seetest;
    

	@BeforeTest
    public void setUp() throws MalformedURLException {
     
        dc.setCapability("accessKey", "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoxNzM2NSwieHAucCI6MSwieHAubSI6MTY4MjQ5NDE1MDA4OCwiZXhwIjoxOTk5MDk3OTQ4LCJpc3MiOiJjb20uZXhwZXJpdGVzdCJ9.94bluq7AaXy6aSkTlUTTVxKiUuLyzP49WxtfWqiFcCU");
        dc.setCapability("deviceQuery", "@serialnumber='00008030-0011083A3410802E'");
        //dc.setCapability("bundleId", "com.adib.mobilebanking");
        driver = new IOSDriver<IOSElement>(new URL("https://internal.experitest.com/wd/hub"), dc);
        seetest = new SeeTestClient(driver);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
       
    }
    
    @Test(invocationCount = 1)
    public void generatedMethod() throws InterruptedException, MalformedURLException {
    	
//    	driver.findElement(By.xpath("(//*[@class='UIAView' and (./preceding-sibling::* | ./following-sibling::*)[@text='registration_bg'] and ./parent::*[@class='UIAView']]/*[@class='UIAView' and ./*[@class='UIAStaticText']])[1]")).sendKeys("0880");
//	driver.findElement(By.xpath("//*[@text='Transfers']")).click();
//    	driver.findElement(By.xpath("//*[@accessibilityLabel='ERs-dU-JxN']")).click();
//    	Thread.sleep(2000);
//    	driver.findElement(By.xpath("//*[@text='change']"));
    	
    	
    	seetest.setPickerValues("NATIVE", "//*[@class='UIAPicker']", 0, 0, "up:1");
    	Thread.sleep(2000);
    	
    	//driver.findElement(By.xpath("//*[@class='_UIButtonBarButton']")).click();
        	
    }
    
	@AfterTest
    public void tearDown() {
       
            driver.quit();
        
    }
}
