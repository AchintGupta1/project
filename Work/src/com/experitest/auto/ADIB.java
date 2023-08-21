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

public class ADIB {

    protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoyMzA5NzIzLCJ4cC5wIjoyLCJ4cC5tIjoxNjgzNzA2MDM4OTcyLCJleHAiOjE5OTkwNjYwNDAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.EZgUicNJwv0Zze6N3sRQiRJrAu2luUN6a3T9J6T0ts4";

    @BeforeTest
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", "Quick Start iOS Native Demo");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='ios' and @version='16.0.2' and @category='PHONE'");
        //dc.setCapability(MobileCapabilityType.APP, "cloud:com.adib.mobilebanking");
        dc.setCapability(MobileCapabilityType.APP, "cloud:unqiueName=ADIBTest");
        //dc.setCapability("cloud:unqiueName","LatestBuild");
       //dc.setCapability("releaseVersion", "10.0.0");
       //dc.setCapability("buildVersion","1" );
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.adib.mobilebanking");
        driver = new IOSDriver<>(new URL("https://adib.experitest.com/wd/hub"), dc);
    }

    @Test
    public void quickStartiOSNativeDemo() {
//        driver.rotate(ScreenOrientation.PORTRAIT);
  driver.findElement(By.xpath("//*[@text='ADIBApp Offline']")).click();
  driver.findElement(By.xpath("//*[@text='Allow']")).click();
  driver.findElement(By.xpath("//*[@accessibilityLabel='uYF-eq-mog']")).click();
  driver.findElement(By.xpath("//*[@accessibilityLabel='OqU-bS-5Ld']")).click();
  driver.findElement(By.xpath("//*[@id='Account Number & ePIN']")).click();
  driver.findElement(By.xpath("//*[@text='bw2-Ma-dM2’]")).sendKeys("12345678");
  driver.findElement(By.xpath("//*[@text='jsE-u5-GsQ'] ")).sendKeys("1234");
  driver.findElement(By.xpath("//*[@text='I Agree' and @class='UIAStaticText']")).click();
  driver.findElement(By.xpath("//*[@text='Agree']")).click();
  driver.findElement(By.xpath("//*[@id='I Agree']")).click();
  driver.findElement(By.xpath("//*[@text='e2R-ex-0o2']")).sendKeys("123456");
  driver.findElement(By.xpath("//*[@text='Not Interested']")).click();
  driver.findElement(By.xpath("//*[@accessibilityLabel='bEk-fQ-MKR']")).click();
  driver.findElement(By.xpath("//*[@id='Skip, Maybe Later']")).click();
  driver.findElement(By.xpath("(//*[@class='UIAView' and (./preceding-sibling::* | ./following-sibling::*)[@text='registration_bg'] and ./parent::*[@class='UIAView']]/*[@class='UIAView' and ./*[@class='UIAStaticText']])[1]")).sendKeys("1223");
        driver.findElement(By.xpath("//*[@text='product_tabbarImage']")).click();
       driver.findElement(By.xpath("//*[@text='Account']")).click();
       
      

    }

    @AfterTest
    public void tearDown() {
        System.out.println("Report URL: " + driver.getCapabilities().getCapability("reportUrl"));
        driver.quit();
    }
}
