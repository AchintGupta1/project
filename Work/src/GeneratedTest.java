
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class GeneratedTest {

    private IOSDriver<IOSElement> driver = null;
    private DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeTest
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", "1");
        dc.setCapability("accessKey", "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoxNzM2NSwieHAucCI6MSwieHAubSI6MTY4MjQ5NDE1MDA4OCwiZXhwIjoxOTk5MDk3OTQ4LCJpc3MiOiJjb20uZXhwZXJpdGVzdCJ9.94bluq7AaXy6aSkTlUTTVxKiUuLyzP49WxtfWqiFcCU");
        dc.setCapability("deviceQuery", "@serialnumber='00008030-0012710E1AA2802E'");
        driver = new IOSDriver<>(new URL("https://internal.experitest.com/wd/hub"), dc);
    }

    @Test
    public void generatedMethod() {
        driver.findElementByXPath("//*[@accessibilityLabel='Pickers']").click();
        driver.findElementByXPath("//*[@class='UIAPickerWheel']").sendKeys("Chris Armstrong");
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
