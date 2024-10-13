package com.AppCases;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestCases_Run extends AppOpen_code {

    @Test(priority = 0)
    public void loginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            // Allow permission
            WebElement allowButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.permissioncontroller:id/permission_allow_button")));
            allowButton.click();

            // Enter mobile number
            WebElement mobileField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Registered Mobile number']")));
            mobileField.click();
            mobileField.sendKeys("9619023553");

            // Click on another element
            WebElement anotherElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//com.horcrux.svg.GroupView/com.horcrux.svg.PathView[1]")));
            anotherElement.click();
        } catch (Exception e) {
            takeScreenshot("loginPageError");
            Assert.fail("Login page test failed: " + e.getMessage());
        }
    }

    @Test(priority = 1)
    public void pinScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        try {
            WebElement ph = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView")));
            wait.until(ExpectedConditions.elementToBeClickable(ph)).click();

            // Simulate key presses for entering the PIN
            for (int i = 0; i < 4; i++) {
                driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
            }

            // Locate the next element after entering the PIN
            WebElement nextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView[1]")));
            wait.until(ExpectedConditions.elementToBeClickable(nextElement)).click();
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        } catch (Exception e) {
            takeScreenshot("pinScreenError");
            Assert.fail("PIN screen test failed: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void homeAppScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        try {
            WebElement allowButton1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")));
            allowButton1.click();

            // Click on Hamburger menu
            WebElement menuButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='\uF19C\']")));
            menuButton.click();
        } catch (Exception e) {
            takeScreenshot("homeAppScreenError");
            Assert.fail("Home app screen test failed: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void profileDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            WebElement myProfileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='My Profile']")));
            myProfileButton.click();

            // Click on a specific path view
            WebElement pathView = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//com.horcrux.svg.PathView")));
            pathView.click();

            // Click on the same Hamburger menu again
            WebElement menuButtonAgain = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='\uF19C\']")));
            menuButtonAgain.click();
        } catch (Exception e) {
            takeScreenshot("profileDetailsError");
            Assert.fail("Profile details test failed: " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void rewardsFoodCategory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            WebElement myRewards = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='My Rewards'])[2]")));
            myRewards.click();

            // Select Food category
            WebElement foodCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Food']")));
            foodCategory.click();
        } catch (Exception e) {
            takeScreenshot("rewardsFoodCategoryError");
            Assert.fail("Rewards food category test failed: " + e.getMessage());
        }
    }

    @Test(priority = 5)
    public void discountSwipe() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            // Swipe action example
            Dimension size = driver.manage().window().getSize();
            int startX = size.width / 2; // Start swipe from the middle of the screen
            int startY = (int) (size.height * 0.8); // Start from 80% height of the screen
            int endY = (int) (size.height * 0.2); // End at 20% height of the screen

            new TouchAction(driver)
                    .press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                    .moveTo(PointOption.point(startX, endY))
                    .release()
                    .perform();

            takeScreenshot("discountSwipeScreenshot");

        } catch (Exception e) {
            takeScreenshot("discountSwipeError");
            Assert.fail("Discount swipe test failed: " + e.getMessage());
        }
    }

    private void takeScreenshot(String fileName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destDir = new File("C://Users//Leo1//IdeaProjects//Leo1APP_Projecttest-output//");
        if (!destDir.exists()) {
            destDir.mkdirs(); // Create the directory if it doesn't exist
        }

        String DiscountScreenshot = "";
        File destFile = new File(destDir, DiscountScreenshot + ".png");

        //            DocFile FileUtils = null;
//            FileUtils.copyFile(srcFile, destFile);
        System.out.println("Screenshot saved: " + destFile.getAbsolutePath());

    }

}






