package com.experitest.auto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

import java.net.URL;


public class TheAABrowserTest {

    private static final String ACCESS_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoyMTQ0NSwieHAucCI6MSwieHAubSI6MTY3Nzg3NTczMzQyNCwiZXhwIjoxOTkzMjM1NzM0LCJpc3MiOiJjb20uZXhwZXJpdGVzdCJ9.IccNZ_twYpbQqr42lXmXwNkFbiR-WXnQ4RnL8uURaIM";
    private RemoteWebDriver driver;
    private URL url;
    private DesiredCapabilities dc = new DesiredCapabilities();
	private WebElement element;
	//private WebDriver driver;
    @Before
    public void setUp() throws Exception {
//    	FirefoxProfile profile = new FirefoxProfile();
//    	profile.setPreference("security.fileuri.strict_origin_policy",false);
//    	profile.setPreference("privacy.trackingprotection.enabled",false);
        dc.setCapability("testName", "Quick Start Firefox");
        dc.setCapability("accessKey", ACCESS_KEY);
        dc.setCapability(CapabilityType.BROWSER_NAME, "firefox");
//        dc.setCapability("browserVersion", "114");
        dc.setCapability("osName", "Windows 10");
//        dc.setCapability("firefox_profile", profile);
        driver = new RemoteWebDriver(new URL("https://theaa.experitest.com/wd/hub"), dc);
        
       // local setup
//        System.setProperty("webdriver.gecko.driver","C:\\Users\\ChinniSaiHarshith\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
//        driver = new FirefoxDriver();
        
    }


    @Test
    public void browserTestGoogleSearch() throws InterruptedException { 
        driver.get("https://roadsidecover.uat.bcas.theaa.com/Audi");
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='truste-consent-button']"))).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Registration']"))).sendKeys("FT62XNZ");        
        driver.findElement(By.xpath("//*[@id='Search']")).click();
        Thread.sleep(2000);
        element = driver.findElement(By.xpath("//input[@value='Continue']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("StartDate")));
        driver.findElement(By.id("StartDate")).clear();
        driver.findElement(By.id("StartDate")).sendKeys("30/07/2023");
        driver.findElement(By.xpath("//*[contains(text(),'Choose cover')]")).click();
        driver.findElement(By.id("AgreeToTerms")).click();
        Select drpCountry = new Select(driver.findElement(By.cssSelector("#ddlPaymentOptionCCC")));
        drpCountry.selectByValue("2");
        
        Thread.sleep(12000);
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Continue']"))).click();

        new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Postcode']"))).sendKeys("RG214EA");
        driver.findElement(By.xpath("//*[@id='Lookup']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='CustomerTitle']"))).click();
        driver.findElement(By.xpath("//*[contains(text(),'Mr')]")).click();
        driver.findElement(By.xpath("//*[@id='FirstName']")).sendKeys("abc");
        driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys("abc");
        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("abc@xyz.com");
        driver.findElement(By.xpath("//*[@id='MobileNumber']")).sendKeys("1234554321");
        driver.findElement(By.xpath("//*[@id='PhoneNumber']")).sendKeys("1234554321");
        
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Continue']"))).click();
        new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Card payment')]"))).click();
        //new WebDriverWait(driver, 60).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("iframeDoPay")));
        driver.switchTo().frame("iframeDoPay");
//        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("iFramePaymentGateway")));
        driver.switchTo().frame("iFramePaymentGateway");
        driver.manage().window().setSize(new Dimension(1024, 768));
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"pas_ccnum\"]")));
        WebElement ccNum = driver.findElement(By.xpath("//*[@id=\"pas_ccnum\"]"));
        WebElement ccExpiry = driver.findElement(By.xpath("//*[@id=\"pas_expiry\"]"));
        WebElement ccCVC = driver.findElement(By.xpath("//*[@id=\"pas_cccvc\"]"));
                 
         Actions performAct = new Actions(driver); 
         performAct.sendKeys(ccNum, "4263970000005262").build().perform(); 
         performAct.sendKeys(ccExpiry, "1233").build().perform();
         performAct.sendKeys(ccCVC, "123").build().perform();
         
        driver.findElementByXPath("//*[@id=\"pas_ccname\"]").sendKeys("Hello World");
        js.executeScript("window.scrollBy(0,350)", "");
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Proceed to Verification']")));
        driver.findElementByXPath("//button[text()='Proceed to Verification']").click();
        Thread.sleep(20000);
    }

    @After
    public void tearDown() {
        System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
        driver.quit();
    }

}

