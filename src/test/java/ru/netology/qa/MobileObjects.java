package ru.netology.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MobileObjects {

    @AndroidFindBy(id="ru.netology.testing.uiautomator:id/userInput")
    MobileElement El1;

    @AndroidFindBy(id="ru.netology.testing.uiautomator:id/buttonChange")
    MobileElement El2;

    @AndroidFindBy(id="ru.netology.testing.uiautomator:id/buttonActivity")
    MobileElement El4;

    @AndroidFindBy(id="ru.netology.testing.uiautomator:id/text")
    MobileElement text;

    private AppiumDriver driver;

    public MobileObjects(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

}
