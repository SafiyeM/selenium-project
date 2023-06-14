package com.cydeo.tests.day06_alerts_iFrames_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_T2_T3_Alert_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }


    @Test
    public void information_alert_test1() {

        //TC #1: Information alert practice

        //3.Locate the “Click for JS Alert” button
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        // Click to “Click for JS Alert” button
        informationAlertButton.click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        //Failure message will only be displayed if assertion fails
        Assert.assertTrue(resultText.isDisplayed(), "Result text is NOT DISPLAYED!");

        String expectedText = "You successfully clicked an alert";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText, expectedText, "Actual result text is NOT as expected");

    }

    @Test
    public void confirmation_alert_test2() {

        //TC #2: Confirmation alert practice

        //3. Click to “Click for JS Confirm” button
        WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmationAlertButton.click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(resultText.isDisplayed(), "Result text is NOT DISPLAYED!");

        String expectedText = "You clicked: Ok";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText, expectedText, "Actual result text is NOT as expected");

    }

    @Test
    public void prompt_alert_test3() {


        //TC #3: Information alert practice

        //3. Click to “Click for JS Prompt” button
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        informationAlertButton.click();

        //4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");

        //5. Click to OK button from the alert
        alert.accept();

        //6. Verify “You entered: hello” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultText.isDisplayed(), "Result text is NOT DISPLAYED!");

        String actualResultText = resultText.getText();
        String expectedResultText = "You entered: hello";
        Assert.assertEquals(actualResultText, expectedResultText, "Actual result text is NOT as expected");


    }


    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

}
