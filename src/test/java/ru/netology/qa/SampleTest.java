package ru.netology.qa;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SampleTest {

    private AppiumDriver driver;
    private MobileObjects mobileObjects;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "android");
                caps.setCapability("appium:deviceName", "Huawei");
                caps.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
                caps.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
                caps.setCapability("appium:automationName", "uiautomator2");
                caps.setCapability("appium:ensureWebviewsHavePages", true);
                caps.setCapability("appium:nativeWebScreenshot", true);
                caps.setCapability("appium:newCommandTimeout", 5000);
                caps.setCapability("appium:connectHardwareKeyboard", true);



        driver = new AndroidDriver(this.getUrl(), caps);
        mobileObjects = new MobileObjects(driver);
    }



    @Test
    public void cleanLine() {

        mobileObjects.El1.isDisplayed();
        mobileObjects.El1.click();
        mobileObjects.El1.sendKeys("   ");
        mobileObjects.El2.isDisplayed();
        mobileObjects.El2.click();
        Assertions.assertEquals("   ", mobileObjects.El1.getText());


    }

    @Test
    public void newActivity() {

        mobileObjects.El1.isDisplayed();
        mobileObjects.El1.click();
        mobileObjects.El1.sendKeys("NetologyTEST");
        mobileObjects.El4.isDisplayed();
        mobileObjects.El4.click();
        Assertions.assertEquals("NetologyTEST", mobileObjects.text.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
