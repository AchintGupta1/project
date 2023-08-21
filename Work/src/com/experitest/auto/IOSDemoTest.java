package com.experitest.auto;

import com.experitest.client.*;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.testng.annotations.*;
/**
 *
 */
public class IOSDemoTest {
    private String host = "https://internal.experitest.com";

    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoxNzM2NSwieHAucCI6MSwieHAubSI6MTY4MjQ5NDE1MDA4OCwiZXhwIjoxOTk5MDk3OTQ4LCJpc3MiOiJjb20uZXhwZXJpdGVzdCJ9.94bluq7AaXy6aSkTlUTTVxKiUuLyzP49WxtfWqiFcCU";
    protected Client client = null;
    protected GridClient grid = null;


	protected IOSDriver<IOSElement> driver = null;
    @BeforeTest
    public void setUp(){
        // In case your user is assign to a single project you can provide an empty string,
        // otherwise please specify the project name
        grid = new GridClient(accessKey, host);
        client = grid.lockDeviceForExecution("Quick Start seetest iOS NATIVE Demo", "@os='ios' and @version='15.6.1' and @category='PHONE'", 10, 50000);
        client.setReporter("xml", "", "Quick Start seetest iOS Native Demo");

    }

    @Test
    public void quickStartiOSNativeDemo() {
        client.install("cloud:com.experitest.UICatalog", true, false);
        client.launch("com.experitest.UICatalog", true, true);
        client.click("NATIVE", "xpath=//*[@accessibilityLabel='Pickers']", 0, 1);
        client.setPickerValues("NATIVE", "xpath=//*[@class='UIPickerView' and ./*[./*[./*[./*[./*[@class='UIPickerTableViewTitledCell']]]]]]", 0, 2, "down:6");
    }
   

    @AfterTest
    public void tearDown(){
        // Generates a report of the test case.
        // For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
        client.generateReport(false);
        // Releases the client so that other clients can approach the agent in the near future.
        client.releaseClient();
    }
}

