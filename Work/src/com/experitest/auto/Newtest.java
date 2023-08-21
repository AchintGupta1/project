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

public class Newtest {
	
	private IOSDriver<IOSElement> driver = null;
    private DesiredCapabilities dc = new DesiredCapabilities();
    SeeTestClient seetest;
    

	@BeforeTest
    public void setUp() throws MalformedURLException {
     
        dc.setCapability("accessKey", "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoyNDA2MDEyLCJ4cC5wIjoyNDA2MDExLCJ4cC5tIjoxNjg5MzQ4MTE2MjcwLCJleHAiOjIwMDQ3MDgxMTcsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.0rs4psm_xXJuQ-KMXBhED9yHy83fep2AEy73x15qTsg");
        dc.setCapability("deviceQuery", "@serialnumber='00008101-000D09421A78001E'");
        driver = new IOSDriver<IOSElement>(new URL("https://adib.experitest.com/wd/hub"), dc);
        seetest = new SeeTestClient(driver);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
    
    @Test(invocationCount = 1)
    public void generatedMethod() throws InterruptedException, MalformedURLException {
    	
    	Thread.sleep(2000);
    	
    	seetest.setPickerValues("NATIVE", "//*[@class='UIAPicker']", 0, 0, "up:1");
    	Thread.sleep(2000);
    	
        	
        	 driver.findElement(By.xpath("//*[@text='Done']")).click();
        	
    }
    
	@AfterTest
    public void tearDown() {
       
            driver.quit();
        
    }
}
