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

	public class seetestioTest {

	    protected IOSDriver<IOSElement> driver = null;
	    DesiredCapabilities dc = new DesiredCapabilities();
	    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoyMjI3Mzc5MywieHAucCI6MywieHAubSI6MTY3Mzg1MzcyOTYwMywiZXhwIjoxOTg5MjEzNzMwLCJpc3MiOiJjb20uZXhwZXJpdGVzdCJ9.fYRaVX0fb4V6hGLw6Gl-qYqwVUaEktsQ4ORQ7UyclpM";

	    @BeforeTest
	    public void setUp() throws MalformedURLException {
	        dc.setCapability("testName", "Quick Start iOS Native Demo");
	        dc.setCapability("accessKey", accessKey);
	        dc.setCapability("deviceQuery", "@os='ios' and @serialnumber='00008020-000E6C893C50003A' and @category='PHONE'");
	        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
	        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
	        driver = new IOSDriver<>(new URL("https://cloud.seetest.io/wd/hub"), dc);
	    }

	    @Test
	    public void quickStartiOSNativeDemo() {
	        driver.rotate(ScreenOrientation.PORTRAIT);
	        driver.findElement(By.xpath("//*[@name='usernameTextField']")).sendKeys("company");
	        driver.findElement(By.xpath("//*[@name='passwordTextField']")).sendKeys("company");
	        driver.findElement(By.xpath("//*[@name='loginButton']")).click();
	        driver.findElement(By.xpath("//*[@name='makePaymentButton']")).click();
	        driver.findElement(By.xpath("//*[@name='phoneTextField']")).sendKeys("0501234567");
	        driver.findElement(By.xpath("//*[@name='nameTextField']")).sendKeys("John Snow");
	        driver.findElement(By.xpath("//*[@name='amountTextField']")).sendKeys("50");
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