package com.experitest.auto;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Biogen {
	
	private static IOSDriver driver = null;
	//private static IOSDriver driver = null;
    private DesiredCapabilities dc = new DesiredCapabilities();
    
    
    @Test(invocationCount = 1)
    public void CreateSession_Test() throws InterruptedException, IOException {
    	
    	try {
    		dc.setCapability("testName", "CreateSession_Test");
            dc.setCapability("appiumVersion", "2.0.0.beta.23");
            dc.setCapability("accessKey", "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjozNDE4NzYsInhwLnAiOjg0NTc0LCJ4cC5tIjoxNjg2MjE0MjEzOTgxLCJleHAiOjIwMDI2MTA4OTYsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.Xz82O-5YC0V4xyD18PHobKCndIbtzD8fCYWUv0EvIGs");
            dc.setCapability("deviceQuery", "@serialnumber='00008030-000C0C1822D8802E'");
            //dc.setCapability("browserName", "Chrome");
            dc.setCapability("appium:appPackage", "com.experitest.ExperiBank");
           dc.setCapability("automationName", "XCUITEST");
            dc.setCapability("reservationDuration", 15);
            dc.setCapability("newCommandTimeout", 180);
            driver = new IOSDriver(new URL("https://biogen.experitest.com/wd/hub"), dc);
            
           
        	driver.launchApp();
        	Thread.sleep(5000);
        	
       	    Set<String> contextNames = driver.getContextHandles();
       	    for (String s : contextNames)
       	    	{
       	    		System.out.println(s);
       	    	} 
       	    
       	    
       	    System.out.println("Current context is "+driver.getContext()+" : And window size is "+driver.manage().window().getSize());
       	    driver.context("NATIVE_APP");
       	    System.out.println("Current context is "+driver.getContext()+" : And window size is "+driver.manage().window().getSize());
       	    System.out.println("=================================");
       	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	}
    	
    	
    	catch(Exception e) {
    		e.printStackTrace();
   
    	}
    	
    	finally {
    		driver.quit();
    	}
    	 	
    }

}