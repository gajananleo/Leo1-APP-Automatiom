package com.AppCases;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppOpen_code {
    AndroidDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    @BeforeTest
    public void appOpen() throws MalformedURLException {
        // Setup device configuration
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setApp("C:\\Users\\Leo1\\Downloads\\Leo1_(3.3.0) (1).apk");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("e25e9c030922");

        // Start the Appium driver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }
}


