package com.experitest.auto;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class biogeniOS {

    protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjozNDE4NzYsInhwLnAiOjg0NTc0LCJ4cC5tIjoxNjg2MjE0MjEzOTgxLCJleHAiOjIwMDI2MTA4OTYsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.Xz82O-5YC0V4xyD18PHobKCndIbtzD8fCYWUv0EvIGs";

    @BeforeTest()
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", "Quick Start iOS Native Demo");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='ios' and @serialnumber='00008030-001C6C5634D0802E' and @category='PHONE'");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        dc.setCapability("appiumVersion", "2.0.0.beta.23");
        dc.setCapability("automationName", "XCUITEST");
        driver = new IOSDriver<>(new URL("https://biogen.experitest.com/wd/hub"), dc);
    }
@BeforeMethod()
public void BeforeMehtod(){
dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
dc.setCapability("appiumVersion", "2.0.0.beta.23");
dc.setCapability("automationName", "XCUITEST");

}
    @Test(invocationCount = 1)
    public void quickStartiOSNativeDemo() {
        driver.rotate(ScreenOrientation.PORTRAIT);
        //driver.launchApp();
        driver.findElement(By.xpath("//*[@name='usernameTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@name='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@name='loginButton']")).click();
        System.out.println("Current context is "+driver.getContext()+" : And window size is "+driver.manage().window().getSize());
        driver.findElement(By.xpath("//*[@name='makePaymentButton']")).click();
        driver.findElement(By.xpath("//*[@name='phoneTextField']")).sendKeys("0501234567");
        driver.findElement(By.xpath("//*[@name='nameTextField']")).sendKeys("John Snow");
        driver.findElement(By.xpath("//*[@name='amountTextField']")).sendKeys("50");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        driver.findElement(By.xpath("//*[@name='countryButton']")).click();
        driver.findElement(By.xpath("//*[@name='Switzerland']")).click();
        driver.findElement(By.xpath("//*[@name='sendPaymentButton']")).click();
        driver.findElement(By.xpath("//*[@name='Yes']")).click();
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Report URL: " + driver.getCapabilities().getCapability("reportUrl"));
        driver.quit();
    }
}