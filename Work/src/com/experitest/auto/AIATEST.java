package com.experitest.auto;
import com.experitest.appium.SeeTestClient;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class AIATEST {

    private IOSDriver driver = null;
    protected static SeeTestClient client;
    private DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeTest
    public void setUp() throws MalformedURLException {
        String appPackage = "com.aiahk.idirect.uat";
        String appActivity = "com.aiaconnect.MainActivity";

        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, appPackage);
        dc.setCapability("instrumentApp", true);
        dc.setCapability("accessKey", "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51Ijo5MjY5NDQsInhwLnAiOjEsInhwLm0iOjE2OTIwMDAwMTIwODgsImV4cCI6MjAwNzM2MDAxMiwiaXNzIjoiY29tLmV4cGVyaXRlc3QifQ.sNRvvWTDRQ_FYsE0jlq6xrH3q7u2Ag99mAeH5wHe04g");
        dc.setCapability("deviceQuery", "@serialnumber='00008030-00142586223A802E'");
        driver = new IOSDriver<>(new URL("https:aia.experitest.com/wd/hub"), dc);
        //driver = new IOSDriver(new URL(https://aia.experitest.com/wd/hub), dc);
      

        client = new SeeTestClient(driver);

    }

    @Test
    public void generatedMethod() throws InterruptedException {
        client.startCaptureNetworkDump("D:\\Temp\\device.pcap");
// actions to trigger traffic
        client.stopCaptureNetworkDump();

    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}