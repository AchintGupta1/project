package com.experitest.auto;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.experitest.appium.SeeTestClient;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
public class Onepluslanguagescript {
    private String accessKey = "";
	protected AndroidDriver<AndroidElement> driver = null;;
    DesiredCapabilities dc = new DesiredCapabilities();
    SeeTestClient seetest;
    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", "Quick Start Android Native Demo");
        dc.setCapability("accessKey", "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoxMDAxNjE4MiwieHAucCI6MiwieHAubSI6MTY4OTc1MjIxMDQ2NSwiZXhwIjoyMDA1MTEyMjExLCJpc3MiOiJjb20uZXhwZXJpdGVzdCJ9.vQj9So0Y5UswTu3UmCVeUR1I1qcDvZeUJ6djGmm8uDE");
        dc.setCapability("deviceQuery", "@serialnumber='40e05910'");
//        dc.setCapability("appiumversion", "1.22.2");
        driver = new AndroidDriver<>(new URL("https://uscloud.experitest.com/wd/hub"), dc);
        seetest = new SeeTestClient(driver);
    }
    @Test
    public void quickStartAndroidNativeDemo() { 
    	String[] langs = seetest.getDeviceSupportedLanguages();
    	for(String x:langs) {
    		System.out.print(x+" ");	
    	}
    	seetest.setDeviceLanguage("fr");
    }
    @After
    public void tearDown() {
        System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
        driver.quit();
    }
}
