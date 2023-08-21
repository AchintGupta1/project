package com.experitest.auto;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class ADIBTest {

    protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoyMzA5NzIzLCJ4cC5wIjoyLCJ4cC5tIjoxNjgzNzA2MDM4OTcyLCJleHAiOjE5OTkwNjYwNDAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.EZgUicNJwv0Zze6N3sRQiRJrAu2luUN6a3T9J6T0ts4";

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", "Quick Start iOS Native Demo");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='ios' and @version='15.4.1' and @category='PHONE'");
        driver = new IOSDriver<>(new URL("https://adib.experitest.com/wd/hub"), dc);
        driver.executeScript("seetest: client.setProperty(\"element.visibility.level\", \"none\")");
    }

    @Test
    public void quickStartiOSNativeDemo() {
    	
    	driver.findElement(By.xpath("//*[@text='ADIBApp Offline']")).click();
    	  driver.findElement(By.xpath("(//*[@class='UIAView' and (./preceding-sibling::* | ./following-sibling::*)[@text='registration_bg'] and ./parent::*[@class='UIAView']]/*[@class='UIAView' and ./*[@class='UIAStaticText']])[1]")).sendKeys("1234");
   	  driver.findElement(By.xpath("//*[@text='Open New Account']")).click();
    	  driver.findElement(By.xpath("//*[@text='Open Account Now' and (./preceding-sibling::* | ./following-sibling::*)[@text='Ghina Savings Account']]")).click();
    	  driver.findElement(By.xpath("//*[@placeholder='Please Select' and (./preceding-sibling::* | ./following-sibling::*)[@text='Account Currency']]")).click();
         driver.findElement(By.xpath("//*[@text='Done']")).click();
    	 driver.findElement(By.xpath("//*[@placeholder='Please Select' and (./preceding-sibling::* | ./following-sibling::*)[@text='Transfer From']]")).click();
      	    	Object xpath = null;
			Object pickerWheelIndex = null;
				String pickerValue = null;
				if (xpath != null && pickerWheelIndex != null) {
    	    	this.driver.executeScript("seetest: client.setPickerValues(\"NATIVE\",\"xpath=" + xpath + "\",0," + pickerWheelIndex + ",\"" + pickerValue + "\")", new Object[0]);
    	    	} else {
    	    	this.driver.executeScript("seetest: client.setPickerValues(\"NATIVE\",\"xpath=//*[@class='UIAPicker']\",1,2,\"" + pickerValue + "\")", new Object[0]);
    	    	}  	  
//				driver.findElement(By.xpath("//*[@text='Done']")).click();
    	//driver.findElement(By.xpath("//*[@class='UIAPicker']")).sendKeys("AED - GHINA Saving Account28309843");
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Report URL: " + driver.getCapabilities().getCapability("reportUrl"));
        driver.quit();
    }
}
