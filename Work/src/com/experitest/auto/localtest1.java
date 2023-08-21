package com.experitest.auto;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class localtest1 {
public void main (String[] agrs) {
}

private AndroidDriver driver1;

    protected AndroidDriver<AndroidElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoxNzM2NSwieHAucCI6MSwieHAubSI6MTY4MjQ5NDE1MDA4OCwiZXhwIjoxOTk5MDk3OTQ4LCJpc3MiOiJjb20uZXhwZXJpdGVzdCJ9.94bluq7AaXy6aSkTlUTTVxKiUuLyzP49WxtfWqiFcCU";

    @BeforeTest
    public void setUp() throws MalformedURLException {
    
        dc.setCapability("appium:udid", "RZ8TA0N174M");
        dc.setCapability("appium:deviceName", "auto");
        dc.setCapability("appium:app", "/Users/achintagupta.satyaprakash/Desktop/com.experitest.uicatalog_.MainActivity_ver_2926.apk");
        dc.setCapability("appium:appPackage", "com.experitest.UICatalog");
        dc.setCapability("appiumVersion", "1.22.3");
        dc.setCapability("platformName", "Android");
        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
    //driver = new AndroidDriver<>(new URL("127.0.0.1:47233/wd/hub"), dc);
        dc.setCapability("appium:automationName", "UiAutomator");
        driver1 = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void quickStartAndroidNativeDemo() {
    	
    	driver1.findElement(By.xpath("//android.view.View[@content-desc=\"Home\"]"));
    	System.out.println("test");
        //driver.rotate(ScreenOrientation.PORTRAIT);
        //driver.findElement(By.id("com.experitest.UICatalog")).click();
//        driver.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
//        driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
//        driver.findElement(By.id("com.experitest.ExperiBank:id/makePaymentButton")).click();
//        driver.findElement(By.id("com.experitest.ExperiBank:id/phoneTextField")).sendKeys("0501234567");
//        driver.findElement(By.id("com.experitest.ExperiBank:id/nameTextField")).sendKeys("John Snow");
//        driver.findElement(By.id("com.experitest.ExperiBank:id/amountTextField")).sendKeys("50");
//        driver.findElement(By.id("com.experitest.ExperiBank:id/countryTextField")).sendKeys("'Switzerland'");
//        driver.findElement(By.id("com.experitest.ExperiBank:id/sendPaymentButton")).click();
//        driver.findElement(By.id("android:id/button1")).click();
    }

    @AfterTest
    public void tearDown() {
        driver1.quit();
    }
}
