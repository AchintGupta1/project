package com.experitest.auto;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ADIBofflineapp {

    protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoyMzA5NzIzLCJ4cC5wIjoyLCJ4cC5tIjoxNjgzNzA2MDM4OTcyLCJleHAiOjE5OTkwNjYwNDAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.EZgUicNJwv0Zze6N3sRQiRJrAu2luUN6a3T9J6T0ts4";

    @BeforeTest
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", "Quick Start iOS Native Demo");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='ios' and @version='15.4.1' and @category='PHONE'");
//        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
//        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new IOSDriver<>(new URL("https://adib.experitest.com/wd/hub"), dc);
    }

    @Test(invocationCount = 10)
    public void quickStartiOSNativeDemo() {
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.launchApp();
        driver.findElement(By.xpath("//*[@text='ADIBApp Offline']")).click();
        driver.findElement(By.xpath("(//*[@class='UIAView' and (./preceding-sibling::* | ./following-sibling::*)[@text='registration_bg'] and ./parent::*[@class='UIAView']]/*[@class='UIAView' and ./*[@class='UIAStaticText']])[1]")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@text='product_tabbarImage']")).click();
        driver.findElement(By.xpath("//*[@text='Card']")).click();
        driver.findElement(By.xpath("//*[@text='Etihad Card']")).click();
        driver.closeApp();
 
      //*[@class='_UITextLayoutCanvasView']
}

@AfterTest
public void tearDown() {
    System.out.println("Report URL: " + driver.getCapabilities().getCapability("reportUrl"));
    driver.quit();
}
}
