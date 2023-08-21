package com.experitest.auto;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.experitest.appium.SeeTestClient;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ADIBPICKERwheelnewapp {

    protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoxNzM2NSwieHAucCI6MSwieHAubSI6MTY4MjQ5NDE1MDA4OCwiZXhwIjoxOTk5MDk3OTQ4LCJpc3MiOiJjb20uZXhwZXJpdGVzdCJ9.94bluq7AaXy6aSkTlUTTVxKiUuLyzP49WxtfWqiFcCU";
    SeeTestClient seetest;
    @BeforeTest
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", "Quick Start iOS Native Demo");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='ios' and @serialnumber='dd9f1729f3fd00d9d52a0cd91661ea8acdf43775' and @category='PHONE'");
        
       dc.setCapability("app", "cloud:uniqueName=ADIBpickerissue");
       dc.setCapability("instrumentapp", "true");
       dc.setCapability("bundleId", "com.adib.mobilebanking");
        driver = new IOSDriver<>(new URL("https://internal.experitest.com/wd/hub"), dc);
    }

    @Test
    public void quickStartiOSNativeDemo() {
        driver.rotate(ScreenOrientation.PORTRAIT);
  driver.findElement(By.xpath("//*[@class='_UITextLayoutCanvasView']")).sendKeys("1234");
  driver.findElement(By.xpath("//*[@class='UIImageView' and ./parent::*[@accessibilityLabel='closeButton']]")).click();
  driver.findElement(By.xpath("//*[@text='Upgrade Later']")).click();
  driver.findElement(By.xpath("//*[@accessibilityLabel='Transfers' and @class='UITabBarButton']")).click();
  driver.findElement(By.xpath("//*[@class='UIAPicker']")).sendKeys("USD");
 driver.findElement(By.xpath("//*[@text='VS']")).click();
 driver.findElement(By.xpath("//*[@text='AED - Current Account']")).click();
 seetest.setPickerValues("NATIVE", "//*[@class='_UIRemoteKeyboardPlaceholderView']", 0, 0, "up:1");

    }

    @AfterTest
    public void tearDown() {
        System.out.println("Report URL: " + driver.getCapabilities().getCapability("reportUrl"));
        driver.quit();
    }
}
