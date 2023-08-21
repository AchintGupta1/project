package com.experitest.auto;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ADIBEribank {

    protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoyMzA5NzIzLCJ4cC5wIjoyLCJ4cC5tIjoxNjgzNzA2MDM4OTcyLCJleHAiOjE5OTkwNjYwNDAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.EZgUicNJwv0Zze6N3sRQiRJrAu2luUN6a3T9J6T0ts4";

    @BeforeTest
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", "Quick Start iOS Native Demo");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='ios' and @version='16.5' and @category='PHONE'");
        
        dc.setCapability("app", "cloud:uniqueName=ADIBTest");
        dc.setCapability("bundleId", "com.adib.mobilebanking");
        driver = new IOSDriver<>(new URL("https://adib.experitest.com/wd/hub"), dc);
    }

    @Test
    public void quickStartiOSNativeDemo() {
        driver.rotate(ScreenOrientation.PORTRAIT);
  driver.findElement(By.xpath("//*[@text='ADIBApp Offline']")).click();
  driver.findElement(By.xpath("(//*[@class='UIAView' and (./preceding-sibling::* | ./following-sibling::*)[@text='registration_bg'] and ./parent::*[@class='UIAView']]/*[@class='UIAView' and ./*[@class='UIAStaticText']])")).sendKeys("1234");
  driver.findElement(By.xpath("//*[@text='Open New Account']")).click();
  driver.findElement(By.xpath("//*[@text='Open Account Now' and (./preceding-sibling::* | ./following-sibling::*)[@text='Ghina Savings Account']]")).click();
  driver.findElement(By.xpath("//*[@placeholder='Please Select' and (./preceding-sibling::* | ./following-sibling::*)[@text='Account Currency']]")).click();
  driver.findElement(By.xpath("//*[@class='UIAPicker']")).sendKeys("USD");
 

    }

    @AfterTest
    public void tearDown() {
        System.out.println("Report URL: " + driver.getCapabilities().getCapability("reportUrl"));
        driver.quit();
    }
}
